package cse.duytan.coms.presenters;

import android.content.Context;

import org.json.JSONObject;

import cse.duytan.coms.R;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.helpers.Prefs;
import cse.duytan.coms.models.Token;
import cse.duytan.coms.models.User;
import cse.duytan.coms.untils.DebugLog;
import cse.duytan.coms.untils.Utils;
import cse.duytan.coms.views.RegisterView;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Pham Van Thien on 6/15/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class RegisterPresenter extends BasePresenter {
    private Context context;
    private RegisterView registerView;
    private String username;
    private String password;

    public RegisterPresenter(Context context, RegisterView registerView) {
        this.context = context;
        this.registerView = registerView;
    }

    public void register(String fullname, String email, int gender, String username, String password, String confirmPassword) {
        if (fullname.equals("")) {
            registerView.error(context.getString(R.string.msg_please_enter_full_name));
        } else if (email.equals("")) {
            registerView.error(context.getString(R.string.msg_please_enter_email));
        } else if (gender == -1) {
            registerView.error(context.getString(R.string.msg_please_select_gender));
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
                this.username = username;
                this.password = password;

                JSONObject postData = new JSONObject();
                postData.put("Fullname", fullname);
                postData.put("Email", email);
                postData.put("Username", username);
                postData.put("Password", password);
                postData.put("Gender", gender);
                DownloadAsyncTask.POST(context, ID_API_REGISTER, API_REGISTER, postData.toString(), User.class, true, this);
            } catch (Exception e) {
                DebugLog.logD(TAG, e.getMessage());
            }
        }
    }

    public void getToken(String username, String password) {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "username=" + username + "&password=" + password + "&grant_type=password");
        Request request = new Request.Builder()
                .url(API_GET_TOKEN)
                .post(body)
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "bc5fe7ee-e0d8-3e36-7dba-a7bb035fe878")
                .build();
        DownloadAsyncTask.POST(context, ID_API_GET_TOKEN, API_GET_TOKEN, request, Token.class, false, this);
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        if (processId == ID_API_REGISTER) {
            getToken(username, password);
            User user = (User) data;
            if (user != null) {
                Prefs.setUser(user);
            }
        } else if (processId == ID_API_GET_TOKEN) {
            Token token = (Token) data;
            Prefs.setToken(token);
            registerView.success();
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        registerView.error(msg);
    }
}
