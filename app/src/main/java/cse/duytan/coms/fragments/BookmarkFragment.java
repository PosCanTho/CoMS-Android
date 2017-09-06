package cse.duytan.coms.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cse.duytan.coms.R;
import cse.duytan.coms.activities.ProfileActivity;
import cse.duytan.coms.adapters.RecyclerBookmarkAdapter;
import cse.duytan.coms.customviews.CustomTextView;
import cse.duytan.coms.dialogs.ConfirmOkDialog;
import cse.duytan.coms.helpers.Prefs;
import cse.duytan.coms.models.Bookmark;
import cse.duytan.coms.models.EventBusInfo;
import cse.duytan.coms.presenters.BookmarkPresenter;
import cse.duytan.coms.views.BookmarkView;

/**
 * Created by Pham Van Thien on 7/27/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class BookmarkFragment extends BaseFragment implements BookmarkView {
    @BindView(R.id.rvBookmark)
    RecyclerView rvBookmark;
    Unbinder unbinder;
    @BindView(R.id.llEmpty)
    LinearLayout llEmpty;
    @BindView(R.id.tvEmpty)
    CustomTextView tvEmpty;
    @BindView(R.id.rlContent)
    RelativeLayout rlContent;

    private View v;
    private RecyclerBookmarkAdapter bookmarkAdapter;
    private BookmarkPresenter bookmarkPresenter;
    private ArrayList<Bookmark> listBookmark;
    private int personId = -1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_bookmark, container, false);
        unbinder = ButterKnife.bind(this, v);
        registerEvent();
        initUI();
        return v;
    }

    private void initUI() {
        getActivity().setTitle(R.string.title_bookmark);
        empty(false, false, "", llEmpty, rlContent, tvEmpty);
        personId = Prefs.getUser().getPersonId();

        bookmarkPresenter = new BookmarkPresenter(getActivity(), this);
        bookmarkPresenter.getListBookmark(personId);
    }

    private void setRvBookmarkAdapter() {
        bookmarkAdapter = new RecyclerBookmarkAdapter(listBookmark, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvBookmark.setLayoutManager(mLayoutManager);
        rvBookmark.setItemAnimator(new DefaultItemAnimator());
        rvBookmark.setAdapter(bookmarkAdapter);
    }

    @Override
    public void onEvent(EventBusInfo eventBusInfo) {
        super.onEvent(eventBusInfo);
        if (eventBusInfo.getProcessId() == ID_EVENT_REFRESH) {
            bookmarkPresenter.getListBookmark(personId);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        unregisterEvent();
    }

    @Override
    public void adpaterCallback(Object data, int processId, int position) {
        if (processId == R.id.clMain) {
            Intent i = new Intent(getActivity(), ProfileActivity.class);
            i.putExtra("PersonIdBookmark", listBookmark.get(position).getPersonIdBookmark());
            startActivity(i);
        }
    }

    @Override
    public void success(ArrayList<Bookmark> listBookmark) {
        this.listBookmark = listBookmark;
        empty(false, false, "", llEmpty, rlContent, tvEmpty);
        setRvBookmarkAdapter();
    }

    @Override
    public void error(String msg) {
        new ConfirmOkDialog(getActivity(), msg, null).show();
        empty(true, true, msg, llEmpty, rlContent, tvEmpty);

    }

    @Override
    public void empty() {
        empty(true, true, getString(R.string.msg_no_data_bookmark), llEmpty, rlContent, tvEmpty);
    }


}
