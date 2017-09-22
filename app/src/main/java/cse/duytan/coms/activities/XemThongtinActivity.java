package cse.duytan.coms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cse.duytan.coms.R;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.models.AbstractModel;
import cse.duytan.coms.models.SeeAbstractModel;
import cse.duytan.coms.untils.Constants;

public class XemThongtinActivity extends AppCompatActivity implements DownloadCallback {


    @BindView(R.id.edTieude_see_abs)
    TextView edTieudeSeeAbs;

    @BindView(R.id.edTieudeEng_see_abs)
    TextView edTieudeEngSeeAbs;

    @BindView(R.id.txtChude_see_abs)
    TextView txtChudeSeeAbs;

    @BindView(R.id.txterr_chonchude_send_abs)
    TextView txterrChonchudeSendAbs;

    @BindView(R.id.txtLoaihinhnghiencuu_see_abs)
    TextView txtLoaihinhnghiencuuSeeAbs;

    @BindView(R.id.txtLoaihinhtrinhbay_see_abs)
    TextView txtLoaihinhtrinhbaySeeAbs;

    @BindView(R.id.edNoidung_see_abs)
    TextView edNoidungSeeAbs;

    @BindView(R.id.btnChonTaptin_send_abs)
    Button btnChonTaptinSendAbs;

    private Toolbar toolbar;
    private Intent intent;
    private AbstractModel abstractModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_thongtin);
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        intent = this.getIntent();
        String type = intent.getStringExtra("type");
        if (type.equals("1")) {
            setTitle(R.string.title_see_abstract);
            abstractModel = new AbstractModel();
            abstractModel = (AbstractModel) intent.getSerializableExtra("object");
        } else {//2
            setTitle(R.string.title_see_paper);
        }
        addEvents();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// hiện nút back

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                intent.putExtra("status",0);//0 đang soạn, chưa gửi
//                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });


    }

    private void addEvents() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Id", abstractModel.getPAPER_ID());
            jsonObject.put("position", abstractModel.getPOSITION());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String json = jsonObject.toString();
        DownloadAsyncTask.POST(this, Constants.ID_API_SEE_ABSTRACT, Constants.API_SEE_ABSTRACT,
                json, SeeAbstractModel.class, true, XemThongtinActivity.this);
    }


    @Override
    public void downloadSuccess(int processId, Object data) {
        if(processId == Constants.ID_API_SEE_ABSTRACT){
            ArrayList<SeeAbstractModel> ds = new ArrayList<>();
            ds = (ArrayList<SeeAbstractModel>) data;
            for (int i = 0; i< ds.size(); i++ ){
                    edTieudeSeeAbs.setText(ds.get(i).getPAPER_ABSTRACT_TITLE());
                    edTieudeEngSeeAbs.setText(ds.get(i).getPAPER_ABSTRACT_TITLE_EN());
                    txtChudeSeeAbs.setText(ds.get(i).getCONFERENCE_SESSION_TOPIC_NAME());
                    txtLoaihinhnghiencuuSeeAbs.setText(ds.get(i).getTYPE_OF_STUDY_NAME());
                    txtLoaihinhtrinhbaySeeAbs.setText(ds.get(i).getCONFERENCE_PRESENTATION_TYPE_NAME());
                    edNoidungSeeAbs.setText(ds.get(i).getPAPER_ABSTRACT_TEXT());
            }
        }
    }

    @Override
    public void downloadError(int processId, String msg) {

    }
}
