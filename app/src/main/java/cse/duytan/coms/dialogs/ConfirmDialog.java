package cse.duytan.coms.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;
import cse.duytan.coms.untils.PopupCalback;

/**
 * Created by Pham Van Thien on 6/17/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ConfirmDialog extends Dialog {

    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvMsg)
    TextView tvMsg;
    @BindView(R.id.btnCancel)
    Button btnCancel;
    @BindView(R.id.btnYes)
    Button btnYes;
    private String title, msg;
    private PopupCalback popupCalback;
    public ConfirmDialog(@NonNull Context context, String title, String message, PopupCalback popupCalback) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_confirm);
        setCancelable(true);
        this.getWindow().setBackgroundDrawable(context.getResources().getDrawable(R.color.transparent_white));
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        this.title = title;
        this.msg = message;
        this.popupCalback = popupCalback;
        ButterKnife.bind(this);
        initUI();
    }

    public ConfirmDialog(@NonNull Context context, String message, PopupCalback popupCalback) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_confirm);
        setCancelable(true);
        this.getWindow().setBackgroundDrawable(context.getResources().getDrawable(R.color.transparent_white));
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        this.title = getContext().getString(R.string.app_name);
        this.msg = message;
        this.popupCalback = popupCalback;
        ButterKnife.bind(this);
        initUI();
    }


    private void initUI() {
        tvTitle.setText(title);
        tvMsg.setText(msg);
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
