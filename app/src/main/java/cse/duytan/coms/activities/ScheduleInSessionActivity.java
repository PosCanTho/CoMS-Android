package cse.duytan.coms.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cse.duytan.coms.R;
import cse.duytan.coms.fragments.MyScheduleInSessionFragment;
import cse.duytan.coms.fragments.ScheduleSessionFragment;

public class ScheduleInSessionActivity extends BaseActivity {


    private static final String TAG = "";
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    private String json;

    private ScheduleSessionFragment scheduleSessionFragment;
    private MyScheduleInSessionFragment myScheduleInSessionFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_in_session);
        ButterKnife.bind(this);
        getMyIntent();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupViewPager();
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void getMyIntent(){
        Intent i = getIntent();
        if(i != null){
            json = i.getStringExtra("dataSession");
            Log.d("", "getMyIntent: "+json);
        }

    }

    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_right, null);
        tabOne.setText("SCHEDULE IN SESSION");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_left, null);
        tabTwo.setText("MY SCHEDULE");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

    }

    public void setupViewPager() {
        scheduleSessionFragment = new ScheduleSessionFragment();
        myScheduleInSessionFragment = new MyScheduleInSessionFragment();

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(scheduleSessionFragment, "SCHEDULE IN SESSION");
        adapter.addFrag(myScheduleInSessionFragment, "MY SCHEDULE");
        viewPager.setAdapter(adapter);
    }

    public String returnData(){
        return json;
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {

            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
