package cn.lvyou.domainbean_model.get_detail;

import java.util.HashMap;
import java.util.Map;

import android.text.TextUtils;
import cn.lvyou.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;

public class GetDetailParseDomainBeanToDD implements IParseDomainBeanToDataDictionary {

	@Override
	public Map<String, String> parseDomainBeanToDataDictionary(Object netRequestDomainBean) {

		if (null == netRequestDomainBean) {
			throw new IllegalArgumentException("netRequestDomainBean is null!");
		}

		boolean isRightObjectType = netRequestDomainBean instanceof GetDetailNetRequestBean;
		if (!isRightObjectType) {
			throw new IllegalArgumentException("传入的业务Bean的类型不符 !");
		}

		GetDetailNetRequestBean requestBean = (GetDetailNetRequestBean) netRequestDomainBean;
		String id = requestBean.getId();
		if (TextUtils.isEmpty(id)) {
			throw new IllegalArgumentException("必须的数据字段不完整 ! ");
		}
		Map<String, String> params = new HashMap<String, String>();
		// 必须参数
		params.put(GetDetailDatabaseFieldsConstant.RequestBean.id.name(), id);
		params.put(GetDetailDatabaseFieldsConstant.RequestBean.oauth_token.name(), requestBean.getOauth_token());

		return params;
	}
}
