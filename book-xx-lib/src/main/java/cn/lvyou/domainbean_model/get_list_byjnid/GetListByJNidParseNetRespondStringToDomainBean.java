package cn.lvyou.domainbean_model.get_list_byjnid;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.lvyou.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public final class GetListByJNidParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		List<JNidBean> list = new ArrayList<JNidBean>();
		// 获取ArrayObject
		if (jsonRootObject.has(GetListByJNidDatabaseFieldsConstant.RespondBean.data.name())) {
			JSONArray discountListArray = jsonRootObject.getJSONArray(GetListByJNidDatabaseFieldsConstant.RespondBean.data.name());
			for (int i = 0; i < discountListArray.length(); i++) {
				JSONObject jsonObject = discountListArray.getJSONObject(i);
				// int ID
				int id = JSONTools.safeParseJSONObjectForValueIsInteger(jsonObject, GetListByJNidDatabaseFieldsConstant.RespondBean.id.name(), 0);
				// string 折扣封图
				String pic = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, GetListByJNidDatabaseFieldsConstant.RespondBean.pic.name(), "");
				// string 折扣title
				String title = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, GetListByJNidDatabaseFieldsConstant.RespondBean.title.name(), "");
				// string 折扣价格
				String price = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, GetListByJNidDatabaseFieldsConstant.RespondBean.price.name(), "");
				// string 折扣到期时间
				String end_date = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, GetListByJNidDatabaseFieldsConstant.RespondBean.end_date.name(), "");
				// string web方面链接
				String web_url = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, GetListByJNidDatabaseFieldsConstant.RespondBean.web_url.name(), "");
				// string m方面链接
				String m_url = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, GetListByJNidDatabaseFieldsConstant.RespondBean.m_url.name(), "");
				// int 分类
				int product_type = JSONTools.safeParseJSONObjectForValueIsInteger(jsonObject, GetListByJNidDatabaseFieldsConstant.RespondBean.product_type.name(), 0);

				JNidBean jNidBean = new JNidBean(id, pic, title, price, end_date, web_url, m_url, product_type);
				list.add(jNidBean);
			}
		}
		return new GetListByJNidNetRespondBean(list);
	}

}
