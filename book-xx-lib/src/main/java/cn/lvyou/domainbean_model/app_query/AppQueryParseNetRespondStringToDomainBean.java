package cn.lvyou.domainbean_model.app_query;

import org.json.JSONObject;

import cn.lvyou.my_network_engine.domainbean_helper.IParseNetRespondDataToDomainBean;

public class AppQueryParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		String out_trade_no = "";
		// 获取ArrayObject
		if (jsonRootObject.has(AppQueryDatabaseFieldsConstant.RespondBean.data.name())) {
			out_trade_no = jsonRootObject.getString(AppQueryDatabaseFieldsConstant.RespondBean.data.name());
		}

		return new AppQueryNetRespondBean(out_trade_no);
	}
}
