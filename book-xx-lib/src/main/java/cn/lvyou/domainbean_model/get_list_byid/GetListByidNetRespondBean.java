package cn.lvyou.domainbean_model.get_list_byid;

import java.util.List;

/**
 * 通过id字符串获取折扣列表
 * 
 * @author hesiming
 * 
 */
public final class GetListByidNetRespondBean {
	private List<ByIdBean> getByIdBeans;

	public GetListByidNetRespondBean(List<ByIdBean> getByIdBeans) {
		this.getByIdBeans = getByIdBeans;
	}

	public List<ByIdBean> getGetByIdBeans() {
		return getByIdBeans;
	}

	@Override
	public String toString() {
		return "GetListByidNetRespondBean [getByIdBeans=" + getByIdBeans + "]";
	}

}
