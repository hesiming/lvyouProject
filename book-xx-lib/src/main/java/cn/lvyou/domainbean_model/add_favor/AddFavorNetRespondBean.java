package cn.lvyou.domainbean_model.add_favor;

public class AddFavorNetRespondBean {
	// int 是否成功1-成功0-未成功
	private boolean data;

	public AddFavorNetRespondBean(boolean data) {
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
