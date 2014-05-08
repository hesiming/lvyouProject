package cn.lvyou.domainbean_model.discount_list;

/**
 * 折扣列表返回Bean
 * 
 * @author hesiming
 * 
 */
public final class DiscountListNetRespondBean {
	// ID
	private int id;
	// 折扣封图
	private String pic;
	// 折扣title
	private String title;
	// 折扣简介
	private String detail;
	// 折扣价格
	private String price;
	// 折扣到期时间
	private String end_date;
	// 是否穷游儿独享1-是0-否
	private boolean self_use;
	// 是否穷游首发1-是0-否
	private boolean first_pub;
	// 原价
	private int list_price;
	// appview折扣详细页面url
	private String url;

	public DiscountListNetRespondBean(int id, String pic, String title, String detail, String price, String end_date, boolean self_use, boolean first_pub, int list_price, String url) {
		super();
		this.id = id;
		this.pic = pic;
		this.title = title;
		this.detail = detail;
		this.price = price;
		this.end_date = end_date;
		this.self_use = self_use;
		this.first_pub = first_pub;
		this.list_price = list_price;
		this.url = url;
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

	public int getList_price() {
		return list_price;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "DiscountListNetRespondBean [id=" + id + ", pic=" + pic + ", title=" + title + ", detail=" + detail + ", price=" + price + ", end_date=" + end_date + ", self_use=" + self_use
				+ ", first_pub=" + first_pub + ", list_price=" + list_price + ", url=" + url + "]";
	}

}
