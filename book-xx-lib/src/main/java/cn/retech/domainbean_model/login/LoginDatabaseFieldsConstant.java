package cn.retech.domainbean_model.login;

public final class LoginDatabaseFieldsConstant {
  private LoginDatabaseFieldsConstant() {

  }

  public static enum RequestBean {
    // 登录名
    username,
    // 密码
    password,
    //
    account_s,

  }

  public static enum RespondBean {
    /// 访问令牌
    //
    access_token,
    // 过期时间
    expires_in,
    // 授权范围
    scope,

    /// 用户信息
    user_info,
    // 用户ID
    uid,
    // 用户名称
    userName,
    // 邮箱
    email,
    // 性别 0 保密 1 男 2 女
    gender,
    // 自我介绍
    bio,
    // 最后访问时间
    lastVisit,
    // 个人头像图片url地址
    avatar,
    // 用户手机号码
    phone;
  }
}
