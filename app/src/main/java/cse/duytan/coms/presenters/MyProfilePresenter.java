package cse.duytan.coms.presenters;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;

import cse.duytan.coms.R;
import cse.duytan.coms.activities.MyProfileActivity;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.dialogs.ConfirmOkDialog;
import cse.duytan.coms.helpers.Prefs;
import cse.duytan.coms.models.User;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.untils.Utils;
import cse.duytan.coms.views.MyProfileView;

/**
 * Created by Pham Van Thien on 8/17/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class MyProfilePresenter extends BasePresenter {
    private Context context;
    private MyProfileView myProfileView;

    public MyProfilePresenter(Context context, MyProfileView myProfileView) {
        this.context = context;
        this.myProfileView = myProfileView;
    }

    public void getMyProfile(int personId) {
        DownloadAsyncTask.GET(context, ID_API_GET_MY_PROFILE, API_GET_MY_PROFILE + "?id=" + personId, User.class, true, this);
    }

    public void editUser(User user) {
        if (TextUtils.isEmpty(user.getFullname())) {
            new ConfirmOkDialog(context, context.getString(R.string.msg_please_enter_full_name), null).show();
        } else if (TextUtils.isEmpty(user.getEmail())) {
            new ConfirmOkDialog(context, context.getString(R.string.msg_please_enter_email), null).show();
        } else if (!Utils.isEmailValid(user.getEmail())) {
            new ConfirmOkDialog(context, context.getString(R.string.msg_email_invalid), null).show();
        } else if (TextUtils.isEmpty(user.getPhoneNumber())) {
            new ConfirmOkDialog(context, context.getString(R.string.msg_please_enter_phone_number), null).show();
        } else if (TextUtils.isEmpty(user.getBirthDay())) {
            new ConfirmOkDialog(context, context.getString(R.string.msg_please_enter_birth_day), null).show();
        } else if (user.getGender() == -1) {
            new ConfirmOkDialog(context, context.getString(R.string.msg_please_select_gender), null).show();
        }else{
            DownloadAsyncTask.POST(context, ID_API_EDIT_PROFILE, API_EDIT_PROFILE, new Gson().toJson(user), null, true, this);
        }
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        if (processId == ID_API_GET_MY_PROFILE) {
            User user = (User) data;
            Prefs.setUser(user);
            myProfileView.success(user);
        } else if (processId == ID_API_EDIT_PROFILE) {

        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        myProfileView.error(msg);
    }
}
