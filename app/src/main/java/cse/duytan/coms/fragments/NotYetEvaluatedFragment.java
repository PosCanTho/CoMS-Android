package cse.duytan.coms.fragments;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.adapters.ReviewAdapter;
import cse.duytan.coms.models.Review;


public class NotYetEvaluatedFragment extends ListFragment {
    private ListView listView;
    private ArrayList<Review> arrNotYetEvaluat;
    private ReviewAdapter adapter;
    private Animation animation, animation_abs;
    private LinearLayout ln, ln_func, ln_row_abstract;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_not_yet_evaluated, container, false);
//        listView = (ListView) rootView.findViewById(R.id.lv_not_yet);//android.R.id.list
        loadListReview();
        return rootView;
    }

    private void loadListReview(){
        arrNotYetEvaluat = new ArrayList<>();
        addArrNotYetEvaluat();
        adapter = new ReviewAdapter(this.getActivity(), android.R.id.list, arrNotYetEvaluat);// android.R.id.list android.R.layout.simple_list_item_multiple_choice
        setListAdapter(adapter);
    }

    private void addArrNotYetEvaluat(){
        arrNotYetEvaluat.add(new Review("Bài tóm tăt 1", 0, "Ngày gửi: 7/7/2017","207 Nguyễn Văn Linh, Phòng 01"));
        arrNotYetEvaluat.add(new Review("Bài tóm tăt 2", 0, "Ngày gửi: 8/7/2017","207 Nguyễn Văn Linh, Phòng 02"));
        arrNotYetEvaluat.add(new Review("Bài tóm tăt 3", 0, "Ngày gửi: 9/7/2017","207 Nguyễn Văn Linh, Phòng 03"));
        arrNotYetEvaluat.add(new Review("Bài tóm tăt 4", 0, "Ngày gửi: 10/7/2017","207 Nguyễn Văn Linh, Phòng 04"));
        arrNotYetEvaluat.add(new Review("Bài tóm tăt 5", 0, "Ngày gửi: 11/7/2017","207 Nguyễn Văn Linh, Phòng 05"));
        arrNotYetEvaluat.add(new Review("Bài tóm tăt 6", 0, "Ngày gửi: 12/7/2017","207 Nguyễn Văn Linh, Phòng 06"));
        arrNotYetEvaluat.add(new Review("Bài tóm tăt 7", 0, "Ngày gửi: 13/7/2017","207 Nguyễn Văn Linh, Phòng 07"));
        arrNotYetEvaluat.add(new Review("Bài tóm tăt 8", 0, "Ngày gửi: 14/7/2017","207 Nguyễn Văn Linh, Phòng 08"));
        arrNotYetEvaluat.add(new Review("Bài tóm tăt 9", 0, "Ngày gửi: 15/7/2017","207 Nguyễn Văn Linh, Phòng 09"));
    }

}
