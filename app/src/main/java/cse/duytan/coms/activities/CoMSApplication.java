package cse.duytan.coms.activities;

import android.app.Application;

/**
 * Created by Pham Van Thien on 2/23/2017 time 7:24 AM.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 * The class application
 */

public class CoMSApplication extends Application {
    private static CoMSApplication fir;

    public CoMSApplication() {
        fir = this;
    }

    public static CoMSApplication getInstance() {
        if (fir == null) {
            fir = new CoMSApplication();
        }
        return fir;
    }
}
