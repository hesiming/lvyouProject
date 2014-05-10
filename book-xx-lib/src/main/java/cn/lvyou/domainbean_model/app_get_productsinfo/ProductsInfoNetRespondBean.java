package cn.lvyou.domainbean_model.app_get_productsinfo;

import java.util.List;

/**
 * APP获取折扣类型信息
 * 
 * @author hesiming
 * 
 */
public class ProductsInfoNetRespondBean {
	// int 折扣ID
	private int id;
	// string 折扣标题
	private String title;
	// string 折扣图片地址 尺寸275×185
	private String pic;
	// string 折扣价格 可能为数字，也可能为<em>999</em>元起
	private String price;
	// array 折扣产品类型，数组,如果折扣不存在类型，则此项没有
	private List<ProdutsInfoItem> products;

	public ProductsInfoNetRespondBean(int id, String title, String pic, String price, List<ProdutsInfoItem> products) {
		this.id = id;
		this.title = title;
		this.pic = pic;
		this.price = price;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getPic() {
		return pic;
	}

	public String getPrice() {
		return price;
	}

	public List<ProdutsInfoItem> getProducts() {
		return products;
	}

	@Override
	public String toString() {
		return "ProductsInfoNetRespondBean [id=" + id + ", title=" + title + ", pic=" + pic + ", price=" + price + ", products=" + products + "]";
	}

}
