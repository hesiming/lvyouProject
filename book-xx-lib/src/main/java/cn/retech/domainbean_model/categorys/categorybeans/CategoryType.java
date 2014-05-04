package cn.retech.domainbean_model.categorys.categorybeans;

import java.io.Serializable;

public class CategoryType implements Serializable, ICategoryItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2567199961097585395L;
	private int id;
	private String cateName;

	public void setId(int id) {
		this.id = id;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	@Override
	public String getDominParameter() {
		return id + "";
	}

	@Override
	public String getDescription() {
		return cateName;
	}

}
