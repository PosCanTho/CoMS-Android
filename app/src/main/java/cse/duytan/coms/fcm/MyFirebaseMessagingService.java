package cse.duytan.coms.fcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;

import cse.duytan.coms.R;
import cse.duytan.coms.activities.ChatActivity;
import cse.duytan.coms.activities.MainActivity;
import cse.duytan.coms.models.ChatBody;
import cse.duytan.coms.untils.Constants;

/**
 * Created by Pham Van Thien on 7/25/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService implements Constants {

    public static int NOTIFICATION_ID = 1111;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        sendNotification(remoteMessage.getNotification());
        String data = remoteMessage.getData().toString();
        Log.d(TAG, "onMessageReceived: "+data);
    }

    private void sendNotification(RemoteMessage.Notification notificationData) {

//        ChatBody chatBody = new Gson().fromJson(notificationData.getBody(), ChatBody.class);
        Intent intent = new Intent(this, ChatActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, notificationData.getBody());

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder notìicationBuilder = null;
        try {
            notìicationBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_chat)
                    .setContentTitle(notificationData.getTitle())
                    .setContentText(notificationData.getBody())
                    .setAutoCancel(true)
                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                    .setContentIntent(pendingIntent);

        }catch (Exception e){
            e.printStackTrace();
        }

        if (notìicationBuilder != null){
            NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            Notification notification = notìicationBuilder.build();
            notificationManager.notify(NOTIFICATION_ID, notification);
        }

    }
}
