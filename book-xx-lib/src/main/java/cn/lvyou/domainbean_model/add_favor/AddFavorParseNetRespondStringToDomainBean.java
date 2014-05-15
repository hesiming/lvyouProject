package cn.lvyou.domainbean_model.add_favor;

import org.json.JSONObject;

import cn.lvyou.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public final class AddFavorParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		return new AddFavorNetRespondBean(JSONTools.safeParseJSONObjectForValueIsBoolean(jsonRootObject, AddFavorDatabaseFieldsConstant.RespondBean.data.name(), false));
	}

}
