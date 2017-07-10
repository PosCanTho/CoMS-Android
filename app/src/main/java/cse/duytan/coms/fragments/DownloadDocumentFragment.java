package cse.duytan.coms.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;


import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.adapters.DownloadDocumentsAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DownloadDocumentFragment extends android.app.Fragment {


    public DownloadDocumentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_download_document, container, false);
        setUp(view);
        setHasOptionsMenu(true);
        return view;
    }

    public void setUp(View view) {

        DownloadDocumentsAdapter adapter;
        ListView listView = (ListView) view.findViewById(R.id.lsDownload);
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        adapter = new DownloadDocumentsAdapter(getActivity(), list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView imCheck = (ImageView) view.findViewById(R.id.imCheck);
                imCheck.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.filter_download, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}
