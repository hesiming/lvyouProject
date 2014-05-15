package cn.lvyou.domainbean_model.app_get_orderforminfo.order_info_item;

public final class SupplierBean {
	private String id;
	private String catename;
	private String catename_en;
	private String catename_py;
	private String image;
	private String sub_image;
	private String alipay_account;
	private String phone;
	private String siteurl;
	private String email;
	private String type;
	private String status;

	public SupplierBean() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCatename() {
		return catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	public String getCatename_en() {
		return catename_en;
	}

	public void setCatename_en(String catename_en) {
		this.catename_en = catename_en;
	}

	public String getCatename_py() {
		return catename_py;
	}

	public void setCatename_py(String catename_py) {
		this.catename_py = catename_py;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSub_image() {
		return sub_image;
	}

	public void setSub_image(String sub_image) {
		this.sub_image = sub_image;
	}

	public String getAlipay_account() {
		return alipay_account;
	}

	public void setAlipay_account(String alipay_account) {
		this.alipay_account = alipay_account;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSiteurl() {
		return siteurl;
	}

	public void setSiteurl(String siteurl) {
		this.siteurl = siteurl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SupplierBean [id=" + id + ", catename=" + catename + ", catename_en=" + catename_en + ", catename_py=" + catename_py + ", image=" + image + ", sub_image=" + sub_image
				+ ", alipay_account=" + alipay_account + ", phone=" + phone + ", siteurl=" + siteurl + ", email=" + email + ", type=" + type + ", status=" + status + "]";
	}

}
