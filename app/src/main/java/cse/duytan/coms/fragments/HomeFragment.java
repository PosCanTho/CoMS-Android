package cse.duytan.coms.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.adapters.HomeAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends android.app.Fragment {

    private TextView tvNameAccount, tvLocation, tvDate;
    private ArrayList<String> listData;
    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //getActivity().setTitle("Lịch trình");
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initUI(view);
        loadData();
        setUp(view);
        setHasOptionsMenu(true);
        return view;
    }

    private void loadData() {
        listData = new ArrayList<>();
        listData.add("1");
        listData.add("2");
        listData.add("1");
        listData.add("1");
        listData.add("1");
        listData.add("1");
        listData.add("1");
    }

    private void initUI(View view) {
        getActivity().setTitle(R.string.title_home);
        tvNameAccount = (TextView) view.findViewById(R.id.tv_name_acccount_home);
        tvLocation = (TextView) view.findViewById(R.id.tv_location_home);
        tvDate = (TextView) view.findViewById(R.id.tv_date_home);
    }

    private void setUp(View view) {
        HomeAdapter homeAdapter;
        ListView list = (ListView) view.findViewById(R.id.lsHome);

        homeAdapter = new HomeAdapter(getActivity(), listData);
        list.setAdapter(homeAdapter);
    }

}
