package cn.lvyou.fragment.main_left_menu;

import java.util.List;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.lvyou.activity.MainActivity;
import cn.lvyou.activity.R;
import cn.lvyou.adapter.FilterAdapter;
import cn.lvyou.domainbean_model.categorys.CategorysNetRequestBean;
import cn.lvyou.domainbean_model.categorys.CategorysNetRespondBean;
import cn.lvyou.domainbean_model.categorys.categorybeans.ICategoryItem;
import cn.lvyou.domainbean_model.discount_list.DiscountListBean;
import cn.lvyou.domainbean_model.discount_list.DiscountListNetRequestBean;
import cn.lvyou.domainbean_model.optionTop.OptionTopNetRequestBean;
import cn.lvyou.domainbean_model.optionTop.OptionTopNetRespondBean;
import cn.lvyou.my_network_engine.IDomainBeanAsyncHttpResponseListener;
import cn.lvyou.my_network_engine.INetRequestHandle;
import cn.lvyou.my_network_engine.NetRequestHandleNilObject;
import cn.lvyou.my_network_engine.SimpleNetworkEngineSingleton;
import cn.lvyou.my_network_engine.net_error_handle.MyNetRequestErrorBean;

import com.google.common.collect.Lists;

public class DiscountFragment extends Fragment {
	private INetRequestHandle netRequestHandleForCategroys = new NetRequestHandleNilObject();
	private INetRequestHandle netRequestHandleForOptionTop = new NetRequestHandleNilObject();
	private CategorysNetRespondBean categoryNetRespondBean;
	private OptionTopNetRespondBean optionTopNetRespondBean;
	private LinearLayout categoryLayout;
	private PopupWindow categoryPopupWindow;
	private ListView filterListView;
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

				if (filterListView.getTag() != null && (Integer) filterListView.getTag() == v.getId()) {
					return;
				}
			}

			List<ICategoryItem> categoryItems = Lists.newArrayList();

			switch (v.getId()) {
			case R.id.discount_type_layout:// 折扣类型
				categoryItems = categoryNetRespondBean.getTypes();
				break;
			case R.id.departure_place_layout:// 出发地
				categoryItems = categoryNetRespondBean.getOriginPlace();
				break;
			case R.id.destination_place_layout:// 目的地
				categoryItems = categoryNetRespondBean.getPlaces();
				break;
			case R.id.travel_date_layout:// 旅行时间
        categoryItems = categoryNetRespondBean.getDates();
        break;
			}

			final FilterAdapter adapter = new FilterAdapter(getActivity(), categoryItems);
			filterListView.setAdapter(adapter);
			filterListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					adapter.setSelectedPosition(position);
				}
			});
			categoryPopupWindow.showAsDropDown(categoryLayout);
		}
	};

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
		requestOptionTop();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		DiscountListNetRequestBean discountListNetRequestBean = new DiscountListNetRequestBean();
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(discountListNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				DiscountListBean discountListBean = (DiscountListBean) respondDomainBean;

			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				// TODO 这里处理折扣列表返回错误的逻辑
			}
		});
		return rootView;
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onStop() {
		super.onStop();
		netRequestHandleForCategroys.cancel();
	}

	/**
	 * 初始化筛选列表
	 */
	private void initFilterView() {
		View popupWindowView = getActivity().getLayoutInflater().inflate(R.layout.categorys_popupwindow_content, null, false);
		categoryPopupWindow = new PopupWindow(popupWindowView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, true);
		// 下面两步必须一起调用,否则点击窗外无法关闭popupwindow
		categoryPopupWindow.setOutsideTouchable(true);
		categoryPopupWindow.setBackgroundDrawable(new BitmapDrawable());// 点击窗口外消失

		filterListView = (ListView) popupWindowView.findViewById(R.id.lv_selection);

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
				discountTypeLayout.setOnClickListener(onCategoryClickListener);

				// categoryOriginPlaceTextView.setText("出发地");
				departurePlaceLayout.setOnClickListener(onCategoryClickListener);

				// categoryPlaceTextView.setText("目的地");
				destinationPlaceLayout.setOnClickListener(onCategoryClickListener);

				// categoryTypesTextView.setText("机票");
				travelDateLayout.setOnClickListener(onCategoryClickListener);

			}
		});
	}

	private void requestOptionTop() {
		OptionTopNetRequestBean optionTopNetRequestBean = new OptionTopNetRequestBean();
		netRequestHandleForOptionTop = SimpleNetworkEngineSingleton.getInstance.requestDomainBean(optionTopNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {
			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onSuccess(Object respondDomainBean) {
				optionTopNetRespondBean = (OptionTopNetRespondBean) respondDomainBean;
			}
		});
	}
}
