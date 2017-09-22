package cse.duytan.coms.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import cse.duytan.coms.R;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.models.AbstractModel;
import cse.duytan.coms.models.ResultBoolean;
import cse.duytan.coms.untils.Constants;

public class SendPaperActivity extends AppCompatActivity implements DownloadCallback {
    private Toolbar toolbar;
    private Intent intent;
    private Button btnChon_taptin;
    private EditText edTieude, edTieudeEng, edNoidung;
    private RadioGroup radioGroup;
    private AbstractModel abstractModel;
    private TextView txterr_file_paper,txterr_Tieude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_paper);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.title_papertext);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// hiện nút back
        intent = this.getIntent();
        abstractModel = new AbstractModel();
        abstractModel = (AbstractModel) intent.getSerializableExtra("object");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("status",0);//0 đang soạn, chưa gửi
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        addControll();
        addEvents();


    }

    private void addEvents() {

        edTieude.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().trim().equals("") || charSequence.equals(null)){
                    txterr_Tieude.setVisibility(View.VISIBLE);
                    txterr_Tieude.setText("Vui lòng nhâp tiêu đề bài tóm tắt");
                }else{
                    txterr_Tieude.setVisibility(View.GONE);
                    txterr_Tieude.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    private void addControll(){
        edTieude = (EditText) findViewById(R.id.edTieude_send_paper);
        edTieudeEng = (EditText) findViewById(R.id.edTieudeEng_send_paper);
        edNoidung = (EditText) findViewById(R.id.edPAPER_TEXT);
        radioGroup = (RadioGroup) findViewById(R.id.myRadioGroup_quatrinh_send_paper);
        txterr_Tieude = (TextView) findViewById(R.id.txterr_Tieude_send_paper);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.send, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_send:
                int err = 0;
                String tieude = edTieude.getText().toString();


                if(tieude.trim().equals("")){
                    txterr_Tieude.setVisibility(View.VISIBLE);
                    txterr_Tieude.setText("Vui lòng nhâp tiêu đề bài tóm tắt");
                    err++;
                }


                if(err>0){
                    Toast.makeText(SendPaperActivity.this, "Lỗi, không thể gửi bài!", Toast.LENGTH_SHORT).show();
                }else{
                    int selected = radioGroup.getCheckedRadioButtonId();
                    View radioButton = radioGroup.findViewById(selected);
                    int idx = radioGroup.indexOfChild(radioButton);

                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("PAPER_ID", abstractModel.getPAPER_ID());
                        jsonObject.put("PAPER_TEXT_TITLE", edTieude.getText().toString());

                        if(edTieudeEng.getText().toString() != null && !edTieudeEng.getText().toString().equals("")){
                            jsonObject.put("PAPER_TEXT_TITLE_EN", edTieudeEng.getText().toString());
                        }else {
                            jsonObject.put("PAPER_TEXT_TITLE_EN", JSONObject.NULL);
                        }

                        if(edNoidung.getText().toString()!= null && !edNoidung.getText().toString().equals("")){
                            jsonObject.put("PAPER_TEXT", edNoidung.getText().toString());
                        }else{
                            jsonObject.put("PAPER_TEXT", JSONObject.NULL);
                        }

                        if(abstractModel.getCONFERENCE_SESSION_TOPIC_ID() > 0 &&
                                !abstractModel.getCONFERENCE_SESSION_TOPIC_NAME().equals(null) &&
                                !abstractModel.getCONFERENCE_SESSION_TOPIC_NAME().equals("")){
                            jsonObject.put("FINAL_ASSIGNED_CONFERENCE_SESSION_TOPIC_ID", abstractModel.getCONFERENCE_SESSION_TOPIC_ID());
                            jsonObject.put("FINAL_ASSIGNED_CONFERENCE_SESSION_TOPIC_NAME",abstractModel.getCONFERENCE_SESSION_TOPIC_NAME());
                            if(!abstractModel.getCONFERENCE_SESSION_TOPIC_NAME_EN().equals(null) && !abstractModel.getCONFERENCE_SESSION_TOPIC_NAME_EN().equals("")){
                                jsonObject.put("FINAL_ASSIGNED_CONFERENCE_SESSION_TOPIC_NAME_EN",abstractModel.getCONFERENCE_SESSION_TOPIC_NAME_EN());
                            }else{
                                jsonObject.put("FINAL_ASSIGNED_CONFERENCE_SESSION_TOPIC_NAME_EN",JSONObject.NULL);
                            }

                        }else{
                            jsonObject.put("FINAL_ASSIGNED_CONFERENCE_SESSION_TOPIC_ID", JSONObject.NULL);
                            jsonObject.put("FINAL_ASSIGNED_CONFERENCE_SESSION_TOPIC_NAME",JSONObject.NULL);
                            jsonObject.put("FINAL_ASSIGNED_CONFERENCE_SESSION_TOPIC_NAME_EN",JSONObject.NULL);
                        }
                        if(idx == 0){
                            jsonObject.put("FINAL_APPROVED_FULL_PAPER_OR_WORK_IN_PROGRESS", "WORK IN PROGRESS");
                        }else{
                            jsonObject.put("FINAL_APPROVED_FULL_PAPER_OR_WORK_IN_PROGRESS", "FULL PAPER");
                        }

                        if(abstractModel.getTYPE_OF_STUDY_ID() >= 0 &&
                                !abstractModel.getTYPE_OF_STUDY_NAME().equals(null) &&
                                !abstractModel.getTYPE_OF_STUDY_NAME().equals("")){
                            jsonObject.put("FINAL_APPROVED_TYPE_OF_STUDY_ID", abstractModel.getTYPE_OF_STUDY_ID());
                            jsonObject.put("FINAL_APPROVED_TYPE_OF_STUDY_NAME", abstractModel.getTYPE_OF_STUDY_NAME());
                            if(!abstractModel.getTYPE_OF_STUDY_NAME_EN().equals(null) && !abstractModel.getTYPE_OF_STUDY_NAME_EN().equals("")){
                                jsonObject.put("FINAL_APPROVED_TYPE_OF_STUDY_NAME_EN", abstractModel.getTYPE_OF_STUDY_NAME_EN());
                            }else{
                                jsonObject.put("FINAL_APPROVED_TYPE_OF_STUDY_NAME_EN", JSONObject.NULL);
                            }
                        }else{
                            jsonObject.put("FINAL_APPROVED_TYPE_OF_STUDY_ID", JSONObject.NULL);
                            jsonObject.put("FINAL_APPROVED_TYPE_OF_STUDY_NAME", JSONObject.NULL);
                            jsonObject.put("FINAL_APPROVED_TYPE_OF_STUDY_NAME_EN", JSONObject.NULL);
                        }


                        String PRESENTATION_TYPE_NAME = abstractModel.getCONFERENCE_PRESENTATION_TYPE_NAME();

                        if(
                                abstractModel.getCONFERENCE_PRESENTATION_TYPE_ID() >= 0 &&
                                PRESENTATION_TYPE_NAME != null &&
                                PRESENTATION_TYPE_NAME != ""
                                ){
                            jsonObject.put("FINAL_APPROVED_CONFERENCE_PRESENTATION_TYPE_ID", abstractModel.getCONFERENCE_PRESENTATION_TYPE_ID());
                            jsonObject.put("FINAL_APPROVED_CONFERENCE_PRESENTATION_TYPE_NAME", abstractModel.getCONFERENCE_PRESENTATION_TYPE_NAME());
                            if(!abstractModel.getCONFERENCE_PRESENTATION_TYPE_NAME_EN().equals(null) && !abstractModel.getCONFERENCE_PRESENTATION_TYPE_NAME_EN().equals("")){
                                jsonObject.put("FINAL_APPROVED_CONFERENCE_PRESENTATION_TYPE_NAME_EN", abstractModel.getCONFERENCE_PRESENTATION_TYPE_NAME_EN());
                            }else{
                                jsonObject.put("FINAL_APPROVED_CONFERENCE_PRESENTATION_TYPE_NAME_EN", JSONObject.NULL);
                            }
                        }else{
                            jsonObject.put("FINAL_APPROVED_CONFERENCE_PRESENTATION_TYPE_ID", JSONObject.NULL);
                            jsonObject.put("FINAL_APPROVED_CONFERENCE_PRESENTATION_TYPE_NAME", JSONObject.NULL);
                            jsonObject.put("FINAL_APPROVED_CONFERENCE_PRESENTATION_TYPE_NAME_EN", JSONObject.NULL);
                        }
                        jsonObject.put("POSITION", abstractModel.getPOSITION());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String json = jsonObject.toString();

                    DownloadAsyncTask.POST(this, Constants.ID_API_REGISTER_PAPERTEXT, Constants.API_REGISTER_PAPERTEXT,
                            json, ResultBoolean.class, true, SendPaperActivity.this);


                }



//                Toast.makeText(getApplication(), "Hiện thị dialog xác nhận", Toast.LENGTH_LONG).show();
//                intent.putExtra("status",0);//0 đang soạn, chưa gửi
//                setResult(Activity.RESULT_OK, intent);
//                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        if(processId == Constants.ID_API_REGISTER_PAPERTEXT){
            ResultBoolean ds = (ResultBoolean) data;
            if(ds.result == true){
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(SendPaperActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.information_dialog, null);
                TextView txtTieude = (TextView)mView.findViewById(R.id.txtTieudeThongbao);
                TextView txtTrangthai = (TextView)mView.findViewById(R.id.txtTrangthaithongbao);
                txtTieude.setText("GỬI BÀI BÁO THÀNH CÔNG");
                txtTrangthai.setText("Bài báo đang chờ đánh giá");
                mBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intent.putExtra("status",0);//0 đang soạn, chưa gửi
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                    }
                });
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }else{
                Toast.makeText(this, "Bài báo đã gửi trước đó", Toast.LENGTH_LONG).show();

                intent.putExtra("status",0);//0 đang soạn, chưa gửi
                setResult(Activity.RESULT_OK, intent);
                finish();
            }


        }
    }

    @Override
    public void downloadError(int processId, String msg) {

    }
}
