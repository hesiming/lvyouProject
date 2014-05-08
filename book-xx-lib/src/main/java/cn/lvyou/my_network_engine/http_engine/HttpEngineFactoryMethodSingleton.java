package cn.lvyou.my_network_engine.http_engine;

import java.io.File;
import java.util.Map;

import cn.lvyou.my_custom_network_engine.http_engine.async_http_client.HttpEngineOfAsyncHttpClient;
import cn.lvyou.my_custom_network_engine.http_engine.volley.HttpEngineOfVolley;
import cn.lvyou.my_network_engine.INetRequestHandle;

import com.loopj.android.http.AsyncHttpClient;

/*
 * Every method of java will have a stack, and every invokation on that method will have it's own 'stack frame'. 
 * 每一个java方法都有一个堆栈, 而且对那个方法每次调用时, 都会有属于它自己的 'stack frame'.
 * So the local data of one method invokation will not affect others. 
 * 所以一个方法被调用时的本地数据, 不会影响到别人.
 * Please do not confuse 'synchronization' with 'atomic'. 
 * 请不要混淆 '同步' 和 '原子性'
 * If one static method is synchronized, JVM will use the Class as the lock. If not, it acts as an instance method.
 * 如果一个静态方法是同步的, JVM会使用类锁. 如果不, 它会被当成一个实力方法.
 * */
/**
 * 
 * @author skyduck
 * 
 */
public enum HttpEngineFactoryMethodSingleton implements IHttpRequestForDomainBean, IHttpRequestForFile {
  getInstance;

  private final static HttpEngineOfAsyncHttpClient httpEngineOfAsyncHttpClient = new HttpEngineOfAsyncHttpClient();

  private final static HttpEngineOfVolley httpEngineOfVolley = new HttpEngineOfVolley();

  /**
   * 对外提供一个共享的 AsyncHttpClient
   * 
   * @return
   */
  public AsyncHttpClient getSharedAsyncHttpClient() {
    return httpEngineOfAsyncHttpClient.asyncHttpClient;
  }

  @Override
  public INetRequestHandle requestDomainBean(final String url, final Map<String, String> dataDictionary, final IDomainBeanRequestAsyncHttpResponseListener domainBeanRequestAsyncHttpResponseListener) {
    return httpEngineOfAsyncHttpClient.requestDomainBean(url, dataDictionary, domainBeanRequestAsyncHttpResponseListener);
  }

  @Override
  public INetRequestHandle requestFile(final String url, final boolean isNeedContinuingly, final Map<String, String> dataDictionary, final File downLoadFile,
      final IFileRequestAsyncHttpResponseListener fileRequestAsyncHttpResponseListener) {
    return httpEngineOfAsyncHttpClient.requestFile(url, isNeedContinuingly, dataDictionary, downLoadFile, fileRequestAsyncHttpResponseListener);
  }
}
