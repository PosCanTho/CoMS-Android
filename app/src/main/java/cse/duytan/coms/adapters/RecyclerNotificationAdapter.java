package cse.duytan.coms.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.Conversation;
import cse.duytan.coms.models.Notification;
import cse.duytan.coms.untils.AdapterCallback;
import cse.duytan.coms.untils.DateTimeFormater;
import cse.duytan.coms.untils.Utils;

/**
 * Created by Pham Van Thien on 6/27/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class RecyclerNotificationAdapter extends RecyclerView.Adapter<RecyclerNotificationAdapter.ViewHolder> {
    private ArrayList<Notification> list;
    private AdapterCallback adapterCallback;
    private Context context;

    public RecyclerNotificationAdapter(Context context, ArrayList<Notification> list, @NonNull AdapterCallback adapterCallback) {
        this.context = context;
        this.list = list;
        this.adapterCallback = adapterCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_notification, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Notification notification = list.get(position);
        if (notification.isReaded()) {
            holder.tvMessage.setTypeface(Utils.getFonts(context, R.string.font_roboto_regular));
        } else {
            holder.tvMessage.setTypeface(Utils.getFonts(context, R.string.font_roboto_bold));
        }
        holder.tvMessage.setText(notification.getTitle() + ": " + notification.getMessage());
        holder.tvStartDate.setText(DateTimeFormater.stringToTime(notification.getCreateDate(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
        holder.clMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterCallback.adpaterCallback(notification, R.id.clMain, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvStartDate, tvMessage;
        ConstraintLayout clMain;

        public ViewHolder(View itemView) {
            super(itemView);
            tvStartDate = (TextView) itemView.findViewById(R.id.tvStartDate);
            tvMessage = (TextView) itemView.findViewById(R.id.tvMessage);
            clMain = (ConstraintLayout) itemView.findViewById(R.id.clMain);
        }
    }
}
