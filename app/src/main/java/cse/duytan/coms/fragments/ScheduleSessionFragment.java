package cse.duytan.coms.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cse.duytan.coms.R;
import cse.duytan.coms.sqlite.DatabasePresentationSlot;
import cse.duytan.coms.activities.ScheduleInSessionActivity;
import cse.duytan.coms.adapters.SchdeuleSessionAdapter;
import cse.duytan.coms.dialogs.ConfirmOkDialog;
import cse.duytan.coms.models.EventBusInfo;
import cse.duytan.coms.models.PresentationSlot;
import cse.duytan.coms.untils.AdapterCallback;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.untils.PopupCalback;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleSessionFragment extends Fragment implements AdapterCallback, PopupCalback {


    @BindView(R.id.rvScheduleSession)
    RecyclerView rvScheduleSession;
    Unbinder unbinder;

    private View view;
    private SchdeuleSessionAdapter adapter;
    private PresentationSlot presentationSlot = new PresentationSlot();
    final ArrayList<PresentationSlot> listObject = new ArrayList<>();
    private DatabasePresentationSlot databasePresentationSlot = new DatabasePresentationSlot();
    private ArrayList<DatabasePresentationSlot> list = new ArrayList<>();

    public ScheduleSessionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_schedule_session, container, false);
        unbinder = ButterKnife.bind(this, view);
        String json = ((ScheduleInSessionActivity)getActivity()).returnData();

        JSONArray array = null;
        try {
            array = new JSONArray(json);

        int lengh = array.length();
        for (int i = 0; i < lengh; i++) {
            JSONObject object = null;

                object = array.getJSONObject(i);

            listObject.add(new Gson().fromJson(object.toString(), PresentationSlot.class));

        }
            Log.i("", "onCreateView: "+listObject.size());
        }catch (JSONException e) {
            e.printStackTrace();
        }

        initUI();
        return view;
    }

    private void initUI(){

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.getActivity(), manager.getOrientation());
        rvScheduleSession.setHasFixedSize(true);
        rvScheduleSession.setLayoutManager(manager);
        rvScheduleSession.addItemDecoration(dividerItemDecoration);
        adapter = new SchdeuleSessionAdapter(getActivity(), listObject, this);
        rvScheduleSession.setAdapter(adapter);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    protected void postEvent(EventBusInfo eventBusInfo){
        EventBus.getDefault().post(eventBusInfo);
    }

    @Override
    public void adpaterCallback(Object data, int processId, int position) {
        if(processId == 113){
            presentationSlot = (PresentationSlot) data;
            databasePresentationSlot = DatabasePresentationSlot.returnSlot(presentationSlot);
            list.add(databasePresentationSlot);
            if(DatabasePresentationSlot.checkSlotIsExist(presentationSlot.PAPER_ID)) {
                new ConfirmOkDialog(getContext(), "Error", this ).show();
            } else {
                DatabasePresentationSlot.insertAll(list);
                new ConfirmOkDialog(getContext(), "Add Schedule Success", this ).show();
            }
            postEvent(new EventBusInfo(Constants.ID_EVENT_REFRESH));
        }
    }

    @Override
    public void popupCalback(int processId, Object data) {

    }
}
