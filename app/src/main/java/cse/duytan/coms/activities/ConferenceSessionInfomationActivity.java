package cse.duytan.coms.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.ListPresentationSlotAdapter;
import cse.duytan.coms.customviews.CustomTextView;
import cse.duytan.coms.dialogs.ConfirmDialog;
import cse.duytan.coms.models.ConferenceSession;
import cse.duytan.coms.models.PresentationSlot;
import cse.duytan.coms.presenters.PresentationSlotPresenter;
import cse.duytan.coms.untils.DateTimeFormater;
import cse.duytan.coms.views.PresentationSlotView;


public class ConferenceSessionInfomationActivity extends BaseActivity implements PresentationSlotView {

    @BindView(R.id.tvNameConSess)
    CustomTextView tvNameConSess;
    @BindView(R.id.tvStartTimeInSess)
    CustomTextView tvStartTimeInSess;
    @BindView(R.id.tvEndTimeInSess)
    CustomTextView tvEndTimeInSess;
    @BindView(R.id.tvTotalPresentationInSess)
    CustomTextView tvTotalPresentationInSess;
    @BindView(R.id.tvTopicInSess)
    CustomTextView tvTopicInSess;
    @BindView(R.id.tvMainTopicInSess)
    CustomTextView tvMainTopicInSess;
    @BindView(R.id.tvDesInSess)
    CustomTextView tvDesInSess;
    @BindView(R.id.tvVenue)
    CustomTextView tvVenue;
    @BindView(R.id.icScheduleInSess) ImageView icScheduleInSess;
    @BindView(R.id.tvScheduleInSess)
    CustomTextView tvScheduleInSess;
    @BindView(R.id.tvTotalScheduleInSess)
    CustomTextView tvTotalScheduleInSess;
    @BindView(R.id.llSchedule) LinearLayout llSchedule;
    @BindView(R.id.icPaperInSess) ImageView icPaperInSess;
    @BindView(R.id.tvPaperInSess)
    CustomTextView tvPaperInSess;
    @BindView(R.id.tvTotalPaperInSession)
    CustomTextView tvTotalPaperInSession;
    @BindView(R.id.llPaper) LinearLayout llPaper;
    @BindView(R.id.icDownloadInSess) ImageView icDownloadInSess;
    @BindView(R.id.tvDownloadInSess)
    CustomTextView tvDownloadInSess;
    @BindView(R.id.tvTotalDownloadInSession)
    CustomTextView tvTotalDownloadInSession;
    @BindView(R.id.llDonwload) LinearLayout llDonwnload;
    @BindView(R.id.icAttendeeInSess) ImageView icAttendeeInSess;
    @BindView(R.id.tvAttendeeInSess)
    CustomTextView tvAttendeeInSess;
    @BindView(R.id.tvTotalAttendeeInSession)
    CustomTextView tvTotalAttendeeInSession;
    @BindView(R.id.llAttendee) LinearLayout llAttendee;
    @BindView(R.id.rvPresentationSlot) RecyclerView rvPresentationSlot;
    @BindView(R.id.llConSessInfomation) LinearLayout llConSessInfomation;

    private ArrayList<PresentationSlot> listdata = new ArrayList<>();
    private PresentationSlotPresenter presentationSlotPresenter;
    private ListPresentationSlotAdapter adapter;
    private ConferenceSession conferenceSession = new ConferenceSession();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference_session_infomation);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getMyIntent();
        setUpPresentationSlot();
        setUpFunction();
    }

    private void initUI() {
        presentationSlotPresenter = new PresentationSlotPresenter(this, this);
        presentationSlotPresenter.getListPresentationSlot(conferenceSession.getConferenceSessionId());
        listdata = new ArrayList<>();
    }

    private void setUpFunction() {

        llAttendee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConferenceSessionInfomationActivity.this, ListAttendeeActivity.class);
                startActivity(intent);
            }
        });

        llDonwnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConferenceSessionInfomationActivity.this, DownloadDocumentActivity.class);
                startActivity(intent);
            }
        });

        llPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConferenceSessionInfomationActivity.this, ListPaperActivity.class);
                startActivity(intent);
            }
        });

        llSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConferenceSessionInfomationActivity.this, ScheduleInSessionActivity.class);
                intent.putExtra("dataSession", new Gson().toJson(listdata).toString());
                startActivity(intent);
            }
        });
    }

    private void setUpPresentationSlot() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, manager.getOrientation());
        manager.setStackFromEnd(true);
        rvPresentationSlot.setHasFixedSize(true);
        rvPresentationSlot.setLayoutManager(manager);
        rvPresentationSlot.addItemDecoration(dividerItemDecoration);
        adapter = new ListPresentationSlotAdapter(this, listdata);
        Log.i("", "setUpPresentationSlot: "+listdata.size());
        rvPresentationSlot.setAdapter(adapter);
    }

    private void getMyIntent(){
        Intent i = getIntent();
        if(i != null){
            String json = i.getStringExtra("dataSession");
            conferenceSession = new Gson().fromJson(json, ConferenceSession.class);

            tvNameConSess.setText(conferenceSession.getConferenceSessionName());
            tvStartTimeInSess.setText(DateTimeFormater.stringToTime(conferenceSession.getStartDatetime(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
            tvEndTimeInSess.setText(DateTimeFormater.stringToTime(conferenceSession.getEndDatetime(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
            tvTopicInSess.setText(conferenceSession.getConferenceSessionTopicName());
            tvTotalPresentationInSess.setText(String.valueOf(conferenceSession.getNumberOfPresentationSlots()));
            tvMainTopicInSess.setText(conferenceSession.getConferenceMainTheme());
            tvDesInSess.setText(conferenceSession.getDescription());
            tvVenue.setText(conferenceSession.getFacilityName());
            //tvConSessChair.setText(conferenceSession.getCurrentFullName());

            initUI();
        }
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
    public void listPresentationSlot(ArrayList<PresentationSlot> listPresentationSlot) {
        listdata.addAll(listPresentationSlot);
        Log.i("", "listPresentationSlot: "+listdata.size());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void error(String msg) {
        new ConfirmDialog(this, msg, null);
    }
}
