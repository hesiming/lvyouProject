package cn.retech.domainbean_model.login;

import java.util.HashMap;
import java.util.Map;

import android.text.TextUtils;
import cn.retech.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;
import cn.retech.toolutils.ToolsFunctionForThisProgect;

public final class LoginParseDomainBeanToDD implements IParseDomainBeanToDataDictionary {

  @Override
  public Map<String, String> parseDomainBeanToDataDictionary(Object netRequestDomainBean) {

    if (null == netRequestDomainBean) {
      throw new IllegalArgumentException("netRequestDomainBean is null!");
    }

    boolean isRightObjectType = netRequestDomainBean instanceof LoginNetRequestBean;
    if (!isRightObjectType) {
      throw new IllegalArgumentException("传入的业务Bean的类型不符 !");
    }

    LoginNetRequestBean requestBean = (LoginNetRequestBean) netRequestDomainBean;
    String username = requestBean.getUsername();
    String password = requestBean.getPassword();
    if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
      throw new IllegalArgumentException("必须的数据字段不完整 ! ");
    }

    Map<String, String> params = new HashMap<String, String>();
    // 必须参数
    params.put(LoginDatabaseFieldsConstant.RequestBean.username.name(), username);
    params.put(LoginDatabaseFieldsConstant.RequestBean.password.name(), password);
    params.put(LoginDatabaseFieldsConstant.RequestBean.account_s.name(), ToolsFunctionForThisProgect.getAccountS(username, password));
    params.put("grant_type", "password");

    return params;
  }
}
