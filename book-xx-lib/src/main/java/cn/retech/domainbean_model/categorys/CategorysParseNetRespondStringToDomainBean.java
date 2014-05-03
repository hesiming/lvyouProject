package cn.retech.domainbean_model.categorys;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cn.retech.domainbean_model.categorys.categorybeans.CategoryDate;
import cn.retech.domainbean_model.categorys.categorybeans.CategoryOriginPlace;
import cn.retech.domainbean_model.categorys.categorybeans.CategoryPlace;
import cn.retech.domainbean_model.categorys.categorybeans.CategoryPlaceCountry;
import cn.retech.domainbean_model.categorys.categorybeans.CategoryType;
import cn.retech.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;

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
    ArrayList<CategoryType> typeList = new ArrayList<CategoryType>();
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
    ArrayList<CategoryPlace> placesList = new ArrayList<CategoryPlace>();
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
    ArrayList<CategoryDate> dateList = new ArrayList<CategoryDate>();
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
    ArrayList<CategoryOriginPlace> originPlaceList = new ArrayList<CategoryOriginPlace>();
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
