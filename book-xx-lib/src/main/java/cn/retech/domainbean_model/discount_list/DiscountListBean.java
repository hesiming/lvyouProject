package cn.retech.domainbean_model.discount_list;

import java.util.List;

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
