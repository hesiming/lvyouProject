package cn.lvyou.domainbean_model.app_post_second_orderform;

import java.util.HashMap;
import java.util.Map;

import android.text.TextUtils;
import cn.lvyou.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;

public final class PostSecondOrderformDomainBeanToDD implements IParseDomainBeanToDataDictionary {

	@Override
	public Map<String, String> parseDomainBeanToDataDictionary(Object netRequestDomainBean) {

		if (null == netRequestDomainBean) {
			throw new IllegalArgumentException("netRequestDomainBean is null!");
		}

		boolean isRightObjectType = netRequestDomainBean instanceof PostSecondOrderformNetRequestBean;
		if (!isRightObjectType) {
			throw new IllegalArgumentException("传入的业务Bean的类型不符 !");
		}

		PostSecondOrderformNetRequestBean requestBean = (PostSecondOrderformNetRequestBean) netRequestDomainBean;
		String oauth_token = requestBean.getOauth_token();
		String id = requestBean.getId();
		if (TextUtils.isEmpty(oauth_token) || TextUtils.isEmpty(id)) {
			throw new IllegalArgumentException("必须的数据字段不完整 ! ");
		}
		Map<String, String> params = new HashMap<String, String>();
		// 必须参数
		params.put(PostSecondOrderformDatabaseFieldsConstant.RequestBean.id.name(), id);
		params.put(PostSecondOrderformDatabaseFieldsConstant.RequestBean.oauth_token.name(), oauth_token);
		return params;
	}
}
