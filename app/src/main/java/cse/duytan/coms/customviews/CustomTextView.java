package cse.duytan.coms.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import cse.duytan.coms.R;

/**
 * Created by Pham Van Thien on 6/29/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        final int size = array.getIndexCount();
        for (int i = 0; i < size; i++) {
            int attr = array.getIndex(i);
            if (attr == R.styleable.CustomTextView_typeFace) {
                try {
                    Typeface font = Typeface.createFromAsset(getResources().getAssets(), "fonts/" + array.getString(attr));
                    if (font != null) {
                        this.setTypeface(font);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
