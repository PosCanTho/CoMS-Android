package cse.duytan.coms.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import cse.duytan.coms.untils.AdapterCallback;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.untils.PopupCalback;

public class BaseActivity extends AppCompatActivity implements Constants, View.OnClickListener, PopupCalback, AdapterCallback, ListView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view) {

    }

    public static void logI(String tag, String msg) {
        if (IS_DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void logD(String tag, String msg) {
        if (IS_DEBUG) {
            Log.d(tag, msg);
        }
    }

    @Override
    public void popupCalback(int processId, Object data) {

    }

    @Override
    public void adpaterCallback(Object data, int processId, int position) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
