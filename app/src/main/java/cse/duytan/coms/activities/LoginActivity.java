package cse.duytan.coms.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.dialogs.ConfirmOkDialog;
import cse.duytan.coms.dialogs.ForgotPasswordDialog;
import cse.duytan.coms.models.User;
import cse.duytan.coms.presenters.LoginPresenter;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.untils.DebugLog;
import cse.duytan.coms.untils.Utils;
import cse.duytan.coms.views.LoginView;

public class LoginActivity extends BaseActivity implements LoginView, Constants {

    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.btnSignin)
    Button btnSignin;
    @BindView(R.id.tvSignup)
    TextView tvSignup;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.tvForgot)
    TextView tvForgot;

    private Context context;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        this.context = LoginActivity.this;
        initUI();
    }

    @OnClick({R.id.btnSignin, R.id.tvForgot, R.id.tvSignup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnSignin:
                loginPresenter.login(etUsername.getText().toString().trim(), etPassword.getText().toString().trim());
                break;
            case R.id.tvForgot:
                new ForgotPasswordDialog(LoginActivity.this).show();
                break;
            case R.id.tvSignup:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }

    private void initUI() {
        loginPresenter = new LoginPresenter(this, this);
        btnSignin.setTypeface(Utils.getFonts(this, R.string.font_nunito_regular));
    }


    @Override
    public void error(String msg) {
        new ConfirmOkDialog(this, msg, this).show();
    }

    @Override
    public void success() {
        new ConfirmOkDialog(this, "Success", this).show();
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        //  User user = (User) data;
        // Toast.makeText(context, "Hello, "+user.Table.get(0).getUserName(), Toast.LENGTH_SHORT).show();
        /// startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @Override
    public void downloadError(int processId, final String msg) {
        super.downloadError(processId, msg);

    }
}
