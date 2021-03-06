package cse.duytan.coms.adapters;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.Account;
import cse.duytan.coms.untils.AdapterCallback;

/**
 * Created by Pham Van Thien on 6/27/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class RecyclerNewMessageAdapter extends RecyclerView.Adapter<RecyclerNewMessageAdapter.ViewHolder> {
    private AdapterCallback adapterCallback;
    private ArrayList<Account> list;
    private ArrayList<Account> listDefault;

    public RecyclerNewMessageAdapter(@NonNull AdapterCallback adapterCallback, ArrayList<Account> list) {
        this.adapterCallback = adapterCallback;
        this.list = list;
        this.listDefault = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_new_message, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Account account = list.get(position);
        holder.tvName.setText(account.getName());
        holder.clMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapterCallback != null)
                    adapterCallback.adpaterCallback(null, R.id.clMain, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void search(String searching) {
        if (TextUtils.isEmpty(searching)) {
            list = listDefault;
            notifyDataSetChanged();
        } else {
            ArrayList<Account> searchList = new ArrayList<>();
            for (Account item : list) {
                if (item.getName().contains(searching)) {
                    searchList.add(item);
                }
            }
            list = searchList;
            notifyDataSetChanged();
        }
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
