package cn.retech.domainbean_model;

import cn.retech.domainbean_model.login.LoginDomainBeanToolsFactory;
import cn.retech.domainbean_model.login.LoginNetRequestBean;
import cn.retech.my_network_engine.domainbean_strategy_mapping.StrategyClassNameMappingBase;

/**
 * 所有业务接口, 要在这里完成NetRequestBean和DomainBeanToolsFactory的映射
 * 
 * @author skyduck
 * 
 */
public final class DomainBeanHelperClassNameMapping extends StrategyClassNameMappingBase {

  // 注意：
  // Key : 网络请求业务Bean
  // Value : 是该网络接口对应的抽象工厂类
  public DomainBeanHelperClassNameMapping() {

    /**
     * 用户登录
     */
    strategyClassesNameMappingList.put(LoginNetRequestBean.class.getName(), LoginDomainBeanToolsFactory.class.getName());

  }
}
