package cn.lvyou.domainbean_model.hot_country;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.lvyou.my_network_engine.domainbean_helper.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public class HotCountryParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		List<HotCountryItem> list = new ArrayList<HotCountryItem>();
		int continent_id = 0;
		String continent_name = "";
		// 获取ArrayObject
		if (jsonRootObject.has(HotCountryDatabaseFieldsConstant.RespondBean.data.name())) {
			JSONObject continentObject = jsonRootObject.getJSONObject(HotCountryDatabaseFieldsConstant.RespondBean.data.name());
			continent_id = JSONTools.safeParseJSONObjectForValueIsInteger(continentObject, HotCountryDatabaseFieldsConstant.RespondBean.continent_id.name(), 0);
			continent_name = JSONTools.safeParseJSONObjectForValueIsString(continentObject, HotCountryDatabaseFieldsConstant.RespondBean.continent_name.name(), "");
			if (continentObject.has(HotCountryDatabaseFieldsConstant.RespondBean.country.name())) {
				JSONArray countryArray = jsonRootObject.getJSONArray(HotCountryDatabaseFieldsConstant.RespondBean.country.name());
				for (int i = 0; i < countryArray.length(); i++) {
					JSONObject jsonObject = countryArray.getJSONObject(i);
					// int 国家id
					int country_id = JSONTools.safeParseJSONObjectForValueIsInteger(jsonObject, HotCountryDatabaseFieldsConstant.RespondBean.country_id.name(), 0);
					// string 国家名称
					String country_name = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, HotCountryDatabaseFieldsConstant.RespondBean.country_name.name(), "");

					HotCountryItem hotCountryItem = new HotCountryItem(country_id, country_name);
					list.add(hotCountryItem);
				}
			}

		}
		HotCountryNetRespondBean hotCountryNetRRespondBean = new HotCountryNetRespondBean(list);
		hotCountryNetRRespondBean.setContinent_id(continent_id);
		hotCountryNetRRespondBean.setContinent_name(continent_name);
		return hotCountryNetRRespondBean;
	}
}
