package cse.duytan.coms.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cse.duytan.coms.R;
import cse.duytan.coms.models.PaperTextModel;

/**
 * Created by lehoangdung on 9/19/2017.
 */

public class PaperTextAdapter extends ArrayAdapter<PaperTextModel> {
    private Context context;

//    public PaperTextAdapter(Context context, int resource, List<PaperTextModel> objects) {
//        super(context, resource, objects);
//        // TODO Auto-generated constructor stub
//        this.context = context;
//    }


    public PaperTextAdapter(Context context, int textViewResourceId, List<PaperTextModel> objects) {
        super(context, textViewResourceId, objects);
        // TODO Auto-generated constructor stub
        this.context = context;
    }

    private class ViewHolder {
        TextView txtThongTinAbs, txtNgayAbs, txtTrangThaiAbs;
        ImageView imgStatus;
        Button btnRight;
        LinearLayout ln_abstract, ln_listfunc_abstract;
        LinearLayout ln_XemDanhGia, ln_Xoa, ln_Capnhat;// chức năng trên 1 dòng theo trạng thái từ chối
        LinearLayout ln_Guibaibao_Daduyet, ln_Xemthongtin_Daduyet, ln_XemDanhGia_Daduyet; // đã duyệt
        LinearLayout ln_Rutbai_Choduyet, ln_XemThongtin_Choduyet; // chờ duyệt
        LinearLayout ln_Rutbai_Dangsoan, ln_Capnhat_Dangsoan; // đang soan
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PaperTextAdapter.ViewHolder holder = null;
        final PaperTextModel rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
//            Log.i("===convertView===","convertView == null");
            holder = new PaperTextAdapter.ViewHolder();
            convertView = mInflater.inflate(R.layout.row_abstract, null);
            holder.txtThongTinAbs = (TextView) convertView.findViewById(R.id.txtThongtinAbs);
            holder.txtNgayAbs = (TextView) convertView.findViewById(R.id.txtNgayAbs);
            holder.txtTrangThaiAbs = (TextView) convertView.findViewById(R.id.txtTrangthaiAbs);
            holder.imgStatus = (ImageView) convertView.findViewById(R.id.imgStatus);
            holder.btnRight = (Button) convertView.findViewById(R.id.btnRightAbs);
            holder.ln_abstract = (LinearLayout) convertView.findViewById(R.id.ln_list_abstract);
            holder.ln_listfunc_abstract = (LinearLayout) convertView.findViewById(R.id.ln_listfunc_abstract);
            //id các chức năng từ chối
            holder.ln_XemDanhGia = (LinearLayout) convertView.findViewById(R.id.ln_listfunc_author_XemDanhGia);
            holder.ln_Xoa = (LinearLayout) convertView.findViewById(R.id.ln_listfunc_author_Xoa);
            holder.ln_Capnhat = (LinearLayout) convertView.findViewById(R.id.ln_listfunc_author_Capnhat);

            //id chức năng đã duyệt
            holder.ln_Guibaibao_Daduyet = (LinearLayout) convertView.findViewById(R.id.ln_listfunc_author_GuiBaocao_Daduyet);
            holder.ln_Xemthongtin_Daduyet = (LinearLayout) convertView.findViewById(R.id.ln_listfunc_author_XemThongtin_Daduyet);
            holder.ln_XemDanhGia_Daduyet = (LinearLayout) convertView.findViewById(R.id.ln_listfunc_author_XemDanhGia_Daduyet);

            // id chức năng chờ duyệt
            holder.ln_Rutbai_Choduyet = (LinearLayout) convertView.findViewById(R.id.ln_listfunc_author_RutBai_Choduyet);
            holder.ln_XemThongtin_Choduyet = (LinearLayout) convertView.findViewById(R.id.ln_listfunc_author_XemThongtin_Choduyet);

            //đang soan
            holder.ln_Rutbai_Dangsoan = (LinearLayout) convertView.findViewById(R.id.ln_listfunc_author_Rutbai_Dangsoan);
            holder.ln_Capnhat_Dangsoan = (LinearLayout) convertView.findViewById(R.id.ln_listfunc_author_Capnhat_Dangsoan);
            convertView.setTag(holder);
        } else {
            holder = (PaperTextAdapter.ViewHolder) convertView.getTag();
        }
        // định dạng datetime
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");// so sán=> xuất trạng thái
        /*format datetime xuất deadline*/
        String formattedDate = "", formatDate_Deadline = "", formatDate_Now = "";
        Date date_deadline = null;
        Date date_submit = null;
        Date date_now = null;
        Calendar currentDate = Calendar.getInstance();

        try {
            date_deadline = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(rowItem.getPAPER_TEXT_DEADLINE() + "");
            date_submit = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(rowItem.getLAST_REVISED_DATE() + "");
            formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(date_deadline);

            formatDate_Now = DateFormat.format("yyyy-MM-dd'T'HH:mm:ss", currentDate).toString();
            date_now = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(formatDate_Now);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        // gán dữ liệu
        holder.txtThongTinAbs.setText(rowItem.getCONFERENCE_NAME());
        holder.txtNgayAbs.setText("Hạn cuối:" + formattedDate);

        // xử lý xuất trạng thái bài tóm tăt
        String str_deadline = rowItem.getPAPER_TEXT_DEADLINE();
        String str_submit = rowItem.getLAST_REVISED_DATE();
        /*
        if ngay hien tai > deadline{

        } else {
                    if ngày submit_end <= deadline & trạng thái abstract null & soạn xong => Chưa duyệt
                    else
                    if ngày submit_end <= deadline & trạng thái abstract null & đang soạn anstract => đang soạn
                    else
                    if ngày submit_end <= deadline & đã duyệt => đã duyệt
                    else
                    if ngày submit_end <= deadline & từ chối => từ chối (còn hạn cho phép chỉnh sửa)
              }
        * */
        int trangthai = 1;//rowItem.getTrangthai();
        String trangthaiAbstract = "";
//        if(rowItem.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT() != null){
//            trangthaiDanhGiaAbstract = Utils.convertStringLowerCase(rowItem.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_ABSTRACT());
//        }
//        if(rowItem.getFULL_PAPER_OR_WORK_IN_PROGRESS() != null){
//            trangthaiAbstract = Utils.convertStringLowerCase(rowItem.getFULL_PAPER_OR_WORK_IN_PROGRESS());
//        }



        if(date_now.getTime() > date_deadline.getTime()){
            if( Boolean.TRUE.equals(rowItem.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT()) &&
                    date_deadline.getTime() > date_now.getTime() ){
                Log.d("--- Trạng thái:","đã duyệt 1");
                Log.d("position:", rowItem.getPOSITION()+"");
                trangthai = 1;
            }else if( Boolean.FALSE.equals(rowItem.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT())
                    ){
                Log.d("--- Trạng thái:","Từ chối 1");// từ chối do hội đồng
                trangthai = 0;
            }else if( Boolean.TRUE.equals(rowItem.getPAPER_TEXT_WITHDRAWN()) ){
                trangthai = 4;// rút bài
            }else if(
                    Boolean.TRUE.equals(rowItem.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT()) == false &&
                            Boolean.FALSE.equals(rowItem.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT()) == false &&
                            Boolean.TRUE.equals(rowItem.getPAPER_TEXT_WITHDRAWN()) == false &&
                            Boolean.FALSE.equals(rowItem.getPAPER_TEXT_WITHDRAWN()) == false
                    ){
                Log.d("--- Trạng thái:","Từ chối 1");// từ chối vi đã gửi bài mà quá deadline vẫn chưa duyệt
                trangthai = 0;
            }else{
                Log.d("--- Trạng thái:","Từ chối 1");// từ chối vi đã gửi bài mà quá deadline vẫn chưa duyệt
                trangthai = 0;
            }
        }else{
            if( Boolean.TRUE.equals(rowItem.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT())  &&
                    date_deadline.getTime() > date_now.getTime()){
                Log.d("--- Trạng thái:","đã duyệt 2");
                Log.d("position:", rowItem.getPOSITION()+"");
                trangthai = 1;
            }else if( Boolean.FALSE.equals(rowItem.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT()) ){
                Log.d("--- Trạng thái:","Từ chối 2" );// từ chối khi deadline chưa hết
                trangthai = 0;
            }else if( Boolean.TRUE.equals(rowItem.getPAPER_TEXT_WITHDRAWN()) ){
                Log.d("--- Trang thái:", "Rút bài2=" + rowItem.getPAPER_TEXT_WITHDRAWN());
                trangthai = 4;
            }else if(Boolean.TRUE.equals(rowItem.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT()) == false &&
                    Boolean.FALSE.equals(rowItem.getFINAL_APPROVAL_OR_REJECTION_OF_PAPER_TEXT()) == false &&
                    Boolean.TRUE.equals(rowItem.getPAPER_TEXT_WITHDRAWN()) == false &&
                    Boolean.FALSE.equals(rowItem.getPAPER_TEXT_WITHDRAWN()) == false){
                Log.d("--- Trạng thái:","chờ duyệt 2");
                trangthai = 2;
            }else{
                Log.d("--- Trạng thái:","Từ chối 2" );// từ chối khi deadline chưa hết
                trangthai = 0;
            }
        }
        /*

         */

        switch (trangthai) {
            case 0:
                holder.txtTrangThaiAbs.setText("Từ chối");
                holder.txtTrangThaiAbs.setBackgroundResource(R.drawable.shape_red);
                holder.txtTrangThaiAbs.setTextColor(Color.parseColor("#f44336"));
                holder.imgStatus.setImageResource(R.drawable.status_red);
                //hiển thị chức năng hiển thị

                holder.ln_Xoa.setVisibility(View.VISIBLE);
                holder.ln_Capnhat.setVisibility(View.VISIBLE);
                // ẩn
                holder.ln_XemDanhGia.setVisibility(View.GONE);


                holder.ln_Guibaibao_Daduyet.setVisibility(View.GONE);
                holder.ln_Xemthongtin_Daduyet.setVisibility(View.GONE);
                holder.ln_XemDanhGia_Daduyet.setVisibility(View.GONE);
                holder.ln_Rutbai_Choduyet.setVisibility(View.GONE);
                holder.ln_XemThongtin_Choduyet.setVisibility(View.GONE);
                holder.ln_Rutbai_Dangsoan.setVisibility(View.GONE);
                holder.ln_Capnhat_Dangsoan.setVisibility(View.GONE);
                break;
            case 1:
                holder.txtTrangThaiAbs.setText("Đã duyệt");
                holder.txtTrangThaiAbs.setBackgroundResource(R.drawable.shape_green);
                holder.txtTrangThaiAbs.setTextColor(Color.parseColor("#00E676"));
                holder.imgStatus.setImageResource(R.drawable.status_green);
                // ẩn
                holder.ln_XemDanhGia.setVisibility(View.GONE);
                holder.ln_Xoa.setVisibility(View.GONE);
                holder.ln_Capnhat.setVisibility(View.GONE);
                holder.ln_Rutbai_Choduyet.setVisibility(View.GONE);
                holder.ln_XemThongtin_Choduyet.setVisibility(View.GONE);
                holder.ln_Rutbai_Dangsoan.setVisibility(View.GONE);
                holder.ln_Capnhat_Dangsoan.setVisibility(View.GONE);


                holder.ln_Guibaibao_Daduyet.setVisibility(View.GONE);
                holder.ln_XemDanhGia_Daduyet.setVisibility(View.GONE);
                // hiển thị chức năng

                holder.ln_Xemthongtin_Daduyet.setVisibility(View.VISIBLE);

                break;
            case 2:
                holder.txtTrangThaiAbs.setText("Chờ duyệt");
                holder.txtTrangThaiAbs.setBackgroundResource(R.drawable.shape_yellows);
                holder.txtTrangThaiAbs.setTextColor(Color.parseColor("#FF9800"));
                holder.imgStatus.setImageResource(R.drawable.status_yellows);
                //ẩn
                holder.ln_XemDanhGia.setVisibility(View.GONE);
                holder.ln_Xoa.setVisibility(View.GONE);
                holder.ln_Capnhat.setVisibility(View.GONE);
                holder.ln_Guibaibao_Daduyet.setVisibility(View.GONE);
                holder.ln_Xemthongtin_Daduyet.setVisibility(View.GONE);
                holder.ln_XemDanhGia_Daduyet.setVisibility(View.GONE);
                holder.ln_Rutbai_Dangsoan.setVisibility(View.GONE);
                holder.ln_Capnhat_Dangsoan.setVisibility(View.GONE);

                //hiện

                holder.ln_Rutbai_Choduyet.setVisibility(View.VISIBLE);
                holder.ln_Capnhat_Dangsoan.setVisibility(View.VISIBLE);
                holder.ln_XemThongtin_Choduyet.setVisibility(View.VISIBLE);
                break;
            case 3:
                holder.txtTrangThaiAbs.setText("Đang soạn");
                holder.txtTrangThaiAbs.setBackgroundResource(R.drawable.shape_yellows);
                holder.txtTrangThaiAbs.setTextColor(Color.parseColor("#FF9800"));
                holder.imgStatus.setImageResource(R.drawable.status_yellows);
                //ẩn
                holder.ln_XemDanhGia.setVisibility(View.GONE);
                holder.ln_Xoa.setVisibility(View.GONE);
                holder.ln_Capnhat.setVisibility(View.GONE);
                holder.ln_Guibaibao_Daduyet.setVisibility(View.GONE);
                holder.ln_Xemthongtin_Daduyet.setVisibility(View.GONE);
                holder.ln_XemDanhGia_Daduyet.setVisibility(View.GONE);
                holder.ln_Rutbai_Choduyet.setVisibility(View.GONE);
                holder.ln_XemThongtin_Choduyet.setVisibility(View.GONE);
                //hiện
                holder.ln_Rutbai_Dangsoan.setVisibility(View.VISIBLE);
                holder.ln_Capnhat_Dangsoan.setVisibility(View.VISIBLE);
                break;
            case 4:
                holder.txtTrangThaiAbs.setText("Rút bài");
                holder.txtTrangThaiAbs.setBackgroundResource(R.drawable.shape_red);
                holder.txtTrangThaiAbs.setTextColor(Color.parseColor("#f44336"));
                holder.imgStatus.setImageResource(R.drawable.status_red);
                //ẩn
                holder.ln_XemDanhGia.setVisibility(View.GONE);
                holder.ln_Xoa.setVisibility(View.GONE);
                holder.ln_Capnhat.setVisibility(View.GONE);
                holder.ln_Guibaibao_Daduyet.setVisibility(View.GONE);
                holder.ln_Xemthongtin_Daduyet.setVisibility(View.GONE);
                holder.ln_XemDanhGia_Daduyet.setVisibility(View.GONE);
                holder.ln_Rutbai_Choduyet.setVisibility(View.GONE);
                holder.ln_XemThongtin_Choduyet.setVisibility(View.GONE);
                holder.ln_Rutbai_Dangsoan.setVisibility(View.GONE);
                holder.ln_Capnhat_Dangsoan.setVisibility(View.GONE);

                break;
            default:
                holder.txtTrangThaiAbs.setText("Đang soạn");
                holder.txtTrangThaiAbs.setBackgroundResource(R.drawable.shape_yellows);
                holder.txtTrangThaiAbs.setTextColor(Color.parseColor("#FF9800"));
                holder.imgStatus.setImageResource(R.drawable.status_yellows);
                //ẩn
                holder.ln_XemDanhGia.setVisibility(View.GONE);
                holder.ln_Xoa.setVisibility(View.GONE);
                holder.ln_Capnhat.setVisibility(View.GONE);
                holder.ln_Guibaibao_Daduyet.setVisibility(View.GONE);
                holder.ln_Xemthongtin_Daduyet.setVisibility(View.GONE);
                holder.ln_XemDanhGia_Daduyet.setVisibility(View.GONE);
                holder.ln_Rutbai_Choduyet.setVisibility(View.GONE);
                holder.ln_XemThongtin_Choduyet.setVisibility(View.GONE);
                //hiện
                holder.ln_Rutbai_Dangsoan.setVisibility(View.VISIBLE);
                holder.ln_Capnhat_Dangsoan.setVisibility(View.VISIBLE);
                break;
        }
        holder.ln_abstract.setVisibility(View.VISIBLE);
        holder.ln_listfunc_abstract.setVisibility(View.GONE);

        return convertView;
    }

    //end
}
