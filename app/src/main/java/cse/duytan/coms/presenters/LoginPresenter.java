package cse.duytan.coms.presenters;

import android.content.Context;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cse.duytan.coms.R;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.untils.DebugLog;
import cse.duytan.coms.views.LoginView;

import static cse.duytan.coms.untils.Constants.API_LOGIN;
import static cse.duytan.coms.untils.Constants.ID_API_LOGIN;

/**
 * Created by Pham Van Thien on 6/15/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class LoginPresenter extends BasePresenter {
    private LoginView loginView;
    private Context context;

    public LoginPresenter(Context context, LoginView loginView) {
        this.context = context;
        this.loginView = loginView;
    }

    public void login(String username, String password) {
        if (username.equals("")) {
            loginView.error(context.getString(R.string.msg_please_enter_username));
        } else if (password.equals("")) {
            loginView.error(context.getString(R.string.msg_please_enter_password));
        } else if (username.length() < 6) {
            loginView.error(context.getString(R.string.msg_username_must_not_be_less_than_6_characters));
        } else if (password.length() < 6) {
            loginView.error(context.getString(R.string.msg_password_must_not_be_less_than_6_characters));
        } else {
            try {
                JSONObject postData = new JSONObject();
                postData.put("Username", username);
                postData.put("Password", password);
                DownloadAsyncTask.POST(context, ID_API_LOGIN, API_LOGIN, postData.toString(), null, true, this);
            } catch (Exception e) {
                DebugLog.logD(TAG, e.toString());
            }
        }
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        loginView.success();
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        loginView.error(msg);
    }
}
