package cn.lvyou.domainbean_model.add_subscribe;

public final class AddSubscribeDatabaseFieldsConstant {
	private AddSubscribeDatabaseFieldsConstant() {

	}

	public static enum RequestBean {
		// true string 采用OAuth授权方式为必填参数， OAuth授权后获得。
		oauth_token,
		// true int 类型id
		type,
		// true string 时间
		times,
		// true int 国家id
		country_id,
		// true string 出发地
		dpt;

	}

	public static enum RespondBean {
		//
		data,

	}
}
