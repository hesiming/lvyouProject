package cn.retech.my_network_engine.engine_helper.interfaces;

import cn.retech.my_network_engine.net_error_handle.MyNetRequestErrorBean;

/**
 * 测试从服务器端返回的数据是否是有效的(数据要先解包, 然后再根据服务器返回的错误码做判断)
 * 
 * @author skyduck
 * 
 */
public interface IServerRespondDataTest {
  public MyNetRequestErrorBean testServerRespondDataError(final Object netUnpackedData);
}
