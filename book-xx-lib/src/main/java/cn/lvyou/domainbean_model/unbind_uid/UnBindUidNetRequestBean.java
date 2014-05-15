package cn.lvyou.domainbean_model.unbind_uid;

public final class UnBindUidNetRequestBean {
	// true string 采用OAuth授权方式为必填参数， OAuth授权后获得。
	private String oauth_token;
	// 设备ID
	private String deviceID;

	public UnBindUidNetRequestBean(String oauth_token, String deviceID) {
		this.oauth_token = oauth_token;
		this.deviceID = deviceID;
	}

	public String getOauth_token() {
		return oauth_token;
	}

	public String getDeviceID() {
		return deviceID;
	}

	@Override
	public String toString() {
		return "AddFavorNetRequestBean [oauth_token=" + oauth_token + ", deviceID=" + deviceID + "]";
	}

}
