package cn.lvyou.domainbean_model.get_list_byjnid;

import java.util.List;

/**
 * 通过传锦囊id获取折扣列表
 * 
 * @author hesiming
 * 
 */
public final class GetListByJNidNetRespondBean {
	private List<JNidBean> jNidBeans;

	public GetListByJNidNetRespondBean(List<JNidBean> jNidBeans) {
		super();
		this.jNidBeans = jNidBeans;
	}

	public List<JNidBean> getjNidBeans() {
		return jNidBeans;
	}

	@Override
	public String toString() {
		return "GetListByJNidNetRespondBean [jNidBeans=" + jNidBeans + "]";
	}

}
