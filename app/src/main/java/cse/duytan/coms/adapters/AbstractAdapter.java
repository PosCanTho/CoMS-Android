package cse.duytan.coms.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cse.duytan.coms.R;
import cse.duytan.coms.models.Abstract;

/**
 * Created by lehoangdung on 20/06/2017.
 */

public class AbstractAdapter extends ArrayAdapter<Abstract> {
    private Context context;


    public AbstractAdapter(Context context, int textViewResourceId, List<Abstract> objects) {
        super(context, textViewResourceId, objects);
        // TODO Auto-generated constructor stub
        this.context = context;
    }


    private class ViewHolder{
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
        ViewHolder holder = null;
        final Abstract rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
//            Log.i("===convertView===","convertView == null");
            holder = new ViewHolder();
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
        } else{
//            Log.i("===convertView===","convertView getTag");
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtThongTinAbs.setText(rowItem.getThongtin());
        holder.txtNgayAbs.setText("Hạn cuối:"+rowItem.getNgay());
        int trangthai = rowItem.getTrangthai();
        switch (trangthai){
            case 0:
                holder.txtTrangThaiAbs.setText("Từ chối");
                holder.txtTrangThaiAbs.setBackgroundResource(R.drawable.shape_red);
                holder.txtTrangThaiAbs.setTextColor(Color.parseColor("#f44336"));
                holder.imgStatus.setImageResource(R.drawable.status_red);
                //hiển thị chức năng hiển thị
                holder.ln_XemDanhGia.setVisibility(View.VISIBLE);
                holder.ln_Xoa.setVisibility(View.VISIBLE);
                holder.ln_Capnhat.setVisibility(View.VISIBLE);
                // ẩn
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
                // hiển thị chức năng
                holder.ln_Guibaibao_Daduyet.setVisibility(View.VISIBLE);
                holder.ln_Xemthongtin_Daduyet.setVisibility(View.VISIBLE);
                holder.ln_XemDanhGia_Daduyet.setVisibility(View.VISIBLE);
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
}
