package cn.lvyou.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.lvyou.activity.R;

public class RightMenuFragment extends Fragment{

	@Override
	public void onAttach(Activity activity) {
		
		super.onAttach(activity);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_right_menu, null);
		
		findView(rootView);
		
		return rootView;
	}

	private void findView(View rootView) {
		
	}

}
