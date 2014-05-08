package cn.lvyou.domainbean_model.discount_list;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.lvyou.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

/**
 * 将Json串转成DomainBean
 * 
 * @author hesiming
 * 
 */
public final class DiscountListParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		List<DiscountListNetRespondBean> list = new ArrayList<DiscountListNetRespondBean>();
		// 获取ArrayObject
		if (jsonRootObject.has(DiscountListDatabaseFiledsConstant.RespondBean.data.name())) {
			JSONArray discountListArray = jsonRootObject.getJSONArray(DiscountListDatabaseFiledsConstant.RespondBean.data.name());
			for (int i = 0; i < discountListArray.length(); i++) {
				JSONObject jsonObject = discountListArray.getJSONObject(i);
				// Id
				int id = JSONTools.safeParseJSONObjectForValueIsInteger(jsonObject, DiscountListDatabaseFiledsConstant.RespondBean.id.name(), 0);
				// 折扣封图
				String pic = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, DiscountListDatabaseFiledsConstant.RespondBean.pic.name(), "");
				// 折扣title
				String title = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, DiscountListDatabaseFiledsConstant.RespondBean.title.name(), "");
				// 折扣简介
				String detail = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, DiscountListDatabaseFiledsConstant.RespondBean.detail.name(), "");
				// 折扣价格
				String price = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, DiscountListDatabaseFiledsConstant.RespondBean.price.name(), "");
				// 折扣到期时间
				String end_date = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, DiscountListDatabaseFiledsConstant.RespondBean.end_date.name(), "");
				// 是否穷游儿独享1-是0-否
				boolean self_use = JSONTools.safeParseJSONObjectForValueIsBoolean(jsonObject, DiscountListDatabaseFiledsConstant.RespondBean.self_use.name(), false);
				// 是否穷游首发1-是0-否
				boolean first_pub = JSONTools.safeParseJSONObjectForValueIsBoolean(jsonObject, DiscountListDatabaseFiledsConstant.RespondBean.first_pub.name(), false);
				// 原价
				int list_price = JSONTools.safeParseJSONObjectForValueIsInteger(jsonObject, DiscountListDatabaseFiledsConstant.RespondBean.list_price.name(), 0);
				// appview折扣详细页面url
				String url = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, DiscountListDatabaseFiledsConstant.RespondBean.url.name(), "");

				DiscountListNetRespondBean discountListNetRespondBean = new DiscountListNetRespondBean(id, pic, title, detail, price, end_date, self_use, first_pub, list_price, url);
				list.add(discountListNetRespondBean);
			}
		}
		return new DiscountListBean(list);
	}
}
