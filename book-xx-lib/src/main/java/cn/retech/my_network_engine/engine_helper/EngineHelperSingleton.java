package cn.retech.my_network_engine.engine_helper;

import cn.retech.my_custom_network_engine.engine_helper.DomainBeanRequestPublicParameterForDreamBook;
import cn.retech.my_custom_network_engine.engine_helper.NetRequestEntityDataPackageForDreamBook;
import cn.retech.my_custom_network_engine.engine_helper.NetRespondEntityDataUnpackDreamBook;
import cn.retech.my_custom_network_engine.engine_helper.ServerRespondDataTestDreamBook;
import cn.retech.my_custom_network_engine.engine_helper.SpliceFullUrlByDomainBeanSpecialPathForDreamBook;
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
    return new NetRequestEntityDataPackageForDreamBook();
  }

  @Override
  public INetRespondRawEntityDataUnpack getNetRespondEntityDataUnpackStrategyObject() {
    return new NetRespondEntityDataUnpackDreamBook();
  }

  @Override
  public IServerRespondDataTest getServerRespondDataTestStrategyObject() {
    return new ServerRespondDataTestDreamBook();
  }

  @Override
  public ISpliceFullUrlByDomainBeanSpecialPath getSpliceFullUrlByDomainBeanSpecialPathStrategyObject() {
    return new SpliceFullUrlByDomainBeanSpecialPathForDreamBook();
  }

  @Override
  public IDomainBeanRequestPublicParameter getDomainBeanRequestPublicParameterStrategyObject() {
    return new DomainBeanRequestPublicParameterForDreamBook();
  }

}
