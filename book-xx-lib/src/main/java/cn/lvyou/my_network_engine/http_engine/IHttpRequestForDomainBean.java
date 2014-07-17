package cn.lvyou.my_network_engine.http_engine;

import cn.lvyou.my_network_engine.INetRequestHandle;

public interface IHttpRequestForDomainBean {
  /**
   * 发起一个业务Bean的http请求
   * 
   * @param url
   *          完整的URL
   * @param requestMethod
   *          http 请求方法(GET/POST)
   * @param requestParams
   *          请求参数
   * @param shortConnectionAsyncHttpResponseListener
   *          http异步响应监听
   * @return
   */
  public INetRequestHandle requestDomainBean(final String url, final String requestMethod, final Object requestParams,
      final IDomainBeanRequestAsyncHttpResponseListener domainBeanRequestAsyncHttpResponseListener);
}
