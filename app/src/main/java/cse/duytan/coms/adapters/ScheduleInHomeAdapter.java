package cse.duytan.coms.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import cse.duytan.coms.R;

/**
 * Created by Tuan Kiet on 7/4/2017.
 */

public class ScheduleInHomeAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> list;

    public ScheduleInHomeAdapter(Context context, ArrayList<String> list){
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
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_list_schedule, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.tv_calotegy);
        textView.setBackgroundColor(Color.parseColor(Random()));
        return view;
    }

    private String Random() {
        int a;
        String[] colorCato = {"#FF9800","#F4FF81","#E65100", "#9E9E9E","#607D8B","#795548"};
        Random r = new Random();
        a = r.nextInt(colorCato.length);
        return colorCato[a];
    }
}
