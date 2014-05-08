package cn.lvyou.my_network_engine.engine_helper.interfaces;

import java.util.Map;

/**
 * 业务Bean请求时,需要传递到服务器的公共参数
 * 
 * @author skyduck
 * 
 */
public interface IDomainBeanRequestPublicParameter {
  public Map<String, String> getPublicParameter();
}
