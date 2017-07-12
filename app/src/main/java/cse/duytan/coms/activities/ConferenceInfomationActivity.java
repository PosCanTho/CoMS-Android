package cse.duytan.coms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.adapters.ListConferenceSessionAdapter;

public class ConferenceInfomationActivity extends AppCompatActivity {
    private ListView ls;
    private ListConferenceSessionAdapter adapter;
    private ArrayList<String> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference_infomation);
        setUp();
        initUI();
    }

    private void initUI() {
        setTitle(R.string.title_conference_infomation);
    }

    private void setUp() {
        ls = (ListView) findViewById(R.id.lsConferenceSession);
        listData.add("a");
        listData.add("b");
        listData.add("c");
        adapter = new ListConferenceSessionAdapter(getApplicationContext(), listData);
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ConferenceInfomationActivity.this, ConferenceSessionInfomationActivity.class);
                startActivity(intent);
            }
        });
    }
}
