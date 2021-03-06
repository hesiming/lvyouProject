package cn.lvyou.my_network_engine.domainbean_helper;

/**
 * 业务Bean相关的助手方法群(这里使用的是抽象工厂模式)
 * 
 * 这里罗列的接口是每个业务Bean都需要实现的.
 * 
 * @author skyduck
 */
public interface IDomainBeanHelper {
  /**
   * 将当前业务Bean, 解析成跟后台数据接口对应的数据字典
   * 
   * @return
   */
  public IParseDomainBeanToDataDictionary getParseDomainBeanToDDStrategyObject();

  /**
   * 将网络返回的数据字符串, 解析成当前业务Bean
   * 
   * @return
   */
  public IParseNetRespondDataToDomainBean getParseNetRespondDataToDomainBeanStrategyObject();

  /**
   * 当前业务接口, 对应的path.
   * 
   * @return
   */
  public String getSpecialPath(final Object netRequestDomainBean);
}
