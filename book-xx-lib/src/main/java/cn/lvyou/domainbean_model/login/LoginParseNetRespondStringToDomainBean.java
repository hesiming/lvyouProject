package cn.lvyou.domainbean_model.login;

import org.json.JSONObject;

import android.text.TextUtils;
import cn.lvyou.global_data_cache.GlobalConstant.SexEnum;
import cn.lvyou.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public final class LoginParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

  @Override
  public Object parseNetRespondDataToDomainBean(final Object netRespondData) throws Exception {

    final String netRespondString = (String) netRespondData;
    JSONObject jsonRootObject = new JSONObject(netRespondString);
    // 关键数据完整性检测
    if (JSONTools.isEmpty(jsonRootObject, LoginDatabaseFieldsConstant.RespondBean.access_token.name())) {
      throw new IllegalArgumentException("is not find 'access_token' field ! ");
    }
    if (JSONTools.isEmpty(jsonRootObject, LoginDatabaseFieldsConstant.RespondBean.user_info.name())) {
      throw new IllegalArgumentException("is not find 'user_info' field ! ");
    }
    String access_token = JSONTools.safeParseJSONObjectForValueIsString(jsonRootObject, LoginDatabaseFieldsConstant.RespondBean.access_token.name(), "");
    if (TextUtils.isEmpty(access_token)) {
      throw new IllegalArgumentException("关键字段 access_token 的值不能为空!");
    }
    int expires_in = JSONTools.safeParseJSONObjectForValueIsInteger(jsonRootObject, LoginDatabaseFieldsConstant.RespondBean.expires_in.name(), 0);
    String scope = JSONTools.safeParseJSONObjectForValueIsString(jsonRootObject, LoginDatabaseFieldsConstant.RespondBean.scope.name(), "");
    AccessToken accessToken = new AccessToken(access_token, expires_in, scope);

    JSONObject jsonObjectOfUserInfo = JSONTools.safeParseJSONObjectForValueIsJSONObject(jsonRootObject, LoginDatabaseFieldsConstant.RespondBean.user_info.name());
    if (JSONTools.isEmpty(jsonObjectOfUserInfo, LoginDatabaseFieldsConstant.RespondBean.uid.name())) {
      // TODO : 发现新注册的用户, 登录成功后, 这个uid就是空的
      //throw new IllegalArgumentException("is not find 'uid' field ! ");
    }
    String uid = JSONTools.safeParseJSONObjectForValueIsString(jsonObjectOfUserInfo, LoginDatabaseFieldsConstant.RespondBean.uid.name(), "");
    String userName = JSONTools.safeParseJSONObjectForValueIsString(jsonObjectOfUserInfo, LoginDatabaseFieldsConstant.RespondBean.userName.name(), "");
    String email = JSONTools.safeParseJSONObjectForValueIsString(jsonObjectOfUserInfo, LoginDatabaseFieldsConstant.RespondBean.email.name(), "");
    int gender = JSONTools.safeParseJSONObjectForValueIsInteger(jsonObjectOfUserInfo, LoginDatabaseFieldsConstant.RespondBean.gender.name(), SexEnum.Null.getCode());
    String bio = JSONTools.safeParseJSONObjectForValueIsString(jsonObjectOfUserInfo, LoginDatabaseFieldsConstant.RespondBean.bio.name(), "");
    int lastVisit = JSONTools.safeParseJSONObjectForValueIsInteger(jsonObjectOfUserInfo, LoginDatabaseFieldsConstant.RespondBean.lastVisit.name(), 0);
    String avatar = JSONTools.safeParseJSONObjectForValueIsString(jsonObjectOfUserInfo, LoginDatabaseFieldsConstant.RespondBean.avatar.name(), "");
    String phone = JSONTools.safeParseJSONObjectForValueIsString(jsonObjectOfUserInfo, LoginDatabaseFieldsConstant.RespondBean.phone.name(), "");
    UserInfo userInfo = new UserInfo(uid, userName, email, gender, bio, lastVisit, avatar, phone);

    LoginNetRespondBean logonNetRespondBean = new LoginNetRespondBean(accessToken, userInfo);

    return logonNetRespondBean;
  }
}
