package cn.lvyou.domainbean_model.del_subscribe;

import org.json.JSONObject;

import cn.lvyou.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public final class DelSubscribeParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		return new DelSubscribeNetRespondBean(JSONTools.safeParseJSONObjectForValueIsBoolean(jsonRootObject, DelSubscribeDatabaseFieldsConstant.RespondBean.data.name(), false));
	}

}
