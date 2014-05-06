package cn.lvyou.fragment.main_left_menu;

import cn.lvyou.activity.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OrderFragment extends Fragment {
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    final View rootView = inflater.inflate(R.layout.fragment_orders, null);
    
    return rootView;
  }
}
