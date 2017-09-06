package cse.duytan.coms.presenters;

import android.content.Context;

import org.json.JSONObject;

import java.util.ArrayList;

import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.helpers.Prefs;
import cse.duytan.coms.models.Notification;
import cse.duytan.coms.models.UpdateReaded;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.views.NotificationView;
import me.leolin.shortcutbadger.ShortcutBadger;

/**
 * Created by Pham Van Thien on 8/30/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class NotificationPresenter extends BasePresenter {
    private Context context;
    private NotificationView notificationView;

    public NotificationPresenter(Context context, NotificationView notificationView) {
        this.context = context;
        this.notificationView = notificationView;
    }

    public void getListNotification(int personId, int page, int pageSize, boolean showDialog) {
        try {
            JSONObject postData = new JSONObject();
            postData.put("PersonId", personId);
            postData.put("Page", page);
            postData.put("PageSize", pageSize);
            DownloadAsyncTask.POST(context, ID_API_LIST_NOTIFICATION, API_LIST_NOTIFICATION, postData.toString(), Notification.class, showDialog, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateReaded(int personId, int notificationId) {
        try {
            JSONObject postData = new JSONObject();
            postData.put("PersonId", personId);
            postData.put("NotificationId", notificationId);
            DownloadAsyncTask.POST(context, ID_API_UPDATE_READED, API_UPDATE_READED, postData.toString(), UpdateReaded.class, false, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteNotification(int personId) {
        DownloadAsyncTask.GET(context, ID_API_DELETE_NOTIFICATION, API_DELETE_NOTIFICATION + "?personId=" + personId, null, false, this);
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        super.downloadSuccess(processId, data);
        if (processId == ID_API_LIST_NOTIFICATION) {
            ArrayList<Notification> listNotification = (ArrayList<Notification>) data;
            if (listNotification.isEmpty()) {
                notificationView.empty();
            } else {
                notificationView.success(listNotification);
            }
        } else if (processId == ID_API_DELETE_NOTIFICATION) {
            notificationView.deleteNotificationSuccess();
            ShortcutBadger.removeCount(context);
        } else if (processId == ID_API_UPDATE_READED) {
            UpdateReaded updateReaded = (UpdateReaded) data;
            ShortcutBadger.applyCount(context, updateReaded.getNumberUnread());
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        super.downloadError(processId, msg);
        if (processId == ID_API_LIST_NOTIFICATION) {
            notificationView.error(msg);
        }
    }
}
