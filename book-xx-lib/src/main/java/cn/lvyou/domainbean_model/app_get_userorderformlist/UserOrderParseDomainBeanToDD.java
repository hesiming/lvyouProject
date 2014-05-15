package cn.lvyou.domainbean_model.app_get_userorderformlist;

import java.util.HashMap;
import java.util.Map;

import android.text.TextUtils;
import cn.lvyou.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;

public class UserOrderParseDomainBeanToDD implements IParseDomainBeanToDataDictionary {

	@Override
	public Map<String, String> parseDomainBeanToDataDictionary(Object netRequestDomainBean) {
		String count = "";
		String page = "";
		if (null == netRequestDomainBean) {
			throw new IllegalArgumentException("netRequestDomainBean is null!");
		}

		boolean isRightObjectType = netRequestDomainBean instanceof UserOrderNetRequestBean;
		if (!isRightObjectType) {
			throw new IllegalArgumentException("传入的业务Bean的类型不符 !");
		}

		UserOrderNetRequestBean requestBean = (UserOrderNetRequestBean) netRequestDomainBean;
		String oauth_token = requestBean.getOauth_token();
		if (TextUtils.isEmpty(oauth_token)) {
			throw new IllegalArgumentException("必须的数据字段不完整 ! ");
		}

		Map<String, String> params = new HashMap<String, String>();
		// 必须参数
		params.put(UserOrderDatabaseFieldsConstant.RequestBean.oauth_token.name(), oauth_token);

		count = requestBean.getCount();
		if (!TextUtils.isEmpty(count)) {
			params.put(UserOrderDatabaseFieldsConstant.RequestBean.count.name(), count);
		}

		page = requestBean.getPage();
		if (!TextUtils.isEmpty(page)) {
			params.put(UserOrderDatabaseFieldsConstant.RequestBean.page.name(), page);
		}
		return params;
	}
}
