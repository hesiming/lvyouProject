package cn.lvyou.my_network_engine.engine_helper.interfaces;


/**
 * 将网络返回的二进制数据包, 解包成可识别的字符串(在这里完成数据的解密)
 * 
 * @author skyduck
 * 
 */
public interface INetRespondRawEntityDataUnpack {
  public Object unpackNetRespondRawEntityData(final Object rawData);
}
