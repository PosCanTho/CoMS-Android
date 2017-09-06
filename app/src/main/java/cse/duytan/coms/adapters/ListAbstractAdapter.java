package cse.duytan.coms.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.PaperAbstract;
import cse.duytan.coms.untils.AdapterCallback;

/**
 * Created by iMac on 8/21/17.
 */

public class ListAbstractAdapter extends RecyclerView.Adapter<ListAbstractAdapter.ViewHolder> {
    private Context context;
    private ArrayList<PaperAbstract> list;
    private AdapterCallback adapterCallback;

    public ListAbstractAdapter(Context context, ArrayList<PaperAbstract> list, AdapterCallback adapterCallback) {
        this.context = context;
        this.list = list;
        this.adapterCallback = adapterCallback;
    }

    @Override
    public ListAbstractAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_paper, parent, false);
        return new ListAbstractAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ListAbstractAdapter.ViewHolder holder, final int position) {
        final PaperAbstract item = list.get(position);

//        holder.tvPaper.setText(String.valueOf(position+1));
//        holder.tvNamePaperText.setText(item.getPaperTextTitle1());
//        Log.i("", "onBindViewHolder: "+item.getPaperTextTitle1());
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                adapterCallback.adpaterCallback(item, 115, position);
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
        public TextView tvPaper, tvNamePaperText;
        public ViewHolder(View itemView) {
            super(itemView);
            tvPaper = (TextView) itemView.findViewById(R.id.tvPaper);
            tvNamePaperText = (TextView) itemView.findViewById(R.id.tvNamePaperText);
        }
    }
}
