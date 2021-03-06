package cn.lvyou.domainbean_model.discount_list;

import cn.lvyou.global_data_cache.UrlConstantForThisProject;
import cn.lvyou.my_network_engine.domainbean_helper.IDomainBeanHelper;
import cn.lvyou.my_network_engine.domainbean_helper.IParseDomainBeanToDataDictionary;
import cn.lvyou.my_network_engine.domainbean_helper.IParseNetRespondDataToDomainBean;

/**
 * 获取折扣列表
 * 
 * @author hesiming
 * 
 */
public final class DiscountListDonainBeanToolsFactory implements IDomainBeanHelper {

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
		// 折扣列表
		return UrlConstantForThisProject.kUrlConstant_SpecialPath_GET_LASTMINUTE_LIST;
	}
}
