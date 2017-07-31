package cse.duytan.coms.adapters;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.Bookmark;
import cse.duytan.coms.models.Conversation;
import cse.duytan.coms.untils.AdapterCallback;

/**
 * Created by Pham Van Thien on 6/27/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class RecyclerBookmarkAdapter extends RecyclerView.Adapter<RecyclerBookmarkAdapter.ViewHolder> {
    private ArrayList<Bookmark> listBookmark;
    private AdapterCallback adapterCallback;

    public RecyclerBookmarkAdapter(ArrayList<Bookmark> listBookmark, @NonNull AdapterCallback adapterCallback) {
        this.listBookmark = listBookmark;
        this.adapterCallback = adapterCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_message, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Bookmark bookmark = listBookmark.get(position);
        holder.tvName.setText(bookmark.getNameBookmark());
        if (TextUtils.isEmpty(bookmark.getDescription())) {
            holder.tvMessage.setVisibility(View.GONE);
        } else {
            holder.tvMessage.setVisibility(View.VISIBLE);
            holder.tvMessage.setText(bookmark.getDescription());
        }
        holder.clMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterCallback.adpaterCallback(bookmark, R.id.clMain, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBookmark.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvMessage;
        ImageView ivAvatar;
        ConstraintLayout clMain;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvMessage = (TextView) itemView.findViewById(R.id.tvMessage);
            ivAvatar = (ImageView) itemView.findViewById(R.id.ivAvatar);
            clMain = (ConstraintLayout) itemView.findViewById(R.id.clMain);
        }
    }
}
