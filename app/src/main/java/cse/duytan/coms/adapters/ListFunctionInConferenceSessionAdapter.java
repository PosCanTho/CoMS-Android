package cse.duytan.coms.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.models.FunctionInSession;

/**
 * Created by Tuan Kiet on 6/27/2017.
 */

public class ListFunctionInConferenceSessionAdapter extends BaseAdapter {
    Context context;
    private ArrayList<FunctionInSession> list;

    public ListFunctionInConferenceSessionAdapter(Context context, ArrayList<FunctionInSession> list){
        this.context = context;
        this.list = list;
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
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.item_function_in_conference_session, viewGroup, false);
        }
        ImageView img = (ImageView) view.findViewById(R.id.imFuncInSession);
        TextView tvName = (TextView) view.findViewById(R.id.txNameFuncInSession);
        TextView tvTotal = (TextView) view.findViewById(R.id.tvTotalInSession);

        FunctionInSession data = list.get(i);
        img.setImageBitmap(data.getIcon());
        tvName.setText(data.nameFunction);
        tvTotal.setText(data.total);

        return view;
    }
}
