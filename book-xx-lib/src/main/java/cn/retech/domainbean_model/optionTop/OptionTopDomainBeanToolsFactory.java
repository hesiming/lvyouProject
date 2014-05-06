package cn.retech.domainbean_model.optionTop;

import cn.retech.global_data_cache.UrlConstantForThisProject;
import cn.retech.my_network_engine.domainbean_tools.IDomainBeanAbstractFactory;
import cn.retech.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;
import cn.retech.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;

/**
 * 筛选分类
 */
public final class OptionTopDomainBeanToolsFactory implements IDomainBeanAbstractFactory {
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
    // public static final String kUrlConstant_SpecialPath_OPERATION_TOP = "operation/get_top";

    return UrlConstantForThisProject.kUrlConstant_SpecialPath_OPERATION_TOP;
  }
}
