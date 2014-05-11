package cn.lvyou.domainbean_model.add_subscribe;

import java.util.HashMap;
import java.util.Map;

import android.text.TextUtils;
import cn.lvyou.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;

public final class AddSubscribeParseDomainBeanToDD implements IParseDomainBeanToDataDictionary {

	@Override
	public Map<String, String> parseDomainBeanToDataDictionary(Object netRequestDomainBean) {

		if (null == netRequestDomainBean) {
			throw new IllegalArgumentException("netRequestDomainBean is null!");
		}

		boolean isRightObjectType = netRequestDomainBean instanceof AddSubscribeNetRequestBean;
		if (!isRightObjectType) {
			throw new IllegalArgumentException("传入的业务Bean的类型不符 !");
		}

		AddSubscribeNetRequestBean requestBean = (AddSubscribeNetRequestBean) netRequestDomainBean;
		// true string 采用OAuth授权方式为必填参数， OAuth授权后获得。
		String oauth_token = requestBean.getOauth_token();
		// true int 类型id
		String type = requestBean.getType();
		// true string 时间
		String times = requestBean.getTimes();
		// true int 国家id
		String country_id = requestBean.getCountry_id();
		// true string 出发地
		String dpt = requestBean.getDpt();
		if (TextUtils.isEmpty(oauth_token) || TextUtils.isEmpty(type) || TextUtils.isEmpty(times) || TextUtils.isEmpty(country_id) || TextUtils.isEmpty(dpt)) {
			throw new IllegalArgumentException("必须的数据字段不完整 ! ");
		}
		Map<String, String> params = new HashMap<String, String>();
		// 必须参数
		params.put(AddSubscribeDatabaseFieldsConstant.RequestBean.oauth_token.name(), oauth_token);
		params.put(AddSubscribeDatabaseFieldsConstant.RequestBean.type.name(), type);
		params.put(AddSubscribeDatabaseFieldsConstant.RequestBean.times.name(), times);
		params.put(AddSubscribeDatabaseFieldsConstant.RequestBean.country_id.name(), country_id);
		params.put(AddSubscribeDatabaseFieldsConstant.RequestBean.dpt.name(), dpt);
		return params;
	}
}
