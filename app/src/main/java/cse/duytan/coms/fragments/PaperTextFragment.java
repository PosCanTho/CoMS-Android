package cse.duytan.coms.fragments;



import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;



import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.adapters.ListPaperAbstractAdapter;
import cse.duytan.coms.adapters.ListPaperTextAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaperTextFragment extends android.app.Fragment {

    ImageView imCheck1, imcheck2;

    public PaperTextFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_paper_text, container, false);
        setUpListPaperText(view);
        setUpListPaperAbstract(view);
        return view;
    }



    public void setUpListPaperText(View view) {

        ListView listView = (ListView) view.findViewById(R.id.lsPaperText);
        ArrayList<String> list = new ArrayList<>();
        ListPaperTextAdapter adapter = new ListPaperTextAdapter(getActivity(), list);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        listView.setAdapter(adapter);
    }

    public void setUpListPaperAbstract(View view) {

        ListView listView = (ListView) view.findViewById(R.id.lsPaperAbstract);
        ArrayList<String> list = new ArrayList<>();
        ListPaperAbstractAdapter adapter = new ListPaperAbstractAdapter(getActivity(), list);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        listView.setAdapter(adapter);
    }
}
