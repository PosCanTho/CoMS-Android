package cse.duytan.coms.presenters;

import android.content.Context;

import org.json.JSONObject;

import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.helpers.Prefs;
import cse.duytan.coms.views.ChangePasswordView;

/**
 * Created by Pham Van Thien on 8/18/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ChangePasswordPresenter extends BasePresenter {
    private Context context;
    private ChangePasswordView changePasswordView;

    public ChangePasswordPresenter(Context context, ChangePasswordView changePasswordView) {
        this.context = context;
        this.changePasswordView = changePasswordView;
    }

    public void changePassword(String oldPassword, String newPassword) {
        try {
            JSONObject postData = new JSONObject();
            postData.put("Id", Prefs.getUser().getPersonId());
            postData.put("OldPassword", oldPassword);
            postData.put("NewPassword", newPassword);
            DownloadAsyncTask.POST(context, ID_API_CHANGE_PASSWORD, API_CHANGE_PASSWORD, postData.toString(), null, true, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        changePasswordView.success();
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        changePasswordView.error(msg);
    }
}
