package cn.lvyou.domainbean_model.app_get_userorderformlist;

import java.util.List;

/**
 * APP获取订单信息
 * 
 * @author hesiming
 * 
 */
public final class UserOrderNetRespondBean {
	// string 分页HTML代码，不用考虑
	private String pager;
	// int 总条数
	private String counts;
	// array 折扣列表，字段说明参见lastminute/app_get_orderforminfo,其中balanceorder表示尾款订单
	private List<UserorderformResBean> res;

	public UserOrderNetRespondBean() {
	}

	public String getPager() {
		return pager;
	}

	public void setPager(String pager) {
		this.pager = pager;
	}

	public String getCounts() {
		return counts;
	}

	public void setCounts(String counts) {
		this.counts = counts;
	}

	public List<UserorderformResBean> getRes() {
		return res;
	}

	public void setRes(List<UserorderformResBean> res) {
		this.res = res;
	}

	@Override
	public String toString() {
		return "UserOrderNetRespondBean [pager=" + pager + ", counts=" + counts + ", res=" + res + "]";
	}

}
