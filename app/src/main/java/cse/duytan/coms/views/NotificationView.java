package cse.duytan.coms.views;

import java.util.ArrayList;

import cse.duytan.coms.models.Notification;

/**
 * Created by Pham Van Thien on 8/30/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public interface NotificationView {
    void success(ArrayList<Notification> listNotification);
    void deleteNotificationSuccess();
    void error(String msg);
    void empty();
}
