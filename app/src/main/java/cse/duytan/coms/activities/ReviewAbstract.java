package cse.duytan.coms.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
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
import cse.duytan.coms.models.AbstractModel;
import cse.duytan.coms.models.BoardOfReview;
import cse.duytan.coms.models.PresentationTypeModel;
import cse.duytan.coms.models.ResultBoolean;
import cse.duytan.coms.models.Review;
import cse.duytan.coms.models.SessionTopicModel;
import cse.duytan.coms.models.TypeOfStudyModel;
import cse.duytan.coms.untils.Constants;

public class ReviewAbstract extends AppCompatActivity implements DownloadCallback {
    @BindView(R.id.txtChude_see_abs)
    TextView txtChudeSeeAbs;

    @BindView(R.id.btnChonchude_see_abs)
    Button btnChonchudeSeeAbs;

    @BindView(R.id.txtLoaihinhnghiencuu_see_abs)
    TextView txtLoaihinhnghiencuuSeeAbs;

    @BindView(R.id.btnChonLoaihinhnghiencuu_send_abs)
    Button btnChonLoaihinhnghiencuuSendAbs;

    @BindView(R.id.txtLoaihinhtrinhbay_see_abs)
    TextView txtLoaihinhtrinhbaySeeAbs;

    @BindView(R.id.btnChonLoaihinhtrinhbay_send_abs)
    Button btnChonLoaihinhtrinhbaySendAbs;

    @BindView(R.id.edNoidung_see_abs)
    EditText edNoidungSeeAbs;

    @BindView(R.id.btnChonTaptin_send_abs)
    Button btnChonTaptinSendAbs;

    @BindView(R.id.rd_tuchoi_send_abs)
    RadioButton rdTuchoiSendAbs;

    @BindView(R.id.rd_duyet_send_abs)
    RadioButton rdDuyetSendAbs;

    @BindView(R.id.myRadioGroup_quatrinh_send_abs)
    RadioGroup myRadioGroupQuatrinhSendAbs;

    @BindView(R.id.txtThangDiem)
    TextView txtThangDiem;

    @BindView(R.id.btnDiem)
    Button btnDiem;
    @BindView(R.id.txtYeucau)
    TextView txtYeucau;

    @BindView(R.id.btnYeucau)
    Button btnYeucau;

    private Toolbar toolbar;
    private Intent intent;
    private Review review;
    private ArrayList<SessionTopicModel> dsSessionTopicModels;
    private ArrayList<TypeOfStudyModel> dsTypeOfStudyModels;
    private ArrayList<PresentationTypeModel> dsPresentationTypeModels;
    private ArrayList<BoardOfReview> dsBoardOfReviews;
    private ArrayList<AbstractModel> dsAbstractModels;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_abstract);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        intent = this.getIntent();
        review = (Review) intent.getSerializableExtra("object");
        setTitle(R.string.review_abstract);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// hiện nút back
        ButterKnife.bind(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
        download();
        addEvents();
        loadDataControllers();
    }

    private void loadDataControllers() {

    }

    private void addEvents() {
        btnChonchudeSeeAbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chủ đề
                dialog_choose(1, "Chọn chủ đề");
            }
        });

        btnChonLoaihinhnghiencuuSendAbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // type of study
                dialog_choose(2, "Loại hình nghiên cứu");
            }
        });

        btnChonLoaihinhtrinhbaySendAbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // loại hình trình bày
                dialog_choose(3, "Loại hình trình bày");
            }
        });

        btnDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_choose(4, "Thang điểm");
            }
        });

        btnYeucau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_choose(5, "Yêu cầu");
            }
        });
    }

    private void dialog_choose(int type, String title){
        AlertDialog.Builder mBuilder  = new AlertDialog.Builder(ReviewAbstract.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_spinner_chude, null);
        switch (type) {
            case 1:
                mBuilder.setTitle(title);
                final Spinner mSpinner = (Spinner) mView.findViewById(R.id.spinner);
                ArrayList<String> ds = new ArrayList<>();
                //arrSessionTopic
                for (int i = 0; i < dsSessionTopicModels.size(); i++) {
                    ds.add(dsSessionTopicModels.get(i).getCONFERENCE_SESSION_TOPIC_NAME());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ReviewAbstract.this, android.R.layout.simple_spinner_item,
                        ds);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mSpinner.setAdapter(adapter);

                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!mSpinner.getSelectedItem().toString().equalsIgnoreCase("Vui lòng chọn chủ đề …")) {
                            txtChudeSeeAbs.setText(mSpinner.getSelectedItem().toString());
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
                //arrSessionTopic
                for (int i = 0; i < dsTypeOfStudyModels.size(); i++) {
                    ds2.add(dsTypeOfStudyModels.get(i).getTYPE_OF_STUDY_NAME());
                }
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(ReviewAbstract.this, android.R.layout.simple_spinner_item,
                        ds2);

                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mSpinner2.setAdapter(adapter2);

                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!mSpinner2.getSelectedItem().toString().equalsIgnoreCase("Vui lòng chọn chủ đề …")) {
                            txtLoaihinhnghiencuuSeeAbs.setText(mSpinner2.getSelectedItem().toString());
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
                //arrSessionTopic
                for (int i = 0; i < dsPresentationTypeModels.size(); i++) {
                    ds3.add(dsPresentationTypeModels.get(i).getCONFERENCE_PRESENTATION_TYPE_NAME());
                }
                ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(ReviewAbstract.this, android.R.layout.simple_spinner_item,
                        ds3);

                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mSpinner3.setAdapter(adapter3);

                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!mSpinner3.getSelectedItem().toString().equalsIgnoreCase("Vui lòng chọn chủ đề …")) {
                            txtLoaihinhtrinhbaySeeAbs.setText(mSpinner3.getSelectedItem().toString());
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
            case 4:
                mBuilder.setTitle(title);
                final Spinner mSpinner4 = (Spinner) mView.findViewById(R.id.spinner);
                ArrayList<String> ds4 = new ArrayList<>();
                ArrayList dsDiem = new ArrayList<>();
                for(int i = 0; i < dsBoardOfReviews.size(); i++){
//                    ds3.add(arrPresentationType.get(i).getCONFERENCE_PRESENTATION_TYPE_NAME());
                    for(int j = dsBoardOfReviews.get(i).getPAPER_ABSTRACT_REVIEW_RATING_SCALE_START_POINT();
                        j <= dsBoardOfReviews.get(i).getPAPER_ABSTRACT_REVIEW_RATING_SCALE_END_POINT();
                        j = j + dsBoardOfReviews.get(i).getPAPER_ABSTRACT_REVIEW_RATING_SCALE_STEP()){
                        dsDiem.add(j);
                    }
                }
                ArrayAdapter adapter4 = new ArrayAdapter(ReviewAbstract.this, android.R.layout.simple_spinner_item,
                        dsDiem);

                adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mSpinner4.setAdapter(adapter4);

//                ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(SendAbstractActivity.this, android.R.layout.simple_spinner_item,
//                        getResources().getStringArray(R.array.dsLoaihinhnghiencuu));
//                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                mSpinner3.setAdapter(adapter3);

                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Object item = mSpinner4.getSelectedItem();
                        if (item != null){
                            if(!item.toString().equalsIgnoreCase("Vui lòng chọn loại hình trình bày …")){
                                txtThangDiem.setText(mSpinner4.getSelectedItem().toString());
                            }
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
                AlertDialog dialog4 = mBuilder.create();
                dialog4.show();
                break;
            case 5:
                mBuilder.setTitle(title);
                final Spinner mSpinner5 = (Spinner) mView.findViewById(R.id.spinner);
                ArrayAdapter<String> adapter5 = new ArrayAdapter<>(ReviewAbstract.this, android.R.layout.simple_spinner_item,
                        getResources().getStringArray(R.array.yeucauReview));
                adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mSpinner5.setAdapter(adapter5);

                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(!mSpinner5.getSelectedItem().toString().equalsIgnoreCase("Vui lòng chọn loại hình trình bày …")){
                            txtYeucau.setText(mSpinner5.getSelectedItem().toString());
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
                AlertDialog dialog5 = mBuilder.create();
                dialog5.show();
                break;
        }
    }

    private void download() {
        JSONObject jsonObject = new JSONObject();
        String json = jsonObject.toString();
        JSONObject jsonObject2 = new JSONObject();
        try {
            jsonObject2.put("IdAbstract", review.getIdpaper());
            jsonObject2.put("IdPerson", review.getIdperson());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String json2 = jsonObject2.toString();

        DownloadAsyncTask.POST(this, Constants.ID_API_SESSIONTOPIC, Constants.API_SESSIONTOPIC,
                json, SessionTopicModel.class, false, ReviewAbstract.this);
        DownloadAsyncTask.POST(this, Constants.ID_API_TYPE_OF_STUDY, Constants.API_TYPE_OF_STUDY,
                json, TypeOfStudyModel.class, false, ReviewAbstract.this);
        DownloadAsyncTask.POST(this, Constants.ID_API_PRESENTATION, Constants.API_PRESENTATION,
                json, PresentationTypeModel.class, false,  ReviewAbstract.this);
        DownloadAsyncTask.POST(this, Constants.ID_API_RATINGSCALE, Constants.API_RATINGSCALE,
                json2, BoardOfReview.class, false, ReviewAbstract.this);

        JSONObject jsonObject3 = new JSONObject();
        try {
            jsonObject3.put("idPaper", review.getIdpaper());
            jsonObject3.put("statusReview", 3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String json3 = jsonObject3.toString();

        DownloadAsyncTask.POST(this, Constants.ID_API_GETITEM_ABSTRACT_FORREVIEW, Constants.API_GETITEM_ABSTRACT_FORREVIEW,
                json3, AbstractModel.class, false, ReviewAbstract.this);
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

                Log.d("txtChudeSeeAbs", txtChudeSeeAbs.getText().toString());
                Log.d("LoaihinhnghiencuuSeeAbs", txtLoaihinhnghiencuuSeeAbs.getText().toString());
                Log.d("LoaihinhtrinhbaySeeAbs", txtLoaihinhtrinhbaySeeAbs.getText().toString());
                Log.d("edNoidungSeeAbs", edNoidungSeeAbs.getText().toString());
                int selected = myRadioGroupQuatrinhSendAbs.getCheckedRadioButtonId();
                View radioButton = myRadioGroupQuatrinhSendAbs.findViewById(selected);
                int idx = myRadioGroupQuatrinhSendAbs.indexOfChild(radioButton);
                if(idx == 0){
                    Log.d("trangthai", "từ chối");
                }else{
                    Log.d("trangthai", "duyệt");
                }
                Log.d("txtThangDiem", txtThangDiem.getText().toString());
                Log.d("txtYeucau", txtYeucau.getText().toString());
                if(txtChudeSeeAbs.getText().toString().equals("") ||
                        txtLoaihinhnghiencuuSeeAbs.getText().toString().equals("") ||
                        txtThangDiem.getText().toString().equals("")
                        ){
                    Toast.makeText(this, "Dữ liệu chưa nhập đầy đủ", Toast.LENGTH_LONG).show();
                }else{
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("PERSON_ID", review.getIdperson());
                        jsonObject.put("CONFERENCE_BOARD_OF_REVIEW_ID", dsBoardOfReviews.get(0).getCONFERENCE_BOARD_OF_REVIEW_ID());
                        jsonObject.put("CONFERENCE_ID", dsBoardOfReviews.get(0).getCONFERENCE_ID());
                        jsonObject.put("PAPER_ID", review.getIdpaper());
                        if(dsSessionTopicModels != null && dsSessionTopicModels.size() > 0 ) {
                            for (int i = 0; i < dsSessionTopicModels.size(); i++) {
                                if (txtChudeSeeAbs.getText().equals(dsSessionTopicModels.get(i).getCONFERENCE_SESSION_TOPIC_NAME())) {
                                    jsonObject.put("PROPOSED_CONFERENCE_SESSION_TOPIC_ID", dsSessionTopicModels.get(i).getCONFERENCE_SESSION_TOPIC_ID());
                                    jsonObject.put("PROPOSED_CONFERENCE_SESSION_TOPIC_NAME", dsSessionTopicModels.get(i).getCONFERENCE_SESSION_TOPIC_NAME());
                                    jsonObject.put("PROPOSED_CONFERENCE_SESSION_TOPIC_NAME_EN", dsSessionTopicModels.get(i).getCONFERENCE_SESSION_TOPIC_NAME_EN());
                                    break;
                                }else{
                                    jsonObject.put("PROPOSED_CONFERENCE_SESSION_TOPIC_ID", JSONObject.NULL);
                                    jsonObject.put("PROPOSED_CONFERENCE_SESSION_TOPIC_NAME", JSONObject.NULL);
                                    jsonObject.put("PROPOSED_CONFERENCE_SESSION_TOPIC_NAME_EN", JSONObject.NULL);
                                }
                            }
                        }else{
                            jsonObject.put("PROPOSED_CONFERENCE_SESSION_TOPIC_ID", JSONObject.NULL);
                            jsonObject.put("PROPOSED_CONFERENCE_SESSION_TOPIC_NAME", JSONObject.NULL);
                            jsonObject.put("PROPOSED_CONFERENCE_SESSION_TOPIC_NAME_EN", JSONObject.NULL);
                        }


                        if(dsTypeOfStudyModels != null && dsTypeOfStudyModels.size() > 0){
                            for(int i = 0; i< dsTypeOfStudyModels.size(); i++){
                                if(txtLoaihinhnghiencuuSeeAbs.getText().equals(dsTypeOfStudyModels.get(i).getTYPE_OF_STUDY_NAME())){
                                    jsonObject.put("PROPOSED_TYPE_OF_STUDY_ID", dsTypeOfStudyModels.get(i).getTYPE_OF_STUDY_ID());
                                    jsonObject.put("PROPOSED_TYPE_OF_STUDY_NAME", dsTypeOfStudyModels.get(i).getTYPE_OF_STUDY_NAME());
                                    jsonObject.put("PROPOSED_TYPE_OF_STUDY_NAME_EN", dsTypeOfStudyModels.get(i).getTYPE_OF_STUDY_NAME_EN());
                                    break;
                                }else{
                                    jsonObject.put("PROPOSED_TYPE_OF_STUDY_ID", JSONObject.NULL);
                                    jsonObject.put("PROPOSED_TYPE_OF_STUDY_NAME", JSONObject.NULL);
                                    jsonObject.put("PROPOSED_TYPE_OF_STUDY_NAME_EN", JSONObject.NULL);
                                }
                            }
                        }else{
                            jsonObject.put("PROPOSED_TYPE_OF_STUDY_ID", JSONObject.NULL);
                            jsonObject.put("PROPOSED_TYPE_OF_STUDY_NAME", JSONObject.NULL);
                            jsonObject.put("PROPOSED_TYPE_OF_STUDY_NAME_EN", JSONObject.NULL);
                        }

                        jsonObject.put("PROPOSED_FOR_PRESENTATION", true);
//                        jsonObject.put("PROPOSED_CONFERENCE_PRESENTATION_TYPE_ID",);
//                        jsonObject.put("PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME", txtLoaihinhtrinhbaySeeAbs.getText().toString());
//                        jsonObject.put("PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME_EN",);
                        if(dsPresentationTypeModels != null && dsPresentationTypeModels.size() > 0){
                            for (int i = 0; i < dsPresentationTypeModels.size() ; i++){
                                if(txtLoaihinhtrinhbaySeeAbs.getText().equals(dsPresentationTypeModels.get(i).getCONFERENCE_PRESENTATION_TYPE_NAME())){
                                    jsonObject.put("PROPOSED_CONFERENCE_PRESENTATION_TYPE_ID", dsPresentationTypeModels.get(i).getCONFERENCE_PRESENTATION_TYPE_ID());
                                    jsonObject.put("PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME", dsPresentationTypeModels.get(i).getCONFERENCE_PRESENTATION_TYPE_NAME());
                                    jsonObject.put("PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME_EN", dsPresentationTypeModels.get(i).getCONFERENCE_PRESENTATION_TYPE_NAME_EN());
                                    break;
                                }else{
                                    jsonObject.put("PROPOSED_CONFERENCE_PRESENTATION_TYPE_ID", JSONObject.NULL);
                                    jsonObject.put("PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME", JSONObject.NULL);
                                    jsonObject.put("PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME_EN", JSONObject.NULL);
                                }
                            }
                        }else{
                            jsonObject.put("PROPOSED_CONFERENCE_PRESENTATION_TYPE_ID", JSONObject.NULL);
                            jsonObject.put("PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME", JSONObject.NULL);
                            jsonObject.put("PROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME_EN", JSONObject.NULL);
                        }


                        jsonObject.put("PAPER_ABSTRACT_REVIEW_RATING_POINT", txtThangDiem.getText().toString());
                        jsonObject.put("SIGNIFICANT_REVISION_OR_MINIMAL_REVISION_OR_REVISION_NEEDED_OR_NO_REVISION_NEEDED", txtYeucau.getText().toString());
                        jsonObject.put("REVIEW_TEXT", edNoidungSeeAbs.getText().toString());
                        jsonObject.put("REVIEW_TEXT_EN","");
                        jsonObject.put("APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT", (idx==0) ? false : true);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String json = jsonObject.toString();
                    DownloadAsyncTask.POST(this, Constants.ID_API_REVIEW_ABSTRACT, Constants.API_REVIEW_ABSTRACT,
                            json, ResultBoolean.class, false, ReviewAbstract.this);


                }


                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        if(processId == Constants.ID_API_SESSIONTOPIC){
            dsSessionTopicModels = new ArrayList<>();
            dsSessionTopicModels = (ArrayList<SessionTopicModel>) data;
        }else if(processId == Constants.ID_API_TYPE_OF_STUDY){
            dsTypeOfStudyModels = new ArrayList<>();
            dsTypeOfStudyModels = (ArrayList<TypeOfStudyModel>) data;
        }else if(processId == Constants.ID_API_PRESENTATION){
            dsPresentationTypeModels = new ArrayList<>();
            dsPresentationTypeModels = (ArrayList<PresentationTypeModel>) data;
        }else if(processId == Constants.ID_API_RATINGSCALE){
            dsBoardOfReviews = new ArrayList<>();
            dsBoardOfReviews = (ArrayList<BoardOfReview>) data;
        }else if(processId == Constants.ID_API_GETITEM_ABSTRACT_FORREVIEW){
            dsAbstractModels = new ArrayList<>();
            dsAbstractModels = (ArrayList<AbstractModel>) data;
            if(dsAbstractModels.isEmpty()){
                new AlertDialog.Builder(this)
                        .setTitle("Thông báo")
                        .setMessage("Bài báo này đã hết hạn")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                setResult(Activity.RESULT_OK, intent);
                                finish();

                            }})
                        .show();
            }else{
                txtChudeSeeAbs.setText(dsAbstractModels.get(0).getCONFERENCE_SESSION_TOPIC_NAME());
                txtLoaihinhnghiencuuSeeAbs.setText(dsAbstractModels.get(0).getTYPE_OF_STUDY_NAME());
                txtLoaihinhtrinhbaySeeAbs.setText(dsAbstractModels.get(0).getCONFERENCE_PRESENTATION_TYPE_NAME());
            }

        }else if(processId == Constants.ID_API_REVIEW_ABSTRACT){
            ResultBoolean ds = (ResultBoolean) data;
            if(ds.result == true){
                JSONObject jsonObject = new JSONObject();
                try {
                    int selected = myRadioGroupQuatrinhSendAbs.getCheckedRadioButtonId();
                    View radioButton = myRadioGroupQuatrinhSendAbs.findViewById(selected);
                    int idx = myRadioGroupQuatrinhSendAbs.indexOfChild(radioButton);

                    jsonObject.put("PAPER_ID", review.getIdpaper());
                    jsonObject.put("APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT", (idx == 0)? false: true);
                    jsonObject.put("PERSON_ID", review.getIdperson());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String json = jsonObject.toString();
                Toast.makeText(this, "Lưu review", Toast.LENGTH_LONG).show();
                DownloadAsyncTask.POST(this, Constants.ID_API_UPDATE_REVIEW_ABSTRACT, Constants.API_UPDATE_REVIEW_ABSTRACT,
                        json, ResultBoolean.class, false, ReviewAbstract.this);
            }else{
                new AlertDialog.Builder(this)
                        .setTitle("Thông báo")
                        .setMessage("Server không lưu được đánh giá")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                setResult(Activity.RESULT_OK, intent);
                                finish();
                            }})
                        .show();
            }



        }else if(processId == Constants.ID_API_UPDATE_REVIEW_ABSTRACT){
            ResultBoolean ds1 = (ResultBoolean) data;
            if(ds1.result == true){
                new AlertDialog.Builder(this)
                        .setTitle("Thông báo")
                        .setMessage("Lưu thành công đánh giá")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                setResult(Activity.RESULT_OK, intent);
                                finish();

                            }})
                        .show();
            }else{
                Toast.makeText(this, "Không thay đổi được trạng thái bài abstract", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        if(processId == Constants.ID_API_REVIEW_ABSTRACT){
            Toast.makeText(this, "lỗi", Toast.LENGTH_LONG).show();
        }
    }
}
