package cse.duytan.coms.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cse.duytan.coms.R;
import cse.duytan.coms.adapters.ScheduleInHomeAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {
    private ListView listView;
    private TextView tv_currentDate;
    private Date currentDate = new Date();
    public ScheduleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        setUpListView(view);
        initUI(view);
        return view;
    }

    private void initUI(View view) {
        getActivity().setTitle(R.string.title_schedule);
        tv_currentDate = (TextView) view.findViewById(R.id.txtCurrentDate);

        currentDate = new Date(currentDate.getTime());
        tv_currentDate.setText(setTitle(currentDate));
    }

    public void setUpListView(View view) {
        listView = (ListView) view.findViewById(R.id.ls_schedule);
        listView.setFocusable(false);
        ArrayList<String> list = new ArrayList<>();
        list.add("1");list.add("2");
        ScheduleInHomeAdapter adapter = new ScheduleInHomeAdapter(getActivity(), list);
        listView.setAdapter(adapter);
    }

    public static String setTitle(Date date) {
        DateFormat df = new SimpleDateFormat("EEEE, d/MM/yyyy");
        String title = df.format(date);
        return title;
    }
}
