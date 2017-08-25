package cse.duytan.coms.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
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
import cse.duytan.coms.customviews.NonScrollListView;
import cse.duytan.coms.dialogs.ConfirmDialog;
import cse.duytan.coms.fragments.HomeFragment;
import cse.duytan.coms.helpers.Prefs;
import cse.duytan.coms.models.CircleImageView;
import cse.duytan.coms.models.MenuApp;
import cse.duytan.coms.models.User;
import cse.duytan.coms.presenters.MainPresenter;
import cse.duytan.coms.views.MainView;

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

        mainPresenter = new MainPresenter(this, this);
        mainPresenter.getListMenu();


        Prefs.setIdCurrentRead(-1);

        Log.d(TAG, "TOKEN: " + FirebaseInstanceId.getInstance().getToken());
    }

    private void setUpActionbar(){
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
                Fragment fragment = listMenu.get(selectItem).getFragment();
                if (fragment != null) {
                    switchFragment(fragment);
                } else {
                    if (selectItem == (listMenu.size() - 1)) {
                        new ConfirmDialog(MainActivity.this, getString(R.string.msg_are_you_sure_you_want_to_logout), MainActivity.this).show();
                    } else if (selectItem == (listMenu.size() - 3)) {
                        startActivity(new Intent(MainActivity.this, PackageActivity.class));
                    } else if (selectItem == (listMenu.size() - 4)) {
                        startActivity(new Intent(MainActivity.this, MapActivity.class));
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
