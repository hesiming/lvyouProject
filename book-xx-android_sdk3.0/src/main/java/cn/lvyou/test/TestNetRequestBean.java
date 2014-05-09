package cn.lvyou.test;

import cn.lvyou.domainbean_model.app_get_start_image.AppStartImageDatabaseFieldsConstant;
import cn.lvyou.domainbean_model.app_get_start_image.AppStartImageNetRequestBean;
import cn.lvyou.domainbean_model.app_get_start_image.AppStartImageNetResondBean;
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
}
