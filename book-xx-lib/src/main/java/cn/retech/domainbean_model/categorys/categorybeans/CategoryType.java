package cn.retech.domainbean_model.categorys.categorybeans;

import java.io.Serializable;

public class CategoryType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2567199961097585395L;
	private int id;
	private String cateName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	
}
