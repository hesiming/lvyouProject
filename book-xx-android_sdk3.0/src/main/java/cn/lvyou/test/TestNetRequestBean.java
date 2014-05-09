package cn.lvyou.test;

import cn.lvyou.domainbean_model.app_get_start_image.AppStartImageDatabaseFieldsConstant;
import cn.lvyou.domainbean_model.app_get_start_image.AppStartImageNetRequestBean;
import cn.lvyou.domainbean_model.app_get_start_image.AppStartImageNetResondBean;
import cn.lvyou.domainbean_model.discount_list.DiscountListBean;
import cn.lvyou.domainbean_model.discount_list.DiscountListNetRequestBean;
import cn.lvyou.domainbean_model.get_detail.GetDetailNetRequestBean;
import cn.lvyou.domainbean_model.get_detail.GetDetailNetRespondBean;
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
}
