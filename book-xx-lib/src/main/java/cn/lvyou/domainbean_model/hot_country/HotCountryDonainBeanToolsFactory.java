package cn.lvyou.domainbean_model.hot_country;

import cn.lvyou.global_data_cache.UrlConstantForThisProject;
import cn.lvyou.my_network_engine.domainbean_tools.IDomainBeanAbstractFactory;
import cn.lvyou.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;
import cn.lvyou.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;

public class HotCountryDonainBeanToolsFactory implements IDomainBeanAbstractFactory {

	@Override
	public IParseDomainBeanToDataDictionary getParseDomainBeanToDDStrategyObject() {
		return new HotCountryParseDomainBeanToDD();
	}

	@Override
	public IParseNetRespondDataToDomainBean getParseNetRespondDataToDomainBeanStrategyObject() {
		return new HotCountryParseNetRespondStringToDomainBean();
	}

	@Override
	public String getSpecialPath(Object netRequestDomainBean) {
		return UrlConstantForThisProject.kUrlConstant_SpecialPath_HOT_COUNTRY;
	}

}
