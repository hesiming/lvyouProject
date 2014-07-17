package cn.lvyou.domainbean_model.subscribe_list;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.lvyou.my_network_engine.domainbean_helper.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public final class SubscribeListParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		List<SubscribeItem> list = new ArrayList<SubscribeItem>();
		// 获取ArrayObject
		if (jsonRootObject.has(SubscribeListDatabaseFieldsConstant.RespondBean.data.name())) {
			JSONArray discountListArray = jsonRootObject.getJSONArray(SubscribeListDatabaseFieldsConstant.RespondBean.data.name());
			for (int i = 0; i < discountListArray.length(); i++) {
				JSONObject jsonObject = discountListArray.getJSONObject(i);
				// int ID
				int id = JSONTools.safeParseJSONObjectForValueIsInteger(jsonObject, SubscribeListDatabaseFieldsConstant.RespondBean.id.name(), 0);
				// 折扣类型
				String product_type = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, SubscribeListDatabaseFieldsConstant.RespondBean.product_type.name(), "");
				// 旅行时间
				String date_str = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, SubscribeListDatabaseFieldsConstant.RespondBean.date_str.name(), "");
				// 目的地
				String country = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, SubscribeListDatabaseFieldsConstant.RespondBean.country.name(), "");
				// 出发地
				String start_pos = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, SubscribeListDatabaseFieldsConstant.RespondBean.start_pos.name(), "");

				SubscribeItem subscribeItem = new SubscribeItem(id, product_type, date_str, country, start_pos);

				list.add(subscribeItem);
			}
		}
		return new SubscribeListNetRespondBean(list);
	}
}
