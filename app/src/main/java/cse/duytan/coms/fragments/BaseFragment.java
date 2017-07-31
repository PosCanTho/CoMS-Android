package cse.duytan.coms.fragments;

import android.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.models.EventBusInfo;
import cse.duytan.coms.untils.AdapterCallback;
import cse.duytan.coms.untils.Constants;

/**
 * Created by Pham Van Thien on 7/7/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class BaseFragment extends Fragment implements Constants, View.OnClickListener, DownloadCallback, AdapterCallback {

    protected void registerEvent(){
        EventBus.getDefault().register(this);
    }

    protected void unregisterEvent(){
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventBusInfo eventBusInfo){

    }

    protected void postEvent(EventBusInfo eventBusInfo){
        EventBus.getDefault().post(eventBusInfo);
    }

    protected void empty(boolean isEmpty, String msg, LinearLayout llEmpty, RelativeLayout rlContent, TextView tvEmpty) {
        if (isEmpty) {
            rlContent.setVisibility(View.GONE);
            llEmpty.setVisibility(View.VISIBLE);
            tvEmpty.setText(msg);
        } else {
            rlContent.setVisibility(View.VISIBLE);
            llEmpty.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void downloadSuccess(int processId, Object data) {

    }

    @Override
    public void downloadError(int processId, String msg) {

    }

    @Override
    public void adpaterCallback(Object data, int processId, int position) {

    }
}
