package cn.lvyou.domainbean_model.subscribe_push;

public final class SubscribePushItem {
	// int ID
	private int id;
	// string 折扣封图
	private String pic;
	// string 折扣title
	private String title;
	// string 折扣简介
	private String detail;
	// string 折扣价格
	private String price;
	// string 折扣到期时间
	private String end_date;
	// int 是否穷游儿独享1-是0-否
	private boolean self_use;
	// int 是否穷游首发1-是0-否
	private boolean first_pub;

	public SubscribePushItem(int id, String pic, String title, String detail, String price, String end_date, boolean self_use, boolean first_pub) {
		this.id = id;
		this.pic = pic;
		this.title = title;
		this.detail = detail;
		this.price = price;
		this.end_date = end_date;
		this.self_use = self_use;
		this.first_pub = first_pub;
	}

	public int getId() {
		return id;
	}

	public String getPic() {
		return pic;
	}

	public String getTitle() {
		return title;
	}

	public String getDetail() {
		return detail;
	}

	public String getPrice() {
		return price;
	}

	public String getEnd_date() {
		return end_date;
	}

	public boolean isSelf_use() {
		return self_use;
	}

	public boolean isFirst_pub() {
		return first_pub;
	}

	@Override
	public String toString() {
		return "SubscribePushItem [id=" + id + ", pic=" + pic + ", title=" + title + ", detail=" + detail + ", price=" + price + ", end_date=" + end_date + ", self_use=" + self_use + ", first_pub="
				+ first_pub + "]";
	}

}
