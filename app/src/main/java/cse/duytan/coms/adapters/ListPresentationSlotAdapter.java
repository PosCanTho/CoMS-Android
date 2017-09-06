package cse.duytan.coms.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.PresentationSlot;
import cse.duytan.coms.untils.AdapterCallback;
import cse.duytan.coms.untils.DateTimeFormater;

/**
 * Created by Pham Van Thien on 6/15/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ListPresentationSlotAdapter extends RecyclerView.Adapter<ListPresentationSlotAdapter.ViewHolder> {
    private Context context;
    private ArrayList<PresentationSlot> list;
    private AdapterCallback adapterCallback;

    public ListPresentationSlotAdapter(Context context, ArrayList<PresentationSlot> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ListPresentationSlotAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_presentation_slot, parent, false);
        return new ListPresentationSlotAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final PresentationSlot item = list.get(position);

        holder.tvNO2.setText(String.valueOf(position+1));
        holder.tvNamePresenter.setText(item.getCurrentFullName());
        holder.tvNamePaperTextTitle.setText(item.getPAPER_TEXT_TITLE_1());
        holder.tvStartDatetime.setText(DateTimeFormater.stringToTime(item.getACTUAL_PRESENTATION_SLOT_START_DATETIME(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));
        holder.tvEndDatetime.setText(DateTimeFormater.stringToTime(item.getACTUAL_PRESENTATION_SLOT_END_DATETIME(), DateTimeFormater.YYYY_MM_DD_T_HH_MM_SS_SS, DateTimeFormater.HH_MM_DD_MM_YYYY));

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                adapterCallback.adpaterCallback(item, 99, position);
//            }
//        });
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
        public TextView tvNO2, tvNamePresenter, tvNamePaperTextTitle, tvStartDatetime, tvEndDatetime;
        public ViewHolder(View itemView) {
            super(itemView);
            tvNO2 = (TextView) itemView.findViewById(R.id.tvNO2);
            tvNamePresenter = (TextView) itemView.findViewById(R.id.tvNamePresenter);
            tvNamePaperTextTitle = (TextView) itemView.findViewById(R.id.tvNamePaperTextTitle);
            tvStartDatetime = (TextView) itemView.findViewById(R.id.tvStartDatetime);
            tvEndDatetime = (TextView) itemView.findViewById(R.id.tvEndDatetime);
        }
    }
}