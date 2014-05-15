package cn.lvyou.domainbean_model.app_get_userorderformlist;

/**
 * APP获取订单信息
 * 
 * @author hesiming
 * 
 */
public final class UserOrderNetRequestBean {
	// true string 采用OAuth授权方式为必填参数， OAuth授权后获得。
	private String oauth_token;
	// false int 每页显示数量
	private String count;
	// false int 页码
	private String page;

	public UserOrderNetRequestBean(String oauth_token) {
		this.oauth_token = oauth_token;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getOauth_token() {
		return oauth_token;
	}

	@Override
	public String toString() {
		return "UserOrderNetRequestBean [oauth_token=" + oauth_token + ", count=" + count + ", page=" + page + "]";
	}

}
