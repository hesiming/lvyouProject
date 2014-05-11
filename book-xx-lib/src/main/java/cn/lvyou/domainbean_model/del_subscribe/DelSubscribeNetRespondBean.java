package cn.lvyou.domainbean_model.del_subscribe;

public final class DelSubscribeNetRespondBean {
	// int 是否成功1-成功0-未成功
	private boolean data;

	public DelSubscribeNetRespondBean(boolean data) {
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
