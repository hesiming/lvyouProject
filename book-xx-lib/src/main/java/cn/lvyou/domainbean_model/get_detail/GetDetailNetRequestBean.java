package cn.lvyou.domainbean_model.get_detail;
/**
 * 获取折扣详情
 * @author hesiming
 *
 */
public final class GetDetailNetRequestBean {
	// 必选 折扣ID
	private String id;
	// 非必选 采用OAuth授权方式为必填参数， OAuth授权后获得。 默认值空
	private String oauth_token;

	public GetDetailNetRequestBean(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getOauth_token() {
		return oauth_token;
	}

	public void setOauth_token(String oauth_token) {
		this.oauth_token = oauth_token;
	}

	@Override
	public String toString() {
		return "GetDetailNetRespondBean [id=" + id + ", oauth_token=" + oauth_token + "]";
	}
}
