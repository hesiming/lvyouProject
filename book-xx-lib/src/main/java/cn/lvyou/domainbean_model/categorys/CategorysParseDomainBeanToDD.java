package cn.lvyou.domainbean_model.categorys;

import com.google.common.collect.Maps;

import java.util.Map;

import cn.lvyou.my_network_engine.domainbean_helper.IParseDomainBeanToDataDictionary;

public class CategorysParseDomainBeanToDD implements IParseDomainBeanToDataDictionary {

  @Override
  public Map<String, String> parseDomainBeanToDataDictionary(Object netRequestDomainBean) {
    Map<String, String> returnMap = Maps.newHashMap();
    return returnMap;
  }

}
