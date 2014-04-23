package cn.retech.my_network_engine.http_engine;

/**
 * 用于发起业务Bean的异步监听
 * 
 * @author skyduck
 * 
 */
public interface IDomainBeanRequestAsyncHttpResponseListener {
  /**
   * 请求成功
   * 
   * @param netRequestIsCancelled
   * @param response
   */
  public void onSuccess(final INetRequestIsCancelled netRequestIsCancelled, final Object response);

  /**
   * 请求失败
   * 
   * @param netRequestIsCancelled
   * @param statusCode
   * @param e
   */
  public void onFailure(final INetRequestIsCancelled netRequestIsCancelled, int statusCode, Throwable e);
}
