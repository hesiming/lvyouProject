package cn.lvyou.domainbean_model.app_get_productsinfo;

public class ProdutsInfoItem {
	// int 折扣类型ID
	private int id;
	// string 类型名称
	private String title;
	// int 库存
	private String stock;
	// int 购买限制，为0则不限制
	private String buy_limit;
	// int 0为全款 1为预付款
	private String type;
	// float 类型的价格
	private String product_price;

	public ProdutsInfoItem(int id, String title, String stock, String buy_limit, String type, String product_price) {
		this.id = id;
		this.title = title;
		this.stock = stock;
		this.buy_limit = buy_limit;
		this.type = type;
		this.product_price = product_price;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getStock() {
		return stock;
	}

	public String getBuy_limit() {
		return buy_limit;
	}

	public String getType() {
		return type;
	}

	public String getProduct_price() {
		return product_price;
	}

	@Override
	public String toString() {
		return "ProdutsInfoItem [id=" + id + ", title=" + title + ", stock=" + stock + ", buy_limit=" + buy_limit + ", type=" + type + ", product_price=" + product_price + "]";
	}

}
