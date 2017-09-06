package cse.duytan.coms.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.DownloadDocumentsAdapter;

public class DownloadDocumentActivity extends AppCompatActivity {

    @BindView(R.id.rvDownloadDocument)
    RecyclerView rvDownloadDocument;
    @BindView(R.id.btDownloadDocument)
    Button btDownloadDocument;

    private ArrayList<String> listData;
    private DownloadDocumentsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_document);
        ButterKnife.bind(this);
        initUI();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initUI() {
        this.setTitle(R.string.title_download_documents);
        listData = new ArrayList<>();
        setUp();
    }

    public void setUp() {

        listData.add("a");
        listData.add("b");
        listData.add("c");
        listData.add("d");
        listData.add("e");
        listData.add("f");
        listData.add("g");
        listData.add("h");
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, manager.getOrientation());
        manager.setStackFromEnd(true);
        rvDownloadDocument.setHasFixedSize(true);
        rvDownloadDocument.setLayoutManager(manager);
        rvDownloadDocument.addItemDecoration(dividerItemDecoration);
        adapter = new DownloadDocumentsAdapter(this, listData);
        rvDownloadDocument.setAdapter(adapter);

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
}
