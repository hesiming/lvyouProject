package cn.lvyou.domainbean_model.app_query;

/**
 * APP获取订单信息
 * 
 * @author hesiming
 * 
 */
public final class AppQueryNetRespondBean {
	// string 分页HTML代码，不用考虑
	private String data;

	public AppQueryNetRespondBean(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	@Override
	public String toString() {
		return "AppQueryNetRespondBean [data=" + data + "]";
	}

}
