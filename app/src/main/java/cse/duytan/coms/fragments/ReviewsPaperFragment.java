package cse.duytan.coms.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.ViewPagerAdapter;

/**
 * Created by DungTrungCut on 7/11/2017.
 */

public class ReviewsPaperFragment extends Fragment {
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    Unbinder unbinder;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reviews, container, false);
        unbinder = ButterKnife.bind(this, view);
        initUI();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initUI(){
        setupViewPager(viewpager);
        tabs.setupWithViewPager(viewpager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(((FragmentActivity)getActivity()).getSupportFragmentManager());

        adapter.addFragment(new NotYetEvaluatedPaperFragment(), getString(R.string.tab_not_yet_evaluated));
//        adapter.addFragment(new FeedbackFragment(), getString(R.string.tab_feedback));
        adapter.addFragment(new RejectPaperFragment(), getString(R.string.tab_reject));
        adapter.addFragment(new AcceptPaperFragment(), getString(R.string.tab_accept));
        viewPager.setAdapter(adapter);
    }
}
