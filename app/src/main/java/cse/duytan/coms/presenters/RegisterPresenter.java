package cse.duytan.coms.presenters;

import android.content.Context;

import org.json.JSONObject;

import cse.duytan.coms.R;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.untils.DebugLog;
import cse.duytan.coms.untils.Utils;
import cse.duytan.coms.views.RegisterView;

/**
 * Created by Pham Van Thien on 6/15/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class RegisterPresenter extends BasePresenter {
    private Context context;
    private RegisterView registerView;

    public RegisterPresenter(Context context, RegisterView registerView) {
        this.context = context;
        this.registerView = registerView;
    }

    public void register(String fullname, String email, String username, String password, String confirmPassword) {
        if (fullname.equals("")) {
            registerView.error(context.getString(R.string.msg_please_enter_full_name));
        } else if (email.equals("")) {
            registerView.error(context.getString(R.string.msg_please_enter_email));
        } else if (username.equals("")) {
            registerView.error(context.getString(R.string.msg_please_enter_username));
        } else if (password.equals("")) {
            registerView.error(context.getString(R.string.msg_please_enter_password));
        } else if (confirmPassword.equals("")) {
            registerView.error(context.getString(R.string.msg_please_enter_confirm_password));
        } else if (!Utils.isEmailValid(email)) {
            registerView.error(context.getString(R.string.msg_email_invalid));
        } else if (username.length() < 6) {
            registerView.error(context.getString(R.string.msg_username_must_not_be_less_than_6_characters));
        } else if (password.length() < 6) {
            registerView.error(context.getString(R.string.msg_password_must_not_be_less_than_6_characters));
        } else if (!password.equals(confirmPassword)) {
            registerView.error(context.getString(R.string.msg_confirm_password_incorrect));
        } else {
            try {
                JSONObject postData = new JSONObject();
                postData.put("Fullname", fullname);
                postData.put("Email", email);
                postData.put("Username", username);
                postData.put("Password", password);
                DownloadAsyncTask.POST(context, ID_API_REGISTER, API_REGISTER, postData.toString(), null, true, this);
            } catch (Exception e) {
                DebugLog.logD(TAG, e.getMessage());
            }
        }
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        registerView.success();
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        registerView.error(msg);
    }
}
