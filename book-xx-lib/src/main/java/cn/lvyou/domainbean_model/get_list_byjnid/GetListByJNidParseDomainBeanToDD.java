package cn.lvyou.domainbean_model.get_list_byjnid;

import java.util.HashMap;
import java.util.Map;

import cn.lvyou.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;

public final class GetListByJNidParseDomainBeanToDD implements IParseDomainBeanToDataDictionary {

	@Override
	public Map<String, String> parseDomainBeanToDataDictionary(Object netRequestDomainBean) {

		if (null == netRequestDomainBean) {
			throw new IllegalArgumentException("netRequestDomainBean is null!");
		}

		boolean isRightObjectType = netRequestDomainBean instanceof GetListByJNidNetRequestBean;
		if (!isRightObjectType) {
			throw new IllegalArgumentException("传入的业务Bean的类型不符 !");
		}

		GetListByJNidNetRequestBean requestBean = (GetListByJNidNetRequestBean) netRequestDomainBean;
		String jn_id = requestBean.getJn_id();
		Map<String, String> params = new HashMap<String, String>();
		// 必须参数
		params.put(GetListByJNidDatabaseFieldsConstant.RequestBean.jn_id.name(), jn_id);
		return params;
	}

}
