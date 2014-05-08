package cn.lvyou.my_network_engine.domainbean_tools;

import java.util.Map;

import android.text.TextUtils;
import cn.lvyou.domainbean_model.DomainBeanHelperClassNameMapping;

import com.google.common.collect.Maps;

/**
 * NetRequestBean对应的DomainBeanToolsFactory, 在这里进行缓存
 * 
 * @author skyduck
 */
public enum DomainBeanAbstractFactoryCacheSingleton {
  getInstance;

  /**
	 * 
	 */
  private DomainBeanHelperClassNameMapping strategyClassNameMapping = new DomainBeanHelperClassNameMapping();
  /**
   * 缓存区
   */
  private Map<String, IDomainBeanAbstractFactory> abstractFactoryObjectBufList = Maps.newHashMapWithExpectedSize(100);

  /**
   * 
   * @param key
   *          就是某个网络业务接口的 NetRequestBean的 getClass().getName() , 这里设计一个字典,
   *          用于缓存一个 NetRequestBean和其对应的 DomainBeanToolsFactory
   * @return
   * @throws Exception
   */
  public IDomainBeanAbstractFactory getDomainBeanAbstractFactoryObjectByKey(final String key) throws Exception {

    if (TextUtils.isEmpty(key)) {
      throw new NullPointerException("key is empty!");
    }

    IDomainBeanAbstractFactory abstractFactoryObject = abstractFactoryObjectBufList.get(key);
    if (abstractFactoryObject == null) {
      final String className = strategyClassNameMapping.getTargetClassNameForKey(key);
      if (TextUtils.isEmpty(className)) {
        // 找不到对应的算法类
        throw new IllegalStateException("key is invalid!");
      }

      // 使用 "反射" 来创建一个NetRequestBean对应的DomainBeanToolsFactory
      final Class<?> cl = Class.forName(className);
      abstractFactoryObject = (IDomainBeanAbstractFactory) cl.newInstance();
      abstractFactoryObjectBufList.put(key, abstractFactoryObject);
    }
    return abstractFactoryObject;
  }
}
