package cse.duytan.coms.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.ListPastSessionAdapter;
import cse.duytan.coms.customviews.NonScrollListView;
import cse.duytan.coms.models.PastSession;

public class ProfileActivity extends BaseActivity {

    @BindView(R.id.ivFacebook)
    ImageView ivFacebook;
    @BindView(R.id.lvPastSession)
    NonScrollListView lvPastSession;

    private ListPastSessionAdapter pastSessionAdp;
    private ArrayList<PastSession> listPastSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        initUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @OnClick(R.id.ivFacebook)
    public void onViewClicked() {
    }

    private void initUI() {
        setLvPastSessionAdp();
    }

    private void setLvPastSessionAdp() {
        listPastSession = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            listPastSession.add(new PastSession("Update and Open Forum on EAC Criteia " + i, "8 - 10am", "Grand Ballroom", false));
        }
        pastSessionAdp = new ListPastSessionAdapter(this, listPastSession, this);
        lvPastSession.setAdapter(pastSessionAdp);
        lvPastSession.setFocusable(false);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        super.onItemClick(adapterView, view, i, l);
        Toast.makeText(this, "OnClick past session: " + listPastSession.get(i).getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void adpaterCallback(Object data, int processId, int position) {
        super.adpaterCallback(data, processId, position);
        if (processId == R.id.flSave) {
            PastSession pastSession = (PastSession) data;
            listPastSession.get(position).setSelected(!pastSession.isSelected());
            pastSessionAdp.notifyDataSetChanged();
        }
    }
}
