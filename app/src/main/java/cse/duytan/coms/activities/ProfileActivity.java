package cse.duytan.coms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
    private boolean isBookmark = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        initUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!isBookmark){
            getMenuInflater().inflate(R.menu.profile_menu, menu);
        }else{
            getMenuInflater().inflate(R.menu.profile_bookmark_menu, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @OnClick(R.id.ivFacebook)
    public void onViewClicked() {
    }

    private void initUI() {
        showHomeButton();
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                break;
            case R.id.actionChat:
                startActivity(new Intent(ProfileActivity.this, ChatActivity.class));
                finish();
                break;
            case R.id.actionBookmark:
                Toast.makeText(this, "Add bookmark", Toast.LENGTH_SHORT).show();
                this.isBookmark = !isBookmark;
                invalidateOptionsMenu();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
