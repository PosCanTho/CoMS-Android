package cse.duytan.coms.helpers;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import cse.duytan.coms.R;

/**
 * Created by Pham Van Thien on 6/22/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class AnimationHelper extends AnimationUtils {
    public static Animation slideUp(Context context) {
        return AnimationUtils.loadAnimation(context, R.anim.anim_slide_up);
    }

    public static Animation slideDown(Context context) {
        return AnimationUtils.loadAnimation(context, R.anim.anim_slide_down);
    }
}
