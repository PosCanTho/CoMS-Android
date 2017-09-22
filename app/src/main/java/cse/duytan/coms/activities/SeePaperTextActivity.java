package cse.duytan.coms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cse.duytan.coms.R;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.models.PaperTextModel;
import cse.duytan.coms.models.SeePaperText;
import cse.duytan.coms.untils.Constants;

public class SeePaperTextActivity extends AppCompatActivity implements DownloadCallback {
    @BindView(R.id.edTieude_see_abs)
    TextView edTieudeSeeAbs;
    @BindView(R.id.edTieudeEng_see_abs)
    TextView edTieudeEngSeeAbs;
    @BindView(R.id.btnChonTaptin_send_abs)
    Button btnChonTaptinSendAbs;

    private Toolbar toolbar;
    private Intent intent;
    private PaperTextModel paperTextModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_paper_text);
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        intent = this.getIntent();
        paperTextModel = (PaperTextModel) intent.getSerializableExtra("object");
//        Toast.makeText(this, "id:"+paperTextModel.getPAPER_ID() + "_position:" + paperTextModel.getPOSITION(), Toast.LENGTH_LONG).show();
        setTitle(R.string.title_see_paper);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// hiện nút back

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Id", paperTextModel.getPAPER_ID());
            jsonObject.put("position", paperTextModel.getPOSITION());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String json = jsonObject.toString();

        DownloadAsyncTask.POST(this, Constants.ID_API_SEE_ITEM_PAPERTEXT, Constants.API_SEE_ITEM_PAPERTEXT,
                json, SeePaperText.class, false, SeePaperTextActivity.this);

    }



    @Override
    public void downloadSuccess(int processId, Object data) {
        if(processId == Constants.ID_API_SEE_ITEM_PAPERTEXT){
            ArrayList<SeePaperText> ds = new ArrayList<>();
            ds = (ArrayList<SeePaperText>) data;
            if(ds.isEmpty()){
                Toast.makeText(this, "Không thấy dữ liệu", Toast.LENGTH_LONG).show();
            }else{

                edTieudeSeeAbs.setText(ds.get(0).getPAPER_TEXT_TITLE());
                edTieudeEngSeeAbs.setText(ds.get(0).getPAPER_TEXT_TITLE_EN());
            }
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        if(processId == Constants.ID_API_SEE_ITEM_PAPERTEXT){
            Toast.makeText(this, "Lỗi server", Toast.LENGTH_LONG).show();
        }
    }
}
