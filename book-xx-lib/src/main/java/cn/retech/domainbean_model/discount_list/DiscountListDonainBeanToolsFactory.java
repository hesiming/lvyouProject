package cn.retech.domainbean_model.discount_list;

import cn.retech.global_data_cache.UrlConstantForThisProject;
import cn.retech.my_network_engine.domainbean_tools.IDomainBeanAbstractFactory;
import cn.retech.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;
import cn.retech.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;

public final class DiscountListDonainBeanToolsFactory implements IDomainBeanAbstractFactory {

	@Override
	public IParseDomainBeanToDataDictionary getParseDomainBeanToDDStrategyObject() {
		return new DiscountListParseDomainBeanToDD();
	}

	@Override
	public IParseNetRespondDataToDomainBean getParseNetRespondDataToDomainBeanStrategyObject() {
		return new DiscountListParseNetRespondStringToDomainBean();
	}

	@Override
	public String getSpecialPath(Object netRequestDomainBean) {
		return UrlConstantForThisProject.kUrlConstant_SpecialPath_DISCOUNT_LIST;
	}

}
