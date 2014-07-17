package cn.lvyou.my_network_engine;

import cn.lvyou.my_network_engine.net_error_handle.MyNetRequestErrorBean;

/**
 * 业务Bean http访问异步响应监听, 一般的联网应用, 其实就是客户端和服务器进行 业务Bean的交换工作而已
 * 
 * @author skyduck
 * 
 */
public interface IDomainBeanAsyncHttpResponseListener {
	/**
	 * 成功
	 * 
	 * @param respondDomainBean
	 *            一个符合要求的业务Bean
	 */
	public void onSuccess(final Object respondDomainBean);

	/**
	 * 失败
	 * 
	 * @param error
	 */
	public void onFailure(final MyNetRequestErrorBean error);

	/**
	 * 取消
	 */
	// public void onCancel();
}
