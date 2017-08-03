package cse.duytan.coms.fcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

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
    private Intent intent;
    private RemoteMessage remoteMessage;
    private Message message;

    @Override
    public void onCreate() {
        super.onCreate();
        broadcastManager = LocalBroadcastManager.getInstance(this);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        this.remoteMessage = remoteMessage;
        String data = remoteMessage.getData().toString();
        try {
            JSONObject json = new JSONObject(data);
            String jsonData = json.getString("Data");
            Intent i = new Intent("Message");
            i.putExtra("message", jsonData);
            message = new Gson().fromJson(jsonData, Message.class);
            sendNotification(remoteMessage.getNotification(), message);
            broadcastManager.sendBroadcast(i);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Intent getMessageReadIntent() {
        return new Intent()
                .addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
                .setAction(READ_ACTION);
    }

    @Override
    public void handleIntent(Intent intent) {
        super.handleIntent(intent);
    }

    private void sendNotification(RemoteMessage.Notification notificationData, Message message) {

        intent = new Intent(this, ChatActivity.class);
        intent.putExtra("personIdFrom", 1);
        intent.putExtra("personIdTo", message.getPersonIdFrom());
        intent.putExtra("name", notificationData.getTitle());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder noticationBuilder = null;
        try {
            noticationBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_chat)
                    .setContentTitle(notificationData.getTitle())
                    .setContentText(notificationData.getBody())
                    .setAutoCancel(true)
                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                    .setContentIntent(pendingIntent);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (noticationBuilder != null) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            Notification notification = noticationBuilder.build();
            notificationManager.notify(NOTIFICATION_ID, notification);
        }

    }
}
