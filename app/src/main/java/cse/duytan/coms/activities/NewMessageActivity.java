package cse.duytan.coms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.RecyclerMessageAdapter;
import cse.duytan.coms.adapters.RecyclerNewMessageAdapter;
import cse.duytan.coms.models.Conversation;

public class NewMessageActivity extends BaseActivity implements SearchView.OnQueryTextListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private SearchView searchView;
    private RecyclerNewMessageAdapter newMessageAdapter;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        showHomeButton();
        setRvNewMessageAdp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_message_menu, menu);
        MenuItem item = menu.findItem(R.id.search_view);
        searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setRvNewMessageAdp() {
        list = new ArrayList<>();
        list.add("Steve Jobs");
        list.add("Steve Jobs 2");
        list.add("Steve Jobs 3");
        list.add("Jack Ma");
        list.add("Jack Ma 2");
        list.add("Donald Trump");
        list.add("Donald Trump 2");
        list.add("Mark Zuckerberg");
        list.add("Mark Zuckerberg 2");
        newMessageAdapter = new RecyclerNewMessageAdapter(this, list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(newMessageAdapter);
    }

    @Override
    public void adpaterCallback(Object data, int processId, int position) {
        if (processId == R.id.clMain) {
            startActivity(new Intent(NewMessageActivity.this, ChatActivity.class));
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
}
