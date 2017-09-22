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
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.models.AbstractModel;
import cse.duytan.coms.models.PresentationTypeModel;
import cse.duytan.coms.models.ResultBoolean;
import cse.duytan.coms.models.SessionTopicModel;
import cse.duytan.coms.models.TypeOfStudyModel;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.untils.Utils;

public class SendAbstractActivity extends AppCompatActivity implements DownloadCallback {
    private Toolbar toolbar;
    private Intent intent;
    private Button btnChon_chude, btnChon_loaihinhnghiencuu, btnChon_loaihinhtrinhbay;
    private TextView txtChude, txtLoaihinhtrinhbay, txtLoaihinhnghiencuu;
    private EditText edTieude, edTieudeEng, edNoidung, edDanhGia, edThangdiem;
    private TextView txterr_chude, txterr_loaihinhnghiencuu, txterr_loaihinhtrinhbay, txterr_Tieude, txtTieude_quatrinh, txtTieudeThangdiem;
    private RadioGroup radioGroup;
    public String type, title;
    private AbstractModel abstractModel;
    private ArrayList<SessionTopicModel> arrSessionTopic;
    private ArrayList<TypeOfStudyModel> arrTypeOfStudy;
    private ArrayList<PresentationTypeModel> arrPresentationType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_abstract);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        intent = this.getIntent();
        arrSessionTopic = new ArrayList<>();
        arrTypeOfStudy = new ArrayList<>();
        arrPresentationType = new ArrayList<>();
        arrSessionTopic = (ArrayList<SessionTopicModel>) intent.getSerializableExtra("session_topic");
        arrTypeOfStudy = (ArrayList<TypeOfStudyModel>) intent.getSerializableExtra("type_of_study");
        arrPresentationType = (ArrayList<PresentationTypeModel>) intent.getSerializableExtra("presentation_type");

        type = intent.getStringExtra("type");
        title = intent.getStringExtra("title");
        abstractModel = new AbstractModel();
        abstractModel = (AbstractModel) intent.getSerializableExtra("object");

        if(type.equals("tomtat") && title.equals("capnhat")){
            setTitle(R.string.title_update_abstract);
        }if(type.equals("baitomtat") && title.equals("danhgia")){
            setTitle(R.string.title_review_abstract);
        }if(type.equals("3") && title.equals("3")){
            setTitle(R.string.title_review_paper);
        }if(type.equals("4") && title.equals("4")){
            setTitle(R.string.title_update_paper);// sửa chỗ này.
        }else{
            //setTitle(R.string.title_abstarct);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// hiện nút back

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
        btnChon_chude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrSessionTopic.size() > 0){
                    dialog_choose(1, "Chủ đề");
                }else{
                    Toast.makeText(getApplication(), "Chưa có dữ liệu", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnChon_loaihinhnghiencuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrTypeOfStudy.size() > 0){
                    dialog_choose(2, "Loại hình nghiên cứu");
                }else{
                    Toast.makeText(getApplication(), "Chưa có dữ liệu", Toast.LENGTH_LONG).show();
                }

            }
        });
        btnChon_loaihinhtrinhbay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrPresentationType.size() > 0){
                    dialog_choose(3, "Loại hình trình bày");
                }else{
                    Toast.makeText(getApplication(), "Chưa có dữ liệu", Toast.LENGTH_LONG).show();
                }

            }
        });
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


    private void dialog_choose(int type, String title){
        AlertDialog.Builder mBuilder  = new AlertDialog.Builder(SendAbstractActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_spinner_chude, null);
        switch (type){
            case 1:

                mBuilder.setTitle(title);
                final Spinner mSpinner = (Spinner) mView.findViewById(R.id.spinner);
                ArrayList<String> ds = new ArrayList<>();
                //arrSessionTopic
                for(int i = 0; i < arrSessionTopic.size(); i++){
                    ds.add(arrSessionTopic.get(i).getCONFERENCE_SESSION_TOPIC_NAME());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(SendAbstractActivity.this, android.R.layout.simple_spinner_item,
                        ds);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mSpinner.setAdapter(adapter);

                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(!mSpinner.getSelectedItem().toString().equalsIgnoreCase("Vui lòng chọn chủ đề …")){
                            txtChude.setText(mSpinner.getSelectedItem().toString());
                            txterr_chude.setVisibility(View.GONE);
                            txterr_chude.setText("");
                        }
                    }
                });

                mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
                break;
            case 2:
                mBuilder.setTitle(title);
                final Spinner mSpinner2 = (Spinner) mView.findViewById(R.id.spinner);
                ArrayList<String> ds2 = new ArrayList<>();
                for(int i = 0; i < arrTypeOfStudy.size(); i++){
                    ds2.add(arrTypeOfStudy.get(i).getTYPE_OF_STUDY_NAME());
                }
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(SendAbstractActivity.this, android.R.layout.simple_spinner_item,
                        ds2);

                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mSpinner2.setAdapter(adapter2);
//                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(SendAbstractActivity.this, android.R.layout.simple_spinner_item,
//                        getResources().getStringArray(R.array.dsLoaihinhnghiencuu));
//                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                mSpinner2.setAdapter(adapter2);

                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(!mSpinner2.getSelectedItem().toString().equalsIgnoreCase("Vui lòng chọn loại hình nghiên cứu …")){
                            txtLoaihinhnghiencuu.setText(mSpinner2.getSelectedItem().toString());
                            txterr_loaihinhnghiencuu.setVisibility(View.GONE);
                            txterr_loaihinhnghiencuu.setText("");
                        }
                    }
                });

                mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog2 = mBuilder.create();
                dialog2.show();
                break;
            case 3:
                mBuilder.setTitle(title);
                final Spinner mSpinner3 = (Spinner) mView.findViewById(R.id.spinner);
                ArrayList<String> ds3 = new ArrayList<>();
                for(int i = 0; i < arrPresentationType.size(); i++){
                    ds3.add(arrPresentationType.get(i).getCONFERENCE_PRESENTATION_TYPE_NAME());
                }
                ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(SendAbstractActivity.this, android.R.layout.simple_spinner_item,
                        ds3);

                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mSpinner3.setAdapter(adapter3);

//                ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(SendAbstractActivity.this, android.R.layout.simple_spinner_item,
//                        getResources().getStringArray(R.array.dsLoaihinhnghiencuu));
//                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                mSpinner3.setAdapter(adapter3);

                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(!mSpinner3.getSelectedItem().toString().equalsIgnoreCase("Vui lòng chọn loại hình trình bày …")){
                            txtLoaihinhtrinhbay.setText(mSpinner3.getSelectedItem().toString());
                            txterr_loaihinhtrinhbay.setVisibility(View.GONE);
                            txterr_loaihinhtrinhbay.setText("");
                        }
                    }
                });

                mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog3 = mBuilder.create();
                dialog3.show();
                break;
        }
    }


    private void addControll(){
        btnChon_chude = (Button) findViewById(R.id.btnChonchude_see_abs);
        btnChon_loaihinhnghiencuu = (Button) findViewById(R.id.btnChonLoaihinhnghiencuu_send_abs);
        btnChon_loaihinhtrinhbay = (Button) findViewById(R.id.btnChonLoaihinhtrinhbay_send_abs);
        txtChude = (TextView) findViewById(R.id.txtChude_see_abs);
        edTieude = (EditText) findViewById(R.id.edTieude_see_abs);
        edTieudeEng = (EditText) findViewById(R.id.edTieudeEng_see_abs);
        edNoidung = (EditText) findViewById(R.id.edNoidung_see_abs);
        txtLoaihinhnghiencuu = (TextView) findViewById(R.id.txtLoaihinhnghiencuu_see_abs);
        txtLoaihinhtrinhbay = (TextView) findViewById(R.id.txtLoaihinhtrinhbay_see_abs);
        txterr_chude = (TextView) findViewById(R.id.txterr_chonchude_send_abs);
        txterr_loaihinhnghiencuu = (TextView) findViewById(R.id.txterr_chonloaihinhnghiencuu_send_abs);
        txterr_loaihinhtrinhbay = (TextView) findViewById(R.id.txterr_chonloaihinhtrinhbay_send_abs);
        txterr_Tieude = (TextView) findViewById(R.id.txterr_Tieude_see_abs);
        txtTieude_quatrinh = (TextView) findViewById(R.id.txtTieude_duyetbai);
        radioGroup = (RadioGroup) findViewById(R.id.myRadioGroup_quatrinh_send_abs);
        edDanhGia = (EditText) findViewById(R.id.edDanhGia);
        txtTieudeThangdiem = (TextView) findViewById(R.id.txtTieude_Thangdiem);
        edThangdiem = (EditText) findViewById(R.id.edThangdiem);
        String strStatus = Utils.convertStringLowerCase(abstractModel.getFULL_PAPER_OR_WORK_IN_PROGRESS());

        if(type.equals("2") && title.equals("2")){
            txtTieude_quatrinh.setText("Đánh giá:");
            radioGroup.setVisibility(View.GONE);
            edDanhGia.setVisibility(View.VISIBLE);
            txtTieudeThangdiem.setVisibility(View.VISIBLE);
            edThangdiem.setVisibility(View.VISIBLE);
        }

        if(type.equals("tomtat") && title.equals("capnhat")){
            edTieude.setText(abstractModel.getPAPER_ABSTRACT_TITLE());
            edTieudeEng.setText(abstractModel.getPAPER_ABSTRACT_TITLE_EN());
            txtChude.setText(abstractModel.getCONFERENCE_SESSION_TOPIC_NAME());
            txtLoaihinhnghiencuu.setText(abstractModel.getTYPE_OF_STUDY_NAME());
            txtLoaihinhtrinhbay.setText(abstractModel.getCONFERENCE_PRESENTATION_TYPE_NAME());
            edNoidung.setText(abstractModel.getPAPER_ABSTRACT_TEXT());
            if(strStatus.equalsIgnoreCase("fullpaper")){
                radioGroup.check(R.id.rd_hoanthanh_send_abs);
            }else{
                radioGroup.check(R.id.rd_tuchoi_send_abs);
            }

        }
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
                String choose_chude = txtChude.getText().toString();
                String choose_loaihinhtrinhbay = txtLoaihinhtrinhbay.getText().toString();
                String choose_loaihinhnghiencuu = txtLoaihinhnghiencuu.getText().toString();

                if(tieude.trim().equals("")){
                    txterr_Tieude.setVisibility(View.VISIBLE);
                    txterr_Tieude.setText("Vui lòng nhâp tiêu đề bài tóm tắt");
                    err++;
                }

                if(choose_chude.equals("")){
                    txterr_chude.setVisibility(View.VISIBLE);
                    txterr_chude.setText("Vui lòng chọn chủ đề");
                    err++;
                }

                if(choose_loaihinhnghiencuu.equals("")){
                    txterr_loaihinhnghiencuu.setVisibility(View.VISIBLE);
                    txterr_loaihinhnghiencuu.setText("Vui lòng chọn loại hình nghiên cứu");
                    err++;
                }

                int selected = radioGroup.getCheckedRadioButtonId();
                View radioButton = radioGroup.findViewById(selected);
                int idx = radioGroup.indexOfChild(radioButton);

//                Toast.makeText(getApplication(), idx + "", Toast.LENGTH_LONG).show();

                if(err>0){
                    Toast.makeText(SendAbstractActivity.this, "Vui lòng nhập đầy đủ thông tin.", Toast.LENGTH_SHORT).show();
                }else{
//                    Toast.makeText(SendAbstractActivity.this, "Gửi dữ liệu.", Toast.LENGTH_SHORT).show();

                    if(type.equals("tomtat") && title.equals("capnhat")){
                        JSONObject jsonObject = new JSONObject();
                        try{
//                            jsonObject.put("PERSON_ID", abstractModel.getPAPER_ID());
                            jsonObject.put("PAPER_ID", abstractModel.getPAPER_ID());
                            jsonObject.put("PAPER_ABSTRACT_TITLE", edTieude.getText().toString());
                            jsonObject.put("PAPER_ABSTRACT_TITLE_EN", edTieudeEng.getText().toString());

                            if(arrSessionTopic != null && arrSessionTopic.size() > 0 ) {
                                for (int i = 0; i < arrSessionTopic.size(); i++) {
                                    if (txtChude.getText().equals(arrSessionTopic.get(i).getCONFERENCE_SESSION_TOPIC_NAME())) {
                                        jsonObject.put("CONFERENCE_SESSION_TOPIC_ID", arrSessionTopic.get(i).getCONFERENCE_SESSION_TOPIC_ID());
                                        jsonObject.put("CONFERENCE_SESSION_TOPIC_NAME", arrSessionTopic.get(i).getCONFERENCE_SESSION_TOPIC_NAME());
                                        jsonObject.put("CONFERENCE_SESSION_TOPIC_NAME_EN", arrSessionTopic.get(i).getCONFERENCE_SESSION_TOPIC_NAME_EN());
                                        break;
                                    }else{
                                        jsonObject.put("CONFERENCE_SESSION_TOPIC_ID", JSONObject.NULL);
                                        jsonObject.put("CONFERENCE_SESSION_TOPIC_NAME", JSONObject.NULL);
                                        jsonObject.put("CONFERENCE_SESSION_TOPIC_NAME_EN", JSONObject.NULL);
                                    }
                                }
                            }else{
                                jsonObject.put("CONFERENCE_SESSION_TOPIC_ID", JSONObject.NULL);
                                jsonObject.put("CONFERENCE_SESSION_TOPIC_NAME", JSONObject.NULL);
                                jsonObject.put("CONFERENCE_SESSION_TOPIC_NAME_EN", JSONObject.NULL);
                            }

                            jsonObject.put("PAPER_ABSTRACT_TEXT", edNoidung.getText().toString());
                            Log.d("idx",idx + "");
                            String temp = "";
                            if(idx == 0)
                            {
                                temp =  "WORK IN PROGRESS";
                            } else {
                                temp = "FULL PAPER";
                            }
                            jsonObject.put("FULL_PAPER_OR_WORK_IN_PROGRESS", temp);

                            Log.d("arrTypeOfStudy.size()",arrTypeOfStudy.size()+"");
                            if(arrTypeOfStudy != null && arrTypeOfStudy.size() > 0){
                                for(int i = 0; i< arrTypeOfStudy.size(); i++){
                                    Log.d("---",txtLoaihinhnghiencuu.getText()+"__"+arrTypeOfStudy.get(i).getTYPE_OF_STUDY_NAME());
                                    if(txtLoaihinhnghiencuu.getText().equals(arrTypeOfStudy.get(i).getTYPE_OF_STUDY_NAME())){
                                        jsonObject.put("TYPE_OF_STUDY_ID", arrTypeOfStudy.get(i).getTYPE_OF_STUDY_ID());
                                        jsonObject.put("TYPE_OF_STUDY_NAME", arrTypeOfStudy.get(i).getTYPE_OF_STUDY_NAME());
                                        jsonObject.put("TYPE_OF_STUDY_NAME_EN", arrTypeOfStudy.get(i).getTYPE_OF_STUDY_NAME_EN());
                                        break;
                                    }else{
                                        jsonObject.put("TYPE_OF_STUDY_ID", JSONObject.NULL);
                                        jsonObject.put("TYPE_OF_STUDY_NAME", JSONObject.NULL);
                                        jsonObject.put("TYPE_OF_STUDY_NAME_EN", JSONObject.NULL);
                                    }
                                }
                            }else{
                                jsonObject.put("TYPE_OF_STUDY_ID", JSONObject.NULL);
                                jsonObject.put("TYPE_OF_STUDY_NAME", JSONObject.NULL);
                                jsonObject.put("TYPE_OF_STUDY_NAME_EN", JSONObject.NULL);
                            }

                            if(arrPresentationType != null && arrPresentationType.size() > 0){
                                for (int i = 0; i < arrPresentationType.size() ; i++){
                                    if(txtLoaihinhtrinhbay.getText().equals(arrPresentationType.get(i).getCONFERENCE_PRESENTATION_TYPE_NAME())){
                                        Log.d("arrPresentationType:","YES");
                                        jsonObject.put("CONFERENCE_PRESENTATION_TYPE_ID", arrPresentationType.get(i).getCONFERENCE_PRESENTATION_TYPE_ID());
                                        jsonObject.put("CONFERENCE_PRESENTATION_TYPE_NAME", arrPresentationType.get(i).getCONFERENCE_PRESENTATION_TYPE_NAME());
                                        jsonObject.put("CONFERENCE_PRESENTATION_TYPE_NAME_EN", arrPresentationType.get(i).getCONFERENCE_PRESENTATION_TYPE_NAME_EN());
                                        break;
                                    }else{
                                        Log.d("arrPresentationType:","NO");
                                        jsonObject.put("CONFERENCE_PRESENTATION_TYPE_ID", JSONObject.NULL);
                                        jsonObject.put("CONFERENCE_PRESENTATION_TYPE_NAME", JSONObject.NULL);
                                        jsonObject.put("CONFERENCE_PRESENTATION_TYPE_NAME_EN", JSONObject.NULL);
                                    }
                                }
                            }else{
                                Log.d("arrPresentationType:","rỗng");
                                jsonObject.put("CONFERENCE_PRESENTATION_TYPE_ID", JSONObject.NULL);
                                jsonObject.put("CONFERENCE_PRESENTATION_TYPE_NAME", JSONObject.NULL);
                                jsonObject.put("CONFERENCE_PRESENTATION_TYPE_NAME_EN", JSONObject.NULL);
                            }


                            jsonObject.put("POSITION", abstractModel.getPOSITION());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String json = jsonObject.toString();
                        Log.d("---json:", json);
                        DownloadAsyncTask.POST(this,
                                Constants.ID_API_UPDATE_ABSTRACT,
                                Constants.API_UPDATE_ABSTRACT,
                                json, ResultBoolean.class,true, SendAbstractActivity.this);
                    }
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        if(processId == Constants.ID_API_SESSIONTOPIC){

        }else if(processId == Constants.ID_API_UPDATE_ABSTRACT){
            setResult(Activity.RESULT_OK);
            finish();
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        if(processId == Constants.ID_API_SESSIONTOPIC){
            Log.d("---","thatbai");

        }else if(processId == Constants.ID_API_UPDATE_ABSTRACT){

        }
    }
}
