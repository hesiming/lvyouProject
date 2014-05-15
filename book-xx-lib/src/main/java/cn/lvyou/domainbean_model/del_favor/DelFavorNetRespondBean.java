package cn.lvyou.domainbean_model.del_favor;

public final class DelFavorNetRespondBean {
	// int 是否成功1-成功0-未成功
	private boolean data;

	public DelFavorNetRespondBean(boolean data) {
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
