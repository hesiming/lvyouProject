package cn.retech.my_network_engine.engine_helper;

import cn.retech.my_network_engine.engine_helper.interfaces.IDomainBeanRequestPublicParameter;
import cn.retech.my_network_engine.engine_helper.interfaces.INetRequestEntityDataPackage;
import cn.retech.my_network_engine.engine_helper.interfaces.INetRespondRawEntityDataUnpack;
import cn.retech.my_network_engine.engine_helper.interfaces.IServerRespondDataTest;
import cn.retech.my_network_engine.engine_helper.interfaces.ISpliceFullUrlByDomainBeanSpecialPath;

/**
 * 网络访问过程中, 请求和返回的 "实体数据" 相关的工具类
 * 
 * @author skyduck
 */
public interface IEngineHelper {
  // 将数据字典集合, 打包成网络请求字符串, (可以在这里完成数据的加密工作)
  public INetRequestEntityDataPackage getNetRequestEntityDataPackageStrategyObject();

  // 将网络返回的数据, 解压成可识别的字符串(在这里完成数据的解密)
  public INetRespondRawEntityDataUnpack getNetRespondEntityDataUnpackStrategyObject();

  // 测试从服务器端返回的数据是否是有效的(数据要先解包, 然后再根据错误码做判断)
  public IServerRespondDataTest getServerRespondDataTestStrategyObject();

  // 拼接一个网络接口的完整请求URL
  public ISpliceFullUrlByDomainBeanSpecialPath getSpliceFullUrlByDomainBeanSpecialPathStrategyObject();

  // 业务Bean请求时,需要传递到服务器的公共参数
  public IDomainBeanRequestPublicParameter getDomainBeanRequestPublicParameterStrategyObject();
}
