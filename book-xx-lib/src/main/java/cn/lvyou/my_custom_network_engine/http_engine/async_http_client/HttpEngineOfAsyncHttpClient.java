package cn.lvyou.my_custom_network_engine.http_engine.async_http_client;

import java.io.File;
import java.util.Map;

import org.apache.http.Header;

import android.text.TextUtils;
import cn.lvyou.my_network_engine.INetRequestHandle;
import cn.lvyou.my_network_engine.engine_helper.EngineHelperSingleton;
import cn.lvyou.my_network_engine.http_engine.IDomainBeanRequestAsyncHttpResponseListener;
import cn.lvyou.my_network_engine.http_engine.IFileRequestAsyncHttpResponseListener;
import cn.lvyou.my_network_engine.http_engine.IHttpRequestForDomainBean;
import cn.lvyou.my_network_engine.http_engine.IHttpRequestForFile;
import cn.lvyou.toolutils.DebugLog;
import cn.lvyou.toolutils.ToolsFunctionForThisProgect;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

public class HttpEngineOfAsyncHttpClient implements IHttpRequestForDomainBean, IHttpRequestForFile {
  private final String TAG = this.getClass().getSimpleName();
  public final AsyncHttpClient asyncHttpClient;

  public HttpEngineOfAsyncHttpClient() {
    asyncHttpClient = new AsyncHttpClient();
    asyncHttpClient.setSSLSocketFactory(MySSLSocketFactory.getFixedSocketFactory());
    asyncHttpClient.setUserAgent(ToolsFunctionForThisProgect.getUserAgent());

    // PersistentCookieStore类用于实现Apache HttpClient的CookieStore接口，
    // 可以自动的将cookie保存到Android设备的SharedPreferences中，如果你打算使用cookie来管理验证会话，
    // 这个非常有用，因为用户可以保持登录状态，不管关闭还是重新打开你的app
    // PersistentCookieStore myCookieStore = new
    // PersistentCookieStore(GlobalDataCacheForMemorySingleton.getInstance.getApplication());
  }

  @Override
  public INetRequestHandle requestDomainBean(final String url, final Map<String, String> dataDictionary, final IDomainBeanRequestAsyncHttpResponseListener domainBeanRequestAsyncHttpResponseListener) {
    DebugLog.i(TAG, "短连接 : sendHttpRequest->url=" + url + ",dataDictionary=" + dataDictionary);
    RequestHandle requestHandle = null;

    // 定义异步HTTP网络响应处理监听器
    final AsyncHttpResponseHandler responseHandler = new HttpRequestHandleOfAsyncHttpClient() {
      @Override
      public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
        domainBeanRequestAsyncHttpResponseListener.onFailure(this, statusCode, e);

        this.setFinished(true);
      }

      @Override
      public void onSuccess(int statusCode, Header[] headers, byte[] response) {
        domainBeanRequestAsyncHttpResponseListener.onSuccess(this, response);

        this.setFinished(true);
      }

    };

    // 如果dataDictionary不为空, 我们就使用 POST方式发送数据到服务器, 否则就是用GET方式访问服务器
    if (dataDictionary != null && dataDictionary.size() > 0) {
      RequestParams requestParams = (RequestParams) EngineHelperSingleton.getInstance.getNetRequestEntityDataPackageStrategyObject().packageNetRequestEntityData(dataDictionary);
      requestHandle = asyncHttpClient.post(url, requestParams, responseHandler);
    } else {
      requestHandle = asyncHttpClient.get(url, responseHandler);
    }

    // 因为发现AsyncHttpClient原生的
    // HttpRequestHandle的isFinished标志位有所异常（开始任务时便默认为true），所以在此做一个自定义分装
    HttpRequestHandleOfAsyncHttpClient httpRequestHandleOfAsyncHttpClient = (HttpRequestHandleOfAsyncHttpClient) responseHandler;
    httpRequestHandleOfAsyncHttpClient.setRequestHandle(requestHandle);
    httpRequestHandleOfAsyncHttpClient.setFinished(false);
    return httpRequestHandleOfAsyncHttpClient;
  }

  @Override
  public INetRequestHandle requestFile(final String url, final boolean isNeedContinuingly, final Map<String, String> dataDictionary, final File downLoadFile,
      final IFileRequestAsyncHttpResponseListener fileRequestAsyncHttpResponseListener) {
    DebugLog.i(TAG, "文件请求 : sendHttpRequest->url=" + url + ",dataDictionary=" + dataDictionary);

    // effective for java 38 检查参数有效性, 对于共有的方法,
    // 要使用异常机制来通知调用方发生了入参错误.
    if (TextUtils.isEmpty(url)) {
      throw new NullPointerException("入参为空.");
    }
    RequestHandle requestHandle = null;

    long seekPos = 0;
    asyncHttpClient.removeHeader("Range");
    if (isNeedContinuingly) {
      // 需要断点续传
      if (downLoadFile.exists()) {
        asyncHttpClient.addHeader("Range", "bytes=" + downLoadFile.length() + "-");
        seekPos = downLoadFile.length();
      }
    } else {
      // 不需要断点续传时, 要删除之前的临时文件, 好重头进行下载
      seekPos = 0;
    }

    try {
      final RandomAccessFileAsyncHttpResponseHandler fileAsyncHttpResponseHandler = new RandomAccessFileAsyncHttpResponseHandler(downLoadFile, seekPos) {

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
          fileRequestAsyncHttpResponseListener.onFailure(statusCode, e);
        }

        @Override
        public void onProgress(int bytesWritten, int totalSize) {
          fileRequestAsyncHttpResponseListener.onProgress(bytesWritten, totalSize);
        }

        @Override
        public void onSuccess(int statusCode, Header[] headers, File file) {
          fileRequestAsyncHttpResponseListener.onSuccess(file);
        }

      };
      // 如果dataDictionary不为空, 我们就使用 POST方式发送数据到服务器, 否则就是用GET方式访问服务器
      if (dataDictionary != null && dataDictionary.size() > 0) {
        RequestParams requestParams = (RequestParams) EngineHelperSingleton.getInstance.getNetRequestEntityDataPackageStrategyObject().packageNetRequestEntityData(dataDictionary);
        requestHandle = asyncHttpClient.post(url, requestParams, fileAsyncHttpResponseHandler);
      } else {
        requestHandle = asyncHttpClient.get(url, fileAsyncHttpResponseHandler);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return new HttpRequestHandleOfAsyncHttpClient(requestHandle);
  }
}
