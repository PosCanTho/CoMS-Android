package cse.duytan.coms.adapters;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.ConferenceMap;
import cse.duytan.coms.untils.AdapterCallback;

/**
 * Created by Pham Van Thien on 8/26/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class RecyclerMapAdapter extends RecyclerView.Adapter<RecyclerMapAdapter.ViewHolder> {

    private ArrayList<ConferenceMap> list;
    private AdapterCallback adapterCallback;

    public RecyclerMapAdapter(ArrayList<ConferenceMap> list, AdapterCallback adapterCallback) {
        this.list = list;
        this.adapterCallback = adapterCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_conference_map, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ConferenceMap item = list.get(position);
        holder.tvName.setText(item.getDESCRIPTION());
        holder.clMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterCallback.adpaterCallback(item, R.id.clMain, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout clMain;
        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            clMain = (ConstraintLayout) itemView.findViewById(R.id.clMain);
        }
    }
}
