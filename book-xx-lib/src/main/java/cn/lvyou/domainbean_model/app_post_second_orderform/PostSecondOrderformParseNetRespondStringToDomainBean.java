package cn.lvyou.domainbean_model.app_post_second_orderform;

import org.json.JSONObject;

import cn.lvyou.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public final class PostSecondOrderformParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		return new PostSecondOrderformNetRespondBean(JSONTools.safeParseJSONObjectForValueIsBoolean(jsonRootObject, PostSecondOrderformDatabaseFieldsConstant.RespondBean.data.name(), false));
	}

}
