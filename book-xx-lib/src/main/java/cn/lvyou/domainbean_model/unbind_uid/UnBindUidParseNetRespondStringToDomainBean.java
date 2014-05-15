package cn.lvyou.domainbean_model.unbind_uid;

import org.json.JSONObject;

import cn.lvyou.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public final class UnBindUidParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		return new UnBindUidNetRespondBean(JSONTools.safeParseJSONObjectForValueIsBoolean(jsonRootObject, UnBindUidDatabaseFieldsConstant.RespondBean.data.name(), false));
	}

}
