package cse.duytan.coms.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import cse.duytan.coms.R;
import cse.duytan.coms.adapters.MenuAdapter;
import cse.duytan.coms.customviews.NonScrollListView;
import cse.duytan.coms.dialogs.ConfirmDialog;
import cse.duytan.coms.fragments.BookmarkFragment;
import cse.duytan.coms.fragments.ConferenceFragment;
import cse.duytan.coms.fragments.HomeFragment;
import cse.duytan.coms.fragments.ListAbstractFragment;
import cse.duytan.coms.fragments.ListPaperFragment;
import cse.duytan.coms.fragments.MessageFragment;
import cse.duytan.coms.fragments.NotificationFragment;
import cse.duytan.coms.fragments.ReviewsFragment;
import cse.duytan.coms.fragments.ReviewsPaperFragment;
import cse.duytan.coms.fragments.ScheduleFragment;
import cse.duytan.coms.fragments.SettingsFragment;
import cse.duytan.coms.models.MenuApp;
import cse.duytan.coms.views.MainView;

public class MainActivity extends BaseActivity {

    private NonScrollListView menu;
    private MenuAdapter menuAdapter;

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private ImageView ivAvatar;
    private int selectItem;
    private ArrayList<MenuApp> listMenu;
    public MainView mainView;
    private FragmentManager fragmentManager;
    private  FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        initUI();
        setUpMenu();
    }

    private void initUI() {
        fragmentManager =  getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switchFragment(new HomeFragment());

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        ivAvatar = (ImageView) navigationView.findViewById(R.id.ivAvatar);

        ivAvatar.setOnClickListener(this);

        Log.d(TAG, "TOKEN: "+ FirebaseInstanceId.getInstance().getToken());
    }

    private void setUpMenu() {
        menu = (NonScrollListView) findViewById(R.id.lsMenu);
        listMenu = new ArrayList<>();
        listMenu.add(new MenuApp(R.drawable.ic_home, "Trang chủ", "5", new HomeFragment()));
        listMenu.add(new MenuApp(R.drawable.ic_calendar_menu, "Lịch trình", "16", new ScheduleFragment()));
        listMenu.add(new MenuApp(R.drawable.ic_conference, "Hội nghị", "16", new ConferenceFragment()));
        listMenu.add(new MenuApp(R.drawable.ic_bookmark_menu, "Đánh dấu", "10", new BookmarkFragment()));
        listMenu.add(new MenuApp(R.drawable.ic_review, "Nhắn tin", "16", new MessageFragment()));
        listMenu.add(new MenuApp(R.drawable.ic_notification, "Thông báo", "16", new NotificationFragment()));
        listMenu.add(new MenuApp(R.drawable.ic_paper, "Danh sách bài tóm tắt", "16", new ListAbstractFragment()));
        listMenu.add(new MenuApp(R.drawable.ic_paper, "Danh sách bài báo", "20", new ListPaperFragment()));
        listMenu.add(new MenuApp(R.drawable.ic_paper, "Đánh giá bài tóm tắt", "4", new ReviewsFragment()));//ReviewsPaperFragment
        listMenu.add(new MenuApp(R.drawable.ic_paper, "Đánh giá bài báo", "2", new ReviewsPaperFragment()));
        listMenu.add(new MenuApp(R.drawable.ic_map_location, "Bản đồ", "", null));
        listMenu.add(new MenuApp(R.drawable.ic_package, "Mua gói", "", null));
        listMenu.add(new MenuApp(R.drawable.ic_settings, "Cài đặt", "", new SettingsFragment()));
        listMenu.add(new MenuApp(R.drawable.ic_logout, "Đăng xuất", "", null));

        menuAdapter = new MenuAdapter(getApplicationContext(), listMenu);
        menu.setAdapter(menuAdapter);
        menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                selectItem = position;
                Fragment fragment = listMenu.get(selectItem).getFragment();
                if (fragment != null) {
                    switchFragment(fragment);
                } else {
                    if (selectItem == (listMenu.size() - 1)) {
                        new ConfirmDialog(MainActivity.this, getString(R.string.msg_are_you_sure_you_want_to_logout), MainActivity.this).show();
                    }else if (selectItem == (listMenu.size() - 3)) {
                        startActivity(new Intent(MainActivity.this, PackageActivity.class));
                    }else if (selectItem == (listMenu.size() - 4)) {
                        startActivity(new Intent(MainActivity.this, MapActivity.class));
                    }
                }

            }
        });
    }

    private void switchFragment(Fragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();
        drawer.closeDrawer(GravityCompat.START);
        invalidateOptionsMenu();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        switch (selectItem) {
            case 4:
                getMenuInflater().inflate(R.menu.message_menu, menu);
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.actionNewMessage:
                startActivity(new Intent(MainActivity.this, NewMessageActivity.class));
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void popupCalback(int processId, Object data) {
        if (processId == ID_DIALOG_CONFIRM_YES) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.ivAvatar:
                startActivity(new Intent(MainActivity.this, MyProfileActivity.class));
                break;
            default:
                break;
        }
    }
}
