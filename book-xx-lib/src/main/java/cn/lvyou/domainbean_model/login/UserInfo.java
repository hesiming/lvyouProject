package cn.lvyou.domainbean_model.login;

import java.io.Serializable;

import cn.lvyou.global_data_cache.GlobalConstant.SexEnum;

/**
 * 用户信息
 * 
 * @author skyduck
 * 
 */
public class UserInfo implements Serializable, Cloneable {

  /**
   * 
   */
  private static final long serialVersionUID = -4101592569137143311L;
  private String uid;
  private String userName;
  private String email;
  private SexEnum gender;
  private String bio;
  private int lastVisit;
  private String avatar;
  private String phone;

  @Override
  public UserInfo clone() {
    UserInfo cloneObject = null;
    try {
      cloneObject = (UserInfo) super.clone();
      cloneObject.uid = this.uid;
      cloneObject.userName = this.userName;
      cloneObject.email = this.email;
      cloneObject.gender = this.gender;
      cloneObject.bio = this.bio;
      cloneObject.lastVisit = this.lastVisit;
      cloneObject.avatar = this.avatar;
      cloneObject.phone = this.phone;
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e); // won't happen        
    }
    return cloneObject;
  }

  public UserInfo(String uid, String userName, String email, int gender, String bio, int lastVisit, String avatar, String phone) {
    super();
    this.uid = uid;
    this.userName = userName;
    this.email = email;
    this.gender = SexEnum.valueOfCode(gender);
    this.bio = bio;
    this.lastVisit = lastVisit;
    this.avatar = avatar;
    this.phone = phone;
  }

  public String getUid() {
    return uid;
  }

  public String getUserName() {
    return userName;
  }

  public String getEmail() {
    return email;
  }

  public SexEnum getGender() {
    return gender;
  }

  public String getBio() {
    return bio;
  }

  public int getLastVisit() {
    return lastVisit;
  }

  public String getAvatar() {
    return avatar;
  }

  public String getPhone() {
    return phone;
  }

  @Override
  public String toString() {
    return "UserInfo [uid=" + uid + ", userName=" + userName + ", email=" + email + ", gender=" + gender + ", bio=" + bio + ", lastVisit=" + lastVisit + ", avatar=" + avatar + ", phone=" + phone
        + "]";
  }

}
