package cn.lvyou.domainbean_model.del_favor;

import org.json.JSONObject;

import cn.lvyou.my_network_engine.domainbean_helper.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public final class DelFavorParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		return new DelFavorNetRespondBean(JSONTools.safeParseJSONObjectForValueIsBoolean(jsonRootObject, DelFavorDatabaseFieldsConstant.RespondBean.data.name(), false));
	}

}
