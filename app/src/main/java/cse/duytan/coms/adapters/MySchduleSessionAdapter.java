package cse.duytan.coms.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cse.duytan.coms.R;
import cse.duytan.coms.sqlite.DatabasePresentationSlot;
import cse.duytan.coms.untils.AdapterCallback;
import cse.duytan.coms.untils.DateTimeFormater;

/**
 * Created by iMac on 8/29/17.
 */

public class MySchduleSessionAdapter extends RecyclerView.Adapter<MySchduleSessionAdapter.ViewHolder> {

    private Context context;
    private List<DatabasePresentationSlot> list;
    private AdapterCallback adapterCallback;

    public MySchduleSessionAdapter(Context context, List<DatabasePresentationSlot> list, AdapterCallback adapterCallback) {
        this.context = context;
        this.list = list;
        this.adapterCallback = adapterCallback;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_schedule, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final DatabasePresentationSlot item = list.get(position);
        holder.tvNameConSessinMySchedule.setText(item.getPAPER_TEXT_TITLE_1());
        holder.tvMyPresenterFullName.setText(item.getCurrentFullName());
        holder.tvMyStartTime.setText(DateTimeFormater.stringToTime(item.getACTUAL_PRESENTATION_SLOT_START_DATETIME(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
        holder.tvMyRoom.setText(item.getFACILITY_NAME());

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
        public TextView tvNameConSessinMySchedule, tvMyPresenterFullName, tvMyStartTime, tvMyRoom;
        public ImageView imgAddSchedule;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNameConSessinMySchedule = (TextView) itemView.findViewById(R.id.tvNameConSessinMySchedule);
            tvMyPresenterFullName = (TextView) itemView.findViewById(R.id.tvMyPresenterFullName);
            tvMyStartTime = (TextView) itemView.findViewById(R.id.tvMyStartTime);
            tvMyRoom = (TextView) itemView.findViewById(R.id.tvMyRoom);
        }
    }
}
