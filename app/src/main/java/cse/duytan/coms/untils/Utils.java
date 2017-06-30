package cse.duytan.coms.untils;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Environment;
import android.support.constraint.ConstraintLayout;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Pham Van Thien on 6/15/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

/*Lớp dùng để chứa các hàm dùng chung cho dự án*/
public class Utils implements Constants {

    public static int PROCESS = 0;

    /*Tạo danh sách menu*/
    public static PopupMenu popupMenu(Context context, View anchorView, ArrayList<String> listData, final AdapterCallback adapterCallback) {
        PopupMenu menu = new PopupMenu(context, anchorView);
        int size = listData.size();
        for (int i = 0; i < size; i++) {
            menu.getMenu().add(i, i, i, listData.get(i));
        }
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                adapterCallback.adpaterCallback(null, ID_MENU_POPUP, menuItem.getItemId());
                return false;
            }
        });
        return menu;
    }

    /*Tạo file chứa ảnh khi chụp hình ảnh đại diện*/
    public static File createImageFile() {
        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String imageFileName = "JPEG_" + timeStamp + "_";
            File storageDir = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_PICTURES);
            File image = File.createTempFile(
                    imageFileName,  // prefix
                    ".jpg",         // suffix
                    storageDir      // directory
            );
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //String mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        return null;
    }

    /*Gán font chữ cho tất cả các textview, edittext, button trong 1 view*/
    public static void getChangeFont(Context context, View view, int typeName) {
        try {
            Typeface typeface = getFonts(context, typeName);
            if (view instanceof LinearLayout) {
                int count = ((LinearLayout) view).getChildCount();
                for (int i = 0; i < count; i++) {
                    View childView = ((LinearLayout) view).getChildAt(i);
                    if (childView instanceof TextView) {
                        String str = ((TextView) childView).getText()
                                .toString();
                        if (!str.startsWith("..........")) {
                            ((TextView) childView).setTypeface(typeface);
                        }
                    } else if (childView instanceof Button) {
                        ((Button) childView).setTypeface(typeface);
                    } else if (childView instanceof LinearLayout) {
                        getChangeFont(context, childView, typeName);
                    } else if (childView instanceof RelativeLayout) {
                        getChangeFont(context, childView, typeName);
                    } else if (childView instanceof ScrollView) {
                        getChangeFont(context, childView, typeName);
                    } else if (childView instanceof ConstraintLayout) {
                        getChangeFont(context, childView, typeName);
                    }
                }
            } else if (view instanceof RelativeLayout) {
                int count = ((RelativeLayout) view).getChildCount();
                for (int i = 0; i < count; i++) {
                    View childView = ((RelativeLayout) view).getChildAt(i);
                    if (childView instanceof TextView) {
                        String str = ((TextView) childView).getText()
                                .toString();
                        if (!str.startsWith("..........")
                                && !str.startsWith("*")) {
                            ((TextView) childView).setTypeface(typeface);
                        }
                    } else if (childView instanceof Button) {
                        ((Button) childView).setTypeface(typeface);
                    } else if (childView instanceof LinearLayout) {
                        getChangeFont(context, childView, typeName);
                    } else if (childView instanceof RelativeLayout) {
                        getChangeFont(context, childView, typeName);
                    } else if (childView instanceof ScrollView) {
                        getChangeFont(context, childView, typeName);
                    } else if (childView instanceof ConstraintLayout) {
                        getChangeFont(context, childView, typeName);
                    }

                }
            } else if (view instanceof ScrollView) {
                int count = ((ScrollView) view).getChildCount();
                for (int i = 0; i < count; i++) {
                    View childView = ((ScrollView) view).getChildAt(i);
                    if (childView instanceof TextView) {
                        String str = ((TextView) childView).getText()
                                .toString();
                        if (!str.startsWith("..........")) {
                            ((TextView) childView).setTypeface(typeface);
                        }
                    } else if (childView instanceof Button) {
                        ((Button) childView).setTypeface(typeface);
                    } else if (childView instanceof LinearLayout) {
                        getChangeFont(context, childView, typeName);
                    } else if (childView instanceof RelativeLayout) {
                        getChangeFont(context, childView, typeName);
                    } else if (childView instanceof ScrollView) {
                        getChangeFont(context, childView, typeName);
                    } else if (childView instanceof ConstraintLayout) {
                        getChangeFont(context, childView, typeName);
                    }
                }
            } else if (view instanceof ConstraintLayout) {
                int count = ((ConstraintLayout) view).getChildCount();
                for (int i = 0; i < count; i++) {
                    View childView = ((ConstraintLayout) view).getChildAt(i);
                    if (childView instanceof TextView) {
                        String str = ((TextView) childView).getText()
                                .toString();
                        if (!str.startsWith("..........")) {
                            ((TextView) childView).setTypeface(typeface);
                        }
                    } else if (childView instanceof Button) {
                        ((Button) childView).setTypeface(typeface);
                    } else if (childView instanceof LinearLayout) {
                        getChangeFont(context, childView, typeName);
                    } else if (childView instanceof RelativeLayout) {
                        getChangeFont(context, childView, typeName);
                    } else if (childView instanceof ScrollView) {
                        getChangeFont(context, childView, typeName);
                    } else if (childView instanceof ConstraintLayout) {
                        getChangeFont(context, childView, typeName);
                    }
                }
            } else if (view instanceof TextView) {
                String str = ((TextView) view).getText().toString();
                if (!str.startsWith("..........")) {
                    ((TextView) view).setTypeface(typeface);
                }

            } else if (view instanceof Button) {
                ((Button) view).setTypeface(typeface);
            }
        } catch (Exception e) {
        }
    }

    public static Typeface getFonts(Context context, int fontName) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/" + context.getString(fontName));
    }

}
