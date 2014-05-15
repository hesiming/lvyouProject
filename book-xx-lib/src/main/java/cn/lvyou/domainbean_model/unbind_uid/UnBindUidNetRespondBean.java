package cn.lvyou.domainbean_model.unbind_uid;

public final class UnBindUidNetRespondBean {
	// int 是否成功1-成功0-未成功
	private boolean data;

	public UnBindUidNetRespondBean(boolean data) {
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
