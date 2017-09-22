package cse.duytan.coms.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cse.duytan.coms.R;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.models.AbstractModel;
import cse.duytan.coms.models.BoardOfReview;
import cse.duytan.coms.models.InfoReviewer;
import cse.duytan.coms.models.ReviewAbstractModel;
import cse.duytan.coms.untils.Constants;

public class SeeReviewActivity extends AppCompatActivity implements DownloadCallback {
    private Toolbar toolbar;
    private Intent intent;
    private AbstractModel abstractModel = null;
    private ArrayList<BoardOfReview> arrBoardOfReview = null;
    private TextView txtStatus, txtTenhoinghi_see_review, txtFromdayToday_see_review,
            txtTenbaitomtat_see_review, txtNgaydanhgia_see_review, txtNguoidanhgia_see_review,
            txtLoaihinhnghiencuu_see_review, txtThangdiem_see_review,
            txtYeucau_see_review, txtReview_see_review, txtReview_see_session_topic, txtReview_see_presentation;
    private ImageView img_see_review;
    private String format_fromday = "", format_thurday = "", format_review = "";
    private Date date_fromday = null, date_thurday = null, date_review = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_review);//activity_see_review
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        intent = this.getIntent();
        String type = intent.getStringExtra("type");
        String status = intent.getStringExtra("status");
        abstractModel = (AbstractModel) intent.getSerializableExtra("object");

        if(type.equals("1")){
            setTitle(R.string.title_see_review_abstract);

            JSONObject jsonObject2 = new JSONObject();
            try{
                jsonObject2.put("IdAbstract", abstractModel.getPAPER_ID());
                jsonObject2.put("IdPerson", abstractModel.getPERSON_ID());
            } catch (Exception e) {
                e.printStackTrace();
            }
            String json2 = jsonObject2.toString();
            DownloadAsyncTask.POST(this, Constants.ID_API_BOARDOFREVIEW, Constants.API_BOARDOFREVIEW, json2,
                    BoardOfReview.class, true, SeeReviewActivity.this);

        }else {
            setTitle(R.string.title_see_review_paper);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// hiện nút back

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        addControllers();
        addEvents();
        if(status.equals("01") || status.endsWith("02")){// từ chối
            txtStatus.setText("Từ chối");
            txtStatus.setBackgroundResource(R.drawable.shape_red);
            txtStatus.setTextColor(Color.RED);
        }else{
            txtStatus.setText("Đã duyệt");
            txtStatus.setBackgroundResource(R.drawable.shape_green);
            txtStatus.setTextColor(Color.GREEN);
        }
    }

    private void addControllers(){
        txtStatus = (TextView) findViewById(R.id.txtStatus_see_review);
        txtTenhoinghi_see_review = (TextView) findViewById(R.id.txtTenhoinghi_see_review);
        txtFromdayToday_see_review = (TextView) findViewById(R.id.txtFromdayToday_see_review);
        txtTenbaitomtat_see_review = (TextView) findViewById(R.id.txtTenbaitomtat_see_review);
        txtNgaydanhgia_see_review = (TextView) findViewById(R.id.txtNgaydanhgia_see_review);
        txtNguoidanhgia_see_review = (TextView) findViewById(R.id.txtNguoidanhgia_see_review);
        txtLoaihinhnghiencuu_see_review = (TextView) findViewById(R.id.txtLoaihinhnghiencuu_see_review);
        txtThangdiem_see_review = (TextView) findViewById(R.id.txtThangdiem_see_review);
        txtYeucau_see_review = (TextView) findViewById(R.id.txtYeucau_see_review);
        txtReview_see_review = (TextView) findViewById(R.id.txtReview_see_review);
        img_see_review = (ImageView) findViewById(R.id.img_see_review);
        txtReview_see_session_topic = (TextView) findViewById(R.id.txtReview_see_session_topic);
        txtReview_see_presentation = (TextView) findViewById(R.id.txtReview_see_presentation);
    }

    private void addEvents(){
        txtTenhoinghi_see_review.setText(abstractModel.getCONFERENCE_NAME());

        try {
            date_fromday = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(abstractModel.getFROM_DATE() + "");
            date_thurday = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(abstractModel.getTHRU_DATE() + "");

            format_fromday = new SimpleDateFormat("dd/MM/yyyy").format(date_fromday);
            format_thurday = new SimpleDateFormat("dd/MM/yyyy").format(date_thurday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        txtFromdayToday_see_review.setText("Bắt đầu:" + format_fromday+" - " + format_thurday);
        txtTenbaitomtat_see_review.setText("Tên: " + abstractModel.getPAPER_ABSTRACT_TITLE());

    }



    @Override
    public void downloadSuccess(int processId, Object data) {
        if(processId == Constants.ID_API_SEE_REVIEW){
            ArrayList<ReviewAbstractModel> ds = new ArrayList<>();
            ds = (ArrayList<ReviewAbstractModel>) data;
            if(ds.isEmpty()){
                new AlertDialog.Builder(this)
                        .setTitle("Thông báo")
                        .setMessage("Bài báo chưa được đánh giá?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                finish();

                            }})
                        .show();
            }else{
                try {
                    date_review = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(ds.get(0).getAPPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT_DATE());
                    format_review = new SimpleDateFormat("dd/MM/yyyy").format(date_review);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("Id", abstractModel.getPERSON_ID());// id person
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String json = jsonObject.toString();
                DownloadAsyncTask.POST(this, Constants.ID_API_INFOMATION_REVIEWER, Constants.API_INFOMATION_REVIEWER,
                        json, InfoReviewer.class, true, this);
                txtNgaydanhgia_see_review.setText(format_review);

                txtLoaihinhnghiencuu_see_review.setText(ds.get(0).getPROPOSED_TYPE_OF_STUDY_NAME());
                txtThangdiem_see_review.setText(ds.get(0).getPAPER_ABSTRACT_REVIEW_RATING_POINT());
                txtYeucau_see_review.setText(ds.get(0).getSIGNIFICANT_REVISION_OR_MINIMAL_REVISION_OR_REVISION_NEEDED_OR_NO_REVISION_NEEDED());
                txtReview_see_review.setText(ds.get(0).getREVIEW_TEXT());
                txtReview_see_session_topic.setText(ds.get(0).getPROPOSED_CONFERENCE_SESSION_TOPIC_NAME());
                txtReview_see_presentation.setText(ds.get(0).getPROPOSED_CONFERENCE_PRESENTATION_TYPE_NAME());
            }
        }else if(processId == Constants.ID_API_BOARDOFREVIEW){
            ArrayList<BoardOfReview> ds = new ArrayList<>();
            ds = (ArrayList<BoardOfReview>) data;
            arrBoardOfReview = new ArrayList<>();

            for(int i = 0; i< ds.size(); i++){
                arrBoardOfReview.add(new BoardOfReview(
                        ds.get(i).getCONFERENCE_BOARD_OF_REVIEW_ID(),
                        ds.get(i).getCONFERENCE_ID(),
                        ds.get(i).getPAPER_ABSTRACT_REVIEW_DEADLINE_1(),
                        ds.get(i).getPAPER_ABSTRACT_REVIEW_DEADLINE_2(),
                        ds.get(i).getPAPER_ABSTRACT_REVIEW_RATING_SCALE_STEP(),
                        ds.get(i).getPAPER_ABSTRACT_REVIEW_RATING_SCALE_START_POINT(),
                        ds.get(i).getPAPER_ABSTRACT_REVIEW_RATING_SCALE_END_POINT()
                ));
            }

            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("PERSON_ID",abstractModel.getPERSON_ID());
                jsonObject.put("CONFERENCE_BOARD_OF_REVIEW_ID", intent.getIntExtra("CONFERENCE_BOARD_OF_REVIEW_ID",1));
                jsonObject.put("CONFERENCE_ID", intent.getIntExtra("CONFERENCE_ID",1));
                jsonObject.put("PAPER_ID", abstractModel.getPAPER_ID());
                jsonObject.put("APPROVED", intent.getBooleanExtra("APPROVED", false));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String json = jsonObject.toString();
            DownloadAsyncTask.POST(this, Constants.ID_API_SEE_REVIEW, Constants.API_SEE_REVIEW, json,
                    ReviewAbstractModel.class, true, SeeReviewActivity.this);
        }else if(processId == Constants.ID_API_INFOMATION_REVIEWER){
            ArrayList<InfoReviewer> ds = new ArrayList<>();
            ds = (ArrayList<InfoReviewer>) data;
            for (int i = 0; i< ds.size(); i++){
                txtNguoidanhgia_see_review.setText(ds.get(i).getCURRENT_MIDDLE_NAME() + " " + ds.get(i).getCURRENT_LAST_NAME()
                + " " + ds.get(i).getCURRENT_FIRST_NAME());
            }
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        if(processId == Constants.ID_API_SEE_REVIEW){
            Toast.makeText(this, "huhu", Toast.LENGTH_LONG).show();
        }
    }

}
