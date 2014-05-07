package cn.retech.my_custom_network_engine.engine_helper;

import java.io.UnsupportedEncodingException;

import cn.retech.my_network_engine.engine_helper.interfaces.INetRespondRawEntityDataUnpack;
import cn.retech.toolutils.DebugLog;

/**
 * 
 * @author skyduck
 *
 */
public final class NetRespondEntityDataUnpackForLvyou implements INetRespondRawEntityDataUnpack {
  private final String TAG = this.getClass().getSimpleName();

  @Override
  public Object unpackNetRespondRawEntityData(final Object rawData) {
    byte[] rawDataOfByteArray = (byte[])rawData;
    String netUnpackedData = null;
    try {
      netUnpackedData = new String(rawDataOfByteArray, "utf-8");
    } catch (UnsupportedEncodingException e) {
      DebugLog.e(TAG, "解包 NetRespondRawEntityData 失败!");
    }

    return netUnpackedData;
  }

}
