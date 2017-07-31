package cse.duytan.coms.fcm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Pham Van Thien on 7/25/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        Log.d("OKE", "onTokenRefresh: "+ FirebaseInstanceId.getInstance().getToken());
    }
}
