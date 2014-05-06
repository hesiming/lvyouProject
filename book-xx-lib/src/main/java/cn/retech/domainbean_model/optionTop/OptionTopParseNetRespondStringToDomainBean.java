package cn.retech.domainbean_model.optionTop;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cn.retech.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;

public class OptionTopParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

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
    JSONArray jsonArray = jsonObject.getJSONArray("data");
    ArrayList<Operation> operations = new ArrayList<Operation>();
    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject jObj = jsonArray.getJSONObject(i);
      Operation op = new Operation();
      op.setOpenType(getIntegerFromJson(jObj, "open_type"));
      op.setTitle(getStringFromJson(jObj, "title"));
      op.setContent(getStringFromJson(jObj, "content"));
      op.setIds(getStringFromJson(jObj, "ids"));
      op.setUrl(getStringFromJson(jObj, "url"));
      op.setPic(getStringFromJson(jObj, "pic"));
      op.setBigPic(getStringFromJson(jObj, "big_pic"));
      operations.add(op);
    }

    OptionTopNetRespondBean optionTopNetRespondBean = new OptionTopNetRespondBean(operations);

    return optionTopNetRespondBean;
  }
}
