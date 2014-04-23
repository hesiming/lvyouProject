package cn.retech.my_network_engine;

public interface IFileAsyncHttpResponseListenerOnProgressDoInUIThread extends IFileAsyncHttpResponseListener {
  /**
   * 文件下载进度(在主线程中)
   * 
   * @param bytesWritten
   *          已完成的数据长度
   * @param totalSize
   *          要下载的数据总长度
   */
  public void onProgressDoInUIThread(final long bytesWritten, final long totalSize);
}
