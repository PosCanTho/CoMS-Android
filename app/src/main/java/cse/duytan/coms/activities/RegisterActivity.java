package cse.duytan.coms.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;
import cse.duytan.coms.dialogs.ChooseAvatarDialog;
import cse.duytan.coms.dialogs.ConfirmOkDialog;
import cse.duytan.coms.dialogs.CropImageDialog;
import cse.duytan.coms.models.CircleImageView;
import cse.duytan.coms.presenters.RegisterPresenter;
import cse.duytan.coms.untils.Utils;
import cse.duytan.coms.views.RegisterView;

public class RegisterActivity extends BaseActivity implements RegisterView {

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
    @BindView(R.id.rBtnMale)
    RadioButton rBtnMale;
    @BindView(R.id.rBtnFemale)
    RadioButton rBtnFemale;
    private File fileAvatar;
    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        context = RegisterActivity.this;
        initUI();
    }


    private void initUI() {
        showHomeButton();

        registerPresenter = new RegisterPresenter(this, this);
        btnRegister.setTypeface(Utils.getFonts(this, R.string.font_nunito_regular));
        rBtnMale.setTypeface(Utils.getFonts(this, R.string.font_roboto_regular));
        rBtnFemale.setTypeface(Utils.getFonts(this, R.string.font_roboto_regular));
    }

    private void openAlbum() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(i, SELECT_PHOTO);
    }

    private void openCamera() {
        fileAvatar = Utils.createImageFile();
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        i.putExtra(MediaStore.EXTRA_OUTPUT, FileProvider.getUriForFile(RegisterActivity.this, getPackageName() + ".my.package.name.provider", fileAvatar));
        startActivityForResult(i, TAKE_PHOTO);
    }

    private void onRegister() {
        String fullName = etFullname.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String userName = etUsername.getText().toString().trim();
        String passWord = etPassword.getText().toString();
        String confirmPassword = etConfirmPassword.getText().toString();
        int gender;
        if (rBtnFemale.isChecked() == false && rBtnMale.isChecked() == false) {
            gender = -1;
        } else {
            gender = rBtnMale.isChecked() ? 1 : 0;
        }
        registerPresenter.register(fullName, email, gender, userName, passWord, confirmPassword);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.ibtnChooseAvatar, R.id.btnRegister, R.id.tvSignin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ibtnChooseAvatar:
                new ChooseAvatarDialog(this, this).show();
                break;
            case R.id.btnRegister:
                onRegister();
                break;
            case R.id.tvSignin:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void popupCalback(int processId, Object data) {
        if (processId == R.id.ivTakePhoto || processId == R.id.tvTakePhoto) {
            ActivityCompat.requestPermissions(RegisterActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, TAKE_PHOTO);
        } else if (processId == R.id.ivSelectPhoto || processId == R.id.tvSelectPhoto) {
            ActivityCompat.requestPermissions(RegisterActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, SELECT_PHOTO);
        } else if (processId == TAKE_PHOTO || processId == SELECT_PHOTO) {
            ivAvatar.setImageBitmap((Bitmap) data);
            fileAvatar.deleteOnExit();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case TAKE_PHOTO:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openCamera();
                } else {
                    Toast.makeText(this, getString(R.string.msg_permission_denied_to_write_your_external_storage), Toast.LENGTH_SHORT).show();
                }
                break;
            case SELECT_PHOTO:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openAlbum();
                } else {
                    Toast.makeText(this, getString(R.string.msg_permission_denied_to_write_your_external_storage), Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
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

    @Override
    public void error(String msg) {
        new ConfirmOkDialog(context, msg, null).show();
    }

    @Override
    public void success() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
