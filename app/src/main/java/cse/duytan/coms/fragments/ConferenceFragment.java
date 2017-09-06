package cse.duytan.coms.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cse.duytan.coms.R;
import cse.duytan.coms.activities.ConferenceInfomationActivity;
import cse.duytan.coms.adapters.ConferenceAdapter;
import cse.duytan.coms.dialogs.ConfirmDialog;
import cse.duytan.coms.models.Conference;
import cse.duytan.coms.presenters.ConferencePresenter;
import cse.duytan.coms.views.ConferenceView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConferenceFragment extends BaseFragment implements ConferenceView, SwipeRefreshLayout.OnRefreshListener{
    @BindView(R.id.rvCon)
    RecyclerView rvCon;
    @BindView(R.id.swipeRefreshCon) SwipeRefreshLayout swipeRefreshCon;

    Unbinder unbinder;
    private View view;
    private ArrayList<Conference> listData;
    private ConferenceAdapter adapter;
    private ConferencePresenter conferencePresenter;
    private Conference conference = new Conference();
    private Context context;
    private int page = 1, pageSize = 10;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)  {

        view = inflater.inflate(R.layout.fragment_conference, container, false);
        unbinder = ButterKnife.bind(this,view);

        setHasOptionsMenu(true);
        initUI();
        return view;
    }
    private void initUI() {

        getActivity().setTitle(R.string.title_list_conference);
        conferencePresenter = new ConferencePresenter(getActivity(), this);
        swipeRefreshCon.setOnRefreshListener(this);
        listData = new ArrayList<>();
        conferencePresenter.getListConference(page, pageSize);
        setUp();
    }

    public void setUp() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.getActivity(), manager.getOrientation());
        rvCon.setHasFixedSize(true);
        rvCon.setLayoutManager(manager);
        rvCon.addItemDecoration(dividerItemDecoration);
        adapter = new ConferenceAdapter(getActivity(), listData, this);
        rvCon.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void onSearch(String query){
        adapter.search(query);
    }

    @Override
    public void adpaterCallback(Object data, int processId, int position) {
        super.adpaterCallback(data, processId, position);
        if(processId == 99){
            conference = (Conference) data;
            Intent intent = new Intent(getActivity(), ConferenceInfomationActivity.class);
            intent.putExtra("data", new Gson().toJson(conference).toString());
            getActivity().startActivity(intent);
        }
    }

    @Override
    public void listConference(ArrayList<Conference> listConference) {
        if (listConference.isEmpty()) {
            swipeRefreshCon.setEnabled(false);
        }
        ArrayList<Conference> list = new ArrayList<>();
        int size = listConference.size();
        for (int i = 0; i < size; i++) {
            list.add(0, listConference.get(i));
        }
        this.listData.addAll(0, list);
        adapter.notifyDataSetChanged();
        swipeRefreshCon.setRefreshing(false);
    }


    @Override
    public void error(String msg) {
        new ConfirmDialog(getActivity(), msg, null).show();
        swipeRefreshCon.setRefreshing(false);
        page--;
    }

    @Override
    public void onRefresh() {
        page++;
        conferencePresenter.getListConference(page, pageSize);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        page = 1;
    }

}
