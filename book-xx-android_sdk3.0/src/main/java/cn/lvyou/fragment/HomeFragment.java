package cn.lvyou.fragment;

import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import cn.lvyou.activity.R;
import cn.retech.domainbean_model.categorys.CategorysNetRequestBean;
import cn.retech.domainbean_model.categorys.CategorysNetRespondBean;
import cn.retech.domainbean_model.categorys.categorybeans.ICategoryItem;
import cn.retech.my_network_engine.IDomainBeanAsyncHttpResponseListener;
import cn.retech.my_network_engine.INetRequestHandle;
import cn.retech.my_network_engine.NetRequestHandleNilObject;
import cn.retech.my_network_engine.SimpleNetworkEngineSingleton;
import cn.retech.my_network_engine.net_error_handle.MyNetRequestErrorBean;

import com.google.common.collect.Lists;

/**
 * 主界面
 * 
 * @author hesiming
 * 
 */
public class HomeFragment extends Fragment {
	private INetRequestHandle netRequestHandleForCategroys = new NetRequestHandleNilObject();

	private CategorysNetRespondBean categoryNetRespondBean;
	private LinearLayout categoryLayout;
	private PopupWindow categoryPopupWindow;
	private LinearLayout listViewInCategoryPopupWindow;
	private TextView categoryTypesTextView;
	private TextView categoryOriginPlaceTextView;
	private TextView categoryPlaceTextView;
	private TextView categoryDatesTextView;

	private final OnClickListener onCategoryClickListener = new OnClickListener() {
		@SuppressLint("ResourceAsColor")
		@Override
		public void onClick(View v) {
			if (null == categoryNetRespondBean) {
				Toast.makeText(getActivity(), "筛选类型仍在努力加载，请稍后再试!", Toast.LENGTH_LONG).show();
			}

			if (null != categoryPopupWindow && categoryPopupWindow.isShowing()) {
				categoryPopupWindow.dismiss();

				if (listViewInCategoryPopupWindow.getTag() != null && (Integer) listViewInCategoryPopupWindow.getTag() == v.getId()) {
					return;
				}
			}

			listViewInCategoryPopupWindow.removeAllViews();
			listViewInCategoryPopupWindow.setTag(v.getId());

			List<ICategoryItem> categoryItems = Lists.newArrayList();

			switch (v.getId()) {
			case R.id.categoryDatesTextView:
				categoryItems = categoryNetRespondBean.getDates();
				break;
			case R.id.categoryTypesTextView:
				categoryItems = categoryNetRespondBean.getTypes();
				break;
			case R.id.categoryOriginPlaceTextView:
				categoryItems = categoryNetRespondBean.getOriginPlace();
				break;
			case R.id.categoryPlaceTextView:
				categoryItems = categoryNetRespondBean.getPlaces();
				break;
			}

			for (ICategoryItem categoryDate : categoryItems) {
				TextView textView = new TextView(getActivity());
				textView.setTextSize(19f);
				textView.setGravity(Gravity.CENTER_VERTICAL);
				textView.setTextColor(getResources().getColor(android.R.color.black));
				textView.setText(categoryDate.getDescription());
				listViewInCategoryPopupWindow.addView(textView, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 85));
			}

			categoryPopupWindow.showAsDropDown(categoryLayout);
		}
	};

	public HomeFragment() {
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		View popupWindowView = getActivity().getLayoutInflater().inflate(R.layout.categorys_popupwindow_content, null, false);
		categoryPopupWindow = new PopupWindow(popupWindowView, LayoutParams.MATCH_PARENT, 500, false);
		listViewInCategoryPopupWindow = (LinearLayout) popupWindowView.findViewById(R.id.categoryContentList);

		categoryLayout = (LinearLayout) getView().findViewById(R.id.categorysLayout);
		categoryTypesTextView = (TextView) getView().findViewById(R.id.categoryTypesTextView);
		categoryOriginPlaceTextView = (TextView) getView().findViewById(R.id.categoryOriginPlaceTextView);
		categoryPlaceTextView = (TextView) getView().findViewById(R.id.categoryPlaceTextView);
		categoryDatesTextView = (TextView) getView().findViewById(R.id.categoryDatesTextView);

		requestCategroys();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_home, container, false);

		return rootView;
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	private void requestCategroys() {
		CategorysNetRequestBean categorysNetRequestBean = new CategorysNetRequestBean();
		netRequestHandleForCategroys = SimpleNetworkEngineSingleton.getInstance.requestDomainBean(categorysNetRequestBean,
				new IDomainBeanAsyncHttpResponseListener() {
					@Override
					public void onFailure(MyNetRequestErrorBean error) {
						// TODO Auto-generated method stub
					}

					@Override
					public void onSuccess(Object respondDomainBean) {
						categoryNetRespondBean = (CategorysNetRespondBean) respondDomainBean;

						categoryDatesTextView.setText("时间");
						categoryDatesTextView.setOnClickListener(onCategoryClickListener);

						categoryOriginPlaceTextView.setText("出发地");
						categoryOriginPlaceTextView.setOnClickListener(onCategoryClickListener);

						categoryPlaceTextView.setText("目的地");
						categoryPlaceTextView.setOnClickListener(onCategoryClickListener);

						categoryTypesTextView.setText("机票");
						categoryTypesTextView.setOnClickListener(onCategoryClickListener);
					}
				});
	}
}
