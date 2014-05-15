package cn.lvyou.domainbean_model.app_post_del_orderform;

import cn.lvyou.global_data_cache.UrlConstantForThisProject;
import cn.lvyou.my_network_engine.domainbean_tools.IDomainBeanAbstractFactory;
import cn.lvyou.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;
import cn.lvyou.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;

public final class DelOrderformDonainBeanToolsFactory implements IDomainBeanAbstractFactory {

	@Override
	public IParseDomainBeanToDataDictionary getParseDomainBeanToDDStrategyObject() {
		return new DelOrderformParseDomainBeanToDD();
	}

	@Override
	public IParseNetRespondDataToDomainBean getParseNetRespondDataToDomainBeanStrategyObject() {
		return new DelOrderformParseNetRespondStringToDomainBean();
	}

	@Override
	public String getSpecialPath(Object netRequestDomainBean) {
		return UrlConstantForThisProject.kUrlConstant_SpecialPath_APP_POST_DEL_ORDERFORM;
	}

}
