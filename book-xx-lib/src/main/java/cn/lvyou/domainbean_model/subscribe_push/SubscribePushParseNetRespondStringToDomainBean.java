package cn.lvyou.domainbean_model.subscribe_push;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.lvyou.my_network_engine.domainbean_helper.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public final class SubscribePushParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		List<SubscribePushItem> list = new ArrayList<SubscribePushItem>();
		// 获取ArrayObject
		if (jsonRootObject.has(SubscribePushDatabaseFieldsConstant.RespondBean.data.name())) {
			JSONArray discountListArray = jsonRootObject.getJSONArray(SubscribePushDatabaseFieldsConstant.RespondBean.data.name());
			for (int i = 0; i < discountListArray.length(); i++) {
				JSONObject jsonObject = discountListArray.getJSONObject(i);

				// int ID
				int id = JSONTools.safeParseJSONObjectForValueIsInteger(jsonObject, SubscribePushDatabaseFieldsConstant.RespondBean.id.name(), 0);
				// string 折扣封图
				String pic = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, SubscribePushDatabaseFieldsConstant.RespondBean.pic.name(), "");
				// string 折扣title
				String title = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, SubscribePushDatabaseFieldsConstant.RespondBean.title.name(), "");
				// string 折扣简介
				String detail = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, SubscribePushDatabaseFieldsConstant.RespondBean.price.name(), "");
				// string 折扣价格
				String price = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, SubscribePushDatabaseFieldsConstant.RespondBean.price.name(), "");
				// string 折扣到期时间
				String end_date = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, SubscribePushDatabaseFieldsConstant.RespondBean.end_date.name(), "");
				// int 是否穷游儿独享1-是0-否
				boolean self_use = JSONTools.safeParseJSONObjectForValueIsBoolean(jsonObject, SubscribePushDatabaseFieldsConstant.RespondBean.self_use.name(), false);
				// int 是否穷游首发1-是0-否
				boolean first_pub = JSONTools.safeParseJSONObjectForValueIsBoolean(jsonObject, SubscribePushDatabaseFieldsConstant.RespondBean.first_pub.name(), false);

				SubscribePushItem subscribePushItem = new SubscribePushItem(id, pic, title, detail, price, end_date, self_use, first_pub);
				list.add(subscribePushItem);
			}
		}
		return new SubscribePushNetRespondBean(list);
	}

}
