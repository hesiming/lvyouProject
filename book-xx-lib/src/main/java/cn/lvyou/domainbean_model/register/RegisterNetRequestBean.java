package cn.lvyou.domainbean_model.register;

public final class RegisterNetRequestBean {
  // 邮箱
  private final String mail;
  // 登录名
  private final String username;
  // 密码
  private final String password;

  public RegisterNetRequestBean(String mail, String username, String password) {
    this.mail = mail;
    this.username = username;
    this.password = password;
  }

  public String getMail() {
    return mail;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public String toString() {
    return "RegisterNetRequestBean [mail=" + mail + ", username=" + username + ", password=" + password + "]";
  }

}
