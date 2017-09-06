package cse.duytan.coms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.ListPaperAdapter;
import cse.duytan.coms.dialogs.ConfirmDialog;
import cse.duytan.coms.models.PaperText;
import cse.duytan.coms.presenters.ListPaperPresenter;
import cse.duytan.coms.views.ListPaperView;

public class ListPaperActivity extends BaseActivity implements ListPaperView{

    @BindView(R.id.rvPaper)
    RecyclerView rvPaper;

    private ArrayList<PaperText> listData;
    private ListPaperAdapter adapter;
    private ListPaperPresenter listPaperPresenter;
    private PaperText paperText = new PaperText();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_paper);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        initUI();
    }

    private void initUI() {
        listPaperPresenter = new ListPaperPresenter(this,this);
        listData = new ArrayList<>();
        listPaperPresenter.getListPaper(1);
        setUp();
    }

    private void setUp() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, manager.getOrientation());
        manager.setStackFromEnd(true);
        rvPaper.setHasFixedSize(true);
        rvPaper.setLayoutManager(manager);
        rvPaper.addItemDecoration(dividerItemDecoration);
        adapter = new ListPaperAdapter(this, listData, this);
        Log.i(TAG, "setUp: "+listData.size());
        rvPaper.setAdapter(adapter);
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

    @Override
    public void adpaterCallback(Object data, int processId, int position) {
        super.adpaterCallback(data, processId, position);
        if(processId == 115){
            paperText = (PaperText) data;
            Intent intent = new Intent(this, PaperActivity.class);
            intent.putExtra("dataSession", new Gson().toJson(paperText).toString());
            startActivity(intent);
        }
    }

    @Override
    public void listPaper(ArrayList<PaperText> listPaper) {
        listData.addAll(listPaper);
        Log.i(TAG, "listPaper: "+"hihi");
        adapter.notifyDataSetChanged();
    }

    @Override
    public void error(String msg) {
        new ConfirmDialog(this, msg, null);
    }
}
