package cse.duytan.coms.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.activities.ConferenceInfomationActivity;
import cse.duytan.coms.adapters.ConferenceAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConferenceFragment extends android.app.Fragment {


    public ConferenceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conference, container, false);
        setUp(view);
        setHasOptionsMenu(true);
        return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.filter_conference, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void setUp(View view) {
        ConferenceAdapter adapter;
        ListView list = (ListView) view.findViewById(R.id.lsCon);
        ArrayList<String> listData = new ArrayList<>();
        listData.add("1");
        listData.add("2");
        listData.add("1");
        listData.add("1");
        listData.add("1");
        listData.add("1");
        listData.add("1");
        adapter = new ConferenceAdapter(getActivity(), listData);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ConferenceInfomationActivity.class);
                startActivity(intent);
            }
        });
    }
}
