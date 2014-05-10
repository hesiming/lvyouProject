package cn.lvyou.domainbean_model.app_get_bookinfo;

/**
 * APP获取折扣预定基础信息
 * 
 * @author hesiming
 * 
 */
// 还有个字段stock,但是测试为--->"stock":null 不知道什么意思
public final class BookInfoNetRespondBean {
	// int 折扣ID
	private int id;
	// string 折扣H5页地址
	private String url;
	// int 是否预定类折扣 1、预定类产品 0、非预定类产品
	private int booktype;
	// string 折扣开始时间 格式9999-12-31 23:59:59
	private String start_date;
	// string 折扣结束时间 格式9999-12-31 23:59:59
	private String end_date;
	// string 第一次定单开始时间 格式UNIX时间戳
	private String firstpay_start_time;
	// string 第一次定单结束时间 格式UNIX时间戳
	private String firstpay_end_time;
	// string 第二次定单开始时间 格式UNIX时间戳
	private String secondpay_start_time;
	// string 第二次定单结束时间 格式UNIX时间戳
	private String secondpay_end_time;

	public BookInfoNetRespondBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getBooktype() {
		return booktype;
	}

	public void setBooktype(int booktype) {
		this.booktype = booktype;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getFirstpay_start_time() {
		return firstpay_start_time;
	}

	public void setFirstpay_start_time(String firstpay_start_time) {
		this.firstpay_start_time = firstpay_start_time;
	}

	public String getFirstpay_end_time() {
		return firstpay_end_time;
	}

	public void setFirstpay_end_time(String firstpay_end_time) {
		this.firstpay_end_time = firstpay_end_time;
	}

	public String getSecondpay_start_time() {
		return secondpay_start_time;
	}

	public void setSecondpay_start_time(String secondpay_start_time) {
		this.secondpay_start_time = secondpay_start_time;
	}

	public String getSecondpay_end_time() {
		return secondpay_end_time;
	}

	public void setSecondpay_end_time(String secondpay_end_time) {
		this.secondpay_end_time = secondpay_end_time;
	}

	@Override
	public String toString() {
		return "BookInfoNetRespondBean [id=" + id + ", url=" + url + ", booktype=" + booktype + ", start_date=" + start_date + ", end_date=" + end_date + ", firstpay_start_time="
				+ firstpay_start_time + ", firstpay_end_time=" + firstpay_end_time + ", secondpay_start_time=" + secondpay_start_time + ", secondpay_end_time=" + secondpay_end_time + "]";
	}

}
