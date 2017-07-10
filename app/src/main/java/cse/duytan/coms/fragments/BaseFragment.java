package cse.duytan.coms.fragments;

import android.app.Fragment;
import android.view.View;

import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.untils.AdapterCallback;
import cse.duytan.coms.untils.Constants;

/**
 * Created by Pham Van Thien on 7/7/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class BaseFragment extends Fragment implements Constants, View.OnClickListener, DownloadCallback, AdapterCallback {
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
