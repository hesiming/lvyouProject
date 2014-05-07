package cn.retech.domainbean_model.discount_list;

/**
 * 折扣列表请求Bean,这里的参数全是非必选
 * 
 * @author hesiming
 */
public final class DiscountListNetRequestBean {
	// 分类id 默认值0 指全部分类
	private String product_type;
	// 本页最大id 默认值0,指第一页
	private String max_id;
	// 页大小 默认值10
	private String page_size;
	// 时间
	private String times;
	// 大洲id
	private String continent_id;
	// 国家id
	private String country_id;
	// 出发城市
	private String departure;

	public DiscountListNetRequestBean() {
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getMax_id() {
		return max_id;
	}

	public void setMax_id(String max_id) {
		this.max_id = max_id;
	}

	public String getPage_size() {
		return page_size;
	}

	public void setPage_size(String page_size) {
		this.page_size = page_size;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getContinent_id() {
		return continent_id;
	}

	public void setContinent_id(String continent_id) {
		this.continent_id = continent_id;
	}

	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	@Override
	public String toString() {
		return "DiscountListNetRequestBean [product_type=" + product_type + ", max_id=" + max_id + ", page_size=" + page_size + ", times=" + times + ", continent_id=" + continent_id + ", country_id="
				+ country_id + ", departure=" + departure + "]";
	}

}
