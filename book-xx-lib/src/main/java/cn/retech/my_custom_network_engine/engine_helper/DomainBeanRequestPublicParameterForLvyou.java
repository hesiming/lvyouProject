package cn.retech.my_custom_network_engine.engine_helper;

import java.util.Map;

import com.google.common.collect.Maps;

import cn.retech.my_network_engine.engine_helper.interfaces.IDomainBeanRequestPublicParameter;

public class DomainBeanRequestPublicParameterForLvyou implements IDomainBeanRequestPublicParameter {

  public DomainBeanRequestPublicParameterForLvyou() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public Map<String, String> getPublicParameter() {
    Map<String, String> params = Maps.newHashMap();
    params.put("client_id", "qyer_discount_androi");
    params.put("client_secret", "227097da1d07a2a9860f");
    return params;
  }

}
