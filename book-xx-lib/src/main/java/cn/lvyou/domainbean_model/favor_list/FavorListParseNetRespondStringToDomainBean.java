package cn.lvyou.domainbean_model.favor_list;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.lvyou.domainbean_model.get_list_byid.GetListByidDatabaseFieldsConstant;
import cn.lvyou.my_network_engine.domainbean_helper.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public final class FavorListParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		List<FavorItem> list = new ArrayList<FavorItem>();
		// 获取ArrayObject
		if (jsonRootObject.has(FavorListDatabaseFieldsConstant.RespondBean.data.name())) {
			JSONArray discountListArray = jsonRootObject.getJSONArray(FavorListDatabaseFieldsConstant.RespondBean.data.name());
			for (int i = 0; i < discountListArray.length(); i++) {
				JSONObject jsonObject = discountListArray.getJSONObject(i);
				// int ID
				int id = JSONTools.safeParseJSONObjectForValueIsInteger(jsonObject, GetListByidDatabaseFieldsConstant.RespondBean.id.name(), 0);
				// string 折扣封图
				String pic = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, GetListByidDatabaseFieldsConstant.RespondBean.pic.name(), "");
				// string 折扣title
				String title = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, GetListByidDatabaseFieldsConstant.RespondBean.title.name(), "");
				// 折扣简介
				String detail = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, GetListByidDatabaseFieldsConstant.RespondBean.detail.name(), "");
				// string 折扣价格
				String price = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, GetListByidDatabaseFieldsConstant.RespondBean.price.name(), "");
				// string 折扣到期时间
				String end_date = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, GetListByidDatabaseFieldsConstant.RespondBean.end_date.name(), "");
				// 是否穷游儿独享1-是0-否
				boolean self_use = JSONTools.safeParseJSONObjectForValueIsBoolean(jsonObject, GetListByidDatabaseFieldsConstant.RespondBean.self_use.name(), false);
				// 是否穷游首发1-是0-否
				boolean first_pub = JSONTools.safeParseJSONObjectForValueIsBoolean(jsonObject, GetListByidDatabaseFieldsConstant.RespondBean.first_pub.name(), false);

				FavorItem favorItem = new FavorItem(id, pic, title, detail, price, end_date, self_use, first_pub);

				list.add(favorItem);
			}
		}
		return new FavorListNetRespondBean(list);
	}

}
