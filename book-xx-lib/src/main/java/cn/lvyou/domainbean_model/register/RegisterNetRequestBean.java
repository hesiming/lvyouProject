package cn.lvyou.domainbean_model.register;

public final class RegisterNetRequestBean {
  // 邮箱
  private final String email;
  // 登录名
  private final String username;
  // 密码
  private final String password;

  public RegisterNetRequestBean(String email, String username, String password) {
    this.email = email;
    this.username = username;
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public String toString() {
    return "RegisterNetRequestBean [email=" + email + ", username=" + username + ", password=" + password + "]";
  }

}
