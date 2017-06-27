package cse.duytan.coms.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;
import cse.duytan.coms.helpers.AnimationHelper;
import cse.duytan.coms.untils.PopupCalback;

/**
 * Created by Pham Van Thien on 6/22/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ChooseAvatarDialog extends Dialog implements Animation.AnimationListener {
    @BindView(R.id.ivTakePhoto)
    ImageView ivTakePhoto;
    @BindView(R.id.tvTakePhoto)
    TextView tvTakePhoto;
    @BindView(R.id.ivSelectPhoto)
    ImageView ivSelectPhoto;
    @BindView(R.id.tvSelectPhoto)
    TextView tvSelectPhoto;
    @BindView(R.id.clMain)
    ConstraintLayout clMain;
    @BindView(R.id.tvSpase)
    TextView tvSpase;

    private PopupCalback popupCalback;
    private Animation slideDown;

    public ChooseAvatarDialog(@NonNull Context context, PopupCalback popupCalback) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_choose_avatar);
        setCancelable(true);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        this.popupCalback = popupCalback;
        ButterKnife.bind(this);

        clMain.setAnimation(AnimationHelper.slideUp(context));
        slideDown = AnimationHelper.slideDown(context);
        slideDown.setAnimationListener(this);
    }

    @OnClick({R.id.ivTakePhoto, R.id.tvTakePhoto, R.id.ivSelectPhoto, R.id.tvSelectPhoto, R.id.tvSpase})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivTakePhoto:
                clMain.startAnimation(slideDown);
                popupCalback.popupCalback(R.id.ivTakePhoto, null);
                break;
            case R.id.tvTakePhoto:
                clMain.startAnimation(slideDown);
                popupCalback.popupCalback(R.id.tvTakePhoto, null);
                break;
            case R.id.ivSelectPhoto:
                clMain.startAnimation(slideDown);
                popupCalback.popupCalback(R.id.ivSelectPhoto, null);
                break;
            case R.id.tvSelectPhoto:
                clMain.startAnimation(slideDown);
                popupCalback.popupCalback(R.id.tvSelectPhoto, null);
                break;
            case R.id.tvSpase:
                clMain.startAnimation(slideDown);
                break;
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        dismiss();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
