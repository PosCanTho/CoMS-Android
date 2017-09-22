package cse.duytan.coms.fragments;


import android.app.Activity;
import android.app.ListFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import cse.duytan.coms.R;
import cse.duytan.coms.activities.SeeReviewActivity;
import cse.duytan.coms.activities.SendAbstractActivity;
import cse.duytan.coms.activities.SendPaperActivity;
import cse.duytan.coms.activities.XemThongtinActivity;
import cse.duytan.coms.adapters.AbstractAdapter;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.dialogs.ConfirmOkDialog;
import cse.duytan.coms.models.AbstractModel;
import cse.duytan.coms.models.BoardOfReview;
import cse.duytan.coms.models.PresentationTypeModel;
import cse.duytan.coms.models.ResultBoolean;
import cse.duytan.coms.models.SessionTopicModel;
import cse.duytan.coms.models.TypeOfStudyModel;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.untils.PopupCalback;
import cse.duytan.coms.untils.Utils;

/**
 * Created by lehoangdung on 19/06/2017.
 */

public class ListAbstractFragment extends ListFragment implements View.OnClickListener, PopupCalback, Constants, DownloadCallback {
    private ListView listView;
    private ArrayList<AbstractModel> arrAbstract;
    private ArrayList<SessionTopicModel> arrSessionTopic;
    private ArrayList<TypeOfStudyModel> arrTypeOfStudy;
    private ArrayList<PresentationTypeModel> arrPresentationType;
    private ArrayList<BoardOfReview> arr;
    private AbstractAdapter adapter;
    private Animation animation, animation_abs;
    private LinearLayout ln, ln_func, ln_row_abstract;
    public static final int REQUEST_CODE_LISTABSTRACTFRAGMENT_GUIPAPER = 1;
    public static final int REQUEST_CODE_UPDATE_ABSTRACT = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listabstract_fragment, container, false);
        listView = (ListView) rootView.findViewById(android.R.id.list);
        loadListAbstract();
        return rootView;

    }

    private void loadListAbstract() {
        arrAbstract = new ArrayList<>();
        arrSessionTopic = new ArrayList<>();
        arrPresentationType = new ArrayList<>();
        addArrAbstract();
        loadSessionTopic();
        loadTypeOfStudy();
        loadPresentationType();
    }

    private void loadTypeOfStudy() {
        JSONObject jsonObject = new JSONObject();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DownloadAsyncTask.POST(getActivity(), Constants.ID_API_TYPE_OF_STUDY, Constants.API_TYPE_OF_STUDY,
                jsonObject.toString(), TypeOfStudyModel.class, false, this);
    }

    private void loadPresentationType() {
        JSONObject jsonObject = new JSONObject();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DownloadAsyncTask.POST(getActivity(), Constants.ID_API_PRESENTATION, Constants.API_PRESENTATION,
                jsonObject.toString(), PresentationTypeModel.class, false, this);
    }

    private void loadSessionTopic() {
        JSONObject jsonObject = new JSONObject();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DownloadAsyncTask.POST(getActivity(), Constants.ID_API_SESSIONTOPIC,
                Constants.API_SESSIONTOPIC, jsonObject.toString(), SessionTopicModel.class, false, this);
    }

    private void addArrAbstract() {
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("id", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String json = jsonObject.toString();
        DownloadAsyncTask.POST(getActivity(), Constants.ID_API_LISTABSTRACT,
                Constants.API_LISTABSTRACT, json, AbstractModel.class, false, this);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //Từ chối
        TextView txtXemDanhGia, txtXoa, txtCapnhat;// các control chức năng trên 1 dòng từ chối
        ImageView imgXemDanhGia, imgXoa, imgCapnhat;// từ chối
        //Đã duyệt
        TextView txtGuiBaocaoAbs_Daduyet, txtXemThongtinAbs_Daduyet, txtXemDanhGiaAbs_Daduyet;
        ImageView imgGuiBaocaoAbs_Daduyet, imgXemThongtinAbs_Daduyet, imgXemDanhGiaAbs_Daduyet;
        //Chờ duyệt
        TextView txtRutbaiAbs_Choduyet, txtXemThongtinAbs_Choduyet;
        ImageView imgRutbaiAbs_Choduyet, imgXemThongtinAbs_Choduyet;
        //Đoạn soạn
        TextView txtRutbaiAbs_Dangsoan, txtCapnhatAbs_Dangsoan;
        ImageView imgRutbaiAbs_Dangsoan, imgCapnhatAbs_Dangsoan;

        ln = (LinearLayout) v.findViewById(R.id.ln_list_abstract);//thông tin trên 1 dòng
        ln_func = (LinearLayout) v.findViewById(R.id.ln_listfunc_abstract);// danh sách chức năng trên 1 dòng dựa trên trạng thái => hiển thị
        ln_row_abstract = (LinearLayout) v.findViewById(R.id.row_abstract);
        // từ chối
        txtXemDanhGia = (TextView) v.findViewById(R.id.txtXemDanhGiaAbs);
        txtXoa = (TextView) v.findViewById(R.id.txtXoaAbs);
        txtCapnhat = (TextView) v.findViewById(R.id.txtCapNhatAbs);
        imgXemDanhGia = (ImageView) v.findViewById(R.id.imgXemDanhGiaAbs);
        imgXoa = (ImageView) v.findViewById(R.id.imgXoaAbs);
        imgCapnhat = (ImageView) v.findViewById(R.id.imgCapNhatAbs);

        //đã duyệt
        txtGuiBaocaoAbs_Daduyet = (TextView) v.findViewById(R.id.txtGuiBaocaoAbs_Daduyet);
        txtXemThongtinAbs_Daduyet = (TextView) v.findViewById(R.id.txtXemThongtinAbs_Daduyet);
        txtXemDanhGiaAbs_Daduyet = (TextView) v.findViewById(R.id.txtXemDanhGiaAbs_Daduyet);
        imgGuiBaocaoAbs_Daduyet = (ImageView) v.findViewById(R.id.imgGuiBaocaoAbs_Daduyet);
        imgXemThongtinAbs_Daduyet = (ImageView) v.findViewById(R.id.imgXemThongtinAbs_Daduyet);
        imgXemDanhGiaAbs_Daduyet = (ImageView) v.findViewById(R.id.imgXemDanhGiaAbs_Daduyet);

        //chờ duyệt
        txtRutbaiAbs_Choduyet = (TextView) v.findViewById(R.id.txtRutbaiAbs_Choduyet);
        txtXemThongtinAbs_Choduyet = (TextView) v.findViewById(R.id.txtXemThongtinAbs_Choduyet);
        imgRutbaiAbs_Choduyet = (ImageView) v.findViewById(R.id.imgRutbaiAbs_Choduyet);
        imgXemThongtinAbs_Choduyet = (ImageView) v.findViewById(R.id.imgXemThongtinAbs_Choduyet);

        // đang soạn
        txtRutbaiAbs_Dangsoan = (TextView) v.findViewById(R.id.txtRutbaiAbs_Dangsoan);
        txtCapnhatAbs_Dangsoan = (TextView) v.findViewById(R.id.txtCapnhatAbs_Dangsoan);
        imgRutbaiAbs_Dangsoan = (ImageView) v.findViewById(R.id.imgRutbaiAbs_Dangsoan);
        imgCapnhatAbs_Dangsoan = (ImageView) v.findViewById(R.id.imgCapnhatAbs_Dangsoan);

        int temp_showFunc = 0;
        if (ln.getVisibility() == View.GONE) {
            hideFunc();
        } else {

            for (int i = 0; i < listView.getAdapter().getCount(); i++) {
                if (position != i) {
                    Animation animation2, animation_abs2;
                    View viewrow = listView.getChildAt(i);
                    View view = listView.getAdapter().getView(i, viewrow, listView);//listView.getChildAt(i);
                    LinearLayout ln2 = (LinearLayout) view.findViewById(R.id.ln_list_abstract);
                    LinearLayout ln_func2 = (LinearLayout) view.findViewById(R.id.ln_listfunc_abstract);
                    LinearLayout ln_row_abstract2 = (LinearLayout) view.findViewById(R.id.row_abstract);

                    // rút bài=> hiện dialog, không hiển thị animation
                    AbstractModel abstractModel = (AbstractModel) listView.getItemAtPosition(i);
                    // so sánh từng deadline, xác định trạng thái từng item

                    String formatDate_Now = "";
                    Date date_deadline = null;
                    Date date_now = null;
                    Calendar currentDate = Calendar.getInstance();
                    try {
                        date_deadline = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(abstractModel.getPAPER_ABSTRACT_DEADLINE() + "");

                        formatDate_Now = DateFormat.format("yyyy-MM-dd'T'HH:mm:ss", currentDate).toString();
                        date_now = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(formatDate_Now);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    if(Boolean.TRUE.equals(abstractModel.getPAPER_ABSTRACT_WITHDRAWN()) && date_now.getTime() > date_deadline.getTime()){
                        new ConfirmOkDialog(getActivity(),"Thông báo", "Bài báo tóm tắt đã được tác giả rút", ListAbstractFragment.this).show();
                        temp_showFunc=1;
                    }else{
                        temp_showFunc = 0;
                        if (ln_func2.getVisibility() == View.VISIBLE) {
                            animation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out_left);
                            ln_func2.setVisibility(View.GONE);//ẩn danh sách chức năng
                            animation2.setDuration(400);
                            ln_func2.setAnimation(animation2);
                            ln_func2.animate().withLayer();
                            ln_row_abstract2.setBackgroundColor(Color.WHITE);

                            animation_abs2 = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right);
                            animation_abs2.setDuration(700);
                            ln2.setAnimation(animation_abs2);
                            ln2.animate().withLayer();
                            ln2.setVisibility(View.VISIBLE);// hiển dòng abstract ra
                        }
                    }
                }
            }
            if(temp_showFunc != 1){
                temp_showFunc = 0;
                showFunc();
            }

        }
        // từ chối
        txtXemDanhGia.setOnClickListener(this);
        txtXoa.setOnClickListener(this);
        txtCapnhat.setOnClickListener(this);
        imgXemDanhGia.setOnClickListener(this);
        imgXoa.setOnClickListener(this);
        imgCapnhat.setOnClickListener(this);
        //đã duyệt
        txtGuiBaocaoAbs_Daduyet.setOnClickListener(this);
        txtXemThongtinAbs_Daduyet.setOnClickListener(this);
        txtXemDanhGiaAbs_Daduyet.setOnClickListener(this);
        imgGuiBaocaoAbs_Daduyet.setOnClickListener(this);
        imgXemThongtinAbs_Daduyet.setOnClickListener(this);
        imgXemDanhGiaAbs_Daduyet.setOnClickListener(this);
        // Chờ duyệt
        txtRutbaiAbs_Choduyet.setOnClickListener(this);
        txtXemThongtinAbs_Choduyet.setOnClickListener(this);
        imgRutbaiAbs_Choduyet.setOnClickListener(this);
        imgXemThongtinAbs_Choduyet.setOnClickListener(this);
        // đang soạn
        txtRutbaiAbs_Dangsoan.setOnClickListener(this);
        txtCapnhatAbs_Dangsoan.setOnClickListener(this);
        imgRutbaiAbs_Dangsoan.setOnClickListener(this);
        imgCapnhatAbs_Dangsoan.setOnClickListener(this);

    }

    private void hideFunc() {
        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out_left);
        ln_func.setVisibility(View.GONE);//ẩn danh sách chức năng
        animation.setDuration(400);
        ln_func.setAnimation(animation);
        ln_func.animate().withLayer();
        ln_row_abstract.setBackgroundColor(Color.WHITE);

        animation_abs = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right);
        animation_abs.setDuration(700);
        ln.setAnimation(animation_abs);
        ln.animate().withLayer();
        ln.setVisibility(View.VISIBLE);// hiển dòng abstract ra
    }

    private void showFunc() {
        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right);
        ln.setVisibility(View.GONE);
        ln_func.setVisibility(View.VISIBLE);
        animation.setDuration(500);
        ln_func.setAnimation(animation);
        ln_func.animate().withLayer();
    }



    @Override
    public void onClick(View view) {
        ListView lv = getListView();
        int position = lv.getPositionForView(view);
        final AbstractModel item = (AbstractModel) listView.getAdapter().getItem(position);

        // định dạng datetime
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");// so sán=> xuất trạng thái
                /*format datetime xuất deadline*/
        String formattedDate = "", formatDate_Deadline = "", formatDate_Now = "";
        Date date_deadline = null;
        Date date_submit = null;
        Date date_now = null;
        Calendar currentDate = Calendar.getInstance();
        try {
            date_deadline = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(item.getPAPER_ABSTRACT_DEADLINE() + "");
            date_submit = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(item.getLAST_REVISED_DATE() + "");

            formatDate_Now = DateFormat.format("yyyy-MM-dd'T'HH:mm:ss", currentDate).toString();
            date_now = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(formatDate_Now);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean trangthaiDanhGiaAbstract;

        switch (view.getId()) {
            case R.id.imgXemDanhGiaAbs:
            case R.id.txtXemDanhGiaAbs:
                hideFunc();
                //chuyển trang Xem đánh giá abs
                Intent intent4 = new Intent(getActivity(), SeeReviewActivity.class);
                intent4.putExtra("type", "1");
                intent4.putExtra("status", "02");
                //01 từ chối do hội đồng chấm, 02 từ chối do quá deadline và hội đồng chưa duyệt, 1 đồng ý
                intent4.putExtra("object", item);

                /*
                2 trường hợp xem đánh giá bài abstract bị từ chối
                1> bài abstract từ chối này, đã dc đánh giá
                2> bài abstract từ chối này, chưa được đánh giá
                * */


                if( Boolean.FALSE.equals(item.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT()) ){
                    startActivity(intent4);
                }else if(date_now.getTime() > date_deadline.getTime() &&
                        Boolean.FALSE.equals(item.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT()) == false &&
                        Boolean.TRUE.equals(item.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT()) == false){
                    new ConfirmOkDialog(getActivity(), "Không thể xem đánh giá", "Bài tóm tắt chưa được đánh giá.", ListAbstractFragment.this).show();
                }else if(Boolean.TRUE.equals(item.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT()) == true &&
                        date_now.getTime() > date_deadline.getTime()){

                    intent4.putExtra("APPROVED", false);
                    startActivity(intent4);
                }
                break;
            case R.id.imgXoaAbs:
            case R.id.txtXoaAbs:
                hideFunc();
                //hiển thi dialog Xóa
                /*
                    2 trường hợp
                    1> từ chối do nộp abstract rồi mà quá time deadline mà chưa đc đánh giá
                    2> từ chối do hội đồng
                */

                if(date_now.getTime() > date_deadline.getTime()){
                    // xuất thông báo, không cho phép rút do quá deadline
                    new ConfirmOkDialog(getActivity(), "Không thể rút bài", "Hết thời hạn chỉnh sửa và rút bài.", ListAbstractFragment.this).show();
                }else if(date_submit.getTime() <= date_deadline.getTime()){
                    // cho phép rút bài abstract
                    if(
                            Boolean.TRUE.equals(item.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT()) == false &&
                                    Boolean.FALSE.equals(item.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT()) == false &&
                                    Boolean.TRUE.equals(item.getPAPER_ABSTRACT_WITHDRAWN()) == false &&
                                    Boolean.FALSE.equals(item.getPAPER_ABSTRACT_WITHDRAWN()) == false &&
                                    date_now.getTime() <= date_deadline.getTime()
                            ){
                        new AlertDialog.Builder(getActivity())
                                .setTitle("Thông báo")
                                .setMessage("Bạn có muốn rút bài?")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        JSONObject jsonObject = new JSONObject();
                                        try{
                                            jsonObject.put("id", item.getPAPER_ID());
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        String json = jsonObject.toString();
                                        Rutbai(json, Constants.ID_API_WITHDRAWNABSTRACT, Constants.API_WITHDRAWNABSTRACT);

                                    }})
                                .setNegativeButton(android.R.string.no, null).show();
                    }
                }
                break;
            case R.id.imgCapNhatAbs:
            case R.id.txtCapNhatAbs:
                hideFunc();
                // hiển trị trang cập nhật abs

                Intent intent7 = new Intent(getActivity(), SendAbstractActivity.class);
                intent7.putExtra("title", "capnhat");//tiêu đề cập nhật
                intent7.putExtra("type", "tomtat");// bài tóm tắt
                intent7.putExtra("object", item);
                intent7.putExtra("session_topic", arrSessionTopic);
                intent7.putExtra("type_of_study",arrTypeOfStudy);
                intent7.putExtra("presentation_type",arrPresentationType);

                /*
                2 trường hợp cập nhật của trạng thái từ chối
                1> do hôi đồng từ chối và còn trong deadline => cho phép cập nhật
                2> từ chối cập nhật do quá deadline mà chưa soạn xong || hội đồng chưa đánh giá

                * */

                if( Boolean.FALSE.equals(item.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT()) &&
                   date_now.getTime() <= date_deadline.getTime()){
                    startActivityForResult(intent7, REQUEST_CODE_UPDATE_ABSTRACT);
                }else if( Boolean.FALSE.equals(item.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT()) &&
                        date_now.getTime() > date_deadline.getTime()){
                    new ConfirmOkDialog(getActivity(), "Không thể cập nhật", "Hết thời hạn chỉnh sửa và rút bài.", ListAbstractFragment.this).show();
                }else if( Boolean.FALSE.equals(item.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT()) == false &&
                        Boolean.TRUE.equals(item.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT()) == false &&
                        date_now.getTime() > date_deadline.getTime()){
                    new ConfirmOkDialog(getActivity(), "Không thể cập nhật", "Hết thời hạn chỉnh sửa và rút bài. Bài báo chưa được duyệt.", ListAbstractFragment.this).show();
                }else if(date_now.getTime() > date_deadline.getTime()){
                    new ConfirmOkDialog(getActivity(), "Không thể cập nhật", "Hết thời hạn chỉnh sửa và rút bài.", ListAbstractFragment.this).show();
                }

                break;
            case R.id.imgGuiBaocaoAbs_Daduyet:
            case R.id.txtGuiBaocaoAbs_Daduyet:
                hideFunc();
                //hiển thị trang Nhập thông tin bài paper
                // nếu đã có bài paper thì cho xem danh sách paper
                Intent intent = new Intent(getActivity(), SendPaperActivity.class);
                intent.putExtra("object", item);
                startActivityForResult(intent, REQUEST_CODE_LISTABSTRACTFRAGMENT_GUIPAPER);

                break;
            case R.id.imgXemThongtinAbs_Daduyet:
            case R.id.txtXemThongtinAbs_Daduyet:
                hideFunc();
                //hiện dialog xem thông tin bài abs
                Intent intent2 = new Intent(getActivity(), XemThongtinActivity.class);
                intent2.putExtra("type", "1");// tiêu đề bài tóm tắt
                intent2.putExtra("object", item);
                startActivity(intent2);
                break;
            case R.id.imgXemDanhGiaAbs_Daduyet:
            case R.id.txtXemDanhGiaAbs_Daduyet:
                hideFunc();
                //chuyển trang xem Đánh giá

                Intent intent3 = new Intent(getActivity(), SeeReviewActivity.class);
                intent3.putExtra("type", "1");// bài tóm tắt
                intent3.putExtra("status", "02");
                intent3.putExtra("object", item);
                intent3.putExtra("APPROVED", false);
                startActivity(intent3);
                break;
            case R.id.imgRutbaiAbs_Choduyet:
            case R.id.txtRutbaiAbs_Choduyet:
                hideFunc();
                //hiện dialog Rút bài
                if(
                        Boolean.TRUE.equals(item.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT()) == false &&
                                Boolean.FALSE.equals(item.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT()) == false &&
                                Boolean.TRUE.equals(item.getPAPER_ABSTRACT_WITHDRAWN()) == false &&
                                Boolean.FALSE.equals(item.getPAPER_ABSTRACT_WITHDRAWN()) == false &&
                                date_now.getTime() <= date_deadline.getTime()
                        ){
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Thông báo")
                            .setMessage("Bạn có muốn rút bài?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int whichButton) {
                                    JSONObject jsonObject = new JSONObject();
                                    try{
                                        jsonObject.put("id", item.getPAPER_ID());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    String json = jsonObject.toString();
                                    Rutbai(json, Constants.ID_API_WITHDRAWNABSTRACT, Constants.API_WITHDRAWNABSTRACT);

                                }})
                            .setNegativeButton(android.R.string.no, null).show();
                }
                break;
            case R.id.imgXemThongtinAbs_Choduyet:
            case R.id.txtXemThongtinAbs_Choduyet:
                hideFunc();
                //chuyển trang xem thông tin
                Intent intent5 = new Intent(getActivity(), XemThongtinActivity.class);
                intent5.putExtra("type", "1");// bài tóm tắt
                intent5.putExtra("object", item);
                startActivity(intent5);
                break;
            case R.id.imgRutbaiAbs_Dangsoan:
            case R.id.txtRutbaiAbs_Dangsoan:
                hideFunc();
                //hiện dialog xác nhận rút bài


                if(
                        Boolean.TRUE.equals(item.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT()) == false &&
                        Boolean.FALSE.equals(item.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT()) == false &&
                        Boolean.TRUE.equals(item.getPAPER_ABSTRACT_WITHDRAWN()) == false &&
                        Boolean.FALSE.equals(item.getPAPER_ABSTRACT_WITHDRAWN()) == false &&
                        date_now.getTime() <= date_deadline.getTime()
                        ){
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Thông báo")
                            .setMessage("Bạn có muốn rút bài?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int whichButton) {
                                    JSONObject jsonObject = new JSONObject();
                                    try{
                                        jsonObject.put("id", item.getPAPER_ID());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    String json = jsonObject.toString();
                                    Rutbai(json, Constants.ID_API_WITHDRAWNABSTRACT, Constants.API_WITHDRAWNABSTRACT);

                                }})
                            .setNegativeButton(android.R.string.no, null).show();
                }


                break;
            case R.id.imgCapnhatAbs_Dangsoan:
            case R.id.txtCapnhatAbs_Dangsoan:
                hideFunc();
                //chuyển trang Cập nhật

                if( Utils.convertStringLowerCase(item.getFULL_PAPER_OR_WORK_IN_PROGRESS()).equals("workinprogress") &&
                        Boolean.TRUE.equals(item.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT()) == false &&
                        Boolean.FALSE.equals(item.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT()) == false &&
                        Boolean.TRUE.equals(item.getPAPER_ABSTRACT_WITHDRAWN()) == false &&
                        Boolean.FALSE.equals(item.getPAPER_ABSTRACT_WITHDRAWN()) == false &&
                        date_now.getTime() <= date_deadline.getTime()){

                    Intent intent8 = new Intent(getActivity(), SendAbstractActivity.class);
                    intent8.putExtra("title", "capnhat");//tiêu đề cập nhật
                    intent8.putExtra("type", "tomtat");// bài tóm tắt
                    intent8.putExtra("object", item);
                    intent8.putExtra("session_topic", arrSessionTopic);
                    intent8.putExtra("type_of_study",arrTypeOfStudy);
                    intent8.putExtra("presentation_type",arrPresentationType);
                    startActivityForResult(intent8, REQUEST_CODE_UPDATE_ABSTRACT);
                }

                break;
        }
    }





    private void Rutbai(String json, int idApiWithdrawnabstract, String apiWithdrawnabstract) {
              DownloadAsyncTask.POST(getActivity(), idApiWithdrawnabstract,
                      apiWithdrawnabstract, json, ResultBoolean.class, false, this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_LISTABSTRACTFRAGMENT_GUIPAPER:
                if (resultCode == Activity.RESULT_OK) {//Activity.RESULT_CANCELED

                }
                break;
            case REQUEST_CODE_UPDATE_ABSTRACT:

                if (resultCode == Activity.RESULT_OK) {
                    JSONObject jsonObject = new JSONObject();
                    try{
                        jsonObject.put("id", 1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String json = jsonObject.toString();
                    DownloadAsyncTask.POST(getActivity(), Constants.ID_API_LISTABSTRACT,
                            Constants.API_LISTABSTRACT, json, AbstractModel.class, false, this);
                }
                break;
            default:
                Toast.makeText(getActivity(),"Không nhận", Toast.LENGTH_LONG).show();
        }
    }

    private void alertDialog(String title, String message) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getActivity(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getActivity());
        }
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    public void popupCalback(int processId, Object data) {
        if(processId == ID_DIALOG_CONFIRM_YES){

        }
    }



    // download data

    @Override
    public void downloadSuccess(int processId, Object data) {
        if(processId == Constants.ID_API_LISTABSTRACT){
            ArrayList<AbstractModel> ds = new ArrayList<>();
            ds = (ArrayList<AbstractModel>) data;
            arrAbstract = new ArrayList<>();
            for (int i = 0; i< ds.size(); i++){
                arrAbstract.add(new AbstractModel(
                        ds.get(i).getPERSON_ID(),
                        ds.get(i).getCONFERENCE_ID(),
                        ds.get(i).getORGANIZATION_NAME_1(),
                        ds.get(i).getORGANIZATION_NAME_2(),
                        ds.get(i).getORGANIZATION_NAME_3(),
                        ds.get(i).getORGANIZATION_NAME_4(),
                        ds.get(i).getORGANIZATION_NAME_5(),
                        ds.get(i).getCORRESPONDING_AUTHOR(),
                        ds.get(i).getPAPER_ID(),
                        ds.get(i).getCONFERENCE_NAME(),
                        ds.get(i).getPAPER_ABSTRACT_DEADLINE(),
                        ds.get(i).getPAPER_ABSTRACT_TITLE(),
                        ds.get(i).getPAPER_ABSTRACT_TITLE_EN(),
                        ds.get(i).getCONFERENCE_SESSION_TOPIC_ID(),
                        ds.get(i).getCONFERENCE_SESSION_TOPIC_NAME(),
                        ds.get(i).getCONFERENCE_SESSION_TOPIC_NAME_EN(),
                        ds.get(i).getPAPER_ABSTRACT_TEXT(),
                        ds.get(i).getFULL_PAPER_OR_WORK_IN_PROGRESS(),
                        ds.get(i).getTYPE_OF_STUDY_ID(),
                        ds.get(i).getTYPE_OF_STUDY_NAME(),
                        ds.get(i).getTYPE_OF_STUDY_NAME_EN(),
                        ds.get(i).getCONFERENCE_PRESENTATION_TYPE_ID(),
                        ds.get(i).getCONFERENCE_PRESENTATION_TYPE_NAME(),
                        ds.get(i).getCONFERENCE_PRESENTATION_TYPE_NAME_EN(),
                        ds.get(i).getFIRST_SUBMITTED_DATE(),
                        ds.get(i).getLAST_REVISED_DATE(),
                        ds.get(i).getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT(),
                        ds.get(i).getFROM_DATE(),
                        ds.get(i).getTHRU_DATE(),
                        ds.get(i).getPAPER_ABSTRACT_WITHDRAWN(),
                        ds.get(i).getPOSITION()
                ));

            }
            adapter = new AbstractAdapter(this.getActivity(), android.R.id.list, arrAbstract);
            listView.setAdapter(adapter);



        }else if(processId == Constants.ID_API_WITHDRAWNABSTRACT){
            ResultBoolean ds = (ResultBoolean) data;
            Log.d("---data", ds.result+"");

            if(ds.result == true){
                JSONObject jsonObject = new JSONObject();
                try{
                    jsonObject.put("id", 1);// id: author
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String json = jsonObject.toString();
                DownloadAsyncTask.POST(getActivity(), Constants.ID_API_LISTABSTRACT,
                        Constants.API_LISTABSTRACT, json, AbstractModel.class, false, this);

                Toast.makeText(getActivity(), "Rút bài thành công.", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getActivity(), "Rút bài thất bại.", Toast.LENGTH_LONG).show();
            }

        }else if(processId == Constants.ID_API_SESSIONTOPIC){
            ArrayList<SessionTopicModel> ds = new ArrayList<>();
            ds = (ArrayList<SessionTopicModel>) data;
            arrSessionTopic = new ArrayList<>();
            for (int i = 0; i< ds.size(); i++){
                arrSessionTopic.add(new SessionTopicModel(
                        ds.get(i).getCONFERENCE_SESSION_TOPIC_ID(),
                        ds.get(i).getCONFERENCE_SESSION_TOPIC_NAME(),
                        ds.get(i).getCONFERENCE_SESSION_TOPIC_NAME_EN()
                ));
            }
        }else if(processId == Constants.ID_API_PRESENTATION){
            ArrayList<PresentationTypeModel> ds = new ArrayList<>();
            ds = (ArrayList<PresentationTypeModel>) data;
            arrPresentationType = new ArrayList<>();
            for (int i = 0; i< ds.size(); i++){
                arrPresentationType.add(new PresentationTypeModel(
                        ds.get(i).getCONFERENCE_PRESENTATION_TYPE_ID(),
                        ds.get(i).getCONFERENCE_PRESENTATION_TYPE_NAME(),
                        ds.get(i).getCONFERENCE_PRESENTATION_TYPE_NAME_EN()
                ));
            }
        }else if(processId == Constants.ID_API_TYPE_OF_STUDY){
            ArrayList<TypeOfStudyModel> ds = new ArrayList<>();
            ds = (ArrayList<TypeOfStudyModel>) data;
            arrTypeOfStudy = new ArrayList<>();
            for (int i = 0; i < ds.size(); i++){
                arrTypeOfStudy.add(new TypeOfStudyModel(
                        ds.get(i).getTYPE_OF_STUDY_ID(),
                        ds.get(i).getTYPE_OF_STUDY_NAME(),
                        ds.get(i).getTYPE_OF_STUDY_NAME_EN()
                ));
            }
        }else if(processId == Constants.ID_API_BOARDOFREVIEW){
            ArrayList<BoardOfReview> ds = new ArrayList<>();
            ds = (ArrayList<BoardOfReview>) data;
            arr = new ArrayList<>();

            for(int i = 0; i< ds.size(); i++){
                arr.add(new BoardOfReview(
                        ds.get(i).getCONFERENCE_BOARD_OF_REVIEW_ID(),
                        ds.get(i).getCONFERENCE_ID(),
                        ds.get(i).getPAPER_ABSTRACT_REVIEW_DEADLINE_1(),
                        ds.get(i).getPAPER_ABSTRACT_REVIEW_DEADLINE_2(),
                        ds.get(i).getPAPER_ABSTRACT_REVIEW_RATING_SCALE_STEP(),
                        ds.get(i).getPAPER_ABSTRACT_REVIEW_RATING_SCALE_START_POINT(),
                        ds.get(i).getPAPER_ABSTRACT_REVIEW_RATING_SCALE_END_POINT()
                ));
            }

        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        if(processId == Constants.ID_API_LISTABSTRACT){
            Log.d("---KQ false---", msg);
        }else if(processId == Constants.ID_API_SESSIONTOPIC){
            Log.d("---KQ false---", msg);
        }else if(processId == Constants.ID_API_BOARDOFREVIEW){
            Log.d("---KQ false---", msg);
        }
    }


}
