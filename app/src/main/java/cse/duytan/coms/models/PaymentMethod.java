package cse.duytan.coms.models;

import android.graphics.Bitmap;

/**
 * Created by Pham Van Thien on 6/30/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class PaymentMethod {
    private String name;
    private Bitmap bitmap;
    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public PaymentMethod(String name, Bitmap bitmap, boolean isSelected) {
        this.name = name;
        this.bitmap = bitmap;
        this.isSelected = isSelected;
    }

    public PaymentMethod() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
