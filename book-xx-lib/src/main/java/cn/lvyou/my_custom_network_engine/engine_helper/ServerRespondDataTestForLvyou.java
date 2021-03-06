package cn.lvyou.my_custom_network_engine.engine_helper;

import org.json.JSONException;
import org.json.JSONObject;

import cn.lvyou.my_network_engine.engine_helper.interfaces.IServerRespondDataTest;
import cn.lvyou.my_network_engine.net_error_handle.MyNetErrorCodeEnum;
import cn.lvyou.my_network_engine.net_error_handle.MyNetRequestErrorBean;

/**
 * 
 * @author skyduck
 * 
 */
public final class ServerRespondDataTestForLvyou implements IServerRespondDataTest {

  @Override
  public MyNetRequestErrorBean testServerRespondDataError(final Object netUnpackedData) {

    final String netUnpackedDataOfUTF8String = (String) netUnpackedData;
    int errorCode = MyNetErrorCodeEnum.kNetErrorCodeEnum_Success.getCode();
    String errorMessage = "OK";

    try {
      JSONObject respondJSON = new JSONObject(netUnpackedDataOfUTF8String);
      // 这里的逻辑修改了:
      // 原来的逻辑是:status表示返回的数据不正确
      // 现在的逻辑是:status不能表示返回的数据不正确
      // 这里修改的方式,当errorcode不为1则表示不是正确的,只要为1都表示正确,这里需要再次确认
      if (respondJSON.has("status")) {
        errorCode = respondJSON.getInt("status");
        // 这里的状态需要根据具体的业务逻辑来,qyer业务逻辑中1表示正确数据,0表示无数据
        switch (errorCode) {
        case 0:// 无数据
          errorCode = MyNetErrorCodeEnum.kNetErrorCodeEnum_Server_NoResult.getCode();
          break;
        case 1:// 访问成功
          errorCode = MyNetErrorCodeEnum.kNetErrorCodeEnum_Success.getCode();
          break;
        default:
          break;
        }

        // 获取错误信息
        if (respondJSON.has("info")) {
          errorMessage = respondJSON.getString("info");
        }
      }
    } catch (JSONException e) {
      errorCode = MyNetErrorCodeEnum.kNetErrorCodeEnum_Server_DataExchangeProtocolMismatch.getCode();
      errorMessage = "服务器和客户端约定好的数据交换协议不匹配.";
    }

    return new MyNetRequestErrorBean(errorCode, errorMessage);

  }
}
