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

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.activities.SeeReviewActivity;
import cse.duytan.coms.activities.SendAbstractActivity;
import cse.duytan.coms.activities.SendPaperActivity;
import cse.duytan.coms.activities.XemThongtinActivity;
import cse.duytan.coms.adapters.AbstractAdapter;
import cse.duytan.coms.dialogs.ConfirmDialog;
import cse.duytan.coms.models.Abstract;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.untils.PopupCalback;

/**
 * Created by lehoangdung on 19/06/2017.
 */

public class ListAbstractFragment extends ListFragment implements View.OnClickListener, PopupCalback, Constants {
    private ListView listView;
    private ArrayList<Abstract> arrAbstract;
    private AbstractAdapter adapter;
    private Animation animation, animation_abs;
    private LinearLayout ln, ln_func, ln_row_abstract;
    public static final int REQUEST_CODE_LISTABSTRACTFRAGMENT_GUIPAPER = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //loadListAbstract();
        View rootView = inflater.inflate(R.layout.listabstract_fragment, container, false);
        listView = (ListView) rootView.findViewById(android.R.id.list);
        loadListAbstract();
        return rootView;
    }

    private void loadListAbstract() {
        arrAbstract = new ArrayList<>();
        addArrAbstract();
        adapter = new AbstractAdapter(this.getActivity(), android.R.id.list, arrAbstract);
        //setListAdapter(adapter);
        listView.setAdapter(adapter);
    }

    private void addArrAbstract() {
        arrAbstract.add(new Abstract("Hội nghị khoa học kỹ thuật - Tóm tắt 2", 1, "6/9/2017"));
        arrAbstract.add(new Abstract("Hội nghị trung ương khóa 5 - Tóm tắt 1", 0, "9/10/2017"));
        arrAbstract.add(new Abstract("Hội nghị tin học trẻ - Tóm tắt 3", 2, "12/11/2017"));
        arrAbstract.add(new Abstract("Hội nghị APEC - Tóm tắt 2", 2, "16/12/2017"));
        arrAbstract.add(new Abstract("Hội nghị Diên Hồng - Tóm tắt 2", 3, "5/1/2017"));
        arrAbstract.add(new Abstract("Hội nghị Răng hàm mặt 2017 - Tóm tắt 4", 0, "6/2/2017"));
        arrAbstract.add(new Abstract("Hội nghị rút kinh nghiệm công tác giáo dục quản lý kỷ luật và đảm bảo an toàn" +
                " - Tóm tắt 2", 3, "10/3/2017"));
        arrAbstract.add(new Abstract("Hội nghị cán bô công chức 2017 - Tóm tắt 1", 1, "3/4/2017"));
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
        switch (view.getId()) {
            case R.id.imgXemDanhGiaAbs:
            case R.id.txtXemDanhGiaAbs:
                hideFunc();
                //chuyển trang Xem đánh giá abs
                Intent intent4 = new Intent(getActivity(), SeeReviewActivity.class);
                intent4.putExtra("type", "1");
                intent4.putExtra("status", "0");//0 từ chối, 1 đồng ý
                startActivity(intent4);
                break;
            case R.id.imgXoaAbs:
            case R.id.txtXoaAbs:
                hideFunc();
                //hiển thi dialog Xóa
               // alertDialog("Rút bài", "Bạn có chắc muốn rút bài");
                new ConfirmDialog(getActivity(), "Rút bài", "Bạn có chắc muốn rút bài", ListAbstractFragment.this).show();
                break;
            case R.id.imgCapNhatAbs:
            case R.id.txtCapNhatAbs:
                hideFunc();
                // hiển trị trang cập nhật abs
//                Toast.makeText(getActivity(), "hiển trị trang cập nhật abs", Toast.LENGTH_SHORT).show();
                Intent intent7 = new Intent(getActivity(), SendAbstractActivity.class);
                intent7.putExtra("title", "0");//tiêu đề cập nhật
                intent7.putExtra("type", "1");// bài tóm tắt
                startActivity(intent7);
                break;
            case R.id.imgGuiBaocaoAbs_Daduyet:
            case R.id.txtGuiBaocaoAbs_Daduyet:
                hideFunc();
                //hiển thị trang Nhập thông tin bài paper
                // nếu đã có bài paper thì cho xem danh sách paper
                Intent intent = new Intent(getActivity(), SendPaperActivity.class);
                startActivityForResult(intent, REQUEST_CODE_LISTABSTRACTFRAGMENT_GUIPAPER);
                break;
            case R.id.imgXemThongtinAbs_Daduyet:
            case R.id.txtXemThongtinAbs_Daduyet:
                hideFunc();
                //hiện dialog xem thông tin bài abs
                Intent intent2 = new Intent(getActivity(), XemThongtinActivity.class);
                intent2.putExtra("type", "1");// tiêu đề bài tóm tắt
                startActivity(intent2);
                break;
            case R.id.imgXemDanhGiaAbs_Daduyet:
            case R.id.txtXemDanhGiaAbs_Daduyet:
                hideFunc();
                //chuyển trang xem Đánh giá
                Intent intent3 = new Intent(getActivity(), SeeReviewActivity.class);
                intent3.putExtra("type", "1");// bài tóm tắt
                intent3.putExtra("status", "2");
                startActivity(intent3);
                break;
            case R.id.imgRutbaiAbs_Choduyet:
            case R.id.txtRutbaiAbs_Choduyet:
                hideFunc();
                //hiện dialog Rút bài
//                Toast.makeText(getActivity(), "hiện dialog Rút bài", Toast.LENGTH_SHORT).show();
                alertDialog("Rút bài", "Bạn có chắc muốn rút bài");
                break;
            case R.id.imgXemThongtinAbs_Choduyet:
            case R.id.txtXemThongtinAbs_Choduyet:
                hideFunc();
                //chuyển trang xem thông tin
                Toast.makeText(getActivity(), "chuyển trang xem thông tin", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(getActivity(), XemThongtinActivity.class);
                intent5.putExtra("type", "1");// bài tóm tắt
                startActivity(intent5);
                break;
            case R.id.imgRutbaiAbs_Dangsoan:
            case R.id.txtRutbaiAbs_Dangsoan:
                hideFunc();
                //hiện dialog xác nhận rút bài
//                Toast.makeText(getActivity(), "hiện dialog xác nhận rút bài", Toast.LENGTH_SHORT).show();
                alertDialog("Rút bài", "Bạn có chắc muốn rút bài");
                break;
            case R.id.imgCapnhatAbs_Dangsoan:
            case R.id.txtCapnhatAbs_Dangsoan:
                hideFunc();
                //chuyển trang Cập nhật
                Toast.makeText(getActivity(), "chuyển trang Cập nhật", Toast.LENGTH_SHORT).show();
                Intent intent8 = new Intent(getActivity(), SendAbstractActivity.class);
                intent8.putExtra("title", "0");//tiêu đề cập nhật
                intent8.putExtra("type", "1");// bài tóm tắt
                startActivity(intent8);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_LISTABSTRACTFRAGMENT_GUIPAPER:
                if (resultCode == Activity.RESULT_OK) {//Activity.RESULT_CANCELED
                    int status = data.getIntExtra("status", 1);
                    Toast.makeText(getActivity(), "Đã nhận dữ liệu trả về " + status, Toast.LENGTH_SHORT).show();
                }
                break;
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
            Toast.makeText(getActivity(), "Bạn đã rút bài báo!", Toast.LENGTH_SHORT).show();
        }
    }
}
