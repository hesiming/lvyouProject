package cn.lvyou.domainbean_model.app_get_orderforminfo.order_info_item;

public final class ProductsBean {
	private String id;
	private String lid;
	private String title;
	private String total;
	private String stock;
	private String price;
	private String advance_payment;
	private String buy_limit;
	private String type;

	public ProductsBean() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAdvance_payment() {
		return advance_payment;
	}

	public void setAdvance_payment(String advance_payment) {
		this.advance_payment = advance_payment;
	}

	public String getBuy_limit() {
		return buy_limit;
	}

	public void setBuy_limit(String buy_limit) {
		this.buy_limit = buy_limit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ProductsBean [id=" + id + ", lid=" + lid + ", title=" + title + ", total=" + total + ", stock=" + stock + ", price=" + price + ", advance_payment=" + advance_payment + ", buy_limit="
				+ buy_limit + ", type=" + type + "]";
	}

}
