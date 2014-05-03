package cn.retech.domainbean_model.categorys.categorybeans;

import java.io.Serializable;

public class CategoryDate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2703075583336306434L;
	private String tiems;
	private String description;
	public String getTiems() {
		return tiems;
	}
	public void setTiems(String tiems) {
		this.tiems = tiems;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
