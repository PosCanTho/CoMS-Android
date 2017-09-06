package cse.duytan.coms.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.Conference;
import cse.duytan.coms.untils.AdapterCallback;
import cse.duytan.coms.untils.DateTimeFormater;

/**
 * Created by Tuan Kiet on 6/22/2017.
 */

public class ConferenceAdapter extends RecyclerView.Adapter<ConferenceAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Conference> list;
    private ArrayList<Conference> listDefault;
    private AdapterCallback adapterCallback;
    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();

    public ConferenceAdapter(Context context, ArrayList<Conference> list, AdapterCallback adapterCallback) {
        this.context = context;
        this.list = list;
        this.listDefault = list;
        this.adapterCallback = adapterCallback;
    }

    public void search(String searching) {
        if (TextUtils.isEmpty(searching)) {
            list = listDefault;
            notifyDataSetChanged();
        } else {
            ArrayList<Conference> searchList = new ArrayList<>();
            for (Conference item : list) {
                if (item.getConferenceName().contains(searching)) {
                    searchList.add(item);
                }
            }
            list = searchList;
            notifyDataSetChanged();
        }
    }

    @Override
    public ConferenceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conference, parent, false);
        return new ConferenceAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Conference item = list.get(position);
        holder.tvName.setText(item.getConferenceName());

        CalendarDay date;
        date = CalendarDay.from(DateTimeFormater.stringToDate(item.getFromDate(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS));
        holder.tvTime.setText(FORMATTER.format(date.getDate()));
        holder.tvOgr.setText(item.getOrganizingOrganizationName1());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterCallback.adpaterCallback(item, 99, position);
            }
        });
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
        public TextView tvTime, tvName, tvOgr;
        public ViewHolder(View itemView) {
            super(itemView);
            tvTime = (TextView) itemView.findViewById(R.id.tvTimes);
            tvName = (TextView) itemView.findViewById(R.id.tvNameCons);
            tvOgr = (TextView) itemView.findViewById(R.id.tvOrgs);
        }
    }
    public void setFilter(ArrayList<Conference> newList){
        list = new ArrayList<>();
        list.addAll(newList);
        notifyDataSetChanged();
    }
}