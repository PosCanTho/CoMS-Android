package cse.duytan.coms.presenters;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;

import cse.duytan.coms.R;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.helpers.Prefs;
import cse.duytan.coms.models.Account;
import cse.duytan.coms.models.Token;
import cse.duytan.coms.models.User;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.untils.DebugLog;
import cse.duytan.coms.views.LoginView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * Created by Pham Van Thien on 6/15/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class LoginPresenter extends BasePresenter {
    private LoginView loginView;
    private Context context;
    private String username, password;

    public LoginPresenter(Context context, LoginView loginView) {
        this.context = context;
        this.loginView = loginView;
    }

    public void checkIsLogin() {
        Token token = Prefs.getToken();
        if (token != null) {
            loginView.success();
        }
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
                this.username = username;
                this.password = password;

                JSONObject postData = new JSONObject();
                postData.put("Username", username);
                postData.put("Password", password);
                DownloadAsyncTask.POST(context, ID_API_LOGIN, API_LOGIN, postData.toString(), User.class, true, this);
            } catch (Exception e) {
                DebugLog.logD(TAG, e.toString());
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
        if (processId == ID_API_LOGIN) {
            getToken(username, password);
            User user = (User) data;
            if (user != null) {
                Log.d(TAG, "downloadSuccess: " + user.getFullname());
                Prefs.setUser(user);
            }
        } else if (processId == ID_API_GET_TOKEN) {
            Token token = (Token) data;
            Prefs.setToken(token);
            loginView.success();
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        loginView.error(msg);
    }
}
