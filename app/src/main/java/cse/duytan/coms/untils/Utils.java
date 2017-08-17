package cse.duytan.coms.untils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    //Kiểm tra kết nối mạng
    public static boolean isConnectionAvailable(Context context) {
        try {
            final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            final NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            final NetworkInfo mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (wifi.isAvailable() && wifi.isConnected()) {
                return true;
            } else return mobile.isAvailable() && mobile.isConnected();

        } catch (Exception e) {
            //e.printStackTrace();
        }
        return false;
    }

    /*Lấy ảnh trong drawable*/
    public static Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    /*Kiểm tra email có đúng định dạng hay không*/
    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /*Chuyển số thành kiểu tiền VND*/
    public static String formatPrice(long price){
        DecimalFormat format = new DecimalFormat("###,###,###");
        return format.format(price);
    }
}
