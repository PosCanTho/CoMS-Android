package cse.duytan.coms.adapters;

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
import cse.duytan.coms.models.Message;
import cse.duytan.coms.untils.AdapterCallback;
import cse.duytan.coms.untils.Constants;

/**
 * Created by Pham Van Thien on 6/27/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class RecyclerMessageAdapter extends RecyclerView.Adapter<RecyclerMessageAdapter.ViewHolder> {
    private ArrayList<Conversation> listMessage;
    private AdapterCallback adapterCallback;

    public RecyclerMessageAdapter(ArrayList<Conversation> listMessage, @NonNull AdapterCallback adapterCallback) {
        this.listMessage = listMessage;
        this.adapterCallback = adapterCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_message, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Conversation conversation = listMessage.get(position);
        holder.tvName.setText(conversation.getName());
        holder.tvMessage.setText(conversation.getMessage());
        holder.clMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterCallback.adpaterCallback(conversation, R.id.clMain, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMessage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvMessage;
        ConstraintLayout clMain;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvMessage = (TextView) itemView.findViewById(R.id.tvMessage);
            clMain = (ConstraintLayout) itemView.findViewById(R.id.clMain);
        }
    }
}
