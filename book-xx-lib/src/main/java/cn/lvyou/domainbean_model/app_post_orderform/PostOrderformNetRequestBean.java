package cn.lvyou.domainbean_model.app_post_orderform;

public final class PostOrderformNetRequestBean {
	// true string 采用OAuth授权方式为必填参数， OAuth授权后获得。
	private String oauth_token;
	// true int 折扣类型ID 必填参数
	private String pid;
	// true int 数量 必填参数
	private String num;
	// true string 姓名 必填参数
	private String name;
	// true string 电话 必填参数
	private String phone;
	// true string 邮箱 必填参数
	private String email;
	// true float 金额，总价 必填参数
	private String price;

	public PostOrderformNetRequestBean(String oauth_token, String pid, String num, String name, String phone, String email, String price) {
		this.oauth_token = oauth_token;
		this.pid = pid;
		this.num = num;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.price = price;
	}

	public String getOauth_token() {
		return oauth_token;
	}

	public String getPid() {
		return pid;
	}

	public String getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "PostOrderformNetRequestBean [oauth_token=" + oauth_token + ", pid=" + pid + ", num=" + num + ", name=" + name + ", phone=" + phone + ", email=" + email + ", price=" + price + "]";
	}

}
