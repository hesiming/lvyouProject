package cn.lvyou.domainbean_model.get_list_byid;

/**
 * 通过id字符串获取折扣列表 这里的id是需要做到这里的时候进行重新设计的,因为这里传入的id不是一个而是十个,并且这十个是哪里来的? "3661,3564,3763,3786,3794,3707,3771,3803,3683,3188"
 * 
 * @author hesiming
 * 
 */
public final class GetListByidNetRequestBean {
	// true int 折扣id字符串 例如4,3,44,33
	private String id;

	public GetListByidNetRequestBean(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "GetListByidNetRequestBean [id=" + id + "]";
	}

}
