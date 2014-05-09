package cn.lvyou.domainbean_model.register;

public final class RegisterDatabaseFieldsConstant {
  private RegisterDatabaseFieldsConstant() {

  }

  public static enum RequestBean {
    // 邮箱
    email,
    // 登录名
    username,
    // 密码
    password,
    //
    account_s,

  }

  public static enum RespondBean {

    data,
    
    // 用户ID
    uid,
    // 用户名称
    userName,
    // 邮箱
    email
  }
}
