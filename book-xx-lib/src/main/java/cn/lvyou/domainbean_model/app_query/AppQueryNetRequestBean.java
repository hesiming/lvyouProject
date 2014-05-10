package cn.lvyou.domainbean_model.app_query;

/**
 * APP获取订单信息
 * 
 * @author hesiming
 * 
 */
public final class AppQueryNetRequestBean {
	// true int 订单ID 必选参数
	private String out_trade_no;

	public AppQueryNetRequestBean(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	@Override
	public String toString() {
		return "AppQueryNetRequestBean [out_trade_no=" + out_trade_no + "]";
	}

}
