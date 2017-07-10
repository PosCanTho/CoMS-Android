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
import cse.duytan.coms.adapters.ReviewAdapter1;
import cse.duytan.coms.models.Review;


public class RejectFragment extends ListFragment {
    private ListView listView;
    private ArrayList<Review> arrReject;
    private ReviewAdapter1 adapter1;
    private Animation animation, animation_abs;
    private LinearLayout ln, ln_func, ln_row_reject;

    public RejectFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_reject, container, false);
//        listView = (ListView) rootView.findViewById(R.id.lv_reject);//
        loadListReview();
        return rootView;
    }

    private void loadListReview(){
        arrReject = new ArrayList<>();
        addArrNotYetEvaluat();
        adapter1 = new ReviewAdapter1(this.getActivity(), android.R.id.list, arrReject);
        setListAdapter(adapter1);
//        listView.setAdapter(adapter1);
    }


    private void addArrNotYetEvaluat(){
        arrReject.add(new Review("Bài tóm tăt 10", 1, "Ngày gửi: 7/7/2017","207 Nguyễn Văn Linh, Phòng 01"));
        arrReject.add(new Review("Bài tóm tăt 11", 1, "Ngày gửi: 8/7/2017","207 Nguyễn Văn Linh, Phòng 02"));
        arrReject.add(new Review("Bài tóm tăt 12", 1, "Ngày gửi: 9/7/2017","207 Nguyễn Văn Linh, Phòng 03"));
        arrReject.add(new Review("Bài tóm tăt 13", 1, "Ngày gửi: 10/7/2017","207 Nguyễn Văn Linh, Phòng 04"));
        arrReject.add(new Review("Bài tóm tăt 14", 1, "Ngày gửi: 11/7/2017","207 Nguyễn Văn Linh, Phòng 05"));
        arrReject.add(new Review("Bài tóm tăt 15", 1, "Ngày gửi: 12/7/2017","207 Nguyễn Văn Linh, Phòng 06"));
        arrReject.add(new Review("Bài tóm tăt 16", 1, "Ngày gửi: 13/7/2017","207 Nguyễn Văn Linh, Phòng 07"));
        arrReject.add(new Review("Bài tóm tăt 17", 1, "Ngày gửi: 14/7/2017","207 Nguyễn Văn Linh, Phòng 08"));
        arrReject.add(new Review("Bài tóm tăt 18", 1, "Ngày gửi: 15/7/2017","207 Nguyễn Văn Linh, Phòng 09"));
    }

}
