package cn.lvyou.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import cn.lvyou.entity.ContentBean;
import cn.lvyou.fragment.TestContentFragment;

public class ContentFragmentPagerAdapter extends FragmentPagerAdapter {

	private List<ContentBean> list;

	public ContentFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public ContentFragmentPagerAdapter(FragmentManager fm, List<ContentBean> list) {
		super(fm);
		this.list = list;
	}

	@Override
	public Fragment getItem(int arg0) {

		return TestContentFragment.newInstance(list.get(arg0).getContent());

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return list.get(position).getTitle();
	}

}
