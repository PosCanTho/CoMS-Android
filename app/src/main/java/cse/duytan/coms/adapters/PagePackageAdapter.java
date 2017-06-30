package cse.duytan.coms.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.DescriptionPackage;
import cse.duytan.coms.models.Package;

/**
 * Created by Pham Van Thien on 6/28/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class PagePackageAdapter extends RecyclerView.Adapter<PagePackageAdapter.ViewHolder> {

    private ArrayList<Package> listPackage;
    private ArrayList<DescriptionPackage> listDescription;
    private Context context;

    public PagePackageAdapter(Context context, ArrayList<Package> listPackage) {
        this.listPackage = listPackage;
        this.context = context;
        listDescription = new ArrayList<>();
        listDescription.add(new DescriptionPackage(0, "Form date: 22/07/2017"));
        listDescription.add(new DescriptionPackage(1, "Thru date: 25/07/2017"));
        for (int i = 0; i < 6; i++) {
            listDescription.add(new DescriptionPackage(i + 2, "Breakfast lunch " + i));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_page_package, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Package item = listPackage.get(position);
        holder.lvDescriptionPackage.setAdapter(new ListDescriptionPackageAdapter(context, listDescription));
    }

    @Override
    public int getItemCount() {
        return listPackage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ListView lvDescriptionPackage;

        public ViewHolder(View itemView) {
            super(itemView);
            lvDescriptionPackage = (ListView) itemView.findViewById(R.id.lvDescriptionPackage);
            lvDescriptionPackage.setDivider(null);
        }
    }
}
