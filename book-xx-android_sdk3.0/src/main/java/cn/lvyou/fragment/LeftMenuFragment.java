package cn.lvyou.fragment;

import android.app.Activity;
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
  /**
   * 左侧菜单 点击回调接口
   */
  public interface MenuListOnItemClickListener {
    public void onItemClick(int position);
  }

  private MenuListOnItemClickListener mOnItemClickListener;

  public void setMenuListOnClickListener(MenuListOnItemClickListener l) {
    mOnItemClickListener = l;
  }

  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  private View.OnClickListener mOnClickListener = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
      mOnItemClickListener.onItemClick((Integer) v.getTag());
    }
  };

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    final View rootView = inflater.inflate(R.layout.fragment_menu, null);
    final View allDiscount = rootView.findViewById(R.id.btn_all_deal);
    allDiscount.setOnClickListener(mOnClickListener);
    allDiscount.setTag(0);
    final View myOrder = rootView.findViewById(R.id.btn_my_order);
    myOrder.setOnClickListener(mOnClickListener);
    myOrder.setTag(1);
    final View myFavor = rootView.findViewById(R.id.btn_my_favor);
    myFavor.setOnClickListener(mOnClickListener);
    myFavor.setTag(2);
    final View myNotification = rootView.findViewById(R.id.btn_my_notification);
    myNotification.setOnClickListener(mOnClickListener);
    myNotification.setTag(3);
    final View setting = rootView.findViewById(R.id.btn_more_setting);
    setting.setOnClickListener(mOnClickListener);
    setting.setTag(4);
    return rootView;
  }

}
