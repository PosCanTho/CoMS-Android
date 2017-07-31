package cse.duytan.coms.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import cse.duytan.coms.activities.CoMSApplication;

/**
 * Created by Pham Van Thien on 6/15/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class Prefs {
    private static final String PREFERENCES_HELPER = "prefhelper";

    private static final String PREFERENCE_FRESH_APP_DATA = "pref.fresh_app_data";
    private static final String PREFERENCE_NOTIFICATION = "pref.Notification";
    private static final String PREFERENCE_ENGLISH = "pref.English";

    private static SharedPreferences getPrefs() {
        return CoMSApplication.getInstance().getSharedPreferences(PREFERENCES_HELPER, Context.MODE_PRIVATE);
    }

    public static void setFreshAppData(boolean fresh) {
        getPrefs().edit().putBoolean(PREFERENCE_FRESH_APP_DATA, fresh).commit();
    }

    public static boolean getFreshAppData() {
        return getPrefs().getBoolean(PREFERENCE_FRESH_APP_DATA, false);
    }

    public static void setNotification(boolean notification) {
        getPrefs().edit().putBoolean(PREFERENCE_NOTIFICATION, notification).commit();
    }

    public static boolean getNotification() {
        return getPrefs().getBoolean(PREFERENCE_NOTIFICATION, false);
    }

    public static void setEnglish(boolean english) {
        getPrefs().edit().putBoolean(PREFERENCE_ENGLISH, english).commit();
    }

    public static boolean getEnglish() {
        return getPrefs().getBoolean(PREFERENCE_ENGLISH, false);
    }

}
