package cse.duytan.coms.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.activities.ProfileActivity;
import cse.duytan.coms.adapters.ListAttendeeAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttendeeFragment extends android.app.Fragment {


    public AttendeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attendee, container, false);
        setUp(view);
        initUI();
        return view;
    }

    private void initUI() {
        getActivity().setTitle(R.string.title_attendee);
    }

    public void setUp(View view) {
        ListView listView = (ListView) view.findViewById(R.id.lsAttendee);
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        ListAttendeeAdapter adapter = new ListAttendeeAdapter(getActivity(), list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), ProfileActivity.class));
            }
        });
    }
}
