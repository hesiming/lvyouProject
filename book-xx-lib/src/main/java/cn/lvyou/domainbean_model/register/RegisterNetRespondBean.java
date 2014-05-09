package cn.lvyou.domainbean_model.register;

public class RegisterNetRespondBean {

  // 用户ID
  private final int uid;
  // 登录名
  private final String userName;
  // 邮箱
  private final String email;

  public RegisterNetRespondBean(int uid, String userName, String email) {
    this.uid = uid;
    this.userName = userName;
    this.email = email;
  }

  public int getUid() {
    return uid;
  }

  public String getUserName() {
    return userName;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "RegisterNetRespondBean [uid=" + uid + ", userName=" + userName + ", email=" + email + "]";
  }

}
