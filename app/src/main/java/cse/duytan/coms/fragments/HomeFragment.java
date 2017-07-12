package cse.duytan.coms.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.adapters.HomeAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends android.app.Fragment {


    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //getActivity().setTitle("Lịch trình");
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setUp(view);
        setHasOptionsMenu(true);
        initUI();
        return view;
    }

    private void initUI() {
        getActivity().setTitle(R.string.title_home);
    }


    private void setUp(View view) {
        HomeAdapter homeAdapter;
        ListView list = (ListView) view.findViewById(R.id.lsHome);
        ArrayList<String> listData = new ArrayList<>();
        listData.add("1");
        listData.add("2");
        listData.add("1");
        listData.add("1");
        listData.add("1");
        listData.add("1");
        listData.add("1");
        homeAdapter = new HomeAdapter(getActivity(), listData);
        list.setAdapter(homeAdapter);
    }

}
