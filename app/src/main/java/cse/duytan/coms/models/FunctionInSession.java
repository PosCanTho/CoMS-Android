package cse.duytan.coms.models;

import android.graphics.Bitmap;

/**
 * Created by Tuan Kiet on 7/5/2017.
 */

public class FunctionInSession {
    public int icon;
    public String nameFunction;
    public String total;

    public FunctionInSession() {
    }

    public FunctionInSession(int icon, String nameFunction, String total) {
        this.icon = icon;
        this.nameFunction = nameFunction;
        this.total = total;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
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
