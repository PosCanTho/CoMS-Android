package cse.duytan.coms.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * Created by Pham Van Thien on 6/22/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ScreenHelper {
    public static int height() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int width() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static float dpToPx(float dp) {
        return dp * Resources.getSystem().getDisplayMetrics().density;
    }

    public static float pxToDp(float px) {
        return px * Resources.getSystem().getDisplayMetrics().density;
    }
}
