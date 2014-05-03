package cn.retech.domainbean_model.categorys.categorybeans;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoryPlace implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5275741803497823430L;
	private int continentId;
	private String continentName;
	private ArrayList<CategoryPlaceCountry> countrise;
	public int getContinentId() {
		return continentId;
	}
	public void setContinentId(int continentId) {
		this.continentId = continentId;
	}
	public String getContinentName() {
		return continentName;
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
	
	
}
