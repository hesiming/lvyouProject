package cn.lvyou.domainbean_model.register;

import java.util.HashMap;
import java.util.Map;

import android.text.TextUtils;
import cn.lvyou.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;
import cn.lvyou.toolutils.ToolsFunctionForThisProgect;

public final class RegisterParseDomainBeanToDD implements IParseDomainBeanToDataDictionary {

  @Override
  public Map<String, String> parseDomainBeanToDataDictionary(Object netRequestDomainBean) {

    if (null == netRequestDomainBean) {
      throw new IllegalArgumentException("netRequestDomainBean is null!");
    }

    boolean isRightObjectType = netRequestDomainBean instanceof RegisterNetRequestBean;
    if (!isRightObjectType) {
      throw new IllegalArgumentException("传入的业务Bean的类型不符 !");
    }

    RegisterNetRequestBean requestBean = (RegisterNetRequestBean) netRequestDomainBean;
    String email = requestBean.getEmail();
    String username = requestBean.getUsername();
    String password = requestBean.getPassword();
    if (TextUtils.isEmpty(email) || TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
      throw new IllegalArgumentException("必须的数据字段不完整 ! ");
    }

    Map<String, String> params = new HashMap<String, String>();
    // 必须参数
    params.put(RegisterDatabaseFieldsConstant.RequestBean.email.name(), email);
    params.put(RegisterDatabaseFieldsConstant.RequestBean.username.name(), username);
    params.put(RegisterDatabaseFieldsConstant.RequestBean.password.name(), password);
    params.put(RegisterDatabaseFieldsConstant.RequestBean.account_s.name(), ToolsFunctionForThisProgect.getAccountS(username, password));

    return params;
  }
}
