package cn.lvyou.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import cn.lvyou.fragment.LeftMenuFragment;
import cn.lvyou.fragment.LeftMenuFragment.LeftMenuIndexEnum;
import cn.lvyou.fragment.main_left_menu.DiscountFragment;
import cn.lvyou.fragment.main_left_menu.FavorFragment;
import cn.lvyou.fragment.main_left_menu.NotificationFragment;
import cn.lvyou.fragment.main_left_menu.OrderFragment;
import cn.lvyou.fragment.main_left_menu.SettingFragment;
import cn.lvyou.global_data_cache.GlobalDataCacheForMemorySingleton;
import cn.lvyou.slidingmenu.SlidingMenu;
import cn.lvyou.slidingmenu.app.SlidingFragmentActivity;
import cn.lvyou.test.TestNetRequestBean;
import cn.lvyou.toolutils.DebugLog;

public class MainActivity extends SlidingFragmentActivity {
	private final String TAG = this.getClass().getSimpleName();

	private static enum IntentRequestCodeEnum {
		TO_LOGIN_ACTIVITY
	};

	private Handler handler = new Handler();

	private final LeftMenuFragment leftMenuFragment = new LeftMenuFragment();

	private LeftMenuIndexEnum currentMenuIndexEnum;

	private void initSlidingMenu() {

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
			public void onItemClick(LeftMenuIndexEnum indexEnum) {
				// 记录当前要跳转的菜单索引
				currentMenuIndexEnum = indexEnum;

				// 先收回 LeftMenuFragment
				toggle();

				// 在切换左侧滑栏的菜单之前, 要先判断是否需要先登录
				if (isNeedToFirstLogin(indexEnum)) {
					// 如果需要先登录, 就跳转到登录界面
					gotoLoginActivity();
					return;
				}

				// 切换左侧滑栏的菜单
				changeLeftMenuByIndex(indexEnum);
			}
		});
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置前景视图
		setContentView(R.layout.main_activity_foreground_fragment_container);
		// 设置背景视图
		setBehindContentView(R.layout.main_activity_background_fragment_container);

		initSlidingMenu();
		initLeftMenuFragment();

		// 设置 SlidingMenu 内容
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.replace(R.id.left_menu, leftMenuFragment);
		fragmentTransaction.replace(R.id.content, new DiscountFragment());
		fragmentTransaction.commit();
		TestNetRequestBean testNetRequestBean = new TestNetRequestBean();
		// 获取折扣列表接口
		// testNetRequestBean.discountListNetRequestBean();
		// 获取APP启动页面图片
		// testNetRequestBean.appStartImageNetRequestBean();
		// 获取折扣详情
		// testNetRequestBean.getDetailNetRequestBean();
		// 通过传锦囊id获取折扣列表
		// testNetRequestBean.getListByJNidNetRequestBean();
		// 通过id字符串获取折扣列表
		// testNetRequestBean.getListByidNetRequestBean();
		// lastminute提醒条件列表
		// testNetRequestBean.favorListNetRequestBean();
		// lastminute收藏列表
		// testNetRequestBean.subscribeListNetRequestBean();
		// 折扣提醒推送
		// testNetRequestBean.subscribePushNetRequestBean();
		// 获取折扣热门国家
		// testNetRequestBean.hotCountryNetRequestBean();
		// APP获取折扣预定基础信息
		// testNetRequestBean.bookInfoNetRequestBean();
		// APP获取折扣预定基础信息
		// testNetRequestBean.productsInfoNetRequestBean();
		// APP获取订单信息
		// testNetRequestBean.orderforminfoNetRequestBean();
		// APP获取用户订单列表
		// testNetRequestBean.userOrderNetRequestBean();
		// APP主动查询支付宝
		// testNetRequestBean.appQueryNetRequestBean();
		// lastminute添加收藏
		// testNetRequestBean.addFavorNetRequestBean();
		// lastminute取消收藏
		// testNetRequestBean.delFavorNetRequestBean();

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

	/**
	 * 判断是否需要先登录
	 * 
	 * @param indexEnum
	 */
	private boolean isNeedToFirstLogin(LeftMenuIndexEnum indexEnum) {
		do {
			if (indexEnum == LeftMenuIndexEnum.Setting || indexEnum == LeftMenuIndexEnum.AllDiscount) {
				break;
			}
			if (GlobalDataCacheForMemorySingleton.getInstance.isLogged()) {
				break;
			}
			return true;

		} while (false);

		return false;
	}

	private Fragment getLeftMenuFragmentByIndex(LeftMenuIndexEnum indexEnum) throws IllegalArgumentException {
		if (indexEnum == null) {
			throw new IllegalArgumentException("入参 indexEnum 为null.");
		}
		switch (indexEnum) {
		case AllDiscount:// 全部折扣
			return new DiscountFragment();
		case MyOrder:// 我的订单
			return new OrderFragment();
		case MyFavor:// 我的收藏
			return new FavorFragment();
		case MyNotification:// 我的提醒
			return new NotificationFragment();
		case Setting:// 更多设置
			return new SettingFragment();
		default:
			throw new IllegalArgumentException("入参 indexEnum 无效!");
		}
	}

	/**
	 * 切换左侧滑出菜单中包含的界面
	 * 
	 * @param indexEnum
	 */
	private void changeLeftMenuByIndex(LeftMenuIndexEnum indexEnum) {
		try {
			final Fragment nextFragment = getLeftMenuFragmentByIndex(indexEnum);
			final FragmentManager fragmentManager = getSupportFragmentManager();
			final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			fragmentTransaction.replace(R.id.content, nextFragment);
			// 这个是给Fragment添加回退栈
			fragmentTransaction.addToBackStack(null);
			fragmentTransaction.commit();
		} catch (IllegalArgumentException e) {
			DebugLog.e(TAG, e.getLocalizedMessage());
		} finally {
			getSlidingMenu().showContent();
		}
	}

	private void gotoLoginActivity() {
		Intent intent = new Intent(MainActivity.this, LoginActivity.class);
		startActivityForResult(intent, IntentRequestCodeEnum.TO_LOGIN_ACTIVITY.ordinal());

		overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		DebugLog.i(TAG, "onActivityResult");

		if (requestCode == IntentRequestCodeEnum.TO_LOGIN_ACTIVITY.ordinal()) {
			if (resultCode == Activity.RESULT_OK) {
				// 登录成功, 直接跳转目标菜单
				handler.post(new Runnable() {

					@Override
					public void run() {
						// 05-09 12:43:29.723: E/AndroidRuntime(6720): Caused by:
						// java.lang.IllegalStateException: Can not perform this action
						// after onSaveInstanceState
						// TODO : 必须这样异步更换碎片视图, 否则就报上面的异常
						changeLeftMenuByIndex(currentMenuIndexEnum);
					}
				});

				// 返回 onActivityResult 时, 是在主线程的 Thread[main,5,main]
				DebugLog.i(TAG, "当前线程 --> " + Thread.currentThread());
			}
		}
	}
}
