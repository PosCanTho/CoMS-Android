package cse.duytan.coms.presenters;

import android.content.Context;

import cse.duytan.coms.R;
import cse.duytan.coms.views.LoginView;

/**
 * Created by Pham Van Thien on 6/15/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class LoginPresenter {
    private LoginView loginView;
    private Context context;

    public LoginPresenter(Context context, LoginView loginView) {
        this.context = context;
        this.loginView = loginView;
    }

    public void login(String username, String password) {
        if (username.equals("")){
            loginView.error(context.getString(R.string.msg_please_enter_username));
        }else if (password.equals("")){
            loginView.error(context.getString(R.string.msg_please_enter_password));
        }else{
            loginView.success();
        }
    }
}
