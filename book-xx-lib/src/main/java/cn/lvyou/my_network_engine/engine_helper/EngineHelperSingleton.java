package cn.lvyou.my_network_engine.engine_helper;

import cn.lvyou.my_custom_network_engine.engine_helper.DomainBeanRequestPublicParameterForLvyou;
import cn.lvyou.my_custom_network_engine.engine_helper.NetRequestEntityDataPackageForLvyou;
import cn.lvyou.my_custom_network_engine.engine_helper.NetRespondEntityDataUnpackForLvyou;
import cn.lvyou.my_custom_network_engine.engine_helper.ServerRespondDataTestForLvyou;
import cn.lvyou.my_custom_network_engine.engine_helper.SpliceFullUrlByDomainBeanSpecialPathForLvyou;
import cn.lvyou.my_network_engine.engine_helper.interfaces.IDomainBeanRequestPublicParameter;
import cn.lvyou.my_network_engine.engine_helper.interfaces.INetRequestEntityDataPackage;
import cn.lvyou.my_network_engine.engine_helper.interfaces.INetRespondRawEntityDataUnpack;
import cn.lvyou.my_network_engine.engine_helper.interfaces.IServerRespondDataTest;
import cn.lvyou.my_network_engine.engine_helper.interfaces.ISpliceFullUrlByDomainBeanSpecialPath;

/**
 * 引擎助手函数
 * 
 * @author skyduck
 */
public enum EngineHelperSingleton implements IEngineHelper {
  getInstance;

  @Override
  public INetRequestEntityDataPackage getNetRequestEntityDataPackageStrategyObject() {
    return new NetRequestEntityDataPackageForLvyou();
  }

  @Override
  public INetRespondRawEntityDataUnpack getNetRespondEntityDataUnpackStrategyObject() {
    return new NetRespondEntityDataUnpackForLvyou();
  }

  @Override
  public IServerRespondDataTest getServerRespondDataTestStrategyObject() {
    return new ServerRespondDataTestForLvyou();
  }

  @Override
  public ISpliceFullUrlByDomainBeanSpecialPath getSpliceFullUrlByDomainBeanSpecialPathStrategyObject() {
    return new SpliceFullUrlByDomainBeanSpecialPathForLvyou();
  }

  @Override
  public IDomainBeanRequestPublicParameter getDomainBeanRequestPublicParameterStrategyObject() {
    return new DomainBeanRequestPublicParameterForLvyou();
  }

}
