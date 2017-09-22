package cse.duytan.coms.fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.activities.SeePaperTextActivity;
import cse.duytan.coms.activities.SeeReviewActivity;
import cse.duytan.coms.activities.SendAbstractActivity;
import cse.duytan.coms.activities.SendPaperActivity;
import cse.duytan.coms.activities.UpdatePaperTextActivity;
import cse.duytan.coms.activities.XemThongtinActivity;
import cse.duytan.coms.adapters.PaperTextAdapter;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.dialogs.ConfirmDialog;
import cse.duytan.coms.models.PaperTextModel;
import cse.duytan.coms.models.ResultBoolean;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.untils.PopupCalback;

/**
 * Created by DungTrungCut on 7/11/2017.
 */

public class ListPaperFragment extends ListFragment implements View.OnClickListener, PopupCalback, Constants, DownloadCallback {
    private ListView listView;
    private ArrayList<PaperTextModel> arrPaper;
    private PaperTextAdapter adapter;
    private Animation animation, animation_abs;
    private LinearLayout ln, ln_func, ln_row_paper;
    public static final int REQUEST_CODE_LISTABSTRACTFRAGMENT_GUIPAPER = 1;
    public static final int REQUEST_CODE_UPDATEPAPER = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //loadListAbstract();
        View rootView = inflater.inflate(R.layout.listabstract_fragment, container, false);
        listView = (ListView) rootView.findViewById(android.R.id.list);
        loadListAbstract();
        return rootView;
    }

    private void loadListAbstract() {
        arrPaper = new ArrayList<>();
        addArrAbstract();
    }

    private void addArrAbstract() {
//        arrPaper.add(new Abstract("Hội nghị khoa học kỹ thuật - Bài báo 2", 1, "6/9/2017"));
//        arrPaper.add(new Abstract("Hội nghị trung ương khóa 5 - Bài báo 1", 0, "9/10/2017"));
//        arrPaper.add(new Abstract("Hội nghị tin học trẻ - Bài báo 3", 2, "12/11/2017"));
//        arrPaper.add(new Abstract("Hội nghị APEC - Tóm tắt 2", 2, "16/12/2017"));
//        arrPaper.add(new Abstract("Hội nghị Diên Hồng - Tóm tắt 2", 3, "5/1/2017"));
//        arrPaper.add(new Abstract("Hội nghị Răng hàm mặt 2017 - Bài báo 4", 0, "6/2/2017"));
//        arrPaper.add(new Abstract("Hội nghị rút kinh nghiệm công tác giáo dục quản lý kỷ luật và đảm bảo an toàn" +
//                " - Bài báo 2", 3, "10/3/2017"));
//        arrPaper.add(new Abstract("Hội nghị cán bô công chức 2017 - Bài báo 1", 1, "3/4/2017"));
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("idAuthor", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String json = jsonObject.toString();
        DownloadAsyncTask.POST(this.getActivity(), Constants.ID_API_LIST_PAPERTEXT, Constants.API_LIST_PAPERTEXT,
                json, PaperTextModel.class, false, this);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //Từ chối
        TextView txtXemDanhGia, txtXoa, txtCapnhat;// các control chức năng trên 1 dòng từ chối
        ImageView imgXemDanhGia, imgXoa, imgCapnhat;// từ chối
        //Đã duyệt
        TextView txtGuiBaocaoPaper_Daduyet, txtXemThongtinPaper_Daduyet, txtXemDanhGiaPaper_Daduyet;
        ImageView imgGuiBaocaoPaper_Daduyet, imgXemThongtinPaper_Daduyet, imgXemDanhGiaPaper_Daduyet;
        //Chờ duyệt
        TextView txtRutbaiPaper_Choduyet, txtXemThongtinPaper_Choduyet;
        ImageView imgRutbaiPaper_Choduyet, imgXemThongtinPaper_Choduyet;
        //Đoạn soạn
        TextView txtRutbaiPaper_Dangsoan, txtCapnhatPaper_Dangsoan;
        ImageView imgRutbaiPaper_Dangsoan, imgCapnhatPaper_Dangsoan;

        ln = (LinearLayout)v.findViewById(R.id.ln_list_abstract);//thông tin trên 1 dòng
        ln_func = (LinearLayout)v.findViewById(R.id.ln_listfunc_abstract);// danh sách chức năng trên 1 dòng dựa trên trạng thái => hiển thị
        ln_row_paper = (LinearLayout)v.findViewById(R.id.row_abstract);
        // từ chối
        txtXemDanhGia = (TextView) v.findViewById(R.id.txtXemDanhGiaAbs);
        txtXoa = (TextView) v.findViewById(R.id.txtXoaAbs);
        txtCapnhat = (TextView) v.findViewById(R.id.txtCapNhatAbs);
        imgXemDanhGia = (ImageView) v.findViewById(R.id.imgXemDanhGiaAbs);
        imgXoa = (ImageView) v.findViewById(R.id.imgXoaAbs);
        imgCapnhat = (ImageView) v.findViewById(R.id.imgCapNhatAbs);

        //đã duyệt
        txtGuiBaocaoPaper_Daduyet = (TextView) v.findViewById(R.id.txtGuiBaocaoAbs_Daduyet);
        txtXemThongtinPaper_Daduyet = (TextView) v.findViewById(R.id.txtXemThongtinAbs_Daduyet);
        txtXemDanhGiaPaper_Daduyet = (TextView) v.findViewById(R.id.txtXemDanhGiaAbs_Daduyet);
        imgGuiBaocaoPaper_Daduyet = (ImageView) v.findViewById(R.id.imgGuiBaocaoAbs_Daduyet);
        imgXemThongtinPaper_Daduyet = (ImageView) v.findViewById(R.id.imgXemThongtinAbs_Daduyet);
        imgXemDanhGiaPaper_Daduyet = (ImageView) v.findViewById(R.id.imgXemDanhGiaAbs_Daduyet);

        //chờ duyệt
        txtRutbaiPaper_Choduyet = (TextView) v.findViewById(R.id.txtRutbaiAbs_Choduyet);
        txtXemThongtinPaper_Choduyet = (TextView) v.findViewById(R.id.txtXemThongtinAbs_Choduyet);
        imgRutbaiPaper_Choduyet = (ImageView) v.findViewById(R.id.imgRutbaiAbs_Choduyet);
        imgXemThongtinPaper_Choduyet = (ImageView) v.findViewById(R.id.imgXemThongtinAbs_Choduyet);

        // đang soạn
        txtRutbaiPaper_Dangsoan = (TextView) v.findViewById(R.id.txtRutbaiAbs_Dangsoan);
        txtCapnhatPaper_Dangsoan = (TextView) v.findViewById(R.id.txtCapnhatAbs_Dangsoan);
        imgRutbaiPaper_Dangsoan = (ImageView) v.findViewById(R.id.imgRutbaiAbs_Dangsoan);
        imgCapnhatPaper_Dangsoan = (ImageView) v.findViewById(R.id.imgCapnhatAbs_Dangsoan);


        if (ln.getVisibility() == View.GONE) {
            hideFunc();
        } else {

            for (int i = 0; i < listView.getAdapter().getCount(); i++){
                if(position !=i ){
                    Animation animation2, animation_abs2;
                    View viewrow = listView.getChildAt(i);
                    View view = listView.getAdapter().getView(i, viewrow, listView);//listView.getChildAt(i);
                    LinearLayout ln2 = (LinearLayout)view.findViewById(R.id.ln_list_abstract);
                    LinearLayout ln_func2 = (LinearLayout)view.findViewById(R.id.ln_listfunc_abstract);
                    LinearLayout ln_row_abstract2 = (LinearLayout) view.findViewById(R.id.row_abstract);

                    if(ln_func2.getVisibility() == View.VISIBLE){
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
            showFunc();
        }
        // từ chối
        txtXemDanhGia.setOnClickListener(this);
        txtXoa.setOnClickListener(this);
        txtCapnhat.setOnClickListener(this);
        imgXemDanhGia.setOnClickListener(this);
        imgXoa.setOnClickListener(this);
        imgCapnhat.setOnClickListener(this);
        //đã duyệt
        txtGuiBaocaoPaper_Daduyet.setOnClickListener(this);
        txtXemThongtinPaper_Daduyet.setOnClickListener(this);
        txtXemDanhGiaPaper_Daduyet.setOnClickListener(this);
        imgGuiBaocaoPaper_Daduyet.setOnClickListener(this);
        imgXemThongtinPaper_Daduyet.setOnClickListener(this);
        imgXemDanhGiaPaper_Daduyet.setOnClickListener(this);
        // Chờ duyệt
        txtRutbaiPaper_Choduyet.setOnClickListener(this);
        txtXemThongtinPaper_Choduyet.setOnClickListener(this);
        imgRutbaiPaper_Choduyet.setOnClickListener(this);
        imgXemThongtinPaper_Choduyet.setOnClickListener(this);
        // đang soạn
        txtRutbaiPaper_Dangsoan.setOnClickListener(this);
        txtCapnhatPaper_Dangsoan.setOnClickListener(this);
        imgRutbaiPaper_Dangsoan.setOnClickListener(this);
        imgCapnhatPaper_Dangsoan.setOnClickListener(this);

    }

    private void hideFunc(){
        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out_left);
        ln_func.setVisibility(View.GONE);//ẩn danh sách chức năng
        animation.setDuration(400);
        ln_func.setAnimation(animation);
        ln_func.animate().withLayer();
        ln_row_paper.setBackgroundColor(Color.WHITE);

        animation_abs = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right);
        animation_abs.setDuration(700);
        ln.setAnimation(animation_abs);
        ln.animate().withLayer();
        ln.setVisibility(View.VISIBLE);// hiển dòng abstract ra
    }

    private void showFunc(){
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
        final PaperTextModel item = (PaperTextModel) listView.getAdapter().getItem(position);
        switch (view.getId()) {
            case R.id.imgXemDanhGiaAbs:
            case R.id.txtXemDanhGiaAbs:
                hideFunc();
                //chuyển trang Xem đánh giá abs
//                Intent intent4 = new Intent(getActivity(), SeeReviewActivity.class);
//                intent4.putExtra("type","2");
//                intent4.putExtra("status","0");//0 từ chối, 1 đồng ý
//                startActivity(intent4);
                break;
            case R.id.imgXoaAbs:
            case R.id.txtXoaAbs:
                hideFunc();
                //hiển thi dialog Xóa
//                alertDialog("Rút bài","Bạn có chắc muốn rút bài");
//                new ConfirmDialog(getActivity(), "Rút bài", "Bạn có chắc muốn rút bài", ListPaperFragment.this).show();
                new AlertDialog.Builder(getActivity())
                        .setTitle("Thông báo")
                        .setMessage("Bạn có muốn rút bài?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                JSONObject jsonObject = new JSONObject();
                                try{
                                    jsonObject.put("Id", item.getPAPER_ID());
                                    jsonObject.put("position", item.getPOSITION());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                String json = jsonObject.toString();
                                Rutbai(json, Constants.ID_API_WITHDRAWN_PAPERTEXT, Constants.API_WITHDRAWN_PAPERTEXT);

                            }})
                        .show();
                break;
            case R.id.imgCapNhatAbs:
            case R.id.txtCapNhatAbs:
                hideFunc();
                // hiển trị trang cập nhật abs
//                Toast.makeText(getActivity(), "hiển trị trang cập nhật abs", Toast.LENGTH_SHORT).show();
//                Intent intent7 = new Intent(getActivity(), SendAbstractActivity.class);
//                intent7.putExtra("title","4");//tiêu đề cập nhật
//                intent7.putExtra("type","4");// bài báo
//                startActivity(intent7);
                break;
            case R.id.imgGuiBaocaoAbs_Daduyet:
            case R.id.txtGuiBaocaoAbs_Daduyet:
                hideFunc();
                //hiển thị trang Nhập thông tin bài paper
                // nếu đã có bài paper thì cho xem danh sách paper
//                Intent intent = new Intent(getActivity(), SendPaperActivity.class);
//                startActivityForResult(intent, REQUEST_CODE_LISTABSTRACTFRAGMENT_GUIPAPER);
                break;
            case R.id.imgXemThongtinAbs_Daduyet:
            case R.id.txtXemThongtinAbs_Daduyet:
                hideFunc();
                //hiện dialog xem thông tin bài abs
//                Intent intent2 = new Intent(getActivity(), XemThongtinActivity.class);
//                intent2.putExtra("type","2");// tiêu đề bài báo
//                startActivity(intent2);
                Intent intent2 = new Intent(getActivity(), SeePaperTextActivity.class);
                intent2.putExtra("object", item);
                startActivity(intent2);
                break;
            case R.id.imgXemDanhGiaAbs_Daduyet:
            case R.id.txtXemDanhGiaAbs_Daduyet:
                hideFunc();
                //chuyển trang xem Đánh giá
//                Intent intent3 = new Intent(getActivity(), SeeReviewActivity.class);
//                intent3.putExtra("type","2");// bài báo
//                intent3.putExtra("status","2");
//                startActivity(intent3);
                break;
            case R.id.imgRutbaiAbs_Choduyet:
            case R.id.txtRutbaiAbs_Choduyet:
                hideFunc();
                //hiện dialog Rút bài
//                Toast.makeText(getActivity(), "hiện dialog Rút bài", Toast.LENGTH_SHORT).show();
//                alertDialog("Rút bài","Bạn có chắc muốn rút bài");
                new AlertDialog.Builder(getActivity())
                        .setTitle("Thông báo")
                        .setMessage("Bạn có muốn rút bài?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                JSONObject jsonObject = new JSONObject();
                                try{
                                    jsonObject.put("Id", item.getPAPER_ID());
                                    jsonObject.put("position", item.getPOSITION());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                String json = jsonObject.toString();
                                Rutbai(json, Constants.ID_API_WITHDRAWN_PAPERTEXT, Constants.API_WITHDRAWN_PAPERTEXT);

                            }})
                        .show();
                break;
            case R.id.imgXemThongtinAbs_Choduyet:
            case R.id.txtXemThongtinAbs_Choduyet:
                hideFunc();
                //chuyển trang xem thông tin
//                Toast.makeText(getActivity(), "chuyển trang xem thông tin", Toast.LENGTH_SHORT).show();
//                Intent intent5 = new Intent(getActivity(), XemThongtinActivity.class);
//                intent5.putExtra("type","2");// bài tóm tắt
//                startActivity(intent5);
                Intent intent5 = new Intent(getActivity(), SeePaperTextActivity.class);
                intent5.putExtra("object", item);
                startActivity(intent5);
                break;
            case R.id.imgRutbaiAbs_Dangsoan:
            case R.id.txtRutbaiAbs_Dangsoan:
                hideFunc();
                //hiện dialog xác nhận rút bài
//                Toast.makeText(getActivity(), "hiện dialog xác nhận rút bài", Toast.LENGTH_SHORT).show();
//                alertDialog("Rút bài","Bạn có chắc muốn rút bài");
                new AlertDialog.Builder(getActivity())
                        .setTitle("Thông báo")
                        .setMessage("Bạn có muốn rút bài?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                JSONObject jsonObject = new JSONObject();
                                try{
                                    jsonObject.put("Id", item.getPAPER_ID());
                                    jsonObject.put("position", item.getPOSITION());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                String json = jsonObject.toString();
                                Rutbai(json, Constants.ID_API_WITHDRAWN_PAPERTEXT, Constants.API_WITHDRAWN_PAPERTEXT);

                            }})
                        .show();
                break;
            case R.id.imgCapnhatAbs_Dangsoan:
            case R.id.txtCapnhatAbs_Dangsoan:
                hideFunc();
                //chuyển trang Cập nhật bài báo
//                Toast.makeText(getActivity(), "chuyển trang Cập nhật", Toast.LENGTH_SHORT).show();
//                Intent intent8 = new Intent(getActivity(), SendAbstractActivity.class);
//                intent8.putExtra("title","4");//tiêu đề cập nhật
//                intent8.putExtra("type","4");// bài tóm tắt
//                startActivity(intent8);
                Intent intent8 = new Intent(getActivity(), UpdatePaperTextActivity.class);
                intent8.putExtra("object", item);
                startActivityForResult(intent8, REQUEST_CODE_UPDATEPAPER);
                break;
        }
    }

    private void Rutbai(String json, int idApiWithdrawnPapertext, String url) {
        DownloadAsyncTask.POST(getActivity(), idApiWithdrawnPapertext, url,
                json, ResultBoolean.class, false, ListPaperFragment.this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_CODE_LISTABSTRACTFRAGMENT_GUIPAPER:
                if(resultCode == Activity.RESULT_OK){//Activity.RESULT_CANCELED
                    int status =  data.getIntExtra("status", 1);
                    Toast.makeText(getActivity(), "Đã nhận dữ liệu trả về "+ status, Toast.LENGTH_SHORT).show();
                }
                break;
            case REQUEST_CODE_UPDATEPAPER:
                addArrAbstract();
                break;
        }
    }

    private void alertDialog(String title, String message){
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
            Toast.makeText(getActivity(), "Bạn đã rút bài báo!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        if(processId == Constants.ID_API_LIST_PAPERTEXT){

            ArrayList<PaperTextModel> ds = new ArrayList<>();
            ds = (ArrayList<PaperTextModel>) data;

            arrPaper = new ArrayList<>();
            for(int i = 0; i < ds.size(); i++){
                arrPaper.add(new PaperTextModel(
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
                        ds.get(i).getPAPER_TEXT_DEADLINE(),
                        ds.get(i).getPAPER_TEXT_TITLE(),
                        ds.get(i).getPAPER_TEXT_TITLE_EN(),
                        ds.get(i).getCONFERENCE_SESSION_TOPIC_ID(),
                        ds.get(i).getCONFERENCE_SESSION_TOPIC_NAME(),
                        ds.get(i).getCONFERENCE_SESSION_TOPIC_NAME_EN(),
                        ds.get(i).getPAPER_TEXT(),
                        ds.get(i).getTYPE_OF_STUDY_ID(),
                        ds.get(i).getTYPE_OF_STUDY_NAME(),
                        ds.get(i).getTYPE_OF_STUDY_NAME_EN(),
                        ds.get(i).getCONFERENCE_PRESENTATION_TYPE_ID(),
                        ds.get(i).getCONFERENCE_PRESENTATION_TYPE_NAME(),
                        ds.get(i).getCONFERENCE_PRESENTATION_TYPE_NAME_EN(),
                        ds.get(i).getFIRST_SUBMITTED_DATE(),
                        ds.get(i).getLAST_REVISED_DATE(),
                        ds.get(i).getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT(),
                        ds.get(i).getFROM_DATE(),
                        ds.get(i).getTHRU_DATE(),
                        ds.get(i).getPAPER_TEXT_WITHDRAWN(),
                        ds.get(i).getPOSITION()
                ));
            }
            adapter = new PaperTextAdapter(this.getActivity(), android.R.id.list, arrPaper);
            listView.setAdapter(adapter);
        }else if(processId == Constants.ID_API_WITHDRAWN_PAPERTEXT){
            ResultBoolean kq = (ResultBoolean) data;
            if(kq.result == true){
                Toast.makeText(getActivity(), "Đã rút bài", Toast.LENGTH_LONG).show();
                addArrAbstract();
            }
        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        if(processId == Constants.ID_API_LIST_PAPERTEXT){
            Toast.makeText(this.getActivity(), "loi", Toast.LENGTH_LONG).show();

        }
    }
}
