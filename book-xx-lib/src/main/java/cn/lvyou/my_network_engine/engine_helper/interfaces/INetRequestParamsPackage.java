package cn.lvyou.my_network_engine.engine_helper.interfaces;

import java.util.Map;

/**
 * 根据httpRequestMethod和domainDataDictionary来打包RequestParams(可以在这里进行数据的加密工作)
 * 
 * @author skyduck
 */
public interface INetRequestParamsPackage {
  /**
   * 
   * @param httpRequestMethod
   *          http请求方法(GET/POST)
   * @param domainDataDictionary
   *          业务数据字典
   * @return
   */
  public Object packageNetRequestParams(final String httpRequestMethod, final Map<String, String> domainDataDictionary);
}
