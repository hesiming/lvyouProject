package cn.retech.my_network_engine;

import cn.retech.my_network_engine.SimpleNetworkEngineSingleton.NetRequestResultEnum;

/**
 * 该接口对外提供两个额外的回调, 用于控制层控制跟网络请求的UI
 * 
 * @author skyduck
 * 
 */
public interface IDomainBeanAsyncHttpResponseListenerWithUIControl extends IDomainBeanAsyncHttpResponseListener {
  /**
   * 网络请求激活成功(可以在这个回调中, 显示 ProgressDialog 之类的UI)
   */
  public void onBegin();

  /**
   * 网络请求彻底完成(可以在这个回调中, 关闭 ProgressDialog 之类的UI)
   * 这是一次网络请求最后的一站, 如果要进行界面跳转, 请在这里实现
   * 
   * @param resultEnum
   *          本次网络请求的结果
   */
  public void onEnd(final NetRequestResultEnum resultEnum);
}
