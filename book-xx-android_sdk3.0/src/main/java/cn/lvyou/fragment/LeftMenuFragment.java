package cn.lvyou.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.lvyou.activity.R;

/**
 * 左边滑出的侧边碎片
 * 
 * @author zhihuatang
 * 
 */
public class LeftMenuFragment extends Fragment {
  public enum LeftMenuIndexEnum {
    // 全部折扣
    AllDiscount,
    // 我的订单
    MyOrder,
    // 我的收藏
    MyFavor,
    // 我的提醒
    MyNotification,
    // 更多设置
    Setting
  }

  /**
   * 左侧菜单 点击回调接口
   */
  public interface MenuListOnItemClickListener {
    public void onItemClick(LeftMenuIndexEnum indexEnum);
  }

  private MenuListOnItemClickListener mOnItemClickListener;

  public void setMenuListOnClickListener(MenuListOnItemClickListener l) {
    mOnItemClickListener = l;
  }

  private View.OnClickListener mOnClickListener = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
      mOnItemClickListener.onItemClick((LeftMenuIndexEnum) v.getTag());
    }
  };

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    final View rootView = inflater.inflate(R.layout.fragment_menu, null);
    // 全部折扣
    final View allDiscount = rootView.findViewById(R.id.btn_all_deal);
    allDiscount.setOnClickListener(mOnClickListener);
    allDiscount.setTag(LeftMenuIndexEnum.AllDiscount);
    // 我的订单
    final View myOrder = rootView.findViewById(R.id.btn_my_order);
    myOrder.setOnClickListener(mOnClickListener);
    myOrder.setTag(LeftMenuIndexEnum.MyOrder);
    // 我的收藏
    final View myFavor = rootView.findViewById(R.id.btn_my_favor);
    myFavor.setOnClickListener(mOnClickListener);
    myFavor.setTag(LeftMenuIndexEnum.MyFavor);
    // 我的提醒
    final View myNotification = rootView.findViewById(R.id.btn_my_notification);
    myNotification.setOnClickListener(mOnClickListener);
    myNotification.setTag(LeftMenuIndexEnum.MyNotification);
    // 更多设置
    final View setting = rootView.findViewById(R.id.btn_more_setting);
    setting.setOnClickListener(mOnClickListener);
    setting.setTag(LeftMenuIndexEnum.Setting);
    return rootView;
  }

}
