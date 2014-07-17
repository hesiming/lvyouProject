package cn.lvyou.my_network_engine;

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
   */
  public void onEnd();
}
