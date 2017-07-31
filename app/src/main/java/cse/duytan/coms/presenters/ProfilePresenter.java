package cse.duytan.coms.presenters;

import android.content.Context;

import org.json.JSONObject;

import cse.duytan.coms.R;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.models.Profile;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.views.ProfileView;

/**
 * Created by Pham Van Thien on 7/27/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ProfilePresenter extends BasePresenter {
    private Context context;
    private ProfileView profileView;

    public ProfilePresenter(Context context, ProfileView profileView) {
        this.context = context;
        this.profileView = profileView;
    }

    public void getProfile(int personId, int personIdBookmark) {
        try {
            JSONObject postData = new JSONObject();
            postData.put("PersonId", personId);
            postData.put("PersonIdBookmark", personIdBookmark);
            DownloadAsyncTask.POST(context, ID_API_GET_PROFILE, API_GET_PROFILE, postData.toString(), Profile.class, true, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBookmark(int personId, int personIdBookmark){
        try {
            JSONObject postData = new JSONObject();
            postData.put("PersonId", personId);
            postData.put("PersonIdBookmark", personIdBookmark);
            DownloadAsyncTask.POST(context, ID_API_ADD_BOOKMARK, API_ADD_BOOKMARK, postData.toString(), null, true, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBookmark(int personId, int personIdBookmark){
        try {
            JSONObject postData = new JSONObject();
            postData.put("PersonId", personId);
            postData.put("PersonIdBookmark", personIdBookmark);
            DownloadAsyncTask.POST(context, ID_API_DELETE_BOOKMARK, API_DELETE_BOOKMARK, postData.toString(), null, true, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        if(processId == ID_API_GET_PROFILE){
            profileView.success((Profile)data);
        }else if(processId == ID_API_ADD_BOOKMARK){
            profileView.error(context.getString(R.string.msg_add_bookmark_success));
            profileView.invalidMenu();
        }else if(processId == ID_API_DELETE_BOOKMARK){
            profileView.error(context.getString(R.string.msg_delete_bookmark_success));
            profileView.invalidMenu();
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        profileView.error(msg);
    }
}
