package cn.lvyou.domainbean_model.app_get_start_image;

public final class AppStartImageNetResondBean {
	// ID
	private int id;
	// 图片地址
	private String url;

	public AppStartImageNetResondBean() {
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

	@Override
	public String toString() {
		return "AppStartImageNetResondBean [id=" + id + ", url=" + url + "]";
	}

}
