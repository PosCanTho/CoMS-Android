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
import cse.duytan.coms.helpers.Prefs;
import cse.duytan.coms.models.ChatBody;
import cse.duytan.coms.models.Message;
import cse.duytan.coms.presenters.ChatPresenter;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.views.ChatView;

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
        handler = new Handler(){
            @Override
            public void handleMessage(android.os.Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case MESSAGE_DONE:
                        Toast.makeText(MyFirebaseMessagingService.this, "DONE", Toast.LENGTH_SHORT).show();
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
            Intent i = new Intent("Message");
            i.putExtra("message", jsonData);
            Message message = new Gson().fromJson(jsonData, Message.class);
            broadcastManager.sendBroadcast(i);
            Log.d(TAG, "getIdCurrentRead: " + Prefs.getIdCurrentRead());
            Log.d(TAG, "getPersonIdFrom: " + message.getPersonIdFrom());
            if (Prefs.getNotification() && (Prefs.getIdCurrentRead() != message.getPersonIdFrom())) {
//                sendNotification(remoteMessage.getNotification(), message);
                pushNotification(remoteMessage.getNotification(), message);
            } else {
                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                r.play();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleIntent(Intent intent) {
        super.handleIntent(intent);
        // Intent i = new Intent(this, MyService.class);
        //  startService(i);
//        Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
    }

    private void sendNotification(RemoteMessage.Notification notificationData, Message message) {
        Intent intent = new Intent(this, ChatActivity.class);
        intent.putExtra("personIdTo", message.getPersonIdFrom());
        intent.putExtra("name", notificationData.getTitle());
        intent.putExtra("task", "New");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder noticationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_chat)
                .setContentTitle(notificationData.getTitle())
                .setContentText(notificationData.getBody())
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentIntent(pendingIntent);

        if (noticationBuilder != null) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            Notification notification = noticationBuilder.build();
            notificationManager.notify(NOTIFICATION_ID, notification);
        }
    }

    private void pushNotification(final RemoteMessage.Notification notificationData, final Message message) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                Intent intent = new Intent(MyFirebaseMessagingService.this, ChatActivity.class);
                intent.putExtra("personIdTo", message.getPersonIdFrom());
                intent.putExtra("name", notificationData.getTitle());
                intent.putExtra("task", "New");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

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
                    notificationManager.notify(NOTIFICATION_ID, notification);
                }
                handler.sendEmptyMessage(MESSAGE_DONE);
            }
        };
        thread.start();

    }


}
