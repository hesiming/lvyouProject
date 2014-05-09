package cn.lvyou.domainbean_model.subscribe_list;

public final class SubscribeItem {
	// id
	private int id;
	// 折扣类型
	private String product_type;
	// 旅行时间
	private String date_str;
	// 目的地
	private String country;
	// 出发地
	private String start_pos;

	public SubscribeItem(int id, String product_type, String date_str, String country, String start_pos) {
		this.id = id;
		this.product_type = product_type;
		this.date_str = date_str;
		this.country = country;
		this.start_pos = start_pos;
	}

	public int getId() {
		return id;
	}

	public String getProduct_type() {
		return product_type;
	}

	public String getDate_str() {
		return date_str;
	}

	public String getCountry() {
		return country;
	}

	public String getStart_pos() {
		return start_pos;
	}

	@Override
	public String toString() {
		return "SubscribeItem [id=" + id + ", product_type=" + product_type + ", date_str=" + date_str + ", country=" + country + ", start_pos=" + start_pos + "]";
	}

}
