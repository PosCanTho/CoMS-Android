package cse.duytan.coms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.RecyclerNewMessageAdapter;
import cse.duytan.coms.customviews.CustomTextView;
import cse.duytan.coms.dialogs.ConfirmOkDialog;
import cse.duytan.coms.models.Account;
import cse.duytan.coms.models.EventBusInfo;
import cse.duytan.coms.presenters.NewMessagaPresenter;
import cse.duytan.coms.views.NewMessageView;

public class NewMessageActivity extends BaseActivity implements SearchView.OnQueryTextListener, NewMessageView {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tvEmpty)
    CustomTextView tvEmpty;
    @BindView(R.id.llEmpty)
    LinearLayout llEmpty;
    @BindView(R.id.rlContent)
    RelativeLayout rlContent;

    private SearchView searchView;
    private RecyclerNewMessageAdapter newMessageAdapter;
    private ArrayList<Account> listAccount;
    private NewMessagaPresenter newMessagaPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        showHomeButton();
        listAccount = new ArrayList<>();
        empty(false, "", llEmpty, rlContent, tvEmpty);

        newMessagaPresenter = new NewMessagaPresenter(this, this);
        newMessagaPresenter.getListAccount();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!listAccount.isEmpty()) {
            getMenuInflater().inflate(R.menu.new_message_menu, menu);
            MenuItem item = menu.findItem(R.id.search_view);
            searchView = (SearchView) item.getActionView();
            searchView.setOnQueryTextListener(this);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                postEvent(new EventBusInfo(ID_EVENT_REFRESH));
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setRvNewMessageAdp() {
        newMessageAdapter = new RecyclerNewMessageAdapter(this, listAccount);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(newMessageAdapter);
        newMessageAdapter.notifyDataSetChanged();
    }

    @Override
    public void adpaterCallback(Object data, int processId, int position) {
        if (processId == R.id.clMain) {
            Intent i = new Intent(NewMessageActivity.this, ChatActivity.class);
            i.putExtra("personIdFrom", 1);
            i.putExtra("personIdTo", listAccount.get(position).getPersonId());
            i.putExtra("name", listAccount.get(position).getName());
            startActivity(i);
            finish();
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newMessageAdapter.search(newText);
        return true;
    }

    @Override
    public void success(ArrayList<Account> listAccount) {
        this.listAccount = listAccount;
        empty(false, "", llEmpty, rlContent, tvEmpty);
        setRvNewMessageAdp();
        invalidateOptionsMenu();
    }

    @Override
    public void error(String msg) {
        new ConfirmOkDialog(this, msg, null).show();
        empty(true, msg, llEmpty, rlContent, tvEmpty);
        invalidateOptionsMenu();
    }

    @Override
    public void empty() {
        empty(true, getString(R.string.msg_no_data_person), llEmpty, rlContent, tvEmpty);
        invalidateOptionsMenu();
    }
}
