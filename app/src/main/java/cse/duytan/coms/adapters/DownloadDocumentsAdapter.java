package cse.duytan.coms.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cse.duytan.coms.R;

/**
 * Created by Tuan Kiet on 7/3/2017.
 */

public class DownloadDocumentsAdapter extends RecyclerView.Adapter<DownloadDocumentsAdapter.ViewHolder> {
    private Context context;
    private ArrayList<String> list;


    public DownloadDocumentsAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public DownloadDocumentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_download_document, parent, false);
        return new DownloadDocumentsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DownloadDocumentsAdapter.ViewHolder holder, int position) {

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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImageView imCheck = (ImageView) view.findViewById(R.id.imCheck);
                    imCheck.setVisibility(View.VISIBLE);
                }
            });
        }
    }
}
