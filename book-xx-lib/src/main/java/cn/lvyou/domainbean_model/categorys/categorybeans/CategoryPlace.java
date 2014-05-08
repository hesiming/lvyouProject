package cn.lvyou.domainbean_model.categorys.categorybeans;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoryPlace implements Serializable, ICategoryItem {
	private static final long serialVersionUID = -5275741803497823430L;
	private int continentId;
	private String continentName;
	private ArrayList<CategoryPlaceCountry> countrise;

	public void setContinentId(int continentId) {
		this.continentId = continentId;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public ArrayList<CategoryPlaceCountry> getCountrise() {
		return countrise;
	}

	public void setCountrise(ArrayList<CategoryPlaceCountry> countrise) {
		this.countrise = countrise;
	}

	@Override
	public String getDominParameter() {
		return continentId + "";
	}

	@Override
	public String getDescription() {
		return continentName;
	}

}
