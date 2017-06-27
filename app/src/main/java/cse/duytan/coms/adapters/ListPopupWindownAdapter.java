package cse.duytan.coms.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import cse.duytan.coms.R;

/**
 * Created by Pham Van Thien on 6/19/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ListPopupWindownAdapter extends BaseAdapter {
    private Context context;
    private String[] list;
    public ListPopupWindownAdapter(Context context, String[] list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        OneItem oneItem;
        if(v == null){
            v = LayoutInflater.from(context).inflate(R.layout.item_list_pupup_windown, viewGroup,false);
            oneItem = new OneItem(v);
            v.setTag(oneItem);
        }else{
            oneItem = (OneItem) v.getTag();
        }
        String name = list[i];
        oneItem.tvName.setText(name);
        return v;
    }

    class OneItem{
        TextView tvName;

        public OneItem(View v) {
            tvName = (TextView)v.findViewById(R.id.tvName);
        }
    }
}
