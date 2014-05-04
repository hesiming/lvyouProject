package cn.lvyou.fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.lvyou.activity.MainActivity;
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
	// 主界面筛选的文字TextView
	// 折扣类型
	private TextView discountTypeTextView;
	// 出发地
	private TextView departurePlaceTextView;
	// 目的地
	private TextView destinationPlaceTextView;
	// 旅行时间
	private TextView travelDateTextView;
	// 主界面筛选的布局,用于响应监听事件
	// 折扣类型
	private RelativeLayout discountTypeLayout;
	// 出发地
	private RelativeLayout departurePlaceLayout;
	// 目的地
	private RelativeLayout destinationPlaceLayout;
	// 旅行时间
	private RelativeLayout travelDateLayout;

	private final OnClickListener onCategoryClickListener = new OnClickListener() {
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
			case R.id.travel_date_textView:
				categoryItems = categoryNetRespondBean.getDates();
				break;
			case R.id.discount_type_textView:
				categoryItems = categoryNetRespondBean.getTypes();
				break;
			case R.id.departure_place_textView:
				categoryItems = categoryNetRespondBean.getOriginPlace();
				break;
			case R.id.destination_place_textView:
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

	/**
	 * 初始化筛选列表
	 */
	private void initFilterView() {
		View popupWindowView = getActivity().getLayoutInflater().inflate(R.layout.categorys_popupwindow_content, null, false);
		categoryPopupWindow = new PopupWindow(popupWindowView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, false);
		listViewInCategoryPopupWindow = (LinearLayout) popupWindowView.findViewById(R.id.categoryContentList);

		categoryLayout = (LinearLayout) getView().findViewById(R.id.filter_layout);
		// 加载筛选列表的布局
		discountTypeLayout = (RelativeLayout) getView().findViewById(R.id.discount_type_layout);// 全部分类
		departurePlaceLayout = (RelativeLayout) getView().findViewById(R.id.departure_place_layout);// 出发地
		destinationPlaceLayout = (RelativeLayout) getView().findViewById(R.id.destination_place_layout);// 目的地
		travelDateLayout = (RelativeLayout) getView().findViewById(R.id.travel_date_layout);// 旅行时间

		// 加载筛选列表的TextView
		discountTypeTextView = (TextView) getView().findViewById(R.id.discount_type_textView);// 全部分类
		departurePlaceTextView = (TextView) getView().findViewById(R.id.departure_place_textView);// 出发地
		destinationPlaceTextView = (TextView) getView().findViewById(R.id.destination_place_textView);// 目的地
		travelDateTextView = (TextView) getView().findViewById(R.id.travel_date_textView);// 全部时间
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initFilterView();
		// 添加点击显示SlidingMenu
		ImageButton titleBtnLeft = (ImageButton) getView().findViewById(R.id.titleBtnLeft);
		titleBtnLeft.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				((MainActivity) getActivity()).showMenuContent();
			}
		});
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
		netRequestHandleForCategroys = SimpleNetworkEngineSingleton.getInstance.requestDomainBean(categorysNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {
			@Override
			public void onFailure(MyNetRequestErrorBean error) {
			}

			@Override
			public void onSuccess(Object respondDomainBean) {
				categoryNetRespondBean = (CategorysNetRespondBean) respondDomainBean;

				// categoryDatesTextView.setText("时间");
				travelDateTextView.setOnClickListener(onCategoryClickListener);

				// categoryOriginPlaceTextView.setText("出发地");
				departurePlaceTextView.setOnClickListener(onCategoryClickListener);

				// categoryPlaceTextView.setText("目的地");
				destinationPlaceTextView.setOnClickListener(onCategoryClickListener);

				// categoryTypesTextView.setText("机票");
				discountTypeTextView.setOnClickListener(onCategoryClickListener);
			}
		});
	}
}
