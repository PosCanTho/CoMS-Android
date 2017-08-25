package cse.duytan.coms.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;

import cse.duytan.coms.activities.CoMSApplication;
import cse.duytan.coms.models.Account;
import cse.duytan.coms.models.ChatPrefs;
import cse.duytan.coms.models.Token;
import cse.duytan.coms.models.User;

/**
 * Created by Pham Van Thien on 6/15/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class Prefs {
    private static final String PREFERENCES_HELPER = "prefhelper";

    private static final String PREFERENCE_FIRST_INSTALL = "pref.Firs_install";
    private static final String PREFERENCE_FRESH_APP_DATA = "pref.fresh_app_data";
    private static final String PREFERENCE_NOTIFICATION = "pref.Notification";
    private static final String PREFERENCE_ENGLISH = "pref.English";
    private static final String PREFERENCE_ACCOUNT = "pref.Account";
    private static final String PREFERENCE_CHAT_PREFS = "pref.ChatPrefs";
    private static final String PREFERENCE_TOKEN = "pref.Token";
    private static final String PREFERENCE_USER = "pref.User";
    private static final String PREFERENCE_ID_CURRENT_READ = "pref.id_current_read";

    private static SharedPreferences getPrefs() {
        return CoMSApplication.getInstance().getSharedPreferences(PREFERENCES_HELPER, Context.MODE_PRIVATE);
    }

    public static void setFirstInstall(boolean firstInstall) {
        getPrefs().edit().putBoolean(PREFERENCE_FIRST_INSTALL, firstInstall).commit();
    }

    public static boolean getFirstInstall() {
        return getPrefs().getBoolean(PREFERENCE_FIRST_INSTALL, false);
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
        return getPrefs().getBoolean(PREFERENCE_NOTIFICATION, true);
    }

    public static void setEnglish(boolean english) {
        getPrefs().edit().putBoolean(PREFERENCE_ENGLISH, english).commit();
    }

    public static boolean getEnglish() {
        return getPrefs().getBoolean(PREFERENCE_ENGLISH, true);
    }

    public static void setAccount(Account account) {
        getPrefs().edit().putString(PREFERENCE_ACCOUNT, new Gson().toJson(account, Account.class)).commit();
    }

    public static Account getAccount() {
        String obs = getPrefs().getString(PREFERENCE_ACCOUNT, "");
        if (!TextUtils.isEmpty(obs)) {
            return new Gson().fromJson(obs, Account.class);
        }
        return null;
    }

    public static void setChat(ChatPrefs chat) {
        getPrefs().edit().putString(PREFERENCE_CHAT_PREFS, new Gson().toJson(chat, ChatPrefs.class)).commit();
    }

    public static ChatPrefs getChat() {
        String obs = getPrefs().getString(PREFERENCE_CHAT_PREFS, "");
        if (!TextUtils.isEmpty(obs)) {
            return new Gson().fromJson(obs, ChatPrefs.class);
        }
        return null;
    }

    public static void setToken(Token token) {
        getPrefs().edit().putString(PREFERENCE_TOKEN, new Gson().toJson(token, Token.class)).commit();
    }

    public static Token getToken() {
        String obs = getPrefs().getString(PREFERENCE_TOKEN, "");
        if (!TextUtils.isEmpty(obs)) {
            return new Gson().fromJson(obs, Token.class);
        }
        return null;
    }

    public static void setUser(User user) {
        getPrefs().edit().putString(PREFERENCE_USER, new Gson().toJson(user, User.class)).commit();
    }

    public static User getUser() {
        String obs = getPrefs().getString(PREFERENCE_USER, "");
        if (!TextUtils.isEmpty(obs)) {
            return new Gson().fromJson(obs, User.class);
        }
        return null;
    }

    public static void setIdCurrentRead(int idCurrentRead) {
        getPrefs().edit().putInt(PREFERENCE_ID_CURRENT_READ, idCurrentRead).commit();
    }

    public static int getIdCurrentRead() {
        return getPrefs().getInt(PREFERENCE_ID_CURRENT_READ, -1);
    }

}
