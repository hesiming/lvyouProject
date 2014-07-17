package cn.lvyou.domainbean_model.categorys;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.lvyou.domainbean_model.categorys.categorybeans.CategoryDate;
import cn.lvyou.domainbean_model.categorys.categorybeans.CategoryOriginPlace;
import cn.lvyou.domainbean_model.categorys.categorybeans.CategoryPlace;
import cn.lvyou.domainbean_model.categorys.categorybeans.CategoryPlaceCountry;
import cn.lvyou.domainbean_model.categorys.categorybeans.CategoryType;
import cn.lvyou.domainbean_model.categorys.categorybeans.ICategoryItem;
import cn.lvyou.my_network_engine.domainbean_helper.IParseNetRespondDataToDomainBean;

public class CategorysParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	public static Integer getIntegerFromJson(JSONObject jsonObject, String key) throws JSONException {
		Integer ret = 0;
		if (jsonObject.has(key)) {
			ret = jsonObject.getInt(key);
		}
		return ret;
	}

	public static JSONArray getJsonArrayFromJson(JSONObject jsonObject, String key) throws JSONException {
		JSONArray ret = new JSONArray();
		if (jsonObject.has(key)) {
			ret = jsonObject.getJSONArray(key);
		}
		return ret;
	}

	public static String getStringFromJson(JSONObject jsonObject, String key) throws JSONException {
		String ret = "";
		if (jsonObject.has(key)) {
			ret = jsonObject.getString(key);
		}
		return ret;
	}

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws JSONException {
		JSONObject jsonObject = new JSONObject((String) netRespondData);

		JSONObject jObject = jsonObject.getJSONObject("data");
		CategorysNetRespondBean categorysNetRespondBean = new CategorysNetRespondBean();
		// 折扣类型 解析
		JSONArray types = getJsonArrayFromJson(jObject, "type");
		ArrayList<ICategoryItem> typeList = new ArrayList<ICategoryItem>();
		for (int i = 0; i < types.length(); i++) {
			JSONObject obj = types.getJSONObject(i);
			CategoryType ct = new CategoryType();
			ct.setId(getIntegerFromJson(obj, "id"));
			ct.setCateName(getStringFromJson(obj, "catename"));
			typeList.add(ct);
		}
		categorysNetRespondBean.setTypes(typeList);
		// 目的地
		JSONArray places = getJsonArrayFromJson(jObject, "poi");
		ArrayList<ICategoryItem> placesList = new ArrayList<ICategoryItem>();
		for (int i = 0; i < places.length(); i++) {
			JSONObject obj = places.getJSONObject(i);
			CategoryPlace cp = new CategoryPlace();
			cp.setContinentId(getIntegerFromJson(obj, "continent_id"));
			cp.setContinentName(getStringFromJson(obj, "continent_name"));

			JSONArray jay = getJsonArrayFromJson(obj, "country");
			ArrayList<CategoryPlaceCountry> placesCList = new ArrayList<CategoryPlaceCountry>();
			for (int j = 0; j < jay.length(); j++) {
				JSONObject jcpc = jay.getJSONObject(j);
				CategoryPlaceCountry cpc = new CategoryPlaceCountry();
				cpc.setCountryId(getStringFromJson(jcpc, "country_id"));
				cpc.setCountryName(getStringFromJson(jcpc, "country_name"));
				placesCList.add(cpc);
			}
			cp.setCountrise(placesCList);
			placesList.add(cp);
		}
		categorysNetRespondBean.setPlaces(placesList);
		// 旅行时间
		ArrayList<ICategoryItem> dateList = new ArrayList<ICategoryItem>();
		JSONArray timesDrange = getJsonArrayFromJson(jObject, "times_drange");
		for (int i = 0; i < timesDrange.length(); i++) {
			JSONObject obj = timesDrange.getJSONObject(i);
			CategoryDate cd = new CategoryDate();
			cd.setTiems(getStringFromJson(obj, "times"));
			cd.setDescription(getStringFromJson(obj, "description"));
			dateList.add(cd);
		}
		categorysNetRespondBean.setDates(dateList);
		// 出发地
		ArrayList<ICategoryItem> originPlaceList = new ArrayList<ICategoryItem>();
		JSONArray originPlaces = getJsonArrayFromJson(jObject, "departure");
		for (int i = 0; i < originPlaces.length(); i++) {
			JSONObject obj = originPlaces.getJSONObject(i);
			CategoryOriginPlace cd = new CategoryOriginPlace();
			cd.setCity(getStringFromJson(obj, "city"));
			cd.setCityDes(getStringFromJson(obj, "city_des"));
			originPlaceList.add(cd);
		}
		categorysNetRespondBean.setOriginPlace(originPlaceList);

		return categorysNetRespondBean;
	}
}
