package cse.duytan.coms.fcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;

import org.json.JSONObject;

import cse.duytan.coms.R;
import cse.duytan.coms.activities.ChatActivity;
import cse.duytan.coms.activities.MainActivity;
import cse.duytan.coms.activities.MapActivity;
import cse.duytan.coms.activities.MyProfileActivity;
import cse.duytan.coms.helpers.Prefs;
import cse.duytan.coms.models.ChatBody;
import cse.duytan.coms.models.Message;
import cse.duytan.coms.presenters.ChatPresenter;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.untils.Utils;
import cse.duytan.coms.views.ChatView;
import me.leolin.shortcutbadger.ShortcutBadger;

/**
 * Created by Pham Van Thien on 7/25/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService implements Constants {

    private static final String READ_ACTION =
            "cse.duytan.coms.fcm.ACTION_MESSAGE_READ";
    public static int NOTIFICATION_ID = 1111;
    private LocalBroadcastManager broadcastManager;

    private Handler handler;
    private static final int MESSAGE_DONE = 101;

    @Override
    public void onCreate() {
        super.onCreate();
        broadcastManager = LocalBroadcastManager.getInstance(this);
        handler = new Handler() {
            @Override
            public void handleMessage(android.os.Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case MESSAGE_DONE:
                        break;
                }
            }
        };
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String data = remoteMessage.getData().toString();
        try {
            JSONObject json = new JSONObject(data);
            String jsonData = json.getString("Data");
            Message message = new Gson().fromJson(jsonData, Message.class);

            if (message.getConversationReplyId() != 0) {//Khi đây là tin nhắn
                if (Prefs.getNotification() && (Prefs.getIdCurrentRead() != message.getPersonIdFrom())) {
                    pushNotification(remoteMessage.getNotification(), message);
                } else {
                    if (Prefs.getNotification())
                        Utils.ringTone(getApplicationContext(), RingtoneManager.TYPE_NOTIFICATION);

                    Intent i = new Intent("Message");
                    i.putExtra("data", jsonData);
                    broadcastManager.sendBroadcast(i);
                }
            } else {//Khi đây là thông báo
                if (Prefs.getNotification() && !Prefs.getViewNotification()) {
                    pushNotification(remoteMessage.getNotification(), message);
                } else {
                    if (Prefs.getNotification())
                        Utils.ringTone(getApplicationContext(), RingtoneManager.TYPE_NOTIFICATION);
                }

                cse.duytan.coms.models.Notification notification = new Gson().fromJson(jsonData, cse.duytan.coms.models.Notification.class);
                ShortcutBadger.applyCount(this, notification.getNumberUnread());

                Intent i = new Intent("Notification");
                i.putExtra("data", jsonData);
                broadcastManager.sendBroadcast(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleIntent(Intent intent) {
        super.handleIntent(intent);
    }

    private void pushNotification(final RemoteMessage.Notification notificationData, final Message message) {
        final Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                Intent intent;
                if (message.getConversationReplyId() != 0) {
                    intent = new Intent(MyFirebaseMessagingService.this, ChatActivity.class);
                    intent.putExtra("personIdTo", message.getPersonIdFrom());
                    intent.putExtra("name", notificationData.getTitle());
                    intent.putExtra("task", "New");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                } else {
                    intent = new Intent(MyFirebaseMessagingService.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("personIdTo", message.getPersonIdTo());
                }

                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                NotificationCompat.Builder noticationBuilder = new NotificationCompat.Builder(MyFirebaseMessagingService.this)
                        .setSmallIcon(R.drawable.ic_chat)
                        .setContentTitle(notificationData.getTitle())
                        .setContentText(notificationData.getBody())
                        .setAutoCancel(true)
                        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                        .setContentIntent(pendingIntent);

                if (noticationBuilder != null) {
                    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    Notification notification = noticationBuilder.build();
                    notificationManager.notify(message.getPersonIdFrom(), notification);
                }

                handler.sendEmptyMessage(MESSAGE_DONE);
            }
        };
        thread.start();

    }


}
