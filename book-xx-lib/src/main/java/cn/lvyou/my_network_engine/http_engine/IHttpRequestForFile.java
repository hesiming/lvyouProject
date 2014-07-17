package cn.lvyou.my_network_engine.http_engine;

import java.io.File;

import cn.lvyou.my_network_engine.INetRequestHandle;

public interface IHttpRequestForFile {
  /**
   * 发起一个http文件请求(上传/下载)
   * 
   * @param url
   * @param isNeedContinuingly
   * @param requestMethod
   * @param requestParams
   * @param downLoadFile
   * @param fileRequestAsyncHttpResponseListener
   * @return
   */
  public INetRequestHandle requestFile(final String url, final boolean isNeedContinuingly, final String requestMethod, final Object requestParams, final File downLoadFile,
      final IFileRequestAsyncHttpResponseListener fileRequestAsyncHttpResponseListener);
}
