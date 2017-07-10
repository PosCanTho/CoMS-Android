package cse.duytan.coms.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;
import cse.duytan.coms.dialogs.ChangePasswordDialog;
import cse.duytan.coms.dialogs.ChooseAvatarDialog;
import cse.duytan.coms.dialogs.CropImageDialog;
import cse.duytan.coms.models.CircleImageView;
import cse.duytan.coms.untils.Utils;

public class MyProfileActivity extends BaseActivity {

    @BindView(R.id.ivAvatar)
    CircleImageView ivAvatar;
    @BindView(R.id.ibtnChooseAvatar)
    ImageButton ibtnChooseAvatar;
    @BindView(R.id.etFullname)
    EditText etFullname;
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.tvChangePassword)
    TextView tvChangePassword;
    @BindView(R.id.tvManagePackage)
    TextView tvManagePackage;
    @BindView(R.id.etPhone)
    EditText etPhone;
    @BindView(R.id.etBirth)
    EditText etBirth;
    @BindView(R.id.rBtnMale)
    RadioButton rBtnMale;
    @BindView(R.id.rBtnFemale)
    RadioButton rBtnFemale;
    @BindView(R.id.rgGender)
    RadioGroup rgGender;

    private boolean IS_EDIT = false;
    private static final int TAKE_PHOTO = 1;
    private static final int SELECT_PHOTO = 2;

    private File fileAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        ButterKnife.bind(this);
        initUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (IS_EDIT) {
            getMenuInflater().inflate(R.menu.my_profile_edit_menu, menu);
        } else {
            getMenuInflater().inflate(R.menu.my_profile_menu, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @OnClick({R.id.ibtnChooseAvatar, R.id.tvChangePassword, R.id.tvManagePackage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ibtnChooseAvatar:
                new ChooseAvatarDialog(this, this).show();
                break;
            case R.id.tvChangePassword:
                new ChangePasswordDialog(MyProfileActivity.this).show();
                break;
            case R.id.tvManagePackage:
                Toast.makeText(this, "Chưa có giao diện.", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.actionEdit:
                IS_EDIT = !IS_EDIT;
                invalidateOptionsMenu();
                onEdit();
                break;
            case R.id.actionDone:
                IS_EDIT = !IS_EDIT;
                invalidateOptionsMenu();
                onEdit();
                break;
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initUI() {
        fileAvatar = Utils.createImageFile();

        rBtnMale.setTypeface(Utils.getFonts(this, R.string.font_nunito_regular));
        rBtnFemale.setTypeface(Utils.getFonts(this, R.string.font_nunito_regular));
        showHomeButton();
    }

    private void onEdit() {
        if (IS_EDIT) {
            ibtnChooseAvatar.setVisibility(View.VISIBLE);
            etFullname.setFocusable(true);
            etFullname.setFocusableInTouchMode(true);
            etEmail.setFocusable(true);
            etEmail.setFocusableInTouchMode(true);
            etPhone.setFocusable(true);
            etPhone.setFocusableInTouchMode(true);
            etBirth.setFocusable(true);
            etBirth.setFocusableInTouchMode(true);
            rBtnMale.setEnabled(true);
            rBtnFemale.setEnabled(true);
        } else {
            ibtnChooseAvatar.setVisibility(View.INVISIBLE);
            etFullname.setFocusable(false);
            etFullname.setFocusableInTouchMode(false);
            etEmail.setFocusable(false);
            etEmail.setFocusableInTouchMode(false);
            etPhone.setFocusable(false);
            etPhone.setFocusableInTouchMode(false);
            etBirth.setFocusable(false);
            etBirth.setFocusableInTouchMode(false);
            rBtnMale.setEnabled(false);
            rBtnFemale.setEnabled(false);
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
