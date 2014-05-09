package cn.lvyou.domainbean_model.favor_list;

import java.util.HashMap;
import java.util.Map;

import android.text.TextUtils;
import cn.lvyou.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;

public final class FavorListParseDomainBeanToDD implements IParseDomainBeanToDataDictionary {

	@Override
	public Map<String, String> parseDomainBeanToDataDictionary(Object netRequestDomainBean) {

		if (null == netRequestDomainBean) {
			throw new IllegalArgumentException("netRequestDomainBean is null!");
		}

		boolean isRightObjectType = netRequestDomainBean instanceof FavorListNetRequestBean;
		if (!isRightObjectType) {
			throw new IllegalArgumentException("传入的业务Bean的类型不符 !");
		}

		FavorListNetRequestBean requestBean = (FavorListNetRequestBean) netRequestDomainBean;
		String oauth_token = requestBean.getOauth_token();
		if (TextUtils.isEmpty(oauth_token)) {
			throw new IllegalArgumentException("必须的数据字段不完整 ! ");
		}

		Map<String, String> params = new HashMap<String, String>();
		// 必须参数
		params.put(FavorListDatabaseFieldsConstant.RequestBean.oauth_token.name(), oauth_token);
		params.put(FavorListDatabaseFieldsConstant.RequestBean.max_id.name(), requestBean.getMax_id());
		params.put(FavorListDatabaseFieldsConstant.RequestBean.page_size.name(), requestBean.getPage_size());

		return params;
	}
}
