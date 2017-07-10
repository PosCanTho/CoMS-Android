package cse.duytan.coms.helpers;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import cse.duytan.coms.R;

/**
 * Created by Tuan Kiet on 7/5/2017.
 */

public class SlideAnimationUtil {

    public static void slideInFromLeft(Context context, View view) {
        runSimpleAnimation(context, view, R.anim.slide_from_left);
    }

    public static void slideOutToLeft(Context context, LinearLayout view) {
        runSimpleAnimation(context, view, R.anim.slide_to_left);
    }


    public static void slideInFromRight(Context context, LinearLayout view) {
        runSimpleAnimation(context, view, R.anim.slide_from_right);
    }

    public static void slideOutToRight(Context context, LinearLayout view) {
        runSimpleAnimation(context, view, R.anim.slide_to_right);
    }

    private static void runSimpleAnimation(Context context, View view, int animationId) {
        view.startAnimation(AnimationUtils.loadAnimation(
                context, animationId
        ));
    }

}
