package cn.lvyou.domainbean_model.app_get_bookinfo;

import org.json.JSONObject;

import cn.lvyou.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public class BookInfoParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		BookInfoNetRespondBean bookInfoNetRespondBean = new BookInfoNetRespondBean();
		// 获取ArrayObject
		if (jsonRootObject.has(BookInfoDatabaseFieldsConstant.RespondBean.data.name())) {
			JSONObject continentObject = jsonRootObject.getJSONObject(BookInfoDatabaseFieldsConstant.RespondBean.data.name());
			// int 折扣ID
			bookInfoNetRespondBean.setId(JSONTools.safeParseJSONObjectForValueIsInteger(continentObject, BookInfoDatabaseFieldsConstant.RespondBean.id.name(), 0));
			// string 折扣H5页地址
			bookInfoNetRespondBean.setUrl(JSONTools.safeParseJSONObjectForValueIsString(continentObject, BookInfoDatabaseFieldsConstant.RespondBean.url.name(), ""));
			// int 是否预定类折扣 1、预定类产品 0、非预定类产品
			bookInfoNetRespondBean.setBooktype(JSONTools.safeParseJSONObjectForValueIsInteger(continentObject, BookInfoDatabaseFieldsConstant.RespondBean.booktype.name(), 0));
			// string 折扣开始时间 格式9999-12-31 23:59:59
			bookInfoNetRespondBean.setStart_date(JSONTools.safeParseJSONObjectForValueIsString(continentObject, BookInfoDatabaseFieldsConstant.RespondBean.start_date.name(), ""));
			// string 折扣结束时间 格式9999-12-31 23:59:59
			bookInfoNetRespondBean.setEnd_date(JSONTools.safeParseJSONObjectForValueIsString(continentObject, BookInfoDatabaseFieldsConstant.RespondBean.end_date.name(), ""));
			// string 第一次定单开始时间 格式UNIX时间戳
			bookInfoNetRespondBean.setFirstpay_start_time(JSONTools.safeParseJSONObjectForValueIsString(continentObject, BookInfoDatabaseFieldsConstant.RespondBean.firstpay_start_time.name(), ""));
			// string 第一次定单结束时间 格式UNIX时间戳
			bookInfoNetRespondBean.setFirstpay_end_time(JSONTools.safeParseJSONObjectForValueIsString(continentObject, BookInfoDatabaseFieldsConstant.RespondBean.firstpay_end_time.name(), ""));
			// string 第二次定单开始时间 格式UNIX时间戳
			bookInfoNetRespondBean.setSecondpay_start_time(JSONTools.safeParseJSONObjectForValueIsString(continentObject, BookInfoDatabaseFieldsConstant.RespondBean.secondpay_start_time.name(), ""));
			// string 第二次定单结束时间 格式UNIX时间戳
			bookInfoNetRespondBean.setSecondpay_end_time(JSONTools.safeParseJSONObjectForValueIsString(continentObject, BookInfoDatabaseFieldsConstant.RespondBean.secondpay_end_time.name(), ""));
		}
		return bookInfoNetRespondBean;
	}

}
