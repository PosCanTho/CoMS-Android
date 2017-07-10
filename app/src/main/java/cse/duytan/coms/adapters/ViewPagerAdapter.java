package cse.duytan.coms.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Pham Van Thien on 7/5/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private final ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private final ArrayList<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
//        switch (position){
//            case 0:
//                RejectFragment rejectFragment = new RejectFragment();
//                return rejectFragment;
//            case 1:
//                NotYetEvaluatedFragment notYetEvaluatedFragment = new NotYetEvaluatedFragment();
//                return notYetEvaluatedFragment;
//            case 2:
//                AcceptFragment acceptFragment = new AcceptFragment();
//                return acceptFragment;
//        }
//        return null;
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
