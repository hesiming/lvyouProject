package cn.lvyou.domainbean_model.discount_list;

import cn.lvyou.global_data_cache.UrlConstantForThisProject;
import cn.lvyou.my_network_engine.domainbean_tools.IDomainBeanAbstractFactory;
import cn.lvyou.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;
import cn.lvyou.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;

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
    // 折扣列表
    return UrlConstantForThisProject.kUrlConstant_SpecialPath_GET_LASTMINUTE_LIST;
  }

}
