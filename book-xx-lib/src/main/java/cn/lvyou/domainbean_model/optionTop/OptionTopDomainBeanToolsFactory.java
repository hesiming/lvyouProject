package cn.lvyou.domainbean_model.optionTop;

import cn.lvyou.global_data_cache.UrlConstantForThisProject;
import cn.lvyou.my_network_engine.domainbean_helper.IDomainBeanHelper;
import cn.lvyou.my_network_engine.domainbean_helper.IParseDomainBeanToDataDictionary;
import cn.lvyou.my_network_engine.domainbean_helper.IParseNetRespondDataToDomainBean;

/**
 * 筛选分类
 */
public final class OptionTopDomainBeanToolsFactory implements IDomainBeanHelper {
  @Override
  public IParseDomainBeanToDataDictionary getParseDomainBeanToDDStrategyObject() {
    return new OptionTopParseDomainBeanToDD();
  }

  @Override
  public IParseNetRespondDataToDomainBean getParseNetRespondDataToDomainBeanStrategyObject() {
    return new OptionTopParseNetRespondStringToDomainBean();
  }

  @Override
  public String getSpecialPath(final Object netRequestDomainBean) {
    return UrlConstantForThisProject.kUrlConstant_SpecialPath_OPERATION_TOP;
  }
}
