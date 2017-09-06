package cse.duytan.coms.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.PresentationSlot;
import cse.duytan.coms.untils.AdapterCallback;
import cse.duytan.coms.untils.DateTimeFormater;

/**
 * Created by iMac on 8/24/17.
 */

public class SchdeuleSessionAdapter extends RecyclerView.Adapter<SchdeuleSessionAdapter.ViewHolder> {

    private Context context;
    private ArrayList<PresentationSlot> list;
    private AdapterCallback adapterCallback;

    public SchdeuleSessionAdapter(Context context, ArrayList<PresentationSlot> list, AdapterCallback adapterCallback) {
        this.context = context;
        this.list = list;
        this.adapterCallback = adapterCallback;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final PresentationSlot item = list.get(position);
        holder.tvNameConSessinSchedule.setText(item.getPAPER_TEXT_TITLE_1());
        holder.tvPresenterFullName.setText(item.getCurrentFullName());
        holder.tvStartTime.setText(DateTimeFormater.stringToTime(item.getACTUAL_PRESENTATION_SLOT_START_DATETIME(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
        holder.tvRoom.setText(item.getFACILITY_NAME());

        holder.imgAddSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Dòng: "+position, Toast.LENGTH_SHORT).show();
                adapterCallback.adpaterCallback(item, 113, position);
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
        public TextView tvNameConSessinSchedule, tvPresenterFullName, tvStartTime, tvRoom;
        public ImageView imgAddSchedule;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNameConSessinSchedule = (TextView) itemView.findViewById(R.id.tvNameConSessinSchedule);
            tvPresenterFullName = (TextView) itemView.findViewById(R.id.tvPresenterFullName);
            tvStartTime = (TextView) itemView.findViewById(R.id.tvStartTime);
            tvRoom = (TextView) itemView.findViewById(R.id.tvRoom);
            imgAddSchedule = (ImageView) itemView.findViewById(R.id.imgAddSchedule);
        }
    }
}