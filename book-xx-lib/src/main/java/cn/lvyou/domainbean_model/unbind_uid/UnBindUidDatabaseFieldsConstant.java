package cn.lvyou.domainbean_model.unbind_uid;

public final class UnBindUidDatabaseFieldsConstant {
	private UnBindUidDatabaseFieldsConstant() {

	}

	public static enum RequestBean {
		// true string 采用OAuth授权方式为必填参数， OAuth授权后获得。
		oauth_token,
		// 设备ID
		deviceID;
	}

	public static enum RespondBean {
		//
		data,

	}
}
