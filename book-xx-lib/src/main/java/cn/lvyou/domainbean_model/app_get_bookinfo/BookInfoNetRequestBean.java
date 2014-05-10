package cn.lvyou.domainbean_model.app_get_bookinfo;

public final class BookInfoNetRequestBean {
	// true int 折扣ID 必选参数
	private String id;

	public BookInfoNetRequestBean(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "BookInfoNetRequestBean [id=" + id + "]";
	}

}
