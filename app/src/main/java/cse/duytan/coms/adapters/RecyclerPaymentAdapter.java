package cse.duytan.coms.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.PaymentMethod;
import cse.duytan.coms.untils.AdapterCallback;

/**
 * Created by Pham Van Thien on 6/30/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class RecyclerPaymentAdapter extends RecyclerView.Adapter<RecyclerPaymentAdapter.ViewHolder> {
    private Context context;
    private ArrayList<PaymentMethod> list;
    private AdapterCallback adapterCallback;

    public RecyclerPaymentAdapter(Context context, ArrayList<PaymentMethod> list, AdapterCallback adapterCallback) {
        this.context = context;
        this.list = list;
        this.adapterCallback = adapterCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler_pagment_method, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final PaymentMethod item = list.get(position);
        holder.tvName.setText(item.getName());
        holder.ivImage.setImageBitmap(item.getBitmap());
        if (item.isSelected()) {
            holder.clMain.setBackgroundColor(context.getResources().getColor(R.color.teal));
        } else {
            holder.clMain.setBackgroundColor(context.getResources().getColor(R.color.white));
        }
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


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivImage;
        ConstraintLayout clMain;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
            clMain = (ConstraintLayout) itemView.findViewById(R.id.clMain);
        }
    }
}
