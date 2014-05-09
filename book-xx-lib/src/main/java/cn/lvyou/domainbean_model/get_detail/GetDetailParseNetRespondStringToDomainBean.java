package cn.lvyou.domainbean_model.get_detail;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.lvyou.domainbean_model.app_get_start_image.AppStartImageDatabaseFieldsConstant;
import cn.lvyou.domainbean_model.app_get_start_image.AppStartImageNetResondBean;
import cn.lvyou.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

/**
 * 获取折扣详情 将网络请求的数据解析成Bean
 * 
 * @author hesiming
 * 
 */
public class GetDetailParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		AppStartImageNetResondBean appStartImageNetResondBean = new AppStartImageNetResondBean();
		// 创建折扣详情的bean
		GetDetailNetRespondBean getDetailNetRespondBean = new GetDetailNetRespondBean();
		// array 折扣详情图片原图
		List<String> detail_imageList = new ArrayList<String>();
		// 获取ArrayObject
		if (jsonRootObject.has(AppStartImageDatabaseFieldsConstant.RespondBean.data.name())) {
			JSONObject appStartImageObject = jsonRootObject.getJSONObject(GetDetailDatabaseFieldsConstant.RespondBean.data.name());
			// array 折扣详情图片原图
			JSONArray detail_imageArray = appStartImageObject.getJSONArray(GetDetailDatabaseFieldsConstant.RespondBean.detail_image.name());
			for (int i = 0; i < detail_imageArray.length(); i++) {
				detail_imageList.add(detail_imageArray.get(i).toString());
			}
			getDetailNetRespondBean.setDetail_imageList(detail_imageList);
			// array 折扣预订方式
			List<String> detail_image180List = new ArrayList<String>();
			JSONArray detail_image180Array = appStartImageObject.getJSONArray(GetDetailDatabaseFieldsConstant.RespondBean.detail_image180.name());
			for (int i = 0; i < detail_image180Array.length(); i++) {
				detail_image180List.add(detail_image180Array.get(i).toString());
			}
			getDetailNetRespondBean.setDetail_image180List(detail_image180List);
			// array 折扣预订方式
			List<String> order_infoList = new ArrayList<String>();
			JSONArray order_infoArray = appStartImageObject.getJSONArray(GetDetailDatabaseFieldsConstant.RespondBean.order_info.name());
			for (int i = 0; i < order_infoArray.length(); i++) {
				order_infoList.add(order_infoArray.get(i).toString());
			}
			getDetailNetRespondBean.setOrder_infoList(order_infoList);
			// array 折扣预订方式说明
			List<String> order_info_txtList = new ArrayList<String>();
			JSONArray order_info_txtArray = appStartImageObject.getJSONArray(GetDetailDatabaseFieldsConstant.RespondBean.order_info_txt.name());
			for (int i = 0; i < order_info_txtArray.length(); i++) {
				order_info_txtList.add(order_info_txtArray.get(i).toString());
			}
			getDetailNetRespondBean.setOrder_info_txtList(order_info_txtList);
			// array 相关折扣
			List<GetDetailRelated> getDetailRelatedList = new ArrayList<GetDetailRelated>();
			JSONArray getDetailRelatedArray = appStartImageObject.getJSONArray(GetDetailDatabaseFieldsConstant.RespondBean.related.name());
			for (int i = 0; i < getDetailRelatedArray.length(); i++) {
				JSONObject getDetailRelatedJsonObject = getDetailRelatedArray.getJSONObject(i);
				GetDetailRelated getDetailRelated = new GetDetailRelated();
				getDetailRelated.setId(JSONTools.safeParseJSONObjectForValueIsInteger(getDetailRelatedJsonObject, GetDetailDatabaseFieldsConstant.GetDetailRelatedRespondBean.id.name(), 0));
				getDetailRelated.setPic(JSONTools.safeParseJSONObjectForValueIsString(getDetailRelatedJsonObject, GetDetailDatabaseFieldsConstant.GetDetailRelatedRespondBean.pic.name(), ""));
				getDetailRelated.setPrice(JSONTools.safeParseJSONObjectForValueIsString(getDetailRelatedJsonObject, GetDetailDatabaseFieldsConstant.GetDetailRelatedRespondBean.price.name(), ""));
				getDetailRelated.setTitle(JSONTools.safeParseJSONObjectForValueIsString(getDetailRelatedJsonObject, GetDetailDatabaseFieldsConstant.GetDetailRelatedRespondBean.title.name(), ""));
				getDetailRelated.setAddtime(JSONTools.safeParseJSONObjectForValueIsString(getDetailRelatedJsonObject, GetDetailDatabaseFieldsConstant.GetDetailRelatedRespondBean.addtime.name(), ""));
				getDetailRelatedList.add(getDetailRelated);
			}
			getDetailNetRespondBean.setGetDetailRelatedList(getDetailRelatedList);
			// 下面是解析jsonobject
			getDetailNetRespondBean.setApp_booktype(JSONTools.safeParseJSONObjectForValueIsInteger(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.app_booktype.name(), 0));
			getDetailNetRespondBean.setApp_end_date(JSONTools.safeParseJSONObjectForValueIsString(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.app_end_date.name(), ""));
			getDetailNetRespondBean.setApp_end_date_new(JSONTools.safeParseJSONObjectForValueIsInteger(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.app_end_date_new.name(), 0));
			getDetailNetRespondBean.setApp_firstpay_end_time(JSONTools.safeParseJSONObjectForValueIsString(appStartImageObject,
					GetDetailDatabaseFieldsConstant.RespondBean.app_firstpay_end_time.name(), ""));
			getDetailNetRespondBean.setApp_firstpay_start_time(JSONTools.safeParseJSONObjectForValueIsString(appStartImageObject,
					GetDetailDatabaseFieldsConstant.RespondBean.app_firstpay_start_time.name(), ""));
			getDetailNetRespondBean.setApp_secondpay_end_time(JSONTools.safeParseJSONObjectForValueIsString(appStartImageObject,
					GetDetailDatabaseFieldsConstant.RespondBean.app_secondpay_end_time.name(), ""));
			getDetailNetRespondBean.setApp_secondpay_start_time(JSONTools.safeParseJSONObjectForValueIsString(appStartImageObject,
					GetDetailDatabaseFieldsConstant.RespondBean.app_secondpay_start_time.name(), ""));
			getDetailNetRespondBean.setApp_start_date(JSONTools.safeParseJSONObjectForValueIsString(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.app_start_date.name(), ""));
			getDetailNetRespondBean
					.setApp_start_date_new(JSONTools.safeParseJSONObjectForValueIsInteger(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.app_start_date_new.name(), 0));
			getDetailNetRespondBean.setApp_stock(JSONTools.safeParseJSONObjectForValueIsInteger(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.app_stock.name(), 0));
			getDetailNetRespondBean.setApp_url(JSONTools.safeParseJSONObjectForValueIsString(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.app_url.name(), ""));
			getDetailNetRespondBean.setDeal_info(JSONTools.safeParseJSONObjectForValueIsString(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.deal_info.name(), ""));
			getDetailNetRespondBean.setDetail(JSONTools.safeParseJSONObjectForValueIsString(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.detail.name(), ""));
			getDetailNetRespondBean.setDiscount_code(JSONTools.safeParseJSONObjectForValueIsString(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.discount_code.name(), ""));
			getDetailNetRespondBean.setEnd_date(JSONTools.safeParseJSONObjectForValueIsString(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.end_date.name(), ""));
			getDetailNetRespondBean.setFavored(JSONTools.safeParseJSONObjectForValueIsInteger(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.favored.name(), 0));
			getDetailNetRespondBean.setFirst_pub(JSONTools.safeParseJSONObjectForValueIsInteger(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.first_pub.name(), 0));
			getDetailNetRespondBean.setId(JSONTools.safeParseJSONObjectForValueIsInteger(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.id.name(), 0));
			getDetailNetRespondBean.setLogin_visible(JSONTools.safeParseJSONObjectForValueIsInteger(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.login_visible.name(), 0));
			getDetailNetRespondBean.setOnsale(JSONTools.safeParseJSONObjectForValueIsInteger(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.onsale.name(), 0));
			getDetailNetRespondBean.setOrder_type(JSONTools.safeParseJSONObjectForValueIsInteger(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.order_type.name(), 0));
			getDetailNetRespondBean.setPic(JSONTools.safeParseJSONObjectForValueIsString(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.pic.name(), ""));
			getDetailNetRespondBean.setPrice(JSONTools.safeParseJSONObjectForValueIsString(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.price.name(), ""));
			getDetailNetRespondBean.setQyer_url(JSONTools.safeParseJSONObjectForValueIsString(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.qyer_url.name(), ""));
			getDetailNetRespondBean.setSelf_use(JSONTools.safeParseJSONObjectForValueIsInteger(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.self_use.name(), 0));
			getDetailNetRespondBean.setTitle(JSONTools.safeParseJSONObjectForValueIsString(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.title.name(), ""));
			getDetailNetRespondBean.setUse_if(JSONTools.safeParseJSONObjectForValueIsString(appStartImageObject, GetDetailDatabaseFieldsConstant.RespondBean.use_if.name(), ""));

		}
		return appStartImageNetResondBean;
	}
}
