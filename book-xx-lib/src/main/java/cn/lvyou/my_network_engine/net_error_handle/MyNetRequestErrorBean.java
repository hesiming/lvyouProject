package cn.lvyou.my_network_engine.net_error_handle;

import java.io.Serializable;

/**
 * 网络请求过程中, 发生错误时的数据Bean
 * 
 * @author skyduck
 */
public final class MyNetRequestErrorBean implements Serializable, Cloneable {

  /**
	 * 
	 */
  private static final long serialVersionUID = 4841567150604927632L;

  // 错误代码
  private MyNetErrorCodeEnum errorCodeEnum = MyNetErrorCodeEnum.kNetErrorCodeEnum_Success;
  // 错误描述信息
  private String errorMessage = "OK";

  public MyNetRequestErrorBean() {
  }

  public MyNetRequestErrorBean(int errorCode, String errorMessage) {
    this(MyNetErrorCodeEnum.valueOfCode(errorCode), errorMessage);
  }

  public MyNetRequestErrorBean(MyNetErrorCodeEnum errorCodeEnum, String errorMessage) {
    this.errorCodeEnum = errorCodeEnum;
    this.errorMessage = errorMessage;
  }

  /**
   * 重新初始化
   * 
   * @param srcObject
   */
  public void reinitialize(final MyNetRequestErrorBean srcObject) {
    if (srcObject != null) {
      this.errorCodeEnum = srcObject.errorCodeEnum;
      this.errorMessage = srcObject.errorMessage;
    } else {
      this.errorCodeEnum = MyNetErrorCodeEnum.kNetErrorCodeEnum_Success;
      this.errorMessage = "OK";
    }
  }

  public MyNetErrorCodeEnum getErrorCodeEnum() {
    return errorCodeEnum;
  }

  public int getErrorCode() {
    return errorCodeEnum.getCode();
  }

  public void setErrorCodeEnum(MyNetErrorCodeEnum errorCodeEnum) {
    this.errorCodeEnum = errorCodeEnum;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public MyNetRequestErrorBean clone() {
    MyNetRequestErrorBean o = null;
    try {
      o = (MyNetRequestErrorBean) super.clone();// Object
                                                // 中的clone()识别出你要复制的是哪一个对象。
      o.errorCodeEnum = this.errorCodeEnum;
      o.errorMessage = this.errorMessage;
    } catch (CloneNotSupportedException e) {
      System.out.println(e.toString());
    }
    return o;
  }

  @Override
  public String toString() {
    return "NetErrorBean [errorCodeEnum=" + errorCodeEnum + ", errorMessage=" + errorMessage + "]";
  }

}
