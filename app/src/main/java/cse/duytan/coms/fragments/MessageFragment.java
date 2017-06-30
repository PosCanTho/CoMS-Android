package cse.duytan.coms.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.RecyclerMessageAdapter;
import cse.duytan.coms.models.Message;

/**
 * Created by Pham Van Thien on 6/27/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class MessageFragment extends Fragment {
    @BindView(R.id.rvMessage)
    RecyclerView rvMessage;
    Unbinder unbinder;

    private View v;
    private RecyclerMessageAdapter messageAdapter;
    private ArrayList<Message> listMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_message, container, false);
        initUI();
        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    private void initUI() {
        getActivity().setTitle(R.string.title_message);

        setRvMessageAdp();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void setRvMessageAdp() {
        listMessage = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listMessage.add(new Message("Steve Jobs " + i, "Do you want iphone 8, you want iphone 8, you want iphone 8.", ""));
        }
        messageAdapter = new RecyclerMessageAdapter(listMessage);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvMessage.setLayoutManager(mLayoutManager);
        rvMessage.setItemAnimator(new DefaultItemAnimator());
        rvMessage.setAdapter(messageAdapter);
    }
}
