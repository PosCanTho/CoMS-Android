package cse.duytan.coms.activities;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.ListAttendeeAdapter;
import cse.duytan.coms.dialogs.ConfirmDialog;
import cse.duytan.coms.models.Attendee;
import cse.duytan.coms.presenters.ListAttendeePresenter;
import cse.duytan.coms.views.ListAttendeeView;

public class ListAttendeeActivity extends BaseActivity implements ListAttendeeView {

    @BindView(R.id.rvAttendee) RecyclerView rvAttendee;
    private ArrayList<Attendee> listData;
    private ListAttendeeAdapter adapter;
    private ListAttendeePresenter listAttendeePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_attendee);
        ButterKnife.bind(this);
        initUI();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initUI() {
        setTitle(R.string.title_conference_infomation);
        listAttendeePresenter = new ListAttendeePresenter(this, this);
        listData = new ArrayList<>();
        listAttendeePresenter.getListAttendee(1);
        setUp();
    }

    private void setUp() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, manager.getOrientation());
        rvAttendee.setHasFixedSize(true);
        rvAttendee.setLayoutManager(manager);
        rvAttendee.addItemDecoration(dividerItemDecoration);
        adapter = new ListAttendeeAdapter(this, listData);
        rvAttendee.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void listAttendee(ArrayList<Attendee> listAttedee) {
        listData.addAll(listAttedee);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void error(String msg) {
        new ConfirmDialog(this, msg, null);
    }
}
