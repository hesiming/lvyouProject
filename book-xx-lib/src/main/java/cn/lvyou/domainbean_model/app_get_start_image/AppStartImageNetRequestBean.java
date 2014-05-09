package cn.lvyou.domainbean_model.app_get_start_image;

public final class AppStartImageNetRequestBean {
	private String size;

	public AppStartImageNetRequestBean(String size) {
		this.size = size;
	}

	public String getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "AppStartImageNetRequestBean [size=" + size + "]";
	}

}
