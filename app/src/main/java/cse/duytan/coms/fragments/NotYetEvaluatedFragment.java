package cse.duytan.coms.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cse.duytan.coms.R;
import cse.duytan.coms.activities.ReviewAbstract;
import cse.duytan.coms.adapters.ReviewAdapter1;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.connections.DownloadCallback;
import cse.duytan.coms.models.AbstractApprovedModel;
import cse.duytan.coms.models.Review;
import cse.duytan.coms.untils.Constants;


public class NotYetEvaluatedFragment extends ListFragment implements DownloadCallback {
    private ListView listView;
    private ArrayList<Review> arrNotYetEvaluat;
    private ReviewAdapter1 adapter;
    private Animation animation, animation_abs;
    private LinearLayout ln, ln_func, ln_row_abstract;
    public static final int REVIEWABSTRACT = 1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_not_yet_evaluated, container, false);
        loadListReview();
        return rootView;
    }

    private void loadListReview(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Id", 1);//id person
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String json = jsonObject.toString();
        DownloadAsyncTask.POST(getActivity(), Constants.ID_API_LIST_REVIEW_PENDING_ABSTRACT, Constants.API_LIST_REVIEW_PENDING_ABSTRACT,
                json, AbstractApprovedModel.class, false, NotYetEvaluatedFragment.this);


        arrNotYetEvaluat = new ArrayList<>();
        addArrNotYetEvaluat();
        adapter = new ReviewAdapter1(this.getActivity(), android.R.id.list, arrNotYetEvaluat);// android.R.id.list android.R.layout.simple_list_item_multiple_choice
        setListAdapter(adapter);
//        adapter.notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Review review = (Review) l.getAdapter().getItem(position);
        Intent intent = new Intent(getActivity(), ReviewAbstract.class);
        intent.putExtra("object", review);
        startActivityForResult(intent, REVIEWABSTRACT);
    }

    private void addArrNotYetEvaluat(){
//        arrNotYetEvaluat.add(new Review("Bài tóm tăt 1", 0, "Ngày gửi: 7/7/2017","207 Nguyễn Văn Linh, Phòng 01"));
//        arrNotYetEvaluat.add(new Review("Bài tóm tăt 2", 0, "Ngày gửi: 8/7/2017","207 Nguyễn Văn Linh, Phòng 02"));
//        arrNotYetEvaluat.add(new Review("Bài tóm tăt 3", 0, "Ngày gửi: 9/7/2017","207 Nguyễn Văn Linh, Phòng 03"));
//        arrNotYetEvaluat.add(new Review("Bài tóm tăt 4", 0, "Ngày gửi: 10/7/2017","207 Nguyễn Văn Linh, Phòng 04"));
//        arrNotYetEvaluat.add(new Review("Bài tóm tăt 5", 0, "Ngày gửi: 11/7/2017","207 Nguyễn Văn Linh, Phòng 05"));
//        arrNotYetEvaluat.add(new Review("Bài tóm tăt 6", 0, "Ngày gửi: 12/7/2017","207 Nguyễn Văn Linh, Phòng 06"));
//        arrNotYetEvaluat.add(new Review("Bài tóm tăt 7", 0, "Ngày gửi: 13/7/2017","207 Nguyễn Văn Linh, Phòng 07"));
//        arrNotYetEvaluat.add(new Review("Bài tóm tăt 8", 0, "Ngày gửi: 14/7/2017","207 Nguyễn Văn Linh, Phòng 08"));
//        arrNotYetEvaluat.add(new Review("Bài tóm tăt 9", 0, "Ngày gửi: 15/7/2017","207 Nguyễn Văn Linh, Phòng 09"));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REVIEWABSTRACT:
                if (resultCode == Activity.RESULT_OK) {//Activity.RESULT_CANCELED
                    Toast.makeText(this.getActivity(), "nhận", Toast.LENGTH_LONG).show();
                    loadListReview();
                    adapter.notifyDataSetChanged();
                }
                break;
        }
    }

    @Override
    public void downloadSuccess(int processId, Object data) {
        if(processId == Constants.ID_API_LIST_REVIEW_PENDING_ABSTRACT){
            ArrayList<AbstractApprovedModel> ds = new ArrayList<>();
            ds = (ArrayList<AbstractApprovedModel>) data;

            if(ds.isEmpty()){
                Toast.makeText(getActivity(), "Chưa có bài bị từ chối.", Toast.LENGTH_LONG).show();
            }else {
                for (int i = 0; i < ds.size(); i++) {
                    String formattedDate = "";
                    Date date_deadline = null;
                    try {
                        date_deadline = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(ds.get(i).getLAST_REVISED_DATE());
                        formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(date_deadline);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    arrNotYetEvaluat.add(new Review(
                            ds.get(i).getCONFERENCE_NAME(),
                            0,
                            "Ngày gửi: " + formattedDate,
                            "Địa chỉ: ",
                            ds.get(i).getPERSON_ID(),
                            ds.get(i).getPAPER_ID()
                    ));
                }
                adapter = new ReviewAdapter1(this.getActivity(), android.R.id.list, arrNotYetEvaluat);// android.R.id.list android.R.layout.simple_list_item_multiple_choice
                setListAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

        }
    }

    @Override
    public void downloadError(int processId, String msg) {
        if(processId == Constants.ID_API_LIST_REVIEW_PENDING_ABSTRACT){
            Toast.makeText(this.getActivity(), "lỗi", Toast.LENGTH_LONG).show();
        }
    }
}
