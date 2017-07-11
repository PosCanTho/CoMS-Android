package cse.duytan.coms.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.MenuApp;

/**
 * Created by Tuan Kiet on 6/22/2017.
 */

public class MenuAdapter extends BaseAdapter {
    private ArrayList<MenuApp> list;
    private Context context;

    public MenuAdapter(Context context, ArrayList<MenuApp> menuApp) {
        this.context = context;
        this.list = menuApp;
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
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        OneItem oneItem;
        if (v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.item_menu, viewGroup, false);
            oneItem = new OneItem(v);
            v.setTag(oneItem);
        } else {
            oneItem = (OneItem) v.getTag();
        }
        MenuApp data = list.get(i);
        oneItem.tvName.setText(data.getName());
        oneItem.tvTotal.setText(data.getTotal());
        oneItem.ivIcon.setImageResource(data.getIcon());
        return v;
    }

    private class OneItem {
        TextView tvName, tvTotal;
        ImageView ivIcon;

        public OneItem(View v) {
            tvName = (TextView) v.findViewById(R.id.tvName);
            tvTotal = (TextView) v.findViewById(R.id.tvTotal);
            ivIcon = (ImageView) v.findViewById(R.id.ivIcon);
        }
    }
}
