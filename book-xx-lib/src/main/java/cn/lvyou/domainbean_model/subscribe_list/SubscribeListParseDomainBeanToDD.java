package cn.lvyou.domainbean_model.subscribe_list;

import java.util.HashMap;
import java.util.Map;

import android.text.TextUtils;
import cn.lvyou.my_network_engine.domainbean_helper.IParseDomainBeanToDataDictionary;

public final class SubscribeListParseDomainBeanToDD implements IParseDomainBeanToDataDictionary {

	@Override
	public Map<String, String> parseDomainBeanToDataDictionary(Object netRequestDomainBean) {

		if (null == netRequestDomainBean) {
			throw new IllegalArgumentException("netRequestDomainBean is null!");
		}

		boolean isRightObjectType = netRequestDomainBean instanceof SubscribeListNetRequestBean;
		if (!isRightObjectType) {
			throw new IllegalArgumentException("传入的业务Bean的类型不符 !");
		}

		SubscribeListNetRequestBean requestBean = (SubscribeListNetRequestBean) netRequestDomainBean;
		String oauth_token = requestBean.getOauth_token();
		if (TextUtils.isEmpty(oauth_token)) {
			throw new IllegalArgumentException("必须的数据字段不完整 ! ");
		}

		Map<String, String> params = new HashMap<String, String>();
		// 必须参数
		params.put(SubscribeListDatabaseFieldsConstant.RequestBean.oauth_token.name(), oauth_token);
		params.put(SubscribeListDatabaseFieldsConstant.RequestBean.max_id.name(), requestBean.getMax_id());
		params.put(SubscribeListDatabaseFieldsConstant.RequestBean.page_size.name(), requestBean.getPage_size());

		return params;
	}
}
