package cn.lvyou.domainbean_model.app_get_orderforminfo;

/**
 * APP获取订单信息
 * 
 * @author hesiming
 * 
 */
public final class OrderforminfoNetRequestBean {
	// true int 订单ID
	private String id;

	public OrderforminfoNetRequestBean(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "OrderforminfoNetRequestBean [id=" + id + "]";
	}

}
