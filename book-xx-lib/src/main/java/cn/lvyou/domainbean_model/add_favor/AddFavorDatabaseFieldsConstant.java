package cn.lvyou.domainbean_model.add_favor;

public final class AddFavorDatabaseFieldsConstant {
	private AddFavorDatabaseFieldsConstant() {

	}

	public static enum RequestBean {
		// true string 采用OAuth授权方式为必填参数， OAuth授权后获得。
		oauth_token,
		// true int 折扣ID
		id;
	}

	public static enum RespondBean {
		//
		data,

	}
}
