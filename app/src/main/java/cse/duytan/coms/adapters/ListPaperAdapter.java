package cse.duytan.coms.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.PaperText;
import cse.duytan.coms.untils.AdapterCallback;

/**
 * Created by iMac on 8/15/17.
 */

public class ListPaperAdapter extends RecyclerView.Adapter<ListPaperAdapter.ViewHolder> {
    private Context context;
    private ArrayList<PaperText> list;
    private AdapterCallback adapterCallback;

    public ListPaperAdapter(Context context, ArrayList<PaperText> list, AdapterCallback adapterCallback) {
        this.context = context;
        this.list = list;
        this.adapterCallback = adapterCallback;
    }

    @Override
    public ListPaperAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_paper, parent, false);
        return new ListPaperAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ListPaperAdapter.ViewHolder holder, final int position) {
        final PaperText item = list.get(position);

        holder.tvPaper.setText(String.valueOf(position+1));
        holder.tvNamePaperText.setText(item.getPaperTextTitle1());
        Log.i("", "onBindViewHolder: "+item.getPaperTextTitle1());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterCallback.adpaterCallback(item, 115, position);
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
        public TextView tvPaper, tvNamePaperText;
        public ViewHolder(View itemView) {
            super(itemView);
            tvPaper = (TextView) itemView.findViewById(R.id.tvPaper);
            tvNamePaperText = (TextView) itemView.findViewById(R.id.tvNamePaperText);
        }
    }
}
