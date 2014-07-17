package cn.lvyou.domainbean_model.add_subscribe;

import org.json.JSONObject;

import cn.lvyou.my_network_engine.domainbean_helper.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public final class AddSubscribeParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		return new AddSubscribeNetRespondBean(JSONTools.safeParseJSONObjectForValueIsBoolean(jsonRootObject, AddSubscribeDatabaseFieldsConstant.RespondBean.data.name(), false));
	}

}
