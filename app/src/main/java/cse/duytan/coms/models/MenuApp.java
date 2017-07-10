package cse.duytan.coms.models;

import android.app.Fragment;
import android.graphics.Bitmap;

/**
 * Created by Tuan Kiet on 6/22/2017.
 */

public class MenuApp {
    private Bitmap icon;
    private String name;
    private String total;
    private Fragment fragment;

    public Fragment getFragment() {
        return fragment;
    }


    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public MenuApp() {
    }

    public MenuApp(Bitmap icon, String name, String total, Fragment fragment) {
        this.icon = icon;
        this.name = name;
        this.total = total;
        this.fragment = fragment;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
