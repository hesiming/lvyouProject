package cn.lvyou.domainbean_model.app_get_bookinfo;

/**
 * APP获取折扣预定基础信息
 * 
 * @author hesiming
 * 
 */
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
