package cse.duytan.coms.activities;

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import cse.duytan.coms.R;
import cse.duytan.coms.fragments.HomeFragment;
import cse.duytan.coms.fragments.SendAbstractFragment;
import cse.duytan.coms.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // fragment
    private FragmentManager fragmentManager;
    private HomeFragment homeFragment;
    private SendAbstractFragment sendAbstractFragment;
    private SettingsFragment settingFragment;

    //  style user
    public static final int STYLE_USER = 0;// người dùng thường
    public static final int STYLE_USER_AUTHOR = 1;// tác giả
    public static final int STYLE_USER_REVIEW = 2;// người đánh giá
    private int styleUser = STYLE_USER; // style user default


    //page fragment
    public static final int PAGE_HOME = 0;
    public static final int PAGE_SENDABSTRACT = 1;
    public static final int PAGE_SETTING = 2;
    public static final int PAGE_MYSCHEDULE = 3;
    private int currentPage = PAGE_SENDABSTRACT;

    // custom toolbar, navigation view
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private TextView tvFullName;

    private MenuItem searchItem;

    // get current fragment
    public int getCurrentPage() {
        return currentPage;
    }

    // set current fragment
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    // get user style
    public int getStyleUser() {
        return styleUser;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dũng 15-6-2017
        createView();
    }

    private void createView() {
        fragmentManager = getFragmentManager();
        homeFragment = new HomeFragment();
        sendAbstractFragment = new SendAbstractFragment();
        settingFragment = new SettingsFragment();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.ab_layout);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view_user);
        View header = navigationView.getHeaderView(0);
        tvFullName = (TextView) header.findViewById(R.id.tv_full_name);
        // hiện thị danh sách chức năng trên thanh drawer theo người dùng ^^
        if (getStyleUser() == STYLE_USER_REVIEW) {// người đánh giá
            navigationView.getMenu().findItem(R.id.nav_notification).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_message).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_profile).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_login).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_logout).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_reviews).setVisible(true);//chức năng reviewer
            navigationView.getMenu().findItem(R.id.nav_list_abstract).setVisible(false);
        }else if(getStyleUser() == STYLE_USER_AUTHOR){// tác giả
            navigationView.getMenu().findItem(R.id.nav_notification).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_message).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_profile).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_login).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_logout).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_reviews).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_list_abstract).setVisible(true);
        }else{// khách
            navigationView.getMenu().findItem(R.id.nav_notification).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_message).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_profile).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_login).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_logout).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_reviews).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_list_abstract).setVisible(false);
        }
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);

        switchPage(PAGE_HOME);
    }


    // switch fragment
    private void switchPage(int id) {
        switch (id) {
            case PAGE_HOME:
                setTitle("Trang chủ");
                fragmentManager.beginTransaction().replace(R.id.frame_contain, homeFragment).commit();
                setCurrentPage(PAGE_HOME);
                navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
                setShadowToolbar(0);
                break;
            case PAGE_SENDABSTRACT:
                setTitle("Gửi bài tóm tắt");
                fragmentManager.beginTransaction().replace(R.id.frame_contain, sendAbstractFragment).commit();
                setCurrentPage(PAGE_SENDABSTRACT);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
                break;
            case PAGE_SETTING:
                setTitle(getString(R.string.nav_setting));
                fragmentManager.beginTransaction().replace(R.id.frame_contain, settingFragment).commit();
                setCurrentPage(PAGE_SETTING);
                setShadowToolbar(8);
                break;
            default:
                break;
        }
    }

    // set shadow toolbar
    public void setShadowToolbar(float input) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            appBarLayout.setElevation(input);
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }

    // override button BACK of Android plaform
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        backArrowButton(); // call method event BACK
    }

    public void hideBackArrow() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toggle.syncState();
    }

    // display BACK on toolbar
    public void displayBackArrow() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do something you want
                if (((homeFragment.getCurrentLayout() == HomeFragment.LAYOUT_HOME) && (getCurrentPage() == PAGE_HOME))
                        || (getCurrentPage() == PAGE_MYSCHEDULE || (getCurrentPage() == PAGE_SETTING))
                        ) {
                    drawer.openDrawer(GravityCompat.START);
                } else {
                    backArrowButton();
                }
            }
        });

    }


    // method event BACK
    private void backArrowButton() {
        int id = getCurrentPage(); // get current fragment
        // switch current fragment
        switch (id) {
            case PAGE_HOME:
                int layoutHome = homeFragment.getCurrentLayout(); // get current layout of fragment

                // switch layout
                switch (layoutHome) {
                    case HomeFragment.LAYOUT_HOME:
                        new AlertDialog.Builder(this)
                                .setTitle(getString(R.string.exit_title))
                                .setMessage(getString(R.string.exit_mes))
                                .setNegativeButton(getString(R.string.btn_cancel), null)
                                .setPositiveButton(getString(R.string.exit_submit), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        finish();
                                    }
                                }).show();
                        break;

                    case HomeFragment.LAYOUT_ABSTRACT:
                        homeFragment.switchLayout(HomeFragment.LAYOUT_LIST_ABSTRACT);
                        break;
                    default:
                        break;
                }
                break;
//            case PAGE_NOTIFICATION:
//
//                break;
//            case PAGE_SCHEDULE:
//                break;
            case PAGE_SETTING:
                switchPage(PAGE_HOME);
                break;
            default:
                break;
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_home:
                switchPage(PAGE_HOME);
                break;
//            case R.id.nav_notification:
//                switchPage(PAGE_NOTIFICATION);
//                break;
            case R.id.nav_schedule:
                switchPage(PAGE_MYSCHEDULE);
                break;
            case R.id.nav_setting:
                switchPage(PAGE_SETTING);
                break;
            case R.id.nav_logout:

                break;
            default:
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
