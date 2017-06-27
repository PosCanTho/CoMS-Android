package cse.duytan.coms.untils;

import android.content.Context;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.PopupMenu;
import android.widget.TextView;

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

}
