package cn.lvyou.domainbean_model.add_favor;

import cn.lvyou.global_data_cache.UrlConstantForThisProject;
import cn.lvyou.my_network_engine.domainbean_helper.IDomainBeanHelper;
import cn.lvyou.my_network_engine.domainbean_helper.IParseDomainBeanToDataDictionary;
import cn.lvyou.my_network_engine.domainbean_helper.IParseNetRespondDataToDomainBean;

public final class AddFavorDonainBeanToolsFactory implements IDomainBeanHelper {

  @Override
  public IParseDomainBeanToDataDictionary getParseDomainBeanToDDStrategyObject() {
    return new AddFavorParseDomainBeanToDD();
  }

  @Override
  public IParseNetRespondDataToDomainBean getParseNetRespondDataToDomainBeanStrategyObject() {
    return new AddFavorParseNetRespondStringToDomainBean();
  }

  @Override
  public String getSpecialPath(Object netRequestDomainBean) {
    return UrlConstantForThisProject.kUrlConstant_SpecialPath_ADD_FAVOR;
  }

}
