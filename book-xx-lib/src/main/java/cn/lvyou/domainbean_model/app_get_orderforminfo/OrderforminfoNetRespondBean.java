package cn.lvyou.domainbean_model.app_get_orderforminfo;

import java.util.List;

import cn.lvyou.domainbean_model.app_get_orderforminfo.order_info_item.LastminuteBean;
import cn.lvyou.domainbean_model.app_get_orderforminfo.order_info_item.OrderformBean;
import cn.lvyou.domainbean_model.app_get_orderforminfo.order_info_item.ProductsBean;
import cn.lvyou.domainbean_model.app_get_orderforminfo.order_info_item.SupplierBean;

/**
 * APP获取订单信息
 * 
 * @author hesiming
 * 
 */
public final class OrderforminfoNetRespondBean {
	// int 订单号
	private String id;
	// string 截止时间，为0时则表示不限制
	private String lastalipaydatetime;
	// string 折扣标题
	private String lastminute_title;
	// string 折扣价格 可能为数字，也可能为<em>999</em>元起
	private String lastminute_price;
	// int 产品类型 0为全款 1为预付款 2为尾款
	private String products_type;
	// string 产品标题
	private String products_title;
	// float 购买单价
	private String unit_price;
	// int 购买数量
	private String num;
	// float 购买总价
	private String price;
	// string 商家支付宝号
	private String alipay_account;
	// string 商家名称
	private String supplier_title;
	// int 商家类型 1，非认证商家 0，认证商家
	private String supplier_type;
	// string 商家电话
	private String supplier_phone;
	// int 订单状态 1 已支付 0未支付 -1超时
	private String payment;
	// array 对应折扣信息，数组
	private List<LastminuteBean> lastminute;
	// array 对应商家信息，数组
	private List<SupplierBean> supplier;
	// array 对应产品信息，数组
	private List<ProductsBean> products;
	// array 订单信息，数组
	private List<OrderformBean> orderform;
	// int 订单支付类型 0 未支付 1 web端支付 2 app端支付
	private String pay_type;

	public OrderforminfoNetRespondBean() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastalipaydatetime() {
		return lastalipaydatetime;
	}

	public void setLastalipaydatetime(String lastalipaydatetime) {
		this.lastalipaydatetime = lastalipaydatetime;
	}

	public String getLastminute_title() {
		return lastminute_title;
	}

	public void setLastminute_title(String lastminute_title) {
		this.lastminute_title = lastminute_title;
	}

	public String getLastminute_price() {
		return lastminute_price;
	}

	public void setLastminute_price(String lastminute_price) {
		this.lastminute_price = lastminute_price;
	}

	public String getProducts_type() {
		return products_type;
	}

	public void setProducts_type(String products_type) {
		this.products_type = products_type;
	}

	public String getProducts_title() {
		return products_title;
	}

	public void setProducts_title(String products_title) {
		this.products_title = products_title;
	}

	public String getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(String unit_price) {
		this.unit_price = unit_price;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAlipay_account() {
		return alipay_account;
	}

	public void setAlipay_account(String alipay_account) {
		this.alipay_account = alipay_account;
	}

	public String getSupplier_title() {
		return supplier_title;
	}

	public void setSupplier_title(String supplier_title) {
		this.supplier_title = supplier_title;
	}

	public String getSupplier_type() {
		return supplier_type;
	}

	public void setSupplier_type(String supplier_type) {
		this.supplier_type = supplier_type;
	}

	public String getSupplier_phone() {
		return supplier_phone;
	}

	public void setSupplier_phone(String supplier_phone) {
		this.supplier_phone = supplier_phone;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public List<LastminuteBean> getLastminute() {
		return lastminute;
	}

	public void setLastminute(List<LastminuteBean> lastminute) {
		this.lastminute = lastminute;
	}

	public List<SupplierBean> getSupplier() {
		return supplier;
	}

	public void setSupplier(List<SupplierBean> supplier) {
		this.supplier = supplier;
	}

	public List<ProductsBean> getProducts() {
		return products;
	}

	public void setProducts(List<ProductsBean> products) {
		this.products = products;
	}

	public List<OrderformBean> getOrderform() {
		return orderform;
	}

	public void setOrderform(List<OrderformBean> orderform) {
		this.orderform = orderform;
	}

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	@Override
	public String toString() {
		return "OrderforminfoNetRespondBean [id=" + id + ", lastalipaydatetime=" + lastalipaydatetime + ", lastminute_title=" + lastminute_title + ", lastminute_price=" + lastminute_price
				+ ", products_type=" + products_type + ", products_title=" + products_title + ", unit_price=" + unit_price + ", num=" + num + ", price=" + price + ", alipay_account=" + alipay_account
				+ ", supplier_title=" + supplier_title + ", supplier_type=" + supplier_type + ", supplier_phone=" + supplier_phone + ", payment=" + payment + ", lastminute=" + lastminute
				+ ", supplier=" + supplier + ", products=" + products + ", orderform=" + orderform + ", pay_type=" + pay_type + "]";
	}

}
