package cn.lvyou.domainbean_model.app_post_del_orderform;

import org.json.JSONObject;

import cn.lvyou.my_network_engine.domainbean_helper.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public final class DelOrderformParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		return new DelOrderformNetRespondBean(JSONTools.safeParseJSONObjectForValueIsBoolean(jsonRootObject, DelOrderformDatabaseFieldsConstant.RespondBean.data.name(), false));
	}

}
