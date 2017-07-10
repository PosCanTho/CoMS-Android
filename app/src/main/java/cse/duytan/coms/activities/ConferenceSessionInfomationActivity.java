package cse.duytan.coms.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;



import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.adapters.ListFunctionInConferenceSessionAdapter;
import cse.duytan.coms.adapters.PresentationSlotAdapter;
import cse.duytan.coms.fragments.AttendeeFragment;
import cse.duytan.coms.fragments.DownloadDocumentFragment;
import cse.duytan.coms.fragments.PaperTextFragment;
import cse.duytan.coms.fragments.ScheduleInSessionFragment;
import cse.duytan.coms.models.FunctionInSession;


public class ConferenceSessionInfomationActivity extends AppCompatActivity {

    private ListView lsPre, lsFunc;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<FunctionInSession> listFunc = new ArrayList<>();
    private PresentationSlotAdapter adapterPre;
    private ListFunctionInConferenceSessionAdapter adapterFunc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference_session_infomation);
        setUpPre();
        setUpFunc();
    }

    private void setUpFunc() {
        lsFunc = (ListView) findViewById(R.id.lsFunction);
        ArrayList<FunctionInSession> arrayList = new ArrayList<>();
        Bitmap iconSchedule = BitmapFactory.decodeResource(getApplicationContext().getResources(),
                R.drawable.ic_calendar_menu);
        Bitmap iconPaper = BitmapFactory.decodeResource(getApplicationContext().getResources(),
                R.drawable.ic_paper);
        Bitmap iconDownload = BitmapFactory.decodeResource(getApplicationContext().getResources(),
                R.drawable.ic_download);
        Bitmap iconAttendee = BitmapFactory.decodeResource(getApplicationContext().getResources(),
                R.drawable.ic_attendee);
        arrayList.add(new FunctionInSession(iconSchedule, "Lịch trình", ""));
        arrayList.add(new FunctionInSession(iconPaper, "Bài báo", "16"));
        arrayList.add(new FunctionInSession(iconDownload, "Tải tài liệu liên quan", "10"));
        arrayList.add(new FunctionInSession(iconSchedule, "Người tham dự", "300"));

        adapterFunc = new ListFunctionInConferenceSessionAdapter(getApplicationContext(), arrayList);
        lsFunc.setAdapter(adapterFunc);
        lsFunc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = null;
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
                switch (i) {
                    case 0:
                        fragment = new ScheduleInSessionFragment();
                        Toast.makeText(ConferenceSessionInfomationActivity.this, "Hihi" + i, Toast.LENGTH_SHORT).show();
                        linearLayout.setVisibility(LinearLayout.GONE);
                        break;
                    case 1:
                        fragment = new PaperTextFragment();
                        linearLayout.setVisibility(LinearLayout.GONE);
                        break;
                    case 2:
                        fragment = new DownloadDocumentFragment();
                        linearLayout.setVisibility(LinearLayout.GONE);
                        break;
                    case 3:
                        fragment = new AttendeeFragment();
                        linearLayout.setVisibility(LinearLayout.GONE);
                        break;
                }
                getFragmentManager().beginTransaction().replace(R.id.frameFunc,fragment).commit();
            }
        });
    }


    private void setUpPre() {
        lsPre = (ListView) findViewById(R.id.lsPresentationSlot);
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        adapterPre = new PresentationSlotAdapter(getApplicationContext(), list);
        lsPre.setAdapter(adapterPre);
    }
}
