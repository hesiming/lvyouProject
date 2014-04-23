package cn.retech.my_network_engine.http_engine;

import java.io.File;

/**
 * 用于发起文件操作(上传/下载)的异步监听
 * 
 * @author hesiming
 * 
 */
public interface IFileRequestAsyncHttpResponseListener {
  /**
   * 请求成功
   * 
   * @param response
   */
  public void onSuccess(final File file);

  /**
   * 请求失败
   * 
   * @param statusCode
   * @param e
   */
  public void onFailure(int statusCode, Throwable e);

  /**
   * 文件下载进度
   * 
   * @param bytesWritten
   * @param totalSize
   */
  public void onProgress(long bytesWritten, long totalSize);
}
