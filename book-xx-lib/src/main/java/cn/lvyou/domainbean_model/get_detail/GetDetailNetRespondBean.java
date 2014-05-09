package cn.lvyou.domainbean_model.get_detail;

import java.util.List;

/**
 * 获取折扣详情
 * 
 * @author hesiming
 * 
 */
public final class GetDetailNetRespondBean {
	// ID
	private int id;
	// 折扣H5页地址
	private String app_url;
	// 是否预定类折扣 1、预定类产品 0、非预定类产品
	private int app_booktype;
	// 折扣开始时间 字符串
	private String app_start_date;
	// 折扣结束时间 字符串
	private String app_end_date;
	// 折扣开始时间 时间戳
	private int app_start_date_new;
	// 折扣结束时间 时间戳
	private int app_end_date_new;
	// 第一次定单开始时间 格式UNIX时间戳
	private String app_firstpay_start_time;
	// 第一次定单结束时间 格式UNIX时间戳
	private String app_firstpay_end_time;
	// 第二次定单开始时间 格式UNIX时间戳
	private String app_secondpay_start_time;
	// 第二次定单结束时间 格式UNIX时间戳
	private String app_secondpay_end_time;
	// 库存数量
	private int app_stock;
	// 是否在售 1:在售 0:下架
	private int onsale;
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
	// 折扣代码
	private String discount_code;
	// 是否穷游儿独享1-是0-否
	private int self_use;
	// 是否穷游首发1-是0-否
	private int first_pub;
	// 是否登录可见1-是0-否
	private int login_visible;
	// array 折扣详情图片原图
	private List<String> detail_imageList;
	// array 折扣详情图片180×180
	private List<String> detail_image180List;
	// 预订类型-0:链接, 1:电话
	private int order_type;
	// array 折扣预订方式
	private List<String> order_infoList;
	// array 折扣预订方式说明
	private List<String> order_info_txtList;
	// 折扣详情
	private String deal_info;
	// 使用说明
	private String use_if;
	// 相应web详细页地址
	private String qyer_url;
	// array 相关折扣
	private List<GetDetailRelated> getDetailRelatedList;
	// 是否收藏1-是0-否
	private int favored;

	public GetDetailNetRespondBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApp_url() {
		return app_url;
	}

	public void setApp_url(String app_url) {
		this.app_url = app_url;
	}

	public int getApp_booktype() {
		return app_booktype;
	}

	public void setApp_booktype(int app_booktype) {
		this.app_booktype = app_booktype;
	}

	public String getApp_start_date() {
		return app_start_date;
	}

	public void setApp_start_date(String app_start_date) {
		this.app_start_date = app_start_date;
	}

	public String getApp_end_date() {
		return app_end_date;
	}

	public void setApp_end_date(String app_end_date) {
		this.app_end_date = app_end_date;
	}

	public int getApp_start_date_new() {
		return app_start_date_new;
	}

	public void setApp_start_date_new(int app_start_date_new) {
		this.app_start_date_new = app_start_date_new;
	}

	public int getApp_end_date_new() {
		return app_end_date_new;
	}

	public void setApp_end_date_new(int app_end_date_new) {
		this.app_end_date_new = app_end_date_new;
	}

	public String getApp_firstpay_start_time() {
		return app_firstpay_start_time;
	}

	public void setApp_firstpay_start_time(String app_firstpay_start_time) {
		this.app_firstpay_start_time = app_firstpay_start_time;
	}

	public String getApp_firstpay_end_time() {
		return app_firstpay_end_time;
	}

	public void setApp_firstpay_end_time(String app_firstpay_end_time) {
		this.app_firstpay_end_time = app_firstpay_end_time;
	}

	public String getApp_secondpay_start_time() {
		return app_secondpay_start_time;
	}

	public void setApp_secondpay_start_time(String app_secondpay_start_time) {
		this.app_secondpay_start_time = app_secondpay_start_time;
	}

	public String getApp_secondpay_end_time() {
		return app_secondpay_end_time;
	}

	public void setApp_secondpay_end_time(String app_secondpay_end_time) {
		this.app_secondpay_end_time = app_secondpay_end_time;
	}

	public int getApp_stock() {
		return app_stock;
	}

	public void setApp_stock(int app_stock) {
		this.app_stock = app_stock;
	}

	public int getOnsale() {
		return onsale;
	}

	public void setOnsale(int onsale) {
		this.onsale = onsale;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getDiscount_code() {
		return discount_code;
	}

	public void setDiscount_code(String discount_code) {
		this.discount_code = discount_code;
	}

	public int getSelf_use() {
		return self_use;
	}

	public void setSelf_use(int self_use) {
		this.self_use = self_use;
	}

	public int getFirst_pub() {
		return first_pub;
	}

	public void setFirst_pub(int first_pub) {
		this.first_pub = first_pub;
	}

	public int getLogin_visible() {
		return login_visible;
	}

	public void setLogin_visible(int login_visible) {
		this.login_visible = login_visible;
	}

	public List<String> getDetail_imageList() {
		return detail_imageList;
	}

	public void setDetail_imageList(List<String> detail_imageList) {
		this.detail_imageList = detail_imageList;
	}

	public List<String> getDetail_image180List() {
		return detail_image180List;
	}

	public void setDetail_image180List(List<String> detail_image180List) {
		this.detail_image180List = detail_image180List;
	}

	public int getOrder_type() {
		return order_type;
	}

	public void setOrder_type(int order_type) {
		this.order_type = order_type;
	}

	public List<String> getOrder_infoList() {
		return order_infoList;
	}

	public void setOrder_infoList(List<String> order_infoList) {
		this.order_infoList = order_infoList;
	}

	public List<String> getOrder_info_txtList() {
		return order_info_txtList;
	}

	public void setOrder_info_txtList(List<String> order_info_txtList) {
		this.order_info_txtList = order_info_txtList;
	}

	public String getDeal_info() {
		return deal_info;
	}

	public void setDeal_info(String deal_info) {
		this.deal_info = deal_info;
	}

	public String getUse_if() {
		return use_if;
	}

	public void setUse_if(String use_if) {
		this.use_if = use_if;
	}

	public String getQyer_url() {
		return qyer_url;
	}

	public void setQyer_url(String qyer_url) {
		this.qyer_url = qyer_url;
	}

	public List<GetDetailRelated> getGetDetailRelatedList() {
		return getDetailRelatedList;
	}

	public void setGetDetailRelatedList(List<GetDetailRelated> getDetailRelatedList) {
		this.getDetailRelatedList = getDetailRelatedList;
	}

	public int getFavored() {
		return favored;
	}

	public void setFavored(int favored) {
		this.favored = favored;
	}

	@Override
	public String toString() {
		return "GetDetailNetRespondBean [id=" + id + ", app_url=" + app_url + ", app_booktype=" + app_booktype + ", app_start_date=" + app_start_date + ", app_end_date=" + app_end_date
				+ ", app_start_date_new=" + app_start_date_new + ", app_end_date_new=" + app_end_date_new + ", app_firstpay_start_time=" + app_firstpay_start_time + ", app_firstpay_end_time="
				+ app_firstpay_end_time + ", app_secondpay_start_time=" + app_secondpay_start_time + ", app_secondpay_end_time=" + app_secondpay_end_time + ", app_stock=" + app_stock + ", onsale="
				+ onsale + ", pic=" + pic + ", title=" + title + ", detail=" + detail + ", price=" + price + ", end_date=" + end_date + ", discount_code=" + discount_code + ", self_use=" + self_use
				+ ", first_pub=" + first_pub + ", login_visible=" + login_visible + ", detail_imageList=" + detail_imageList + ", detail_image180List=" + detail_image180List + ", order_type="
				+ order_type + ", order_infoList=" + order_infoList + ", order_info_txtList=" + order_info_txtList + ", deal_info=" + deal_info + ", use_if=" + use_if + ", qyer_url=" + qyer_url
				+ ", getDetailRelatedList=" + getDetailRelatedList + ", favored=" + favored + "]";
	}

}
