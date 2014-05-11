package cn.lvyou.domainbean_model.app_post_second_orderform;

public final class PostSecondOrderformNetRequestBean {
	// true string 采用OAuth授权方式为必填参数， OAuth授权后获得。
	private String oauth_token;
	// true int 折扣id 必选参数
	private String id;

	public PostSecondOrderformNetRequestBean(String oauth_token, String id) {
		this.oauth_token = oauth_token;
		this.id = id;
	}

	public String getOauth_token() {
		return oauth_token;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "AddFavorNetRequestBean [oauth_token=" + oauth_token + ", id=" + id + "]";
	}

}
