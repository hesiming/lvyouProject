package cn.retech.my_network_engine.domainbean_strategy_mapping;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;

/**
 * 这里完成一个网络业务接口的 NetRequestBean 和 其对应的 DomainBeanToolsFactory 的映射
 * 
 * @author skyduck
 * 
 */
public abstract class StrategyClassNameMappingBase {
  protected Map<String, String> strategyClassesNameMappingList = newHashMap();

  /**
   * 
   * @param key
   * @return
   */
  public String getTargetClassNameForKey(String key) {
    String className = null;

    do {
      if (null == key || key.equals("")) {
        break;
      }
      className = strategyClassesNameMappingList.get(key);
    } while (false);

    return className;
  }
}
