package cse.duytan.coms.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edUsername)
    EditText edUsername;
    @BindView(R.id.btnSignin)
    Button btnSignin;
    @BindView(R.id.tvSignup)
    TextView tvSignup;
    @BindView(R.id.edPassword)
    EditText edPassword;
    @BindView(R.id.tvForgot)
    TextView tvForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnSignin, R.id.tvForgot})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnSignin:
                break;
            case R.id.tvForgot:
                break;
        }
    }
}
