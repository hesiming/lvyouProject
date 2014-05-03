package cn.retech.domainbean_model.categorys;

import com.google.common.collect.Maps;

import java.util.Map;

import cn.retech.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;

public class CategorysParseDomainBeanToDD implements IParseDomainBeanToDataDictionary {

  @Override
  public Map<String, String> parseDomainBeanToDataDictionary(Object netRequestDomainBean) {
    Map<String, String> returnMap = Maps.newHashMap();
    return returnMap;
  }

}
