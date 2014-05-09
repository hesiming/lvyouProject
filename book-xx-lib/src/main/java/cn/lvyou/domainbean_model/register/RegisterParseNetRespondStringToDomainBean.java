package cn.lvyou.domainbean_model.register;

import org.json.JSONObject;

import cn.lvyou.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public final class RegisterParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

  @Override
  public Object parseNetRespondDataToDomainBean(final Object netRespondData) throws Exception {

    final String netRespondString = (String) netRespondData;

    JSONObject jsonRootObject = new JSONObject(netRespondString);
    // 关键数据完整性检测
    if (JSONTools.isEmpty(jsonRootObject, RegisterDatabaseFieldsConstant.RespondBean.data.name())) {
      throw new IllegalArgumentException("is not find 'data' field ! ");
    }

    JSONObject jsonObjectOfData = JSONTools.safeParseJSONObjectForValueIsJSONObject(jsonRootObject, RegisterDatabaseFieldsConstant.RespondBean.data.name());

    int uid = JSONTools.safeParseJSONObjectForValueIsInteger(jsonObjectOfData, RegisterDatabaseFieldsConstant.RespondBean.uid.name(), 0);
    String userName = JSONTools.safeParseJSONObjectForValueIsString(jsonObjectOfData, RegisterDatabaseFieldsConstant.RespondBean.userName.name(), "");
    String email = JSONTools.safeParseJSONObjectForValueIsString(jsonObjectOfData, RegisterDatabaseFieldsConstant.RespondBean.email.name(), "");

    RegisterNetRespondBean logonNetRespondBean = new RegisterNetRespondBean(uid, userName, email);

    return logonNetRespondBean;
  }
}
