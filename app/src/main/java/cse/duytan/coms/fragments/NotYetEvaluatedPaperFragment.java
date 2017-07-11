package cse.duytan.coms.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.activities.SendAbstractActivity;
import cse.duytan.coms.adapters.ReviewAdapter;
import cse.duytan.coms.models.Review;

/**
 * Created by DungTrungCut on 7/11/2017.
 */

public class NotYetEvaluatedPaperFragment extends ListFragment {
    private ListView listView;
    private ArrayList<Review> arrNotYetEvaluat;
    private ReviewAdapter adapter;
    public static final int REQUEST_CODE_REVIEW_PAPER_NOTYETEVALUATED = 1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_paper_not_yet_evaluated, container, false);
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
        arrNotYetEvaluat.add(new Review("Bài báo 1", 0, "Ngày gửi: 7/7/2017","207 Nguyễn Văn Linh, Phòng 01"));
        arrNotYetEvaluat.add(new Review("Bài báo 2", 0, "Ngày gửi: 8/7/2017","207 Nguyễn Văn Linh, Phòng 02"));
        arrNotYetEvaluat.add(new Review("Bài báo 3", 0, "Ngày gửi: 9/7/2017","207 Nguyễn Văn Linh, Phòng 03"));
        arrNotYetEvaluat.add(new Review("Bài báo 4", 0, "Ngày gửi: 10/7/2017","207 Nguyễn Văn Linh, Phòng 04"));
        arrNotYetEvaluat.add(new Review("Bài báo 5", 0, "Ngày gửi: 11/7/2017","207 Nguyễn Văn Linh, Phòng 05"));
        arrNotYetEvaluat.add(new Review("Bài báo 6", 0, "Ngày gửi: 12/7/2017","207 Nguyễn Văn Linh, Phòng 06"));
        arrNotYetEvaluat.add(new Review("Bài báo 7", 0, "Ngày gửi: 13/7/2017","207 Nguyễn Văn Linh, Phòng 07"));
        arrNotYetEvaluat.add(new Review("Bài báo 8", 0, "Ngày gửi: 14/7/2017","207 Nguyễn Văn Linh, Phòng 08"));
        arrNotYetEvaluat.add(new Review("Bài báo 9", 0, "Ngày gửi: 15/7/2017","207 Nguyễn Văn Linh, Phòng 09"));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(getActivity(), SendAbstractActivity.class);
        intent.putExtra("title", "3");// tiêu đề
        intent.putExtra("type", "3");// đánh giá bài báo
        startActivityForResult(intent, REQUEST_CODE_REVIEW_PAPER_NOTYETEVALUATED);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_CODE_REVIEW_PAPER_NOTYETEVALUATED:
                if(resultCode == Activity.RESULT_OK){
                    int status = data.getIntExtra("status", 1);
                }
                break;
        }
    }
}
