package cn.lvyou.domainbean_model.subscribe_push;

/**
 * 折扣提醒推送
 * 
 * @author hesiming
 * 
 */
public final class SubscribePushNetRequestBean {
	// true string 采用OAuth授权方式为必填参数， OAuth授权后获得。
	private String oauth_token;

	public SubscribePushNetRequestBean(String oauth_token) {
		this.oauth_token = oauth_token;
	}

	public String getOauth_token() {
		return oauth_token;
	}

	@Override
	public String toString() {
		return "SubscribePushNetRequestBean [oauth_token=" + oauth_token + "]";
	}

}
