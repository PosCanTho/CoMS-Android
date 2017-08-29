package cse.duytan.coms.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;
import cse.duytan.coms.customviews.CustomTextView;
import cse.duytan.coms.dialogs.ConfirmOkDialog;
import cse.duytan.coms.libraries.map.MapView;
import cse.duytan.coms.libraries.map.MapViewListener;
import cse.duytan.coms.libraries.map.layer.MarkLayer;
import cse.duytan.coms.models.ConferenceLocation;
import cse.duytan.coms.models.TestData;
import cse.duytan.coms.presenters.MapPresenter;

public class MapActivity extends BaseActivity implements cse.duytan.coms.views.MapView, MapViewListener, MarkLayer.MarkIsClickListener {

    @BindView(R.id.ivZoomIn)
    ImageButton ivZoomIn;
    @BindView(R.id.ivZoomOut)
    ImageButton ivZoomOut;
    @BindView(R.id.ivEmpty)
    ImageView ivEmpty;
    @BindView(R.id.tvEmpty)
    CustomTextView tvEmpty;
    @BindView(R.id.llEmpty)
    LinearLayout llEmpty;
    @BindView(R.id.mapview)
    MapView mapview;
    @BindView(R.id.rlContent)
    RelativeLayout rlContent;

    private MarkLayer markLayer;
    private ArrayList<ConferenceLocation> listLocation;

    private int conferenceMapId = -1;
    private String imageMap;
    private MapPresenter mapPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);
        intUI();
    }

    private void intUI() {
        listLocation = new ArrayList<>();

        getMyIntent();

        showHomeButton();
        //  empty(true, false, "", llEmpty, rlContent, tvEmpty);

    }

    private void getMyIntent() {
        Intent i = getIntent();
        if (i != null) {
            conferenceMapId = i.getIntExtra("conferenceMapId", -1);
            imageMap = i.getStringExtra("imageMap");

            mapPresenter = new MapPresenter(this, this);
            mapPresenter.getListConferenceLocation(conferenceMapId);
        }
    }

    private void setUpMap() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_map);
        mapview.loadMap(bitmap);
        mapview.setMapViewListener(this);
    }

    @OnClick({R.id.ivZoomIn, R.id.ivZoomOut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivZoomIn:
                mapview.setCurrentZoom(mapview.getCurrentZoom() + 0.5f);
                mapview.refresh();
                break;
            case R.id.ivZoomOut:
                mapview.setCurrentZoom(mapview.getCurrentZoom() - 0.5f);
                mapview.refresh();
                break;
        }
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
    public void success(ArrayList<ConferenceLocation> listLocation) {
        empty(false, false, "", llEmpty, rlContent, tvEmpty);
        this.listLocation = listLocation;
        setUpMap();
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
    public void onMapLoadSuccess() {
        final List<PointF> marks = TestData.getMarks();
        final List<String> marksName = TestData.getMarksName();

        markLayer = new MarkLayer(mapview, listLocation);
        markLayer.setMarkIsClickListener(this);
        mapview.addLayer(markLayer);
        mapview.refresh();
    }

    @Override
    public void onMapLoadFail() {
        empty(true, true, getString(R.string.msg_can_not_load_map), llEmpty, rlContent, tvEmpty);
        new ConfirmOkDialog(this, getString(R.string.msg_can_not_load_map), null).show();
    }

    @Override
    public void markIsClick(int num, float x, float y) {

    }

    @Override
    public void markIsClick(int num) {
        Toast.makeText(getApplicationContext(), listLocation.get(num).getDESCRIPTION(), Toast.LENGTH_SHORT).show();
    }
}
