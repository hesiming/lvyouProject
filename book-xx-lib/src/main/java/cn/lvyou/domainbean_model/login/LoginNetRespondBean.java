package cn.lvyou.domainbean_model.login;

import java.io.Serializable;

public final class LoginNetRespondBean implements Serializable, Cloneable {

  /**
   * 
   */
  private static final long serialVersionUID = -2890995490628744290L;

  private AccessToken accessToken;

  private UserInfo userInfo;

  public LoginNetRespondBean() {
    
  }
  public LoginNetRespondBean(AccessToken accessToken, UserInfo userInfo) {
    this.accessToken = accessToken;
    this.userInfo = userInfo;
  }

  @Override
  public LoginNetRespondBean clone() {
    LoginNetRespondBean cloneObject = null;
    try {
      cloneObject = (LoginNetRespondBean) super.clone();
      cloneObject.userInfo = this.userInfo.clone();
      cloneObject.accessToken = this.accessToken.clone();

    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e); // won't happen        
    }
    return cloneObject;
  }

  public AccessToken getAccessToken() {
    return accessToken;
  }

  public UserInfo getUserInfo() {
    return userInfo;
  }

  @Override
  public String toString() {
    return "LoginNetRespondBean [accessToken=" + accessToken + ", userInfo=" + userInfo + "]";
  }

}
