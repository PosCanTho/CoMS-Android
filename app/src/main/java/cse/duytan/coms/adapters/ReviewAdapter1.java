package cse.duytan.coms.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cse.duytan.coms.R;
import cse.duytan.coms.models.Review;

/**
 * Created by DungTrungCut on 7/10/2017.
 */

public class ReviewAdapter1 extends ArrayAdapter<Review> {
    private Context context;

    public ReviewAdapter1(Context context, int resource, List<Review> objects) {
        super(context, resource, objects);
        // TODO Auto-generated constructor stub
        this.context = context;
    }

    private class ViewHolder{
        TextView txtThongTinReview, txtNgayReview, txtNameReview;
        ImageView imgStatus, imgRight;
        LinearLayout ln_review, ln_listfunc_review;
//        LinearLayout ln_XemDanhGia, ln_Xoa, ln_Capnhat;// chức năng trên 1 dòng theo trạng thái từ chối
//        LinearLayout ln_Guibaibao_Daduyet, ln_Xemthongtin_Daduyet, ln_XemDanhGia_Daduyet; // đã duyệt
//        LinearLayout ln_Rutbai_Choduyet, ln_XemThongtin_Choduyet; // chờ duyệt
//        LinearLayout ln_Rutbai_Dangsoan, ln_Capnhat_Dangsoan; // đang soan
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ReviewAdapter1.ViewHolder holder = null;
        final Review rowItem = getItem(position);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            holder = new ReviewAdapter1.ViewHolder();
            convertView = mInflater.inflate(R.layout.row_review, null);
            holder.txtNameReview = (TextView) convertView.findViewById(R.id.txtName_review);
            holder.txtNgayReview = (TextView)convertView.findViewById(R.id.txtTime_review);
            holder.txtThongTinReview = (TextView)convertView.findViewById(R.id.txtInfomation_review);
            holder.imgRight = (ImageView) convertView.findViewById(R.id.imgRight_review);
            holder.imgStatus = (ImageView) convertView.findViewById(R.id.imgTrangthai_review);
            convertView.setTag(holder);
        }else{
            holder = (ReviewAdapter1.ViewHolder) convertView.getTag();
        }


        switch (rowItem.getImgTrangthai()){
            case 0:// chưa đánh giá
                holder.imgStatus.setImageResource(R.drawable.status_yellows);
                break;
            case 1:// từ chối
                holder.imgStatus.setImageResource(R.drawable.status_red);
                break;
            case 2:// đã duyệt
                holder.imgStatus.setImageResource(R.drawable.status_green);
                break;

        }
        holder.txtNameReview.setText(rowItem.getName());
        holder.txtNgayReview.setText(rowItem.getTime());
        holder.txtThongTinReview.setText(rowItem.getInfomation());

        return convertView;
    }
}
