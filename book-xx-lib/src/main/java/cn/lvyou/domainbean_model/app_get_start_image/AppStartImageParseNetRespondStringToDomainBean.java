package cn.lvyou.domainbean_model.app_get_start_image;

import org.json.JSONObject;

import cn.lvyou.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public final class AppStartImageParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		AppStartImageNetResondBean appStartImageNetResondBean = new AppStartImageNetResondBean();
		// 获取ArrayObject
		if (jsonRootObject.has(AppStartImageDatabaseFieldsConstant.RespondBean.data.name())) {
			JSONObject appStartImageObject = jsonRootObject.getJSONObject(AppStartImageDatabaseFieldsConstant.RespondBean.data.name());

			appStartImageNetResondBean.setId(JSONTools.safeParseJSONObjectForValueIsInteger(appStartImageObject, AppStartImageDatabaseFieldsConstant.RespondBean.id.name(), 0));
			appStartImageNetResondBean.setUrl(JSONTools.safeParseJSONObjectForValueIsString(appStartImageObject, AppStartImageDatabaseFieldsConstant.RespondBean.url.name(), ""));
		}
		return appStartImageNetResondBean;
	}
}
