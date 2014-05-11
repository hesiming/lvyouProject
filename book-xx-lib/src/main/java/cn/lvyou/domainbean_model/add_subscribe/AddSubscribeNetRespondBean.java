package cn.lvyou.domainbean_model.add_subscribe;

public final class AddSubscribeNetRespondBean {
	// int 是否成功1-成功0-未成功
	private boolean data;

	public AddSubscribeNetRespondBean(boolean data) {
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
