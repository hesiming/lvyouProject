package cn.lvyou.domainbean_model.optionTop;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.lvyou.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public class OptionTopParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		JSONObject jsonObject = new JSONObject((String) netRespondData);
		JSONArray jsonArray = jsonObject.getJSONArray(OptionTopDatabaseFiledsConstant.RespondBean.data.name());
		ArrayList<Operation> operations = new ArrayList<Operation>();
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jObj = jsonArray.getJSONObject(i);
			Operation op = new Operation();
			op.setOpenType(JSONTools.safeParseJSONObjectForValueIsInteger(jObj, OptionTopDatabaseFiledsConstant.RespondBean.open_type.name(), 0));
			op.setTitle(JSONTools.safeParseJSONObjectForValueIsString(jObj, OptionTopDatabaseFiledsConstant.RespondBean.title.name(), ""));
			op.setContent(JSONTools.safeParseJSONObjectForValueIsString(jObj, OptionTopDatabaseFiledsConstant.RespondBean.content.name(), ""));
			op.setIds(JSONTools.safeParseJSONObjectForValueIsString(jObj, OptionTopDatabaseFiledsConstant.RespondBean.ids.name(), ""));
			op.setUrl(JSONTools.safeParseJSONObjectForValueIsString(jObj, OptionTopDatabaseFiledsConstant.RespondBean.url.name(), ""));
			op.setPic(JSONTools.safeParseJSONObjectForValueIsString(jObj, OptionTopDatabaseFiledsConstant.RespondBean.pic.name(), ""));
			op.setBigPic(JSONTools.safeParseJSONObjectForValueIsString(jObj, OptionTopDatabaseFiledsConstant.RespondBean.big_pic.name(), ""));
			operations.add(op);
		}

		OptionTopNetRespondBean optionTopNetRespondBean = new OptionTopNetRespondBean(operations);

		return optionTopNetRespondBean;
	}
}
