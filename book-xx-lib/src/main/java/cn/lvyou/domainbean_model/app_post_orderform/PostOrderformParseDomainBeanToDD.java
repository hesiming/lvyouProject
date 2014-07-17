package cn.lvyou.domainbean_model.app_post_orderform;

import java.util.HashMap;
import java.util.Map;

import android.text.TextUtils;
import cn.lvyou.my_network_engine.domainbean_helper.IParseDomainBeanToDataDictionary;

public final class PostOrderformParseDomainBeanToDD implements IParseDomainBeanToDataDictionary {

	@Override
	public Map<String, String> parseDomainBeanToDataDictionary(Object netRequestDomainBean) {

		if (null == netRequestDomainBean) {
			throw new IllegalArgumentException("netRequestDomainBean is null!");
		}

		boolean isRightObjectType = netRequestDomainBean instanceof PostOrderformNetRequestBean;
		if (!isRightObjectType) {
			throw new IllegalArgumentException("传入的业务Bean的类型不符 !");
		}

		PostOrderformNetRequestBean requestBean = (PostOrderformNetRequestBean) netRequestDomainBean;
		// true string 采用OAuth授权方式为必填参数， OAuth授权后获得。
		String oauth_token = requestBean.getOauth_token();
		// true int 折扣类型ID 必填参数
		String pid = requestBean.getPid();
		// true int 数量 必填参数
		String num = requestBean.getNum();
		// true string 姓名 必填参数
		String name = requestBean.getName();
		// true string 电话 必填参数
		String phone = requestBean.getPhone();
		// true string 邮箱 必填参数
		String email = requestBean.getEmail();
		// true float 金额，总价 必填参数
		String price = requestBean.getPrice();
		if (TextUtils.isEmpty(oauth_token) || TextUtils.isEmpty(pid) || TextUtils.isEmpty(num) || TextUtils.isEmpty(name) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(email)
				|| TextUtils.isEmpty(price)) {
			throw new IllegalArgumentException("必须的数据字段不完整 ! ");
		}
		Map<String, String> params = new HashMap<String, String>();
		// 必须参数
		params.put(PostOrderformDatabaseFieldsConstant.RequestBean.oauth_token.name(), oauth_token);
		params.put(PostOrderformDatabaseFieldsConstant.RequestBean.pid.name(), pid);
		params.put(PostOrderformDatabaseFieldsConstant.RequestBean.num.name(), num);
		params.put(PostOrderformDatabaseFieldsConstant.RequestBean.name.name(), name);
		params.put(PostOrderformDatabaseFieldsConstant.RequestBean.phone.name(), phone);
		params.put(PostOrderformDatabaseFieldsConstant.RequestBean.email.name(), email);
		params.put(PostOrderformDatabaseFieldsConstant.RequestBean.price.name(), price);
		return params;
	}
}
