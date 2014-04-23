package cn.retech.domainbean_model.login;

import java.io.Serializable;

public class AccessToken implements Serializable, Cloneable {

  /**
   * 
   */
  private static final long serialVersionUID = -6103860375305972229L;
  private String access_token;//token
  private int expires_in;//过期时间
  private String scope;//授权范围

  @Override
  public AccessToken clone() {
    AccessToken cloneObject = null;
    try {
      cloneObject = (AccessToken) super.clone();
      cloneObject.access_token = this.access_token;
      cloneObject.expires_in = this.expires_in;
      cloneObject.scope = this.scope;

    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e); // won't happen        
    }
    return cloneObject;
  }

  public AccessToken(String access_token, int expires_in, String scope) {
    this.access_token = access_token;
    this.expires_in = expires_in;
    this.scope = scope;
  }

  public String getAccess_token() {
    return access_token;
  }

  public void setAccess_token(String access_token) {
    this.access_token = access_token;
  }

  public int getExpires_in() {
    return expires_in;
  }

  public void setExpires_in(int expires_in) {
    this.expires_in = expires_in;
  }

  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  @Override
  public String toString() {
    return "AccessToken [access_token=" + access_token + ", expires_in=" + expires_in + ", scope=" + scope + "]";
  }

}
