package cse.duytan.coms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.RecyclerMapAdapter;
import cse.duytan.coms.customviews.CustomTextView;
import cse.duytan.coms.dialogs.ConfirmOkDialog;
import cse.duytan.coms.models.ConferenceMap;
import cse.duytan.coms.presenters.ListMapPresenter;
import cse.duytan.coms.views.ListMapView;

public class ListMapActivity extends BaseActivity implements ListMapView {

    @BindView(R.id.ivEmpty)
    ImageView ivEmpty;
    @BindView(R.id.tvEmpty)
    CustomTextView tvEmpty;
    @BindView(R.id.llEmpty)
    LinearLayout llEmpty;
    @BindView(R.id.rvListMap)
    RecyclerView rvListMap;
    @BindView(R.id.rlContent)
    RelativeLayout rlContent;

    private ListMapPresenter listMapPresenter;
    private RecyclerMapAdapter recyclerMapAdapter;
    private ArrayList<ConferenceMap> listMap;
    private int conferenceId = 1;//Lấy từ @Kiệt

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_map);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        listMap = new ArrayList<>();
        showHomeButton();
        setTitle(R.string.title_floor_map);

        listMapPresenter = new ListMapPresenter(this, this);
        listMapPresenter.getListConfereceMap(conferenceId);
        empty(true, false, "", llEmpty, rlContent, tvEmpty);

        setRecyclerMapAdapter();
    }

    private void setRecyclerMapAdapter() {
        recyclerMapAdapter = new RecyclerMapAdapter(listMap, this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rvListMap.setLayoutManager(manager);
        rvListMap.setAdapter(recyclerMapAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void success(ArrayList<ConferenceMap> listMap) {
        empty(false, false, "", llEmpty, rlContent, tvEmpty);
        this.listMap.addAll(listMap);
        recyclerMapAdapter.notifyDataSetChanged();
    }

    @Override
    public void error(String msg) {
        empty(true, true, msg, llEmpty, rlContent, tvEmpty);
        new ConfirmOkDialog(this, msg, null).show();
    }

    @Override
    public void empty() {
        empty(true, true, getString(R.string.msg_no_data_map), llEmpty, rlContent, tvEmpty);
    }

    @Override
    public void adpaterCallback(Object data, int processId, int position) {
        super.adpaterCallback(data, processId, position);
        if(processId == R.id.clMain){
            ConferenceMap conferenceMap = (ConferenceMap)data;
            Intent i = new Intent(this, MapActivity.class);
            i.putExtra("conferenceMapId",conferenceMap.getCONFERENCE_MAP_ID());
            i.putExtra("imageMap",conferenceMap.getIMAGE());
            startActivity(i);
        }
    }
}
