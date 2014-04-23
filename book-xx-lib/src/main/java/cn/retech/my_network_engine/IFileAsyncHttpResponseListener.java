package cn.retech.my_network_engine;

import java.io.File;

import cn.retech.my_network_engine.net_error_handle.MyNetRequestErrorBean;

/**
 * 文件下载异步响应处理监听(默认都是回到主线程)
 * 
 * @author skyduck
 * 
 */
public interface IFileAsyncHttpResponseListener {
	/**
	 * 文件下载完成
	 * 
	 * @param file
	 */
	public void onSuccess(final File file);

	/**
	 * 文件下载失败
	 * 
	 * @param error
	 */
	public void onFailure(final MyNetRequestErrorBean error);

	/**
	 * 取消
	 */
	// public void onCancel();
}
