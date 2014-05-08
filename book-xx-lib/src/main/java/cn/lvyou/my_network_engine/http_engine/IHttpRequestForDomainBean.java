package cn.lvyou.my_network_engine.http_engine;

import java.util.Map;

import cn.lvyou.my_network_engine.INetRequestHandle;

public interface IHttpRequestForDomainBean {
  /**
   * 发起一个业务Bean的http请求
   * 
   * @param url
   *          完整的URL
   * @param dataDictionary
   *          数据字典
   * @param shortConnectionAsyncHttpResponseListener
   *          http异步响应监听
   * @return
   */
  public INetRequestHandle requestDomainBean(final String url, final Map<String, String> dataDictionary, final IDomainBeanRequestAsyncHttpResponseListener domainBeanRequestAsyncHttpResponseListener);
}
