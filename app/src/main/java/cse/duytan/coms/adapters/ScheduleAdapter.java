package cse.duytan.coms.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.Schedule;
import cse.duytan.coms.untils.AdapterCallback;
import cse.duytan.coms.untils.DateTimeFormater;

/**
 * Created by iMac on 9/1/17.
 */

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Schedule> list;
    private AdapterCallback adapterCallback;
    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();

    public ScheduleAdapter(Context context, ArrayList<Schedule> list, AdapterCallback adapterCallback) {
        this.context = context;
        this.list = list;
        this.adapterCallback = adapterCallback;
    }

    @Override
    public ScheduleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_on_schedule, parent, false);
        return new ScheduleAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Schedule item = list.get(position);
        holder.tvName.setText(item.getCONFERENCE_NAME());
        holder.tvNameEn.setText(item.getCONFERENCE_NAME_EN());
        holder.tvTime.setText(DateTimeFormater.stringToTime(item.getFROM_DATE(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM));



    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTime, tvName, tvNameEn;
        public ViewHolder(View itemView) {
            super(itemView);
            tvTime = (TextView) itemView.findViewById(R.id.tvTimeStart);
            tvName = (TextView) itemView.findViewById(R.id.tvNameConference);
            tvNameEn = (TextView) itemView.findViewById(R.id.tvNameConferenceEn);
        }
    }
}
