package cn.lvyou.domainbean_model.discount_list;

import java.util.List;

/**
 * 获取折扣列表
 * 
 * @author hesiming
 * 
 */
public final class DiscountListBean {

	private List<DiscountListNetRespondBean> discountListBean;

	public DiscountListBean(List<DiscountListNetRespondBean> discountListBean) {
		this.discountListBean = discountListBean;
	}

	public List<DiscountListNetRespondBean> getDiscountListNetRespondBeanListBean() {
		return discountListBean;
	}

	@Override
	public String toString() {
		return "DiscountListNetRespondBeanListBean [discountListNetRespondBeanListBean=" + discountListBean + "]";
	}

}
