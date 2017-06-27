package cse.duytan.coms.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.*;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;
import cse.duytan.coms.dialogs.ChooseAvatarDialog;
import cse.duytan.coms.dialogs.CropImageDialog;
import cse.duytan.coms.helpers.ScreenHelper;
import cse.duytan.coms.models.CircleImageView;
import cse.duytan.coms.untils.CircleTransform;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.untils.PopupCalback;
import cse.duytan.coms.untils.Utils;

public class RegisterActivity extends BaseActivity implements Constants, PopupCalback {

    @BindView(R.id.ivAvatar)
    CircleImageView ivAvatar;
    @BindView(R.id.ibtnChooseAvatar)
    ImageButton ibtnChooseAvatar;
    @BindView(R.id.etFullname)
    EditText etFullname;
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.etConfirmPassword)
    EditText etConfirmPassword;
    @BindView(R.id.btnRegister)
    Button btnRegister;
    @BindView(R.id.tvSignin)
    TextView tvSignin;

    private static final int TAKE_PHOTO = 1;
    private static final int SELECT_PHOTO = 2;
    private final String TAG = this.getClass().getSimpleName();

    private static Context context;
    private File fileAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        context = RegisterActivity.this;
        fileAvatar = Utils.createImageFile();
    }

    @OnClick({R.id.ibtnChooseAvatar, R.id.btnRegister, R.id.tvSignin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ibtnChooseAvatar:
                new ChooseAvatarDialog(this, this).show();
                break;
            case R.id.btnRegister:
                break;
            case R.id.tvSignin:
                finish();
                break;
        }
    }

    private void openAlbum() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(i, SELECT_PHOTO);
    }

    private void openCamera() {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(fileAvatar));
        startActivityForResult(i, TAKE_PHOTO);
    }

    @Override
    public void popupCalback(int processId, Object data) {
        if (processId == R.id.ivTakePhoto || processId == R.id.tvTakePhoto) {
            openCamera();
        } else if (processId == R.id.ivSelectPhoto || processId == R.id.tvSelectPhoto) {
            openAlbum();
        } else if (processId == TAKE_PHOTO || processId == SELECT_PHOTO) {
            ivAvatar.setImageBitmap((Bitmap) data);
            fileAvatar.deleteOnExit();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == TAKE_PHOTO) {
                if (fileAvatar.exists()) {
                    Uri imageUri = Uri.fromFile(fileAvatar);
                    new CropImageDialog(this, TAKE_PHOTO, imageUri, this).show();
                }
            } else if (requestCode == SELECT_PHOTO) {
                new CropImageDialog(this, SELECT_PHOTO, data.getData(), this).show();
            }
        }
    }
}
