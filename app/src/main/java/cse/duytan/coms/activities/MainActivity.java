package cse.duytan.coms.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cse.duytan.coms.R;
import cse.duytan.coms.adapters.MenuAdapter;
import cse.duytan.coms.connections.DownloadAsyncTask;
import cse.duytan.coms.customviews.NonScrollListView;
import cse.duytan.coms.dialogs.ConfirmDialog;
import cse.duytan.coms.fragments.ConferenceFragment;
import cse.duytan.coms.fragments.HomeFragment;
import cse.duytan.coms.fragments.NotificationFragment;
import cse.duytan.coms.helpers.Prefs;
import cse.duytan.coms.models.CircleImageView;
import cse.duytan.coms.models.MenuApp;
import cse.duytan.coms.models.Notification;
import cse.duytan.coms.models.User;
import cse.duytan.coms.presenters.MainPresenter;
import cse.duytan.coms.views.MainView;
import me.leolin.shortcutbadger.ShortcutBadger;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.ivAvatar)
    CircleImageView ivAvatar;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvEmail)
    TextView tvEmail;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.frame)
    FrameLayout frame;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.lsMenu)
    NonScrollListView lsMenu;
    private MenuAdapter menuAdapter;


    private int selectItem;
    private ArrayList<MenuApp> listMenu;
    private FragmentManager fragmentManager;
    private Fragment fragmentSelected;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        //Khởi tạo
        fragmentManager = getFragmentManager();
        listMenu = new ArrayList<>();

        setUpActionbar();
        setUpHeader();
        setUpMenu();

        switchFragment(new HomeFragment());
        getMyIntent();

        mainPresenter = new MainPresenter(this, this);
        mainPresenter.initalSqlite();
        mainPresenter.getListMenu();

        Prefs.setIdCurrentRead(-1);
        Prefs.setViewNotification(false);

        ShortcutBadger.applyCount(this, 8);

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "TOKEN: " + token);
        if(!TextUtils.isEmpty(token)){
            mainPresenter.UpdateToken(Prefs.getUser().getPersonId(), token);
        }
        //showNotificaiton();
    }

    private void showNotificaiton(){
        NotificationManager nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder ncomp = new NotificationCompat.Builder(MainActivity.this);
        ncomp.setContentTitle("My Notification");
        Intent resultIntent = new Intent(MainActivity.this, MainActivity.class);
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        ncomp.setContentIntent(resultPendingIntent);
        ncomp.setTicker("Notification Listener");
        ncomp.setSmallIcon(R.mipmap.ic_launcher);
        ncomp.setAutoCancel(true);
        ncomp.setNumber(5);
        nManager.notify(1, ncomp.build());

    }

    private void getMyIntent() {
        Intent i = getIntent();
        if (i != null) {
            int personIdTo = i.getIntExtra("personIdTo", -1);
            if (personIdTo != -1) {
                switchFragment(new NotificationFragment());
            }
        }
    }

    private void setUpActionbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void setUpMenu() {
        menuAdapter = new MenuAdapter(getApplicationContext(), listMenu);
        lsMenu.setAdapter(menuAdapter);
        lsMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                selectItem = position;
                fragmentSelected = listMenu.get(selectItem).getFragment();
                if (fragmentSelected != null) {
                    switchFragment(fragmentSelected);
                } else {
                    if (selectItem == (listMenu.size() - 1)) {
                        new ConfirmDialog(MainActivity.this, getString(R.string.msg_are_you_sure_you_want_to_logout), MainActivity.this).show();
                    } else if (selectItem == (listMenu.size() - 3)) {
                        startActivity(new Intent(MainActivity.this, PackageActivity.class));
                    } else if (selectItem == (listMenu.size() - 4)) {
                        startActivity(new Intent(MainActivity.this, ListMapActivity.class));
                    }
                }

            }
        });
    }

    private void setUpHeader() {
        User user = Prefs.getUser();
        if (user == null) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        } else {
            tvName.setText(user.getFullname());
            tvEmail.setText(user.getEmail());
        }
    }


    private void switchFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
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
            case 2:
                getMenuInflater().inflate(R.menu.new_message_menu, menu);
                MenuItem item = menu.findItem(R.id.search_view);
                SearchView searchView = (SearchView) item.getActionView();
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        if(fragmentSelected instanceof ConferenceFragment){
                            ((ConferenceFragment) fragmentSelected).onSearch(newText);
                        }
                        return false;
                    }
                });
                break;
            case 4:
                getMenuInflater().inflate(R.menu.message_menu, menu);
                break;
            case 5:
                getMenuInflater().inflate(R.menu.notification_menu, menu);
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
            case R.id.actionDeleteNotification:
                NotificationFragment notificationFragment = (NotificationFragment) fragmentSelected;
                notificationFragment.deleteAllNotification();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void popupCalback(int processId, Object data) {
        if (processId == ID_DIALOG_CONFIRM_YES) {
            Prefs.setToken(null);
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.ivAvatar)
    public void onViewClicked() {
        startActivity(new Intent(MainActivity.this, MyProfileActivity.class));
    }

    @Override
    public void listMenu(ArrayList<MenuApp> listMenu) {
        this.listMenu.addAll(listMenu);
        menuAdapter.notifyDataSetChanged();
    }
}
