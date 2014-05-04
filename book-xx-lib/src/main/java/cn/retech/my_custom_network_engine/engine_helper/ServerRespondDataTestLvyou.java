package cn.retech.my_custom_network_engine.engine_helper;

import org.json.JSONException;
import org.json.JSONObject;

import cn.retech.my_network_engine.engine_helper.interfaces.IServerRespondDataTest;
import cn.retech.my_network_engine.net_error_handle.MyNetErrorCodeEnum;
import cn.retech.my_network_engine.net_error_handle.MyNetRequestErrorBean;

/**
 * 
 * @author skyduck
 * 
 */
public final class ServerRespondDataTestLvyou implements IServerRespondDataTest {

	@Override
	public MyNetRequestErrorBean testServerRespondDataError(final Object netUnpackedData) {

		final String netUnpackedDataOfUTF8String = (String) netUnpackedData;
		int errorCode = MyNetErrorCodeEnum.kNetErrorCodeEnum_Success.getErrorCode();
		String errorMessage = "OK";

		try {
			JSONObject respondJSON = new JSONObject(netUnpackedDataOfUTF8String);
			if (respondJSON != null) {
				//这里的逻辑修改了:
				//原来的逻辑是:status表示返回的数据不正确
				//现在的逻辑是:status不能表示返回的数据不正确
				//这里修改的方式,当errorcode不为1则表示不是正确的,只要为1都表示正确,这里需要再次确认
				if (respondJSON.has("status")) {
					errorCode = respondJSON.getInt("status");
					// 这里的状态需要根据具体的业务逻辑来,qyer业务逻辑中1表示正确数据,0表示无数据
					if (errorCode != 1) {// 状态码, 不为1时, 证明服务器没有给客户端返回有效的数据
						if (respondJSON.has("info")) {
							errorMessage = respondJSON.getString("info");
						}
					} else {
						return null;
					}
				}
			}
		} catch (JSONException e) {
			errorCode = MyNetErrorCodeEnum.kNetErrorCodeEnum_Server_Server.getErrorCode();
			errorMessage = "数据交换协议发生了变化.";
		}

		return new MyNetRequestErrorBean(errorCode, errorMessage);

	}
}
