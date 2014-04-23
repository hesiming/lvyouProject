package cn.retech.my_network_engine.engine_helper.interfaces;

import java.util.Map;

/**
 * 将业务数据字典, 打包成网络请求报文的实体数据, (可以在这里完成数据的加密工作)
 * 
 * @author skyduck
 */
public interface INetRequestEntityDataPackage {
  public Object packageNetRequestEntityData(final Map<String, String> domainDD);
}
