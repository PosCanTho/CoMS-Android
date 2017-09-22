package cse.duytan.coms.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cse.duytan.coms.R;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.models.PaperTextModel;
import cse.duytan.coms.models.ResultBoolean;
import cse.duytan.coms.untils.Constants;

public class UpdatePaperTextActivity extends AppCompatActivity implements DownloadCallback {

    @BindView(R.id.edTieude_send_paper)
    EditText edTieudeSendPaper;
    @BindView(R.id.edTieudeEng_send_paper)
    EditText edTieudeEngSendPaper;
    @BindView(R.id.btnChonTaptin_send_paper)
    Button btnChonTaptinSendPaper;
    @BindView(R.id.edPAPER_TEXT)
    EditText edPAPERTEXT;
    private Toolbar toolbar;
    private Intent intent;
    private PaperTextModel paperTextModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_paper_text);
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        intent = this.getIntent();
        paperTextModel = (PaperTextModel) intent.getSerializableExtra("object");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// hiện nút back

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        addEvents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.send, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_send:
                Toast.makeText(this, "Lưu", Toast.LENGTH_LONG).show();
                if(edTieudeSendPaper.getText().equals("") || edTieudeEngSendPaper.getText().equals("")){
                    Toast.makeText(this, "Vui lòng đền đầy đủ thông tin", Toast.LENGTH_LONG).show();
                }else{
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("PAPER_ID", paperTextModel.getPAPER_ID());
                        jsonObject.put("PAPER_TEXT_TITLE", edTieudeSendPaper.getText());
                        jsonObject.put("PAPER_TEXT_TITLE_EN", edTieudeEngSendPaper.getText());
                        jsonObject.put("POSITION", paperTextModel.getPOSITION());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String json = jsonObject.toString();
                    DownloadAsyncTask.POST(this, Constants.ID_API_UPDATE_PAPERTEXT, Constants.API_UPDATE_PAPERTEXT,
                            json, ResultBoolean.class, false, UpdatePaperTextActivity.this);
                }
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    private void addEvents() {
        edTieudeSendPaper.setText(paperTextModel.getPAPER_TEXT_TITLE());
        edTieudeEngSendPaper.setText(paperTextModel.getPAPER_TEXT_TITLE_EN());
        edPAPERTEXT.setText(paperTextModel.getPAPER_TEXT());
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        if(processId == Constants.ID_API_UPDATE_PAPERTEXT){
            ResultBoolean kq = new ResultBoolean();
            kq = (ResultBoolean) data;
            if(kq.result == true){
                Toast.makeText(this, "Đã cập nhật", Toast.LENGTH_LONG).show();
                setResult(Activity.RESULT_OK);
                finish();
            }else{
                Toast.makeText(this, "Không cập nhật", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        if(processId == Constants.ID_API_UPDATE_PAPERTEXT){
            Toast.makeText(this, "Lỗi server", Toast.LENGTH_LONG).show();
        }
    }
}
