package cse.duytan.coms.activities;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;
import cse.duytan.coms.dialogs.ChangePasswordDialog;
import cse.duytan.coms.dialogs.ChooseAvatarDialog;
import cse.duytan.coms.dialogs.ConfirmOkDialog;
import cse.duytan.coms.dialogs.CropImageDialog;
import cse.duytan.coms.helpers.Prefs;
import cse.duytan.coms.models.CircleImageView;
import cse.duytan.coms.models.User;
import cse.duytan.coms.presenters.MyProfilePresenter;
import cse.duytan.coms.untils.DateTimeFormater;
import cse.duytan.coms.untils.Utils;
import cse.duytan.coms.views.MyProfileView;

public class MyProfileActivity extends BaseActivity implements MyProfileView, DatePickerDialog.OnDateSetListener {

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
    private MyProfilePresenter myProfilePresenter;
    private User user;
    private Calendar calendar;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        user = new User();

        rBtnMale.setTypeface(Utils.getFonts(this, R.string.font_nunito_regular));
        rBtnFemale.setTypeface(Utils.getFonts(this, R.string.font_nunito_regular));
        showHomeButton();
        myProfilePresenter = new MyProfilePresenter(this, this);
        myProfilePresenter.getMyProfile(Prefs.getUser().getPersonId());
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
            etBirth.setEnabled(true);
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
            etBirth.setEnabled(false);
            rBtnMale.setEnabled(false);
            rBtnFemale.setEnabled(false);
        }
    }

    private void openAlbum() {
        fileAvatar = Utils.createImageFile();
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(i, SELECT_PHOTO);
    }

    private void openCamera() {
        fileAvatar = Utils.createImageFile();
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        i.putExtra(MediaStore.EXTRA_OUTPUT, FileProvider.getUriForFile(MyProfileActivity.this, getPackageName() + ".my.package.name.provider", fileAvatar));
        startActivityForResult(i, TAKE_PHOTO);
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

    @OnClick({R.id.ibtnChooseAvatar, R.id.tvChangePassword, R.id.tvManagePackage, R.id.etBirth})
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
            case R.id.etBirth:
                calendar = Calendar.getInstance();
                 year = calendar.get(Calendar.YEAR);
                 month = calendar.get(Calendar.MONTH);
                 day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(this, this, year, month, day);
                dialog.show();
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
                user.setPersonId(Prefs.getUser().getPersonId());
                user.setFullname(etFullname.getText().toString().trim());
                user.setEmail(etEmail.getText().toString().trim());
                user.setBirthDay(etBirth.getText().toString().trim());
                user.setPhoneNumber(etPhone.getText().toString().trim());
                if (rBtnFemale.isChecked() == false && rBtnMale.isChecked() == false) {
                    user.setGender(-1);
                } else {
                    user.setGender(rBtnMale.isChecked() ? 0 : 1);
                }
                myProfilePresenter.editUser(user);
                break;
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void popupCalback(int processId, Object data) {
        if (processId == R.id.ivTakePhoto || processId == R.id.tvTakePhoto) {
            ActivityCompat.requestPermissions(MyProfileActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, TAKE_PHOTO);
        } else if (processId == R.id.ivSelectPhoto || processId == R.id.tvSelectPhoto) {
            ActivityCompat.requestPermissions(MyProfileActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, SELECT_PHOTO);
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
    public void success(User user) {
        etFullname.setText(user.getFullname());
        etEmail.setText(user.getEmail());
        etPhone.setText(user.getPhoneNumber());
        etBirth.setText(DateTimeFormater.stringToTime(user.getBirthDay(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.MMM_d_YYYY));
        if (user.getGender() == 0) {
            rBtnMale.setChecked(true);
        } else {
            rBtnFemale.setChecked(true);
        }
    }

    @Override
    public void error(String msg) {
        new ConfirmOkDialog(this, msg, null).show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String stringDate = year + "-" + (month+1) + "-" + dayOfMonth;
        if(DateTimeFormater.stringToDate(stringDate,DateTimeFormater.YYYY_MM_DD).after(DateTimeFormater.currentDate())){
            new ConfirmOkDialog(this,getString(R.string.msg_birth_date_is_not_greater_than_the),null).show();
        }else{
            etBirth.setText(DateTimeFormater.stringToTime(stringDate, DateTimeFormater.YYYY_MM_DD, DateTimeFormater.MMM_d_YYYY));
            user.setBirthDay(stringDate);
        }
    }
}
