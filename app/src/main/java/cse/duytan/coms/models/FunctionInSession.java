package cse.duytan.coms.models;

import android.graphics.Bitmap;

/**
 * Created by Tuan Kiet on 7/5/2017.
 */

public class FunctionInSession {
    public Bitmap icon;
    public String nameFunction;
    public String total;

    public FunctionInSession() {
    }

    public FunctionInSession(Bitmap icon, String nameFunction, String total) {
        this.icon = icon;
        this.nameFunction = nameFunction;
        this.total = total;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public String getNameFunction() {
        return nameFunction;
    }

    public void setNameFunction(String nameFunction) {
        this.nameFunction = nameFunction;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
