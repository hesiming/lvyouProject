package cn.lvyou.domainbean_model.app_get_userorderformlist;

import cn.lvyou.global_data_cache.UrlConstantForThisProject;
import cn.lvyou.my_network_engine.domainbean_tools.IDomainBeanAbstractFactory;
import cn.lvyou.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;
import cn.lvyou.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;

public class UserOrderDonainBeanToolsFactory implements IDomainBeanAbstractFactory {

	@Override
	public IParseDomainBeanToDataDictionary getParseDomainBeanToDDStrategyObject() {
		return new UserOrderParseDomainBeanToDD();
	}

	@Override
	public IParseNetRespondDataToDomainBean getParseNetRespondDataToDomainBeanStrategyObject() {
		return new UserOrderParseNetRespondStringToDomainBean();
	}

	@Override
	public String getSpecialPath(Object netRequestDomainBean) {
		return UrlConstantForThisProject.kUrlConstant_SpecialPath_APP_GET_USERORDERFORMLIST;
	}

}
