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
import cse.duytan.coms.models.Organization;
import cse.duytan.coms.untils.AdapterCallback;

/**
 * Created by iMac on 8/30/17.
 */

public class OrganizationAdapter extends RecyclerView.Adapter<OrganizationAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Organization> list;
    private AdapterCallback adapterCallback;
    private View v;

    public OrganizationAdapter(Context context, ArrayList<Organization> list, AdapterCallback adapterCallback) {
        this.context = context;
        this.list = list;
        this.adapterCallback = adapterCallback;
    }

    @Override
    public OrganizationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_organization, parent, false);
        return new OrganizationAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Organization item = list.get(position);
        holder.tvOrganizationName1.setText(item.getORGANIZATION_NAME());
        holder.tvOrganizationCode1.setText(item.getORGANIZATION_CODE());
        holder.tvOrganizationTelephone1.setText(item.getORGANIZATION_TELEPHONE());
        holder.tvOrganizationEmail1.setText(item.getORGANIZATION_EMAIL());
        holder.tvOrganizationAddress1.setText(item.getADDRESS());
        holder.tvOrganizationWebsite1.setText(item.getORGANIZATION_WEBSITE());
        holder.tvOrganizationDescription1.setText(item.getDESCRIPTION());
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
        public TextView tvOrganizationName1,tvOrganizationCode1,tvOrganizationTelephone1,tvOrganizationEmail1,tvOrganizationAddress1,tvOrganizationWebsite1,tvOrganizationDescription1;
        public ImageView imLogo1;
        public ViewHolder(View itemView) {
            super(itemView);
            tvOrganizationName1 = (TextView) itemView.findViewById(R.id.tvOrganizationName1);
            tvOrganizationCode1 = (TextView) itemView.findViewById(R.id.tvOrganizationCode1);
            tvOrganizationTelephone1 = (TextView) itemView.findViewById(R.id.tvOrganizationTelephone1);
            tvOrganizationEmail1 = (TextView) itemView.findViewById(R.id.tvOrganizationEmail1);
            tvOrganizationAddress1 = (TextView) itemView.findViewById(R.id.tvOrganizationAddress1);
            tvOrganizationWebsite1 = (TextView) itemView.findViewById(R.id.tvOrganizationWebsite1);
            tvOrganizationDescription1 = (TextView) itemView.findViewById(R.id.tvOrganizationDescription1);
            imLogo1 = (ImageView) itemView.findViewById(R.id.imLogo1);
        }
    }
}