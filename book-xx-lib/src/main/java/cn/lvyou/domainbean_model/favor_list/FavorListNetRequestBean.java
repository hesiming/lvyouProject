package cn.lvyou.domainbean_model.favor_list;

/**
 * lastminute收藏列表
 * 
 * @author hesiming
 * 
 */
public final class FavorListNetRequestBean {
	// 采用OAuth授权方式为必填参数， OAuth授权后获得。
	private String oauth_token;
	// 本页最大id 默认值0,指第一页 非必选
	private String max_id;
	// 页大小 默认值10 非必选
	private String page_size;

	public FavorListNetRequestBean(String oauth_token) {
		this.oauth_token = oauth_token;
	}

	public String getMax_id() {
		return max_id;
	}

	public void setMax_id(String max_id) {
		this.max_id = max_id;
	}

	public String getPage_size() {
		return page_size;
	}

	public void setPage_size(String page_size) {
		this.page_size = page_size;
	}

	public String getOauth_token() {
		return oauth_token;
	}

	@Override
	public String toString() {
		return "FavorListNetRequestBean [oauth_token=" + oauth_token + ", max_id=" + max_id + ", page_size=" + page_size + "]";
	}

}
