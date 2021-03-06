package cn.lvyou.test;

import cn.lvyou.domainbean_model.add_favor.AddFavorNetRequestBean;
import cn.lvyou.domainbean_model.add_favor.AddFavorNetRespondBean;
import cn.lvyou.domainbean_model.add_subscribe.AddSubscribeNetRequestBean;
import cn.lvyou.domainbean_model.add_subscribe.AddSubscribeNetRespondBean;
import cn.lvyou.domainbean_model.app_get_bookinfo.BookInfoNetRequestBean;
import cn.lvyou.domainbean_model.app_get_bookinfo.BookInfoNetRespondBean;
import cn.lvyou.domainbean_model.app_get_orderforminfo.OrderforminfoNetRequestBean;
import cn.lvyou.domainbean_model.app_get_orderforminfo.OrderforminfoNetRespondBean;
import cn.lvyou.domainbean_model.app_get_productsinfo.ProductsInfoNetRequestBean;
import cn.lvyou.domainbean_model.app_get_productsinfo.ProductsInfoNetRespondBean;
import cn.lvyou.domainbean_model.app_get_start_image.AppStartImageDatabaseFieldsConstant;
import cn.lvyou.domainbean_model.app_get_start_image.AppStartImageNetRequestBean;
import cn.lvyou.domainbean_model.app_get_start_image.AppStartImageNetResondBean;
import cn.lvyou.domainbean_model.app_get_userorderformlist.UserOrderNetRequestBean;
import cn.lvyou.domainbean_model.app_get_userorderformlist.UserOrderNetRespondBean;
import cn.lvyou.domainbean_model.app_post_del_orderform.DelOrderformNetRequestBean;
import cn.lvyou.domainbean_model.app_post_del_orderform.DelOrderformNetRespondBean;
import cn.lvyou.domainbean_model.app_post_orderform.PostOrderformNetRequestBean;
import cn.lvyou.domainbean_model.app_post_orderform.PostOrderformNetRespondBean;
import cn.lvyou.domainbean_model.app_post_second_orderform.PostSecondOrderformNetRequestBean;
import cn.lvyou.domainbean_model.app_post_second_orderform.PostSecondOrderformNetRespondBean;
import cn.lvyou.domainbean_model.app_query.AppQueryNetRequestBean;
import cn.lvyou.domainbean_model.app_query.AppQueryNetRespondBean;
import cn.lvyou.domainbean_model.bind_uid.BindUidNetRequestBean;
import cn.lvyou.domainbean_model.bind_uid.BindUidNetRespondBean;
import cn.lvyou.domainbean_model.del_favor.DelFavorNetRequestBean;
import cn.lvyou.domainbean_model.del_favor.DelFavorNetRespondBean;
import cn.lvyou.domainbean_model.del_subscribe.DelSubscribeNetRequestBean;
import cn.lvyou.domainbean_model.del_subscribe.DelSubscribeNetRespondBean;
import cn.lvyou.domainbean_model.discount_list.DiscountListBean;
import cn.lvyou.domainbean_model.discount_list.DiscountListNetRequestBean;
import cn.lvyou.domainbean_model.favor_list.FavorListNetRequestBean;
import cn.lvyou.domainbean_model.favor_list.FavorListNetRespondBean;
import cn.lvyou.domainbean_model.get_detail.GetDetailNetRequestBean;
import cn.lvyou.domainbean_model.get_detail.GetDetailNetRespondBean;
import cn.lvyou.domainbean_model.get_list_byid.GetListByidNetRequestBean;
import cn.lvyou.domainbean_model.get_list_byid.GetListByidNetRespondBean;
import cn.lvyou.domainbean_model.get_list_byjnid.GetListByJNidNetRequestBean;
import cn.lvyou.domainbean_model.get_list_byjnid.GetListByJNidNetRespondBean;
import cn.lvyou.domainbean_model.hot_country.HotCountryNetRequestBean;
import cn.lvyou.domainbean_model.hot_country.HotCountryParseNetRespondStringToDomainBean;
import cn.lvyou.domainbean_model.subscribe_list.SubscribeListNetRequestBean;
import cn.lvyou.domainbean_model.subscribe_list.SubscribeListNetRespondBean;
import cn.lvyou.domainbean_model.subscribe_push.SubscribePushNetRequestBean;
import cn.lvyou.domainbean_model.subscribe_push.SubscribePushNetRespondBean;
import cn.lvyou.domainbean_model.unbind_uid.UnBindUidNetRequestBean;
import cn.lvyou.domainbean_model.unbind_uid.UnBindUidNetRespondBean;
import cn.lvyou.my_network_engine.IDomainBeanAsyncHttpResponseListener;
import cn.lvyou.my_network_engine.SimpleNetworkEngineSingleton;
import cn.lvyou.my_network_engine.net_error_handle.MyNetRequestErrorBean;
import cn.lvyou.toolutils.DebugLog;

public final class TestNetRequestBean {
	private final String TAG = this.getClass().getSimpleName();

	// 获取APP启动页面图片
	public void appStartImageNetRequestBean() {
		AppStartImageNetRequestBean appStartImageNetRequestBean = new AppStartImageNetRequestBean(AppStartImageDatabaseFieldsConstant.RequestBean.sizeSmall.getValue());
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(appStartImageNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				AppStartImageNetResondBean appStartImageNetResondBean = (AppStartImageNetResondBean) respondDomainBean;
				DebugLog.e(TAG, appStartImageNetResondBean.toString());
			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// 获取折扣列表接口
	public void discountListNetRequestBean() {
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
	}

	// 获取折扣详情
	public void getDetailNetRequestBean() {
		GetDetailNetRequestBean getDetailNetRequestBean = new GetDetailNetRequestBean("4303");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(getDetailNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				GetDetailNetRespondBean getDetailNetRespondBean = (GetDetailNetRespondBean) respondDomainBean;

			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// 通过传锦囊id获取折扣列表
	public void getListByJNidNetRequestBean() {
		GetListByJNidNetRequestBean getDetailNetRequestBean = new GetListByJNidNetRequestBean();
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(getDetailNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				GetListByJNidNetRespondBean getListByJNidNetRespondBean = (GetListByJNidNetRespondBean) respondDomainBean;

			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// 通过id字符串获取折扣列表
	public void getListByidNetRequestBean() {
		GetListByidNetRequestBean getDetailNetRequestBean = new GetListByidNetRequestBean("3661,3564,3763,3786,3794,3707,3771,3803,3683,3188");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(getDetailNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				GetListByidNetRespondBean getListByidNetRespondBean = (GetListByidNetRespondBean) respondDomainBean;

			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// lastminute收藏列表
	public void favorListNetRequestBean() {
		FavorListNetRequestBean getDetailNetRequestBean = new FavorListNetRequestBean("e96b3418be731ff64281ca5f35aa3441");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(getDetailNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				FavorListNetRespondBean favorListNetRespondBean = (FavorListNetRespondBean) respondDomainBean;

			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// 折扣提醒推送
	public void subscribePushNetRequestBean() {
		SubscribePushNetRequestBean subscribePushNetRequestBean = new SubscribePushNetRequestBean("e96b3418be731ff64281ca5f35aa3441");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(subscribePushNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				SubscribePushNetRespondBean subscribePushNetRespondBean = (SubscribePushNetRespondBean) respondDomainBean;

			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// lastminute提醒条件列表
	public void subscribeListNetRequestBean() {
		SubscribeListNetRequestBean subscribeListNetRequestBean = new SubscribeListNetRequestBean("e96b3418be731ff64281ca5f35aa3441");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(subscribeListNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				SubscribeListNetRespondBean subscribeListNetRespondBean = (SubscribeListNetRespondBean) respondDomainBean;

			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// 获取折扣热门国家
	public void hotCountryNetRequestBean() {
		HotCountryNetRequestBean hotCountryNetRequestBean = new HotCountryNetRequestBean();
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(hotCountryNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				HotCountryParseNetRespondStringToDomainBean hotCountryParseNetRespondStringToDomainBean = (HotCountryParseNetRespondStringToDomainBean) respondDomainBean;

			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// APP获取折扣预定基础信息
	public void bookInfoNetRequestBean() {
		BookInfoNetRequestBean bookInfoNetRequestBean = new BookInfoNetRequestBean("2831");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(bookInfoNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				BookInfoNetRespondBean bookInfoNetRespondBean = (BookInfoNetRespondBean) respondDomainBean;

			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// APP获取折扣预定基础信息
	public void productsInfoNetRequestBean() {
		ProductsInfoNetRequestBean productsInfoNetRequestBean = new ProductsInfoNetRequestBean("4249", "e96b3418be731ff64281ca5f35aa3441");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(productsInfoNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				ProductsInfoNetRespondBean productsInfoNetRespondBean = (ProductsInfoNetRespondBean) respondDomainBean;

			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// APP获取订单信息
	public void orderforminfoNetRequestBean() {
		OrderforminfoNetRequestBean orderforminfoNetRequestBean = new OrderforminfoNetRequestBean("12123");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(orderforminfoNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				OrderforminfoNetRespondBean orderforminfoNetRespondBean = (OrderforminfoNetRespondBean) respondDomainBean;

			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// APP获取用户订单列表
	public void userOrderNetRequestBean() {
		UserOrderNetRequestBean userOrderNetRequestBean = new UserOrderNetRequestBean("e96b3418be731ff64281ca5f35aa3441");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(userOrderNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				UserOrderNetRespondBean userOrderNetRespondBean = (UserOrderNetRespondBean) respondDomainBean;

			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// APP主动查询支付宝
	public void appQueryNetRequestBean() {
		AppQueryNetRequestBean appQueryNetRequestBean = new AppQueryNetRequestBean("1212");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(appQueryNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				AppQueryNetRespondBean appQueryNetRespondBean = (AppQueryNetRespondBean) respondDomainBean;
			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// lastminute添加收藏
	public void addFavorNetRequestBean() {
		AddFavorNetRequestBean addFavorNetRequestBean = new AddFavorNetRequestBean("ca31af3ce212c484f6d6d008971e5c49", "1212");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(addFavorNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				AddFavorNetRespondBean addFavorNetRespondBean = (AddFavorNetRespondBean) respondDomainBean;
			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// lastminute取消收藏
	public void delFavorNetRequestBean() {
		DelFavorNetRequestBean delFavorNetRequestBean = new DelFavorNetRequestBean("ca31af3ce212c484f6d6d008971e5c49", "1212");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(delFavorNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				DelFavorNetRespondBean addFavorNetRespondBean = (DelFavorNetRespondBean) respondDomainBean;
			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// lastminute添加提醒条件
	public void addSubscribeNetRequestBean() {
		AddSubscribeNetRequestBean addSubscribeNetRequestBean = new AddSubscribeNetRequestBean("ca31af3ce212c484f6d6d008971e5c49", "1212", "adsasdasd", "121", "12182");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(addSubscribeNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				AddSubscribeNetRespondBean addSubscribeNetRespondBean = (AddSubscribeNetRespondBean) respondDomainBean;
			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// lastminute取消提醒条件
	public void delSubscribeNetRequestBean() {
		DelSubscribeNetRequestBean delSubscribeNetRequestBean = new DelSubscribeNetRequestBean("ca31af3ce212c484f6d6d008971e5c49", "1212");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(delSubscribeNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				DelSubscribeNetRespondBean delSubscribeNetRespondBean = (DelSubscribeNetRespondBean) respondDomainBean;
			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// 绑定用户到应用设备
	public void bindUidNetRequestBean() {
		BindUidNetRequestBean bindUidNetRequestBean = new BindUidNetRequestBean("ca31af3ce212c484f6d6d008971e5c49", "1212");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(bindUidNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				BindUidNetRespondBean bindUidNetRespondBean = (BindUidNetRespondBean) respondDomainBean;
			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// 从应用设备解绑用户
	public void unBindUidNetRequestBean() {
		UnBindUidNetRequestBean unBindUidNetRequestBean = new UnBindUidNetRequestBean("ca31af3ce212c484f6d6d008971e5c49", "1212");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(unBindUidNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				UnBindUidNetRespondBean unBindUidNetRespondBean = (UnBindUidNetRespondBean) respondDomainBean;
			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// APP提交订单
	public void postOrderformNetRequestBean() {
		PostOrderformNetRequestBean postOrderformNetRequestBean = new PostOrderformNetRequestBean("ca31af3ce212c484f6d6d008971e5c49", "1212", "1212", "1212", "1212", "1212", "1212");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(postOrderformNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				PostOrderformNetRespondBean postOrderformNetRespondBean = (PostOrderformNetRespondBean) respondDomainBean;
			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// APP删除订单
	public void delOrderformNetRequestBean() {
		DelOrderformNetRequestBean delOrderformNetRequestBean = new DelOrderformNetRequestBean("ca31af3ce212c484f6d6d008971e5c49", "1212");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(delOrderformNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				DelOrderformNetRespondBean postOrderformNetRespondBean = (DelOrderformNetRespondBean) respondDomainBean;
			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}

	// APP生成尾单
	public void postSecondOrderformNetRequestBean() {
		PostSecondOrderformNetRequestBean postSecondOrderformNetRequestBean = new PostSecondOrderformNetRequestBean("ca31af3ce212c484f6d6d008971e5c49", "1212");
		SimpleNetworkEngineSingleton.getInstance.requestDomainBean(postSecondOrderformNetRequestBean, new IDomainBeanAsyncHttpResponseListener() {

			@Override
			public void onSuccess(Object respondDomainBean) {
				PostSecondOrderformNetRespondBean postSecondOrderformNetRespondBean = (PostSecondOrderformNetRespondBean) respondDomainBean;
			}

			@Override
			public void onFailure(MyNetRequestErrorBean error) {
				DebugLog.e(TAG, error.getErrorMessage());
			}
		});
	}
}
