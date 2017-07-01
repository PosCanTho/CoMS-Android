package cse.duytan.coms.adapters;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.Message;

/**
 * Created by Pham Van Thien on 6/30/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ListChatAdapter extends RecyclerView.Adapter<ListChatAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Message> list;

    public ListChatAdapter(Context context, ArrayList<Message> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler_chat, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Message item = list.get(position);
        holder.tvMessageLeft.setText(item.getMessage());
        holder.tvMessageRight.setText(item.getMessage());
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAvatarLeft, ivAvatarRight;
        TextView tvMessageLeft, tvTimeLeft, tvTimeTop, tvMessageRight, tvTimeRight;
        ConstraintLayout clLeft, clRight;

        public ViewHolder(View itemView) {
            super(itemView);
            ivAvatarLeft = (ImageView)itemView.findViewById(R.id.ivAvatarLeft);
            ivAvatarRight = (ImageView)itemView.findViewById(R.id.ivAvatarRight);
            tvMessageLeft = (TextView)itemView.findViewById(R.id.tvMessageLeft);
            tvTimeLeft = (TextView)itemView.findViewById(R.id.tvTimeLeft);
            tvTimeTop = (TextView)itemView.findViewById(R.id.tvTimeTop);
            tvMessageRight = (TextView)itemView.findViewById(R.id.tvMessageRight);
            tvTimeRight = (TextView)itemView.findViewById(R.id.tvTimeRight);
            clLeft = (ConstraintLayout)itemView.findViewById(R.id.clLeft);
            clRight = (ConstraintLayout)itemView.findViewById(R.id.clRight);
        }
    }
}
