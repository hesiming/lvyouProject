package cn.retech.my_custom_network_engine.http_engine.async_http_client;

import cn.retech.my_network_engine.INetRequestHandle;
import cn.retech.my_network_engine.http_engine.INetRequestIsCancelled;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;

public class HttpRequestHandleOfAsyncHttpClient extends AsyncHttpResponseHandler implements INetRequestHandle, INetRequestIsCancelled {
  /**
   * 目前发现 AsyncHttpClient 的 isFinished() 方法有时是无效的, 也就是说有时候发现才将请求入队, requestHandle.isFinished() 就立刻为true
   * 所以目前先使用我们自己定义的标志位 isFinished
   */
  private boolean isFinished = false;

  public boolean isFinished() {
    return isFinished;
  }

  public void setFinished(boolean isFinished) {
    this.isFinished = isFinished;
  }

  public HttpRequestHandleOfAsyncHttpClient() {
  }

  public HttpRequestHandleOfAsyncHttpClient(RequestHandle requestHandle) {
    this.requestHandle = requestHandle;
  }

  private RequestHandle requestHandle;

  public void setRequestHandle(RequestHandle requestHandle) {
    this.requestHandle = requestHandle;
  }

  @Override
  public boolean idle() {
    // TODO : 发现 AsyncHttpClient 的 isFinished() 方法有时是无效的, 也就是说有时候发现才将请求入队, requestHandle.isFinished() 就立刻为true
    //return requestHandle.isFinished() || requestHandle.isCancelled();
    return this.isFinished || requestHandle.isCancelled();
  }

  @Override
  public void cancel() {
    requestHandle.cancel(true);
  }

  @Override
  public boolean isCancelled() {
    return requestHandle.isCancelled();
  }
}
