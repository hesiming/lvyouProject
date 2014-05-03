package cn.retech.domainbean_model.categorys;

import cn.retech.global_data_cache.UrlConstantForThisProject;
import cn.retech.my_network_engine.domainbean_tools.IDomainBeanAbstractFactory;
import cn.retech.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;
import cn.retech.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;

/**
 * 筛选分类
 */
public final class CategorysDomainBeanToolsFactory implements IDomainBeanAbstractFactory {
  @Override
  public IParseDomainBeanToDataDictionary getParseDomainBeanToDDStrategyObject() {
    return new CategorysParseDomainBeanToDD();
  }

  @Override
  public IParseNetRespondDataToDomainBean getParseNetRespondDataToDomainBeanStrategyObject() {
    return new CategorysParseNetRespondStringToDomainBean();
  }

  @Override
  public String getSpecialPath(final Object netRequestDomainBean) {
    /**
     * public static final String kUrlConstant_SpecialPath_CATEGORYS =
     * "lastminute/get_all_categorys";
     */
    return UrlConstantForThisProject.kUrlConstant_SpecialPath_CATEGORYS;
  }
}
