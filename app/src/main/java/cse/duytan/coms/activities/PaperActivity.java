package cse.duytan.coms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cse.duytan.coms.R;
import cse.duytan.coms.customviews.CustomTextView;
import cse.duytan.coms.dialogs.ConfirmDialog;
import cse.duytan.coms.models.PaperAbstract;
import cse.duytan.coms.models.PaperText;
import cse.duytan.coms.presenters.ListAbstractPresenter;
import cse.duytan.coms.untils.DateTimeFormater;
import cse.duytan.coms.views.ListAbstractView;

public class PaperActivity extends AppCompatActivity implements ListAbstractView{

    @BindView(R.id.imgCheckInPaperText) ImageView imgCheckInPaperText;
    @BindView(R.id.tvPaperTextDate)
    CustomTextView tvPaperTextDate;
    @BindView(R.id.tvPaperTextNote)
    CustomTextView tvPaperTextNote;
    @BindView(R.id.imgCheckInFinalOrRejection) ImageView imgCheckInFinalOrRejection;
    @BindView(R.id.tvFinalOrRejectionDate)
    CustomTextView tvFinalOrRejectionDate;
    @BindView(R.id.tvFinalTopic)
    CustomTextView tvFinalTopic;
    @BindView(R.id.tvFinalTypeOfStudy)
    CustomTextView tvFinalTypeOfStudy;
    @BindView(R.id.tvReviewrName)
    CustomTextView tvReviewrName;
    @BindView(R.id.tvPresenterName)
    CustomTextView tvPresenterName;
    @BindView(R.id.tvTotalText) TextView tvTotalText;
    @BindView(R.id.tvTotalAbstract) TextView tvTotalAbstract;
    @BindView(R.id.tvTitlePaperText1)
    CustomTextView tvTitlePaperText1;
    @BindView(R.id.tvNumberOfPages1)
    CustomTextView tvNumberOfPages1;
    @BindView(R.id.tvFirstSubmittedDate1)
    CustomTextView tvFirstSubmittedDate1;
    @BindView(R.id.tvLastRevisedDate1)
    CustomTextView tvLastRevisedDate1;
    @BindView(R.id.imgDownload1) ImageView imgDownload1;
    @BindView(R.id.tvTitlePaperText2)
    CustomTextView tvTitlePaperText2;
    @BindView(R.id.tvNumberOfPages2)
    CustomTextView tvNumberOfPages2;
    @BindView(R.id.tvFirstSubmittedDate2)
    CustomTextView tvFirstSubmittedDate2;
    @BindView(R.id.tvLastRevisedDate2)
    CustomTextView tvLastRevisedDate2;
    @BindView(R.id.imgDownload2) ImageView imgDownload2;
    @BindView(R.id.tvTitlePaperText3)
    CustomTextView tvTitlePaperText3;
    @BindView(R.id.tvNumberOfPages3)
    CustomTextView tvNumberOfPages3;
    @BindView(R.id.tvFirstSubmittedDate3)
    CustomTextView tvFirstSubmittedDate3;
    @BindView(R.id.tvLastRevisedDate3)
    CustomTextView tvLastRevisedDate3;
    @BindView(R.id.imgDownload3) ImageView imgDownload3;
    @BindView(R.id.tvTitlePaperText4)
    CustomTextView tvTitlePaperText4;
    @BindView(R.id.tvNumberOfPages4)
    CustomTextView tvNumberOfPages4;
    @BindView(R.id.tvFirstSubmittedDate4)
    CustomTextView tvFirstSubmittedDate4;
    @BindView(R.id.tvLastRevisedDate4)
    CustomTextView tvLastRevisedDate4;
    @BindView(R.id.imgDownload4) ImageView imgDownload4;
    @BindView(R.id.tvTitlePaperText5)
    CustomTextView tvTitlePaperText5;@BindView(R.id.tvNumberOfPages5)
    CustomTextView tvNumberOfPages5;
    @BindView(R.id.tvFirstSubmittedDate5)
    CustomTextView tvFirstSubmittedDate5;
    @BindView(R.id.tvLastRevisedDate5)
    CustomTextView tvLastRevisedDate5;
    @BindView(R.id.imgDownload5) ImageView imgDownload5;
    @BindView(R.id.llPaperText1) LinearLayout llPaperText1;
    @BindView(R.id.llPaperText2) LinearLayout llPaperText2;
    @BindView(R.id.llPaperText3) LinearLayout llPaperText3;
    @BindView(R.id.llPaperText4) LinearLayout llPaperText4;
    @BindView(R.id.llPaperText5) LinearLayout llPaperText5;
    @BindView(R.id.tvTitlePaperAbstrac6)
    CustomTextView tvTitlePaperAbstrac6;
    @BindView(R.id.tvWordCount6)
    CustomTextView tvWordCount6;
    @BindView(R.id.tvFirstSubmittedDate6)
    CustomTextView tvFirstSubmittedDate6;
    @BindView(R.id.tvLastRevisedDate6)
    CustomTextView tvLastRevisedDate6;
    @BindView(R.id.imgDownload6) ImageView imgDownload6;
    @BindView(R.id.llPaperAbstract6) LinearLayout llPaperAbstract6;
    @BindView(R.id.tvTitlePaperAbstract7)
    CustomTextView tvTitlePaperAbstract7;
    @BindView(R.id.tvWordCount7)
    CustomTextView tvWordCount7;
    @BindView(R.id.tvFirstSubmittedDate7)
    CustomTextView tvFirstSubmittedDate7;
    @BindView(R.id.tvLastRevisedDate7)
    CustomTextView tvLastRevisedDate7;
    @BindView(R.id.imgDownload7) ImageView imgDownload7;
    @BindView(R.id.llPaperAbstract7) LinearLayout llPaperAbstract7;
    @BindView(R.id.tvTitlePaperAbstrac8)
    CustomTextView tvTitlePaperAbstrac8;
    @BindView(R.id.tvWordCount8)
    CustomTextView tvWordCount8;
    @BindView(R.id.tvFirstSubmittedDate8)
    CustomTextView tvFirstSubmittedDate8;
    @BindView(R.id.tvLastRevisedDate8)
    CustomTextView tvLastRevisedDate8;
    @BindView(R.id.imgDownload8) ImageView imgDownload8;
    @BindView(R.id.llPaperAbstract8) LinearLayout llPaperAbstract8;
    @BindView(R.id.tvTitlePaperAbstrac9)
    CustomTextView tvTitlePaperAbstrac9;
    @BindView(R.id.tvWordCount9)
    CustomTextView tvWordCount9;
    @BindView(R.id.tvFirstSubmittedDate9)
    CustomTextView tvFirstSubmittedDate9;
    @BindView(R.id.tvLastRevisedDate9)
    CustomTextView tvLastRevisedDate9;
    @BindView(R.id.imgDownload9) ImageView imgDownload9;
    @BindView(R.id.llPaperAbstract9) LinearLayout llPaperAbstract9;
    @BindView(R.id.tvTitlePaperAbstrac10)
    CustomTextView tvTitlePaperAbstrac10;
    @BindView(R.id.tvWordCount10)
    CustomTextView tvWordCount10;
    @BindView(R.id.tvFirstSubmittedDate10)
    CustomTextView tvFirstSubmittedDate10;
    @BindView(R.id.tvLastRevisedDate10)
    CustomTextView tvLastRevisedDate10;
    @BindView(R.id.imgDownload10) ImageView imgDownload10;
    @BindView(R.id.llPaperAbstract10) LinearLayout llPaperAbstract10;

    private PaperText paperText = new PaperText();
    private PaperAbstract paperAbstract = new PaperAbstract();
    private ArrayList<PaperAbstract> listData;
    private ListAbstractPresenter listAbstractPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        initUI();
        getMyIntent();
    }

    private void initUI() {
        listData = new ArrayList<>();
        listAbstractPresenter = new ListAbstractPresenter(this, this);

        Log.i("", "initUI: "+listData.size());

    }

    private void getMyIntent() {
        Intent i = getIntent();
        if (i != null) {
            String json = i.getStringExtra("dataSession");
            paperText = new Gson().fromJson(json, PaperText.class);

            listAbstractPresenter.getListAbstract(paperText.paperId);

            tvPaperTextDate.setText(DateTimeFormater.stringToTime(paperText.getPaperTextWithdrawnDate(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
            tvPaperTextNote.setText(paperText.getPaperTextWithdrawnNote());
            tvFinalOrRejectionDate.setText(DateTimeFormater.stringToTime(paperText.getFinalApprovalOrRejectionOfPaperTextDate(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
            tvFinalTopic.setText(paperText.getFinalAssignedConfenceSessionTopicName());
            tvFinalTypeOfStudy.setText(paperText.getFinalApprovedTypeOfStudyName());
            tvReviewrName.setText(paperText.getCurrentFullName());
            tvPresenterName.setText("");

            if(paperText.getPaperTextTitle5() != null){
                tvTotalText.setText("5");
            } else if(paperText.getPaperTextTitle4() != null){
                tvTotalText.setText("4");
            } else if(paperText.getPaperTextTitle3() != null){
                tvTotalText.setText("3");
            } else if(paperText.getPaperTextTitle2() != null){
                tvTotalText.setText("2");
            } else if(paperText.getPaperTextTitle1() != null){
                tvTotalText.setText("1");
            }

            if (paperText.getPaperTextTitle1() != null) {
                llPaperText1.setVisibility(View.VISIBLE);

                tvTitlePaperText1.setText(paperText.getPaperTextTitle1());
                tvNumberOfPages1.setText(String.valueOf(paperText.getNumberOfPagesOfPaperText1()));
                tvFirstSubmittedDate1.setText(DateTimeFormater.stringToTime(paperText.getFirstSubmittedDate1(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
                tvLastRevisedDate1.setText(DateTimeFormater.stringToTime(paperText.getLastRevisedDate1(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
            } else {
                llPaperText1.setVisibility(View.GONE);
            }

            if (paperText.getPaperTextTitle2() != null) {
                llPaperText2.setVisibility(View.VISIBLE);

                tvTitlePaperText2.setText(paperText.getPaperTextTitle2());
                tvNumberOfPages2.setText(String.valueOf(paperText.getNumberOfPagesOfPaperText2()));
                tvFirstSubmittedDate2.setText(DateTimeFormater.stringToTime(paperText.getFirstSubmittedDate2(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
                tvLastRevisedDate2.setText(DateTimeFormater.stringToTime(paperText.getLastRevisedDate2(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
            } else {
                llPaperText2.setVisibility(View.GONE);
            }

            if (paperText.getPaperTextTitle3() != null) {
                llPaperText3.setVisibility(View.VISIBLE);

                tvTitlePaperText3.setText(paperText.getPaperTextTitle3());
                tvNumberOfPages3.setText(String.valueOf(paperText.getNumberOfPagesOfPaperText3()));
                tvFirstSubmittedDate3.setText(DateTimeFormater.stringToTime(paperText.getFirstSubmittedDate3(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
                tvLastRevisedDate3.setText(DateTimeFormater.stringToTime(paperText.getLastRevisedDate3(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
            } else {
                llPaperText3.setVisibility(View.GONE);
            }

            if (paperText.getPaperTextTitle4() != null) {
                llPaperText4.setVisibility(View.VISIBLE);

                tvTitlePaperText4.setText(paperText.getPaperTextTitle4());
                tvNumberOfPages4.setText(String.valueOf(paperText.getNumberOfPagesOfPaperText4()));
                tvFirstSubmittedDate4.setText(DateTimeFormater.stringToTime(paperText.getFirstSubmittedDate4(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
                tvLastRevisedDate4.setText(DateTimeFormater.stringToTime(paperText.getLastRevisedDate4(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
            } else {
                llPaperText4.setVisibility(View.GONE);
            }

            if (paperText.getPaperTextTitle5() != null) {
                llPaperText5.setVisibility(View.VISIBLE);

                tvTitlePaperText5.setText(paperText.getPaperTextTitle5());
                tvNumberOfPages5.setText(String.valueOf(paperText.getNumberOfPagesOfPaperText5()));
                tvFirstSubmittedDate5.setText(DateTimeFormater.stringToTime(paperText.getFirstSubmittedDate5(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
                tvLastRevisedDate5.setText(DateTimeFormater.stringToTime(paperText.getLastRevisedDate5(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
            } else {
                llPaperText5.setVisibility(View.GONE);
            }
        }
    }

    private void setUpAbstract() {
        if(paperAbstract.getPAPER_ABSTRACT_TEXT_5() != null){
            tvTotalAbstract.setText("5");
        } else if(paperAbstract.getPAPER_ABSTRACT_TEXT_4() != null){
            tvTotalAbstract.setText("4");
        } else if(paperAbstract.getPAPER_ABSTRACT_TEXT_3() != null){
            tvTotalAbstract.setText("3");
        } else if(paperAbstract.getPAPER_ABSTRACT_TEXT_2() != null){
            tvTotalAbstract.setText("2");
        } else if(paperAbstract.getPAPER_ABSTRACT_TEXT_1() != null){
            tvTotalAbstract.setText("1");
        }

        if(paperAbstract.getPAPER_ABSTRACT_TEXT_1() != null){
            llPaperAbstract6.setVisibility(View.VISIBLE);

            tvTitlePaperAbstrac6.setText(paperAbstract.getPAPER_ABSTRACT_TEXT_1());
            tvWordCount6.setText(paperAbstract.getWORD_COUNT_OF_PAPER_ABSTRACT_1());
            tvFirstSubmittedDate6.setText(DateTimeFormater.stringToTime(paperAbstract.getFIRST_SUBMITTED_DATE_1(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
            tvLastRevisedDate6.setText(DateTimeFormater.stringToTime(paperAbstract.getLAST_REVISED_DATE_1(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
        }else {
            llPaperAbstract6.setVisibility(View.GONE);
        }

        if(paperAbstract.getPAPER_ABSTRACT_TEXT_2() != null){
            llPaperAbstract7.setVisibility(View.VISIBLE);

            tvTitlePaperAbstract7.setText(paperAbstract.getPAPER_ABSTRACT_TEXT_2());
            tvWordCount7.setText(paperAbstract.getWORD_COUNT_OF_PAPER_ABSTRACT_2());
            tvFirstSubmittedDate7.setText(DateTimeFormater.stringToTime(paperAbstract.getFIRST_SUBMITTED_DATE_2(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
            tvLastRevisedDate7.setText(DateTimeFormater.stringToTime(paperAbstract.getLAST_REVISED_DATE_2(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
        }else {
            llPaperAbstract7.setVisibility(View.GONE);
        }

        if(paperAbstract.getPAPER_ABSTRACT_TEXT_3() != null){
            llPaperAbstract8.setVisibility(View.VISIBLE);

            tvTitlePaperAbstrac8.setText(paperAbstract.getPAPER_ABSTRACT_TEXT_3());
            tvWordCount8.setText(paperAbstract.getWORD_COUNT_OF_PAPER_ABSTRACT_3());
            tvFirstSubmittedDate8.setText(DateTimeFormater.stringToTime(paperAbstract.getFIRST_SUBMITTED_DATE_3(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
            tvLastRevisedDate8.setText(DateTimeFormater.stringToTime(paperAbstract.getLAST_REVISED_DATE_3(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
        }else {
            llPaperAbstract8.setVisibility(View.GONE);
        }

        if(paperAbstract.getPAPER_ABSTRACT_TEXT_4() != null){
            llPaperAbstract9.setVisibility(View.VISIBLE);

            tvTitlePaperAbstrac9.setText(paperAbstract.getPAPER_ABSTRACT_TEXT_4());
            tvWordCount9.setText(paperAbstract.getWORD_COUNT_OF_PAPER_ABSTRACT_4());
            tvFirstSubmittedDate9.setText(DateTimeFormater.stringToTime(paperAbstract.getFIRST_SUBMITTED_DATE_4(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
            tvLastRevisedDate9.setText(DateTimeFormater.stringToTime(paperAbstract.getLAST_REVISED_DATE_4(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
        }else {
            llPaperAbstract9.setVisibility(View.GONE);
        }

        if(paperAbstract.getPAPER_ABSTRACT_TEXT_5() != null){
            llPaperAbstract10.setVisibility(View.VISIBLE);

            tvTitlePaperAbstrac10.setText(paperAbstract.getPAPER_ABSTRACT_TEXT_5());
            tvWordCount10.setText(paperAbstract.getWORD_COUNT_OF_PAPER_ABSTRACT_5());
            tvFirstSubmittedDate10.setText(DateTimeFormater.stringToTime(paperAbstract.getFIRST_SUBMITTED_DATE_5(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
            tvLastRevisedDate10.setText(DateTimeFormater.stringToTime(paperAbstract.getLAST_REVISED_DATE_5(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
        }else {
            llPaperAbstract10.setVisibility(View.GONE);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void listAbstract(ArrayList<PaperAbstract> listAbstract) {
        listData.addAll(listAbstract);
        paperAbstract = listData.get(0);
        if(paperAbstract != null){
            setUpAbstract();
        }
    }

    @Override
    public void error(String msg) {
        new ConfirmDialog(this, msg, null);
    }
}
