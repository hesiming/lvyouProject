package cn.lvyou.my_network_engine.net_error_handle;

/**
 * @author skyduck
 */
public final class DomainBeanNetRequestErrorBeanHandle {
  private DomainBeanNetRequestErrorBeanHandle() {

  }

  public static void handleNetRequestBean(final MyNetRequestErrorBean netErrorBean) {
    if (netErrorBean == null) {
      return;
    }

    String errorMessage = "";

    netErrorBean.setErrorMessage(errorMessage);
  }
}