package cse.duytan.coms.presenters;

import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.untils.Constants;

/**
 * Created by Pham Van Thien on 7/15/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class BasePresenter implements Constants, DownloadCallback {
    @Override
    public void downloadSuccess(int processId, Object data) {

    }

    @Override
    public void downloadError(int processId, String msg) {

    }
}
