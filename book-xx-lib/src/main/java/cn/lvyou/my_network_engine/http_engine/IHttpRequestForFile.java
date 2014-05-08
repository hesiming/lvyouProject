package cn.lvyou.my_network_engine.http_engine;

import java.io.File;
import java.util.Map;

import cn.lvyou.my_network_engine.INetRequestHandle;

public interface IHttpRequestForFile {
  /**
   * 发起一个http文件请求(上传/下载)
   * 
   * @param url
   * @param dataDictionary
   * @param fileAsyncHttpResponseListener
   * @return
   */
  public INetRequestHandle requestFile(final String url, final boolean isNeedContinuingly, final Map<String, String> dataDictionary, final File downLoadFile,
      final IFileRequestAsyncHttpResponseListener fileRequestAsyncHttpResponseListener);
}
