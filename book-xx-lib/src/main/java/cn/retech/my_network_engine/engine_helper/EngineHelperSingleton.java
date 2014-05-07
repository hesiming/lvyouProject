package cn.retech.my_network_engine.engine_helper;

import cn.retech.my_custom_network_engine.engine_helper.DomainBeanRequestPublicParameterForLvyou;
import cn.retech.my_custom_network_engine.engine_helper.NetRequestEntityDataPackageForLvyou;
import cn.retech.my_custom_network_engine.engine_helper.NetRespondEntityDataUnpackForLvyou;
import cn.retech.my_custom_network_engine.engine_helper.ServerRespondDataTestForLvyou;
import cn.retech.my_custom_network_engine.engine_helper.SpliceFullUrlByDomainBeanSpecialPathForLvyou;
import cn.retech.my_network_engine.engine_helper.interfaces.IDomainBeanRequestPublicParameter;
import cn.retech.my_network_engine.engine_helper.interfaces.INetRequestEntityDataPackage;
import cn.retech.my_network_engine.engine_helper.interfaces.INetRespondRawEntityDataUnpack;
import cn.retech.my_network_engine.engine_helper.interfaces.IServerRespondDataTest;
import cn.retech.my_network_engine.engine_helper.interfaces.ISpliceFullUrlByDomainBeanSpecialPath;

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
