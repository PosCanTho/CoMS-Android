package cse.duytan.coms.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import java.util.ArrayList;

import cse.duytan.coms.R;

/**
 * Created by Tuan Kiet on 7/3/2017.
 */

public class DownloadDocumentsAdapter extends BaseAdapter {
    Context context;
    private ArrayList<String> list;
    public DownloadDocumentsAdapter(Context context, ArrayList<String> list){
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

            view = LayoutInflater.from(context).inflate(R.layout.item_download_document, viewGroup, false);
        }
        return view;
    }
}
