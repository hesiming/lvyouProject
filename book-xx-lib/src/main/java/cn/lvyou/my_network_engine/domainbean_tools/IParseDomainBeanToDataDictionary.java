package cn.lvyou.my_network_engine.domainbean_tools;

import java.util.Map;

/**
 * 把一个 "网络请求业务Bean" 解析成其对应网络业务接口的 "数据字典"
 * 
 * @author skyduck
 * 
 */
public interface IParseDomainBeanToDataDictionary {
  public Map<String, String> parseDomainBeanToDataDictionary(final Object netRequestDomainBean);
}
