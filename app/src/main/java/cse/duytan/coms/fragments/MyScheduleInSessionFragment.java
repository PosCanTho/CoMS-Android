package cse.duytan.coms.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cse.duytan.coms.R;
import cse.duytan.coms.sqlite.DatabasePresentationSlot;
import cse.duytan.coms.adapters.MySchduleSessionAdapter;
import cse.duytan.coms.models.EventBusInfo;
import cse.duytan.coms.untils.AdapterCallback;
import cse.duytan.coms.untils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyScheduleInSessionFragment extends Fragment implements AdapterCallback {

    @BindView(R.id.rvMyScheduleSession)
    RecyclerView rvMyScheduleSession;
    Unbinder unbinder;

    private View view;
    private MySchduleSessionAdapter adapter;
    private List<DatabasePresentationSlot> listData = new ArrayList<>();

    private DatabasePresentationSlot db = new DatabasePresentationSlot();

    public MyScheduleInSessionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_my_schedule_in_session, container, false);
        unbinder = ButterKnife.bind(this, view);
        registerEvent();
        getData();
        initUI();
        return view;

    }

    protected void registerEvent(){
        EventBus.getDefault().register(this);
    }
    protected void unregisterEvent(){
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventBusInfo eventBusInfo){
        if(eventBusInfo.getProcessId() == Constants.ID_EVENT_REFRESH){
            listData.clear();
            listData.addAll(DatabasePresentationSlot.getAll());
            adapter.notifyDataSetChanged();
            Toast.makeText(getActivity(), "OKE"+listData.size(), Toast.LENGTH_SHORT).show();

        }
    }


    private void getData(){
        listData = DatabasePresentationSlot.getAll();
    }

    private void initUI(){

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.getActivity(), manager.getOrientation());
        rvMyScheduleSession.setHasFixedSize(true);
        rvMyScheduleSession.setLayoutManager(manager);
        rvMyScheduleSession.addItemDecoration(dividerItemDecoration);
        adapter = new MySchduleSessionAdapter(getActivity(), listData, this);
        rvMyScheduleSession.setAdapter(adapter);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        unregisterEvent();
    }

    @Override
    public void adpaterCallback(Object data, int processId, int position) {

    }
}
