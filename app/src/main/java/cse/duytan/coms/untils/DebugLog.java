package cse.duytan.coms.untils;

import android.util.Log;

/**
 * Created by Pham Van Thien on 7/6/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class DebugLog implements Constants {
    public static void logI(String tag, String msg) {
        if (IS_DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void logD(String tag, String msg) {
        if (IS_DEBUG) {
            Log.d(tag, msg);
        }
    }
}
