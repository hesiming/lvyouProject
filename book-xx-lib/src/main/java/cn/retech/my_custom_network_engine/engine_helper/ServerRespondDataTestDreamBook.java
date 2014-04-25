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
public final class ServerRespondDataTestDreamBook implements IServerRespondDataTest {

  @Override
  public MyNetRequestErrorBean testServerRespondDataError(final Object netUnpackedData) {

    final String netUnpackedDataOfUTF8String = (String) netUnpackedData;
    int errorCode = MyNetErrorCodeEnum.kNetErrorCodeEnum_Success.getErrorCode();
    String errorMessage = "OK";

    try {
      JSONObject respondJSON = new JSONObject(netUnpackedDataOfUTF8String);
      if (respondJSON != null) {
        if (respondJSON.has("status")) {
          errorCode = respondJSON.getInt("status");
          if (errorCode != 0) {// 状态码, 不为0时, 证明服务器没有给客户端返回有效的数据
            if (respondJSON.has("info")) {
              errorMessage = respondJSON.getString("info");
            }
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
