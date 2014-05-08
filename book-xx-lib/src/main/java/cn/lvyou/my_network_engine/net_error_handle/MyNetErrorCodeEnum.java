package cn.lvyou.my_network_engine.net_error_handle;

/**
 * 网络请求时, 错误码枚举 错误码说明 : http 错误码(0~999)
 * 
 * 
 * @author skyduck
 * 
 */
public enum MyNetErrorCodeEnum {

  // 未知的错误码
  kNetErrorCodeEnum_UNKNOWN(-2014, "未知的错误码"),

  // / http错误码 (0 ~ 999)
  kNetErrorCodeEnum_HTTP_Error(0, "http错误代码"),
  //
  kNetErrorCodeEnum_HTTP_NotFound(404, "页面未找到"),
  // 网络访问成功(也就是说从服务器获取到了正常的有效数据)
  kNetErrorCodeEnum_Success(200, "网络访问成功"),

  // / 客户端错误 (1000 ~ 1999)
  kNetErrorCodeEnum_Client_Error(1000, "客户端错误"),
  //
  kNetErrorCodeEnum_Client_ProgrammingError(1001, "客户端编程错误"), // 客户端编程错误
  //
  kNetErrorCodeEnum_Client_TimeOut(1002, "联网超时"), // 联网超时

  // / 服务器错误 (2000 ~ 2999)
  kNetErrorCodeEnum_Server_Error(2000, "服务器错误"),

  // 从服务器端获得的实体数据为空(EntityData), 这种情况有可能是正常的, 比如 退出登录 接口, 服务器就只是通知客户端访问成功,
  // 而不发送任何实体数据.
  kNetErrorCodeEnum_Server_NoResponseData(2001, "从服务器端获得的实体数据为空(EntityData), 这种情况有可能是正常的, 比如 退出登录 接口, 服务器就只是通知客户端访问成功, 而不发送任何实体数据."),
  // 解析服务器端返回的实体数据失败, 在netUnpackedDataOfUTF8String不为空的时候,
  // unpackNetRespondRawEntityDataToUTF8String是绝对不能为空的.
  kNetErrorCodeEnum_Server_UnpackedResponseDataFailed(2002, "解析服务器端返回的实体数据失败, 在netUnpackedDataOfUTF8String不为空的时候, unpackNetRespondRawEntityDataToUTF8String是绝对不能为空的."),
  // 服务器和客户端之前约定的数据交换协议发生了变化(这样会导致客户端解析服务器返回的数据失败)
  kNetErrorCodeEnum_Server_DataExchangeProtocolMismatch(2003, "服务器和客户端约定好的数据交换协议不匹配"),
  // 将网络返回的数据字符串(JSON/XML)解析成业务Bean失败.
  kNetErrorCodeEnum_Server_ParseNetRespondStringToDomainBeanFailed(2004, "将网络返回的数据字符串(JSON/XML)解析成业务Bean失败."),

  // / 和服务器约定好的错误码, 联网成功, 但是服务器那边发生了错误, 服务器要告知客户端错误的详细信息 (20000 ~ )

  kNetErrorCodeEnum_Server_Custom_Error(20000, "和服务器约定好的错误码, 联网成功, 但是服务器那边发生了错误, 服务器要告知客户端错误的详细信息"),
  //
  kNetErrorCodeEnum_Server_Failed(30001, "操作失败"), // "操作失败"
  kNetErrorCodeEnum_Server_Exception(30002, "处理异常"), // "处理异常"
  kNetErrorCodeEnum_Server_NoResult(30003, "无结果返回"), // "无结果返回"
  kNetErrorCodeEnum_Server_NeedLogin(30004, "需要登录"); // "需要登录"

  /**
   * 代码
   */
  private final int code;

  public int getCode() {
    return code;
  }

  /**
   * 描述
   */
  private final String description;

  public String getDescription() {
    return description;
  }

  /**
   * 构造方法
   * 
   * @param code
   *          代码
   * @param description
   *          描述
   */
  private MyNetErrorCodeEnum(int code, String description) {
    this.code = code;
    this.description = description;
  }

  public static MyNetErrorCodeEnum valueOfCode(int code) {
    for (MyNetErrorCodeEnum item : MyNetErrorCodeEnum.values()) {
      if (item.getCode() == code) {
        return item;
      }
    }

    if (code > kNetErrorCodeEnum_HTTP_Error.getCode() && code < kNetErrorCodeEnum_Client_Error.getCode()) {
      // http 错误
      return kNetErrorCodeEnum_HTTP_Error;
    } else if (code > kNetErrorCodeEnum_Server_Custom_Error.getCode()) {
      // 服务器自定义错误
      return kNetErrorCodeEnum_Server_Custom_Error;
    } else {
      // 未知的错误码
      return kNetErrorCodeEnum_UNKNOWN;
    }
  }
}
