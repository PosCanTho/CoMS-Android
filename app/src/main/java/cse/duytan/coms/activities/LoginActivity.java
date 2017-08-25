package cse.duytan.coms.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
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
import cse.duytan.coms.helpers.Prefs;
import cse.duytan.coms.models.Token;
import cse.duytan.coms.models.User;
import cse.duytan.coms.presenters.LoginPresenter;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.untils.DebugLog;
import cse.duytan.coms.untils.Utils;
import cse.duytan.coms.views.LoginView;

public class LoginActivity extends BaseActivity implements LoginView, Constants, EditText.OnEditorActionListener {

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
                onLogin();
                break;
            case R.id.tvForgot:
                new ForgotPasswordDialog(LoginActivity.this).show();
                break;
            case R.id.tvSignup:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
                break;
        }
    }

    private void initUI() {
        loginPresenter = new LoginPresenter(this, this);
        loginPresenter.checkIsLogin();
        btnSignin.setTypeface(Utils.getFonts(this, R.string.font_nunito_regular));

        etUsername.setText("pvthiendeveloper");
        etPassword.setText("123456");

        etPassword.setOnEditorActionListener(this);
    }

    private void onLogin(){
        loginPresenter.login(etUsername.getText().toString().trim(), etPassword.getText().toString().trim());
    }


    @Override
    public void error(String msg) {
        new ConfirmOkDialog(this, msg, this).show();
    }

    @Override
    public void success() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if(actionId == EditorInfo.IME_ACTION_GO){
            onLogin();
        }
        return false;
    }
}
