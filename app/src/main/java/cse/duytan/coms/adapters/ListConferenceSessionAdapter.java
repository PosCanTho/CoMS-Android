package cse.duytan.coms.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.ConferenceSession;
import cse.duytan.coms.untils.AdapterCallback;

/**
 * Created by Tuan Kiet on 6/26/2017.
 */

public class ListConferenceSessionAdapter extends RecyclerView.Adapter<ListConferenceSessionAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ConferenceSession> list;
    private AdapterCallback adapterCallback;


    public ListConferenceSessionAdapter(Context context, ArrayList<ConferenceSession> list, AdapterCallback adapterCallback) {
        this.context = context;
        this.list = list;
        this.adapterCallback = adapterCallback;
    }

    @Override
    public ListConferenceSessionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conference_session, parent, false);
        return new ListConferenceSessionAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final ConferenceSession item = list.get(position);
        holder.tvNo.setText(String.valueOf(position+1));
        holder.tvNameConSess.setText(item.getConferenceSessionName());
        holder.tvMainTopic.setText(item.getConferenceSessionTopicName());

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

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNo, tvNameConSess, tvMainTopic;
        public ViewHolder(View itemView) {
            super(itemView);
            tvNo = (TextView) itemView.findViewById(R.id.tvNO1);
            tvNameConSess = (TextView) itemView.findViewById(R.id.tvNameConSess);
            tvMainTopic = (TextView) itemView.findViewById(R.id.tvMainTopic);

        }
    }
}
