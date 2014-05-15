package cn.lvyou.domainbean_model.app_query;

import cn.lvyou.global_data_cache.UrlConstantForThisProject;
import cn.lvyou.my_network_engine.domainbean_tools.IDomainBeanAbstractFactory;
import cn.lvyou.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;
import cn.lvyou.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;

public class AppQueryDonainBeanToolsFactory implements IDomainBeanAbstractFactory {

	@Override
	public IParseDomainBeanToDataDictionary getParseDomainBeanToDDStrategyObject() {
		return new AppQueryParseDomainBeanToDD();
	}

	@Override
	public IParseNetRespondDataToDomainBean getParseNetRespondDataToDomainBeanStrategyObject() {
		return new AppQueryParseNetRespondStringToDomainBean();
	}

	@Override
	public String getSpecialPath(Object netRequestDomainBean) {
		return UrlConstantForThisProject.kUrlConstant_SpecialPath_APP_QUERY;
	}

}
