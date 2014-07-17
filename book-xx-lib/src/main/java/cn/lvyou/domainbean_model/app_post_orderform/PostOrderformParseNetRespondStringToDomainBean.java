package cn.lvyou.domainbean_model.app_post_orderform;

import org.json.JSONObject;

import cn.lvyou.domainbean_model.app_get_start_image.AppStartImageDatabaseFieldsConstant;
import cn.lvyou.my_network_engine.domainbean_helper.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public final class PostOrderformParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		PostOrderformNetRespondBean postOrderformNetRespondBean = new PostOrderformNetRespondBean();
		if (jsonRootObject.has(PostOrderformDatabaseFieldsConstant.RespondBean.data.name())) {
			JSONObject postOrderformObject = jsonRootObject.getJSONObject(AppStartImageDatabaseFieldsConstant.RespondBean.data.name());
			// int 订单ID
			postOrderformNetRespondBean.setId(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.id.name(), ""));
			// int 折扣类型ID
			postOrderformNetRespondBean.setPid(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.pid.name(), ""));
			// int 数量
			postOrderformNetRespondBean.setNum(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.num.name(), ""));
			// string 姓名
			postOrderformNetRespondBean.setName(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.name.name(), ""));
			// string 手机
			postOrderformNetRespondBean.setPhone(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.phone.name(), ""));
			// string email
			postOrderformNetRespondBean.setEmail(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.email.name(), ""));
			// int UID
			postOrderformNetRespondBean.setUid(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.uid.name(), ""));
			// float 单价
			postOrderformNetRespondBean.setUnit_price(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.unit_price.name(), ""));
			// float 总价
			postOrderformNetRespondBean.setPrice(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.price.name(), ""));
			// int 1 已支付 0未支付 -1超时
			postOrderformNetRespondBean.setPayment(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.payment.name(), ""));
			// string 时间戳
			postOrderformNetRespondBean.setDatetime(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.datetime.name(), ""));
			// int 1首次付款 2二次付款
			postOrderformNetRespondBean.setFirstpay(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.firstpay.name(), ""));
			postOrderformNetRespondBean.setRelid(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.relid.name(), ""));
			postOrderformNetRespondBean.setBuyer_email(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.buyer_email.name(), ""));
			postOrderformNetRespondBean.setBuyer_id(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.buyer_id.name(), ""));
			postOrderformNetRespondBean.setNotify_id(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.notify_id.name(), ""));
			postOrderformNetRespondBean.setNotify_time(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.notify_time.name(), ""));
			postOrderformNetRespondBean.setNotify_type(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.notify_type.name(), ""));
			postOrderformNetRespondBean.setPayment_type(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.payment_type.name(), ""));
			postOrderformNetRespondBean.setSeller_email(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.seller_email.name(), ""));
			postOrderformNetRespondBean.setSeller_id(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.seller_id.name(), ""));
			postOrderformNetRespondBean.setSign(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.sign.name(), ""));
			postOrderformNetRespondBean.setSign_type(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.sign_type.name(), ""));
			postOrderformNetRespondBean.setTotal_fee(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.sign_type.name(), ""));
			postOrderformNetRespondBean.setTrade_no(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.trade_no.name(), ""));
			postOrderformNetRespondBean.setTrade_status(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.trade_status.name(), ""));
			postOrderformNetRespondBean.setReturn_type(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.return_type.name(), ""));
			postOrderformNetRespondBean.setReturn_time(JSONTools.safeParseJSONObjectForValueIsString(postOrderformObject, PostOrderformDatabaseFieldsConstant.RespondBean.return_time.name(), ""));
		}

		return postOrderformNetRespondBean;
	}
}
