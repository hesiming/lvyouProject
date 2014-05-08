package cn.lvyou.domainbean_model.categorys.categorybeans;

import java.io.Serializable;

public class CategoryDate implements Serializable, ICategoryItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2703075583336306434L;
	private String tiems;
	private String description;

	public void setTiems(String tiems) {
		this.tiems = tiems;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getDominParameter() {
		return tiems;
	}

	@Override
	public String getDescription() {
		return description;
	}

}
