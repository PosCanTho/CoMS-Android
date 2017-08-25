package cse.duytan.coms.fcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import cse.duytan.coms.R;
import cse.duytan.coms.activities.ChatActivity;

/**
 * Created by Pham Van Thien on 8/21/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class MyService extends Service {
    private Handler handler;
    private int count;

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting "+intent.getStringExtra("name"), Toast.LENGTH_SHORT).show();
        getCount();

        return START_STICKY;
    }

    private void getCount(){
        Runnable run = new Runnable() {
            @Override
            public void run() {
                count++;
                Toast.makeText(MyService.this, ""+count, Toast.LENGTH_SHORT).show();
              //  getCount();
                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);

                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                NotificationCompat.Builder noticationBuilder = null;
                try {
                    noticationBuilder = new NotificationCompat.Builder(getApplicationContext())
                            .setSmallIcon(R.drawable.ic_chat)
                            .setContentTitle("Title")
                            .setContentText("Content")
                            .setAutoCancel(true)
                            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                            .setContentIntent(pendingIntent);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (noticationBuilder != null) {
                    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    Notification notification = noticationBuilder.build();
                   // notificationManager.notify(1, notification);
                    startForeground(1, notification);
                }
            }
        };
        handler.postDelayed(run, 10000);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // We don't provide binding, so return null
        return null;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
    }

}
