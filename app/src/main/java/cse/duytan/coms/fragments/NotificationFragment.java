package cse.duytan.coms.fragments;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.RecyclerMessageAdapter;
import cse.duytan.coms.adapters.RecyclerNotificationAdapter;
import cse.duytan.coms.models.Conversation;

/**
 * Created by Pham Van Thien on 7/8/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class NotificationFragment extends BaseFragment {
    @BindView(R.id.rvNotification)
    RecyclerView rvNotification;
    Unbinder unbinder;

    private RecyclerNotificationAdapter notificationAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        unbinder = ButterKnife.bind(this, view);
        initUI();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initUI(){
        setRvMessageAdp();
    }

    private void setRvMessageAdp() {

        notificationAdapter = new RecyclerNotificationAdapter(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvNotification.setLayoutManager(mLayoutManager);
        rvNotification.setItemAnimator(new DefaultItemAnimator());
        rvNotification.setAdapter(notificationAdapter);
    }
}
