package cse.duytan.coms.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.omadahealth.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.omadahealth.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.RecyclerNotificationAdapter;
import cse.duytan.coms.customviews.CustomTextView;
import cse.duytan.coms.dialogs.ConfirmDialog;
import cse.duytan.coms.dialogs.ConfirmOkDialog;
import cse.duytan.coms.helpers.Prefs;
import cse.duytan.coms.models.Message;
import cse.duytan.coms.models.Notification;
import cse.duytan.coms.presenters.NotificationPresenter;
import cse.duytan.coms.views.NotificationView;

/**
 * Created by Pham Van Thien on 7/8/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class NotificationFragment extends BaseFragment implements NotificationView, SwipyRefreshLayout.OnRefreshListener {
    @BindView(R.id.rvNotification)
    RecyclerView rvNotification;
    Unbinder unbinder;
    @BindView(R.id.ivEmpty)
    ImageView ivEmpty;
    @BindView(R.id.tvEmpty)
    CustomTextView tvEmpty;
    @BindView(R.id.llEmpty)
    LinearLayout llEmpty;
    @BindView(R.id.rlContent)
    RelativeLayout rlContent;
    @BindView(R.id.swipyrefreshlayout)
    SwipyRefreshLayout swipyrefreshlayout;

    public RecyclerNotificationAdapter notificationAdapter;
    private NotificationPresenter notificationPresenter;
    private ArrayList<Notification> listNotification;

    private int page = 1, pageSize = 10;

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

    private void initUI() {
        getActivity().setTitle(R.string.title_notification);

        notificationPresenter = new NotificationPresenter(getActivity(), this);
        notificationPresenter.getListNotification(Prefs.getUser().getPersonId(), page, pageSize, true);
        swipyrefreshlayout.setOnRefreshListener(this);

        empty(true, false, "", llEmpty, rlContent, tvEmpty);

        setRvMessageAdp();
    }

    private void setRvMessageAdp() {
        listNotification = new ArrayList<>();
        notificationAdapter = new RecyclerNotificationAdapter(getActivity(), listNotification, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvNotification.setLayoutManager(mLayoutManager);
        rvNotification.setItemAnimator(new DefaultItemAnimator());
        rvNotification.setAdapter(notificationAdapter);
    }

    private BroadcastReceiver mNotificationReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                String data = intent.getStringExtra("data");
                Notification notification = new Gson().fromJson(data, Notification.class);
                notification.getCreateDate().substring(0, notification.getCreateDate().length() - 11);
                listNotification.add(0, notification);
                notificationAdapter.notifyDataSetChanged();
                empty(false, false, "", llEmpty, rlContent, tvEmpty);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public void deleteAllNotification() {
        new ConfirmDialog(getActivity(), getString(R.string.msg_are_you_sure_you_want_to_delete_all_notification), NotificationFragment.this).show();
    }

    @Override
    public void success(ArrayList<Notification> listNotification) {
        empty(false, false, "", llEmpty, rlContent, tvEmpty);
        this.listNotification.addAll(listNotification);
        notificationAdapter.notifyDataSetChanged();
        swipyrefreshlayout.setRefreshing(false);
    }

    @Override
    public void deleteNotificationSuccess() {
        listNotification.clear();
        notificationAdapter.notifyDataSetChanged();
    }

    @Override
    public void error(String msg) {
        empty(true, true, msg, llEmpty, rlContent, tvEmpty);
        new ConfirmOkDialog(getActivity(), msg, null).show();
        swipyrefreshlayout.setRefreshing(false);
        page--;
    }

    @Override
    public void empty() {
        if (listNotification.isEmpty()) {
            empty(true, true, getString(R.string.msg_no_data_notification), llEmpty, rlContent, tvEmpty);
        }
        swipyrefreshlayout.setRefreshing(false);
        swipyrefreshlayout.setEnabled(false);

    }

    @Override
    public void onRefresh(SwipyRefreshLayoutDirection direction) {
        page++;
        notificationPresenter.getListNotification(Prefs.getUser().getPersonId(), page, pageSize, false);
    }

    @Override
    public void adpaterCallback(Object data, int processId, int position) {
        super.adpaterCallback(data, processId, position);
        if (processId == R.id.clMain) {
            Notification notification = (Notification) data;
            if (!notification.isReaded()) {
                listNotification.get(position).setReaded(true);
                notificationAdapter.notifyDataSetChanged();
                notificationPresenter.updateReaded(Prefs.getUser().getPersonId(), notification.getNotificationId());
            }
        }
    }

    @Override
    public void popupCalback(int processId, Object data) {
        super.popupCalback(processId, data);
        if (processId == ID_DIALOG_CONFIRM_YES) {
            notificationPresenter.deleteNotification(Prefs.getUser().getPersonId());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        page = 1;
        Prefs.setViewNotification(false);
    }

    @Override
    public void onStop() {
        super.onStop();
        page = 1;
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(mNotificationReceiver);
        Prefs.setViewNotification(false);
    }

    @Override
    public void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver((mNotificationReceiver),
                new IntentFilter("Notification")
        );
        Prefs.setViewNotification(true);
    }
}
