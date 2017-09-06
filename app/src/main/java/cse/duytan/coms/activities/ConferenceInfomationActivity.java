package cse.duytan.coms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.ListConferenceSessionAdapter;
import cse.duytan.coms.adapters.OrganizationAdapter;
import cse.duytan.coms.customviews.CustomTextView;
import cse.duytan.coms.dialogs.ConfirmDialog;
import cse.duytan.coms.models.Conference;
import cse.duytan.coms.models.ConferenceSession;
import cse.duytan.coms.models.Organization;
import cse.duytan.coms.presenters.ConferenceSessionPresenter;
import cse.duytan.coms.presenters.OrganizationPresenter;
import cse.duytan.coms.untils.DateTimeFormater;
import cse.duytan.coms.views.ConferenceSessionView;
import cse.duytan.coms.views.OrganizationView;

public class ConferenceInfomationActivity extends BaseActivity implements ConferenceSessionView, OrganizationView {

    Unbinder unbinder;
    @BindView(R.id.tvNameConInAc)
    CustomTextView tvNameConInAc;
    @BindView(R.id.tvConferenceTpye) TextView tvConferenceTpye;
    @BindView(R.id.tvFieldOfStudy) TextView tvFieldOfStudy;
    @BindView(R.id.tvMainTheme) TextView tvMainTheme;
    @BindView(R.id.tvFromDateInAc) TextView tvFromDateInAc;
    @BindView(R.id.tvThruDateInAc) TextView tvThruDateInAc;
    @BindView(R.id.rvConSess) RecyclerView rvCon;
    @BindView(R.id.rvOrganization) RecyclerView rvOrganization;

    private ArrayList<ConferenceSession> listData = new ArrayList<>();
    private ListConferenceSessionAdapter adapter;
    private Conference conference = new Conference();
    private ConferenceSessionPresenter conferenceSessionPresenter;

    private ArrayList<Organization> listOrganization = new ArrayList<>();
    private OrganizationAdapter adapterOrganization;
    private Organization organization = new Organization();
    private OrganizationPresenter organizationPresenter;

    private ConferenceSession conferenceSession = new ConferenceSession();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference_infomation);
        unbinder = ButterKnife.bind(this);
        initUI();
        setUpConferenceSession();
    }

    private void initUI() {
        setTitle(R.string.title_conference_infomation);
        getMyIntent();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        conferenceSessionPresenter = new ConferenceSessionPresenter(this, this);
        conferenceSessionPresenter.getListConferenceSession(conference.conferenceId);
    }

    private void setUpConferenceSession() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, manager.getOrientation());
        manager.setStackFromEnd(true);
        rvCon.setHasFixedSize(true);
        rvCon.setLayoutManager(manager);
        rvCon.addItemDecoration(dividerItemDecoration);
        adapter = new ListConferenceSessionAdapter(this, listData, this);
        rvCon.setAdapter(adapter);
    }

    private void setUpOrganization() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, manager.getOrientation());
        manager.setStackFromEnd(true);
        rvOrganization.setHasFixedSize(true);
        rvOrganization.setLayoutManager(manager);
        rvOrganization.addItemDecoration(dividerItemDecoration);
        adapterOrganization = new OrganizationAdapter(this, listOrganization, this);
        rvOrganization.setAdapter(adapterOrganization);
    }

    private void getMyIntent(){
        Intent i = getIntent();
        if(i != null){
            String json = i.getStringExtra("data");
            conference = new Gson().fromJson(json, Conference.class);

            tvConferenceTpye.setText(conference.getConferenceTypeName());
            tvNameConInAc.setText(conference.getConferenceName());
            tvFieldOfStudy.setText(conference.getMainFieldOfStudyName());
            tvMainTheme.setText(conference.getConferenceMainTheme());
            tvFromDateInAc.setText(DateTimeFormater.stringToTime(conference.getFromDate(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
            tvThruDateInAc.setText(DateTimeFormater.stringToTime(conference.getThruDate(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));

            organizationPresenter = new OrganizationPresenter(this, this);
            if(conference.getOrganizingOrganizationId1() != 0){
                organizationPresenter.getOrganization(conference.getOrganizingOrganizationId1());
            }if(conference.getOrganizingOrganizationId2() != 0){
                organizationPresenter.getOrganization(conference.getOrganizingOrganizationId2());
            }if(conference.getOrganizingOrganizationId3() != 0){
                organizationPresenter.getOrganization(conference.getOrganizingOrganizationId3());
            }if(conference.getOrganizingOrganizationId4() != 0){
                organizationPresenter.getOrganization(conference.getOrganizingOrganizationId4());
            }if(conference.getOrganizingOrganizationId5() != 0){
                organizationPresenter.getOrganization(conference.getOrganizingOrganizationId5());
            }if(conference.getOrganizingOrganizationId6() != 0){
                organizationPresenter.getOrganization(conference.getOrganizingOrganizationId6());
            }if(conference.getOrganizingOrganizationId7() != 0){
                organizationPresenter.getOrganization(conference.getOrganizingOrganizationId7());
            }if(conference.getOrganizingOrganizationId8() != 0){
                organizationPresenter.getOrganization(conference.getOrganizingOrganizationId8());
            }if(conference.getOrganizingOrganizationId9() != 0){
                organizationPresenter.getOrganization(conference.getOrganizingOrganizationId9());
            }if(conference.getOrganizingOrganizationId10() != 0){
                organizationPresenter.getOrganization(conference.getOrganizingOrganizationId10());
            }
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
    public void adpaterCallback(Object data, int processId, int position) {
        super.adpaterCallback(data, processId, position);
        if(processId == 99){
            conferenceSession = (ConferenceSession) data;
            Intent intent = new Intent(this, ConferenceSessionInfomationActivity.class);
            intent.putExtra("dataSession", new Gson().toJson(conferenceSession).toString());
            startActivity(intent);
            Log.i(TAG, "adpaterCallbackSession: "+conferenceSession.getConferenceSessionName());
        }
    }

    @Override
    public void listSession(ArrayList<ConferenceSession> listSession) {
        listData.addAll(listSession);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void setListOrganization(ArrayList<Organization> listOrganization) {
        this.listOrganization.addAll(listOrganization);
        Log.d(TAG, "setListOrganization: "+this.listOrganization.size());
        setUpOrganization();
        adapterOrganization.notifyDataSetChanged();
    }

    @Override
    public void error(String msg) {
        new ConfirmDialog(this, msg, null);
    }
}
