package cn.lvyou.domainbean_model.bind_uid;

public final class BindUidNetRespondBean {
	// int 是否成功1-成功0-未成功
	private boolean data;

	public BindUidNetRespondBean(boolean data) {
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
