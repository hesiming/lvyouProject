package cn.lvyou.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;
import cn.lvyou.fragment.HomeFragment;
import cn.lvyou.fragment.LeftMenuFragment;
import cn.lvyou.fragment.main_left_menu.DiscountFragment;
import cn.lvyou.fragment.main_left_menu.FavorFragment;
import cn.lvyou.fragment.main_left_menu.NotificationFragment;
import cn.lvyou.fragment.main_left_menu.OrderFragment;
import cn.lvyou.fragment.main_left_menu.SettingFragment;
import cn.lvyou.slidingmenu.SlidingMenu;
import cn.lvyou.slidingmenu.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {
  private LeftMenuFragment leftMenuFragment = new LeftMenuFragment();

  private void initSlidingMenu() {
    // 设置背后的视图
    setBehindContentView(R.layout.frame_left_menu);

    // 自定义SlidingMenu
    // 设置只有左侧可以划出,如果需要设置左右都能划LEFT_RIGHT
    getSlidingMenu().setMode(SlidingMenu.LEFT);
    // 设置阴影图片
    getSlidingMenu().setShadowDrawable(R.drawable.bg_sliding_menu_shadow);
    // 设置阴影图片的宽度
    getSlidingMenu().setShadowWidthRes(R.dimen.shadow_width);
    // SlidingMenu划出时主页面显示的剩余宽度
    getSlidingMenu().setBehindOffsetRes(R.dimen.slidingmenu_offset);
    // 设置SlidingMenu划出淡入淡出的褪色程度0.0f-1.0f
    getSlidingMenu().setFadeDegree(0.35f);
    // 设置SlidingMenu 的手势模式
    // TOUCHMODE_FULLSCREEN 全屏模式，在整个content页面中，滑动，可以打开SlidingMenu
    // TOUCHMODE_MARGIN
    // 边缘模式，在content页面中，如果想打开SlidingMenu,你需要在屏幕边缘滑动才可以打开SlidingMenu
    // TOUCHMODE_NONE 不能通过手势打开SlidingMenu
    getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
    getSlidingMenu().setBehindWidth(getResources().getDimensionPixelSize(R.dimen.cliding_menu_behind_width));
  }

  private void initLeftMenuFragment() {
    leftMenuFragment.setMenuListOnClickListener(new LeftMenuFragment.MenuListOnItemClickListener() {

      @Override
      public void onItemClick(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
        case 0:
          fragment = new DiscountFragment();
          break;
        case 1:
          fragment = new OrderFragment();
          break;
        case 2:
          fragment = new FavorFragment();
          break;
        case 3:
          fragment = new NotificationFragment();
          break;
        case 4:
          fragment = new SettingFragment();
          break;
        default:
          break;
        }

        if (fragment != null) {
          final FragmentManager fragmentManager = getSupportFragmentManager();
          fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
          // update selected item and title, then close the drawer
          // setTitle(title);
          getSlidingMenu().showContent();
        } else {
          // error in creating fragment
          Log.e("MainActivity", "Error in creating fragment");
        }

      }

    });
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);

    initSlidingMenu();
    initLeftMenuFragment();

    // 设置 SlidingMenu 内容
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.replace(R.id.left_menu, leftMenuFragment);
    fragmentTransaction.replace(R.id.content, new HomeFragment());
    fragmentTransaction.commit();

  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case android.R.id.home:

      toggle(); // 动态判断自动关闭或开启SlidingMenu
      return true;
    default:
      return super.onOptionsItemSelected(item);
    }

  }

  public void showMenuContent() {
    if (getSlidingMenu() != null) {
      getSlidingMenu().showMenu();
    }
  }

}
