package cn.lvyou.domainbean_model.get_list_byjnid;

public final class JNidBean {
	// int ID
	private int id;
	// string 折扣封图
	private String pic;
	// string 折扣title
	private String title;
	// string 折扣价格
	private String price;
	// string 折扣到期时间
	private String end_date;
	// string web方面链接
	private String web_url;
	// string m方面链接
	private String m_url;
	// int 分类
	private int product_type;

	public JNidBean(int id, String pic, String title, String price, String end_date, String web_url, String m_url, int product_type) {
		this.id = id;
		this.pic = pic;
		this.title = title;
		this.price = price;
		this.end_date = end_date;
		this.web_url = web_url;
		this.m_url = m_url;
		this.product_type = product_type;
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

	public String getPrice() {
		return price;
	}

	public String getEnd_date() {
		return end_date;
	}

	public String getWeb_url() {
		return web_url;
	}

	public String getM_url() {
		return m_url;
	}

	public int getProduct_type() {
		return product_type;
	}

	@Override
	public String toString() {
		return "GetListByjnidNetRespondBean [id=" + id + ", pic=" + pic + ", title=" + title + ", price=" + price + ", end_date=" + end_date + ", web_url=" + web_url + ", m_url=" + m_url
				+ ", product_type=" + product_type + "]";
	}
}
