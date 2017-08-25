package cse.duytan.coms.presenters;

import android.content.Context;

import java.util.ArrayList;

import cse.duytan.coms.R;
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

/**
 * Created by Pham Van Thien on 8/24/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class MainPresenter extends BasePresenter {
    private Context context;
    private MainView mainView;

    public MainPresenter(Context context, MainView mainView) {
        this.context = context;
        this.mainView = mainView;
    }

    public void getListMenu(){
        ArrayList<MenuApp> listMenu = new ArrayList<>();
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
        mainView.listMenu(listMenu);
    }

}
