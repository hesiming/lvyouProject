package cn.lvyou.domainbean_model.app_get_productsinfo;

/**
 * APP获取折扣类型信息
 * 
 * @author hesiming
 * 
 */
public class ProductsInfoNetRequestBean {
	// true int 折扣ID 必选参数
	private String id;
	// 采用OAuth授权方式为必填参数， OAuth授权后获得。
	private String oauth_token;

	public ProductsInfoNetRequestBean(String id, String oauth_token) {
		this.id = id;
		this.oauth_token = oauth_token;
	}

	public String getId() {
		return id;
	}

	public String getOauth_token() {
		return oauth_token;
	}

	@Override
	public String toString() {
		return "ProductsInfoNetRequestBean [id=" + id + ", oauth_token=" + oauth_token + "]";
	}

}
