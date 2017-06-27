package cse.duytan.coms.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.untils.PopupCalback;

/**
 * Created by Pham Van Thien on 6/17/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class CropImageDialog extends Dialog implements Constants {
    @BindView(R.id.cropImageView)
    CropImageView cropImageView;
    @BindView(R.id.ivClose)
    ImageView ivClose;
    @BindView(R.id.ivRotate)
    ImageView ivRotate;
    @BindView(R.id.ivDone)
    ImageView ivDone;

    private PopupCalback popupCalback;
    private int processId;

    public CropImageDialog(@NonNull Context context, int processId, Uri imageUri, PopupCalback popupCalback) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_crop_image);
        setCancelable(true);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        this.popupCalback = popupCalback;
        ButterKnife.bind(this);
        this.processId = processId;
        cropImageView.setImageUriAsync(imageUri);
        cropImageView.setMinCropResultSize(600, 600);
    }

    @OnClick({R.id.ivClose, R.id.ivRotate, R.id.ivDone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivClose:
                dismiss();
                break;
            case R.id.ivRotate:
                cropImageView.rotateImage(90);
                break;
            case R.id.ivDone:
                popupCalback.popupCalback(processId, cropImageView.getCroppedImage());
                dismiss();
                break;
        }
    }
}
