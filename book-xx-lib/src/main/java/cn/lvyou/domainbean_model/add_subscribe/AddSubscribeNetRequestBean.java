package cn.lvyou.domainbean_model.add_subscribe;

public final class AddSubscribeNetRequestBean {
	// true string 采用OAuth授权方式为必填参数， OAuth授权后获得。
	private String oauth_token;
	// true int 类型id
	private String type;
	// true string 时间
	private String times;
	// true int 国家id
	private String country_id;
	// true string 出发地
	private String dpt;

	public AddSubscribeNetRequestBean(String oauth_token, String type, String times, String country_id, String dpt) {
		this.oauth_token = oauth_token;
		this.type = type;
		this.times = times;
		this.country_id = country_id;
		this.dpt = dpt;
	}

	public String getOauth_token() {
		return oauth_token;
	}

	public String getType() {
		return type;
	}

	public String getTimes() {
		return times;
	}

	public String getCountry_id() {
		return country_id;
	}

	public String getDpt() {
		return dpt;
	}

	@Override
	public String toString() {
		return "AddSubscribeNetRequestBean [oauth_token=" + oauth_token + ", type=" + type + ", times=" + times + ", country_id=" + country_id + ", dpt=" + dpt + "]";
	}

}
