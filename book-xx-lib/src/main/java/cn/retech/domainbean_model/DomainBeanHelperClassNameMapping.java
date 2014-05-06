package cn.retech.domainbean_model;

import cn.retech.domainbean_model.optionTop.OptionTopDomainBeanToolsFactory;

import cn.retech.domainbean_model.optionTop.OptionTopNetRequestBean;

import cn.retech.domainbean_model.categorys.CategorysDomainBeanToolsFactory;

import cn.retech.domainbean_model.categorys.CategorysNetRequestBean;

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

    /**
     * 筛选分类
     */
    strategyClassesNameMappingList.put(CategorysNetRequestBean.class.getName(), CategorysDomainBeanToolsFactory.class.getName());

    /**
     * 顶部索引图片
     */
    strategyClassesNameMappingList.put(OptionTopNetRequestBean.class.getName(), OptionTopDomainBeanToolsFactory.class.getName());
  }
}
