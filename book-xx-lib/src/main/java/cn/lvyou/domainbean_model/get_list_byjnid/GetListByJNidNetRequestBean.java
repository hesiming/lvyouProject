package cn.lvyou.domainbean_model.get_list_byjnid;

/**
 * 通过传锦囊id获取折扣列表
 * 
 * @author hesiming
 * 
 */
public final class GetListByJNidNetRequestBean {
	// int 锦囊id 默认值0 非必选参数
	private String jn_id;

	public GetListByJNidNetRequestBean() {
	}

	public String getJn_id() {
		return jn_id;
	}

	public void setJn_id(String jn_id) {
		this.jn_id = jn_id;
	}

	@Override
	public String toString() {
		return "GetListByjnidNetRespondBean [jn_id=" + jn_id + "]";
	}

}
