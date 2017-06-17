package cse.duytan.coms.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;

/**
 * Created by Pham Van Thien on 6/16/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ForgotPasswordDialog extends Dialog {
    @BindView(R.id.ibtnLose)
    ImageButton ibtnLose;
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.btnConfirm)
    Button btnConfirm;

    public ForgotPasswordDialog(@NonNull Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_forgot_password);
        setCancelable(true);
        this.getWindow().setBackgroundDrawable(context.getResources().getDrawable(R.color.transparent_white));
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ibtnLose, R.id.btnConfirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ibtnLose:
                dismiss();
                break;
            case R.id.btnConfirm:
                break;
        }
    }
}
