package cse.duytan.coms.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;
import cse.duytan.coms.libraries.map.MapView;
import cse.duytan.coms.libraries.map.MapViewListener;
import cse.duytan.coms.libraries.map.layer.MarkLayer;
import cse.duytan.coms.models.TestData;

public class MapActivity extends AppCompatActivity {

    @BindView(R.id.ivZoomIn)
    ImageButton ivZoomIn;
    @BindView(R.id.ivZoomOut)
    ImageButton ivZoomOut;
    private MapView mapView;
    private MarkLayer markLayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);
        intUI();
    }

    private void intUI() {
        mapView = (MapView) findViewById(R.id.mapview);

        setUpMap();
    }

    private void setUpMap() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_map);
        mapView.loadMap(bitmap);
        mapView.setMapViewListener(new MapViewListener() {
            @Override
            public void onMapLoadSuccess() {
                final List<PointF> marks = TestData.getMarks();
                final List<String> marksName = TestData.getMarksName();
                markLayer = new MarkLayer(mapView, marks, marksName);
                markLayer.setMarkIsClickListener(new MarkLayer.MarkIsClickListener() {

                    @Override
                    public void markIsClick(int num, float x, float y) {

                    }

                    @Override
                    public void markIsClick(int num) {
                        Toast.makeText(getApplicationContext(), marksName.get(num) + " is " +
                                "selected", Toast.LENGTH_SHORT).show();
                    }
                });
                mapView.addLayer(markLayer);
                mapView.refresh();
            }

            @Override
            public void onMapLoadFail() {

            }

        });
    }

    @OnClick({R.id.ivZoomIn, R.id.ivZoomOut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivZoomIn:
                mapView.setCurrentZoom(mapView.getCurrentZoom()+0.5f);
                mapView.refresh();
                break;
            case R.id.ivZoomOut:
                mapView.setCurrentZoom(mapView.getCurrentZoom()-0.5f);
                mapView.refresh();
                break;
        }
    }
}
