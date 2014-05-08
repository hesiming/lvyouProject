package cn.lvyou.my_network_engine;

public class NetRequestHandleNilObject implements INetRequestHandle {

  public NetRequestHandleNilObject() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public boolean idle() {
    return true;
  }

  @Override
  public void cancel() {

  }

}
