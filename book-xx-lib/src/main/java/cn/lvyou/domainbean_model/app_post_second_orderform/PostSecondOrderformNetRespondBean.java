package cn.lvyou.domainbean_model.app_post_second_orderform;

public final class PostSecondOrderformNetRespondBean {
	// int 是否成功1-成功0-未成功
	private boolean data;

	public PostSecondOrderformNetRespondBean(boolean data) {
		this.data = data;
	}

	public boolean isData() {
		return data;
	}

	@Override
	public String toString() {
		return "AddFavorNetRespondBean [data=" + data + "]";
	}

}
