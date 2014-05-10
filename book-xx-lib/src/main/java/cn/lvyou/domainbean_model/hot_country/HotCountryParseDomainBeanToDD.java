package cn.lvyou.domainbean_model.hot_country;

import java.util.Map;

import cn.lvyou.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;

import com.google.common.collect.Maps;

public class HotCountryParseDomainBeanToDD implements IParseDomainBeanToDataDictionary {

	@Override
	public Map<String, String> parseDomainBeanToDataDictionary(Object netRequestDomainBean) {
		return Maps.newHashMap();
	}

}
