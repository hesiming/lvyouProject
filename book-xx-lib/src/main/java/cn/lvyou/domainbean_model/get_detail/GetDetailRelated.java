package cn.lvyou.domainbean_model.get_detail;

/**
 * 获取折扣详情
 * 
 * @author hesiming
 * 
 */
public final class GetDetailRelated {
	// ID
	private int id;
	// 折扣title
	private String title;
	// 折扣价格
	private String price;
	// 折扣封图
	private String pic;
	private String addtime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	@Override
	public String toString() {
		return "GetDetailRelated [id=" + id + ", title=" + title + ", price=" + price + ", pic=" + pic + "]";
	}

}
