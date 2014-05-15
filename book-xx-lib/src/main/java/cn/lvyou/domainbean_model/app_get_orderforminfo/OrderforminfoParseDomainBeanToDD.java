package cn.lvyou.domainbean_model.app_get_orderforminfo;

import java.util.HashMap;
import java.util.Map;

import android.text.TextUtils;
import cn.lvyou.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;

public class OrderforminfoParseDomainBeanToDD implements IParseDomainBeanToDataDictionary {

	@Override
	public Map<String, String> parseDomainBeanToDataDictionary(Object netRequestDomainBean) {

		if (null == netRequestDomainBean) {
			throw new IllegalArgumentException("netRequestDomainBean is null!");
		}

		boolean isRightObjectType = netRequestDomainBean instanceof OrderforminfoNetRequestBean;
		if (!isRightObjectType) {
			throw new IllegalArgumentException("传入的业务Bean的类型不符 !");
		}

		OrderforminfoNetRequestBean requestBean = (OrderforminfoNetRequestBean) netRequestDomainBean;
		String id = requestBean.getId();
		if (TextUtils.isEmpty(id)) {
			throw new IllegalArgumentException("必须的数据字段不完整 ! ");
		}
		Map<String, String> params = new HashMap<String, String>();
		// 必须参数
		params.put(OrderforminfoDatabaseFieldsConstant.RequestBean.id.name(), id);
		return params;
	}
}
