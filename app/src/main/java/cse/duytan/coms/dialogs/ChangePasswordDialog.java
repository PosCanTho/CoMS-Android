package cse.duytan.coms.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;

/**
 * Created by Pham Van Thien on 6/26/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ChangePasswordDialog extends Dialog {


    @BindView(R.id.etOldPass)
    EditText etOldPass;
    @BindView(R.id.etNewPass)
    EditText etNewPass;
    @BindView(R.id.etConfirmPass)
    EditText etConfirmPass;
    @BindView(R.id.btnCancel)
    Button btnCancel;
    @BindView(R.id.btnYes)
    Button btnYes;

    public ChangePasswordDialog(@NonNull Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_change_password);
        setCancelable(false);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btnCancel, R.id.btnYes})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnCancel:
                dismiss();
                break;
            case R.id.btnYes:
                break;
        }
    }
}
