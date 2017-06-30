package cse.duytan.coms.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.DescriptionPackage;

/**
 * Created by Pham Van Thien on 6/28/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ListDescriptionPackageAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DescriptionPackage> list;

    public ListDescriptionPackageAdapter(Context context, ArrayList<DescriptionPackage> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        OneItem oneItem;
        if (v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.item_lisst_description_package, viewGroup, false);
            oneItem = new OneItem(v);
            v.setTag(oneItem);
        } else {
            oneItem = (OneItem) v.getTag();
        }
        DescriptionPackage item = list.get(i);
        oneItem.tvName.setText(item.getName());
        if (i == 0) {
            oneItem.tvLineTop.setVisibility(View.GONE);
        } else if (i == (list.size() - 1)) {
            oneItem.tvLineBottom.setVisibility(View.GONE);
        }else{
            oneItem.tvLineTop.setVisibility(View.VISIBLE);
            oneItem.tvLineBottom.setVisibility(View.VISIBLE);
        }
        return v;
    }

    class OneItem {
        TextView tvName, tvLineTop, tvLineBottom;

        public OneItem(View v) {
            tvName = (TextView) v.findViewById(R.id.tvName);
            tvLineTop = (TextView) v.findViewById(R.id.tvLineTop);
            tvLineBottom = (TextView) v.findViewById(R.id.tvLineBottom);
        }

    }
}
