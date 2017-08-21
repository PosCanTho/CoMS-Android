package cse.duytan.coms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.ListPastSessionAdapter;
import cse.duytan.coms.customviews.CustomTextView;
import cse.duytan.coms.customviews.NonScrollListView;
import cse.duytan.coms.dialogs.ConfirmOkDialog;
import cse.duytan.coms.helpers.Prefs;
import cse.duytan.coms.models.CircleImageView;
import cse.duytan.coms.models.EventBusInfo;
import cse.duytan.coms.models.PastConference;
import cse.duytan.coms.models.Profile;
import cse.duytan.coms.presenters.ProfilePresenter;
import cse.duytan.coms.views.ProfileView;

public class ProfileActivity extends BaseActivity implements ProfileView {

    @BindView(R.id.ivFacebook)
    ImageView ivFacebook;
    @BindView(R.id.lvPastSession)
    NonScrollListView lvPastConference;
    @BindView(R.id.ivAvatar)
    CircleImageView ivAvatar;
    @BindView(R.id.tvName)
    CustomTextView tvName;
    @BindView(R.id.tvDescription)
    CustomTextView tvDescription;

    private ListPastSessionAdapter pastSessionAdp;
    private ArrayList<PastConference> listPastConference;
    private boolean isBookmark = false;
    private int personIdBookmark;
    private int personId = -1;
    private ProfilePresenter profilePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        initUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!isBookmark) {
            getMenuInflater().inflate(R.menu.profile_menu, menu);
        } else {
            getMenuInflater().inflate(R.menu.profile_bookmark_menu, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @OnClick(R.id.ivFacebook)
    public void onViewClicked() {
    }

    private void initUI() {
        personId = Prefs.getUser().getPersonId();
        listPastConference = new ArrayList<>();

        getMyIntent();
        showHomeButton();


        setLvPastConferenceAdp();
    }

    private void getMyIntent() {
        Intent i = getIntent();
        if (i != null) {
            personIdBookmark = i.getIntExtra("PersonIdBookmark", -1);

            profilePresenter = new ProfilePresenter(this, this);
            profilePresenter.getProfile(personId, personIdBookmark);
        }
    }

    private void setLvPastConferenceAdp() {
        pastSessionAdp = new ListPastSessionAdapter(this, listPastConference, this);
        lvPastConference.setAdapter(pastSessionAdp);
        lvPastConference.setFocusable(false);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        super.onItemClick(adapterView, view, i, l);
    }

    @Override
    public void adpaterCallback(Object data, int processId, int position) {
        super.adpaterCallback(data, processId, position);
        if (processId == R.id.flSave) {
            PastConference pastSession = (PastConference) data;
            listPastConference.get(position).setSelected(!pastSession.isSelected());
            pastSessionAdp.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                postEvent(new EventBusInfo(ID_EVENT_REFRESH));
                finish();
                break;
            case R.id.actionChat:
                Intent i = new Intent(this, ChatActivity.class);
                i.putExtra("personIdFrom", personId);
                i.putExtra("personIdTo", personIdBookmark);
                i.putExtra("name", tvName.getText().toString().trim());
                startActivity(i);
                finish();
                break;
            case R.id.actionBookmark:
                if (isBookmark) {
                    profilePresenter.deleteBookmark(personId, personIdBookmark);
                } else {
                    profilePresenter.addBookmark(personId, personIdBookmark);
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void success(Profile profile) {
        isBookmark = profile.isBookmark();
        invalidateOptionsMenu();

        tvName.setText(profile.getName());
        tvDescription.setText(profile.getDescription());

        listPastConference.addAll(profile.getListPastConference());
        pastSessionAdp.notifyDataSetChanged();
    }

    @Override
    public void error(String msg) {
        new ConfirmOkDialog(this, msg, null).show();
    }

    @Override
    public void invalidMenu() {
        this.isBookmark = !isBookmark;
        invalidateOptionsMenu();
    }
}
