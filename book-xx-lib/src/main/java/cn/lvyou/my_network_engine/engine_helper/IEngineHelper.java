package cn.lvyou.my_network_engine.engine_helper;

import cn.lvyou.my_network_engine.engine_helper.interfaces.IDomainBeanRequestPublicParameter;
import cn.lvyou.my_network_engine.engine_helper.interfaces.INetRequestParamsPackage;
import cn.lvyou.my_network_engine.engine_helper.interfaces.INetRespondRawEntityDataUnpack;
import cn.lvyou.my_network_engine.engine_helper.interfaces.IServerRespondDataTest;
import cn.lvyou.my_network_engine.engine_helper.interfaces.ISpliceFullUrlByDomainBeanSpecialPath;

/**
 * 网络访问过程中, 请求和返回的 "实体数据" 相关的工具类
 * 
 * @author skyduck
 */
public interface IEngineHelper {
  // 根据httpRequestMethod和domainDataDictionary来打包RequestParams(在这里进行数据的加密工作)
  public INetRequestParamsPackage getNetRequestParamsPackageStrategyObject();

  // 将网络返回的数据, 解压成可识别的字符串(在这里完成数据的解密)
  public INetRespondRawEntityDataUnpack getNetRespondEntityDataUnpackStrategyObject();

  // 测试从服务器端返回的数据是否是有效的(数据要先调用INetRespondRawEntityDataUnpack接口解包,
  // 然后再根据服务器返回的错误码判断)
  public IServerRespondDataTest getServerRespondDataTestStrategyObject();

  // 拼接一个网络接口的完整请求URL
  public ISpliceFullUrlByDomainBeanSpecialPath getSpliceFullUrlByDomainBeanSpecialPathStrategyObject();

  // 业务Bean请求时,需要传递到服务器的公共参数
  public IDomainBeanRequestPublicParameter getDomainBeanRequestPublicParameterStrategyObject();
}
