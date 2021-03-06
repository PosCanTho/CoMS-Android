package cse.duytan.coms.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
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
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.untils.Utils;

/**
 * Created by Pham Van Thien on 6/16/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ForgotPasswordDialog extends Dialog implements DownloadCallback, Constants {
    @BindView(R.id.ibtnLose)
    ImageButton ibtnLose;
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.btnConfirm)
    Button btnConfirm;

    private Context context;

    public ForgotPasswordDialog(@NonNull Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_forgot_password);
        setCancelable(true);
        this.context = context;
        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        ButterKnife.bind(this);
        btnConfirm.setTypeface(Utils.getFonts(context, R.string.font_nunito_regular));
    }

    @OnClick({R.id.ibtnLose, R.id.btnConfirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ibtnLose:
                dismiss();
                break;
            case R.id.btnConfirm:
                String email = etEmail.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    new ConfirmOkDialog(getContext(), getContext().getString(R.string.msg_please_enter_email), null).show();
                } else if (!Utils.isEmailValid(email)) {
                    new ConfirmOkDialog(getContext(), getContext().getString(R.string.msg_email_invalid), null).show();
                } else {
                    DownloadAsyncTask.GET(context, ID_API_FORGOT_PASSWORD, API_FORGOT_PASSWORD+"?email="+email, null, true, this);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        new ConfirmOkDialog(getContext(), getContext().getString(R.string.msg_your_password_has_been_changed), null).show();
        dismiss();
    }

    @Override
    public void downloadError(int processId, String msg) {
        new ConfirmOkDialog(getContext(), msg, null).show();
    }
}
