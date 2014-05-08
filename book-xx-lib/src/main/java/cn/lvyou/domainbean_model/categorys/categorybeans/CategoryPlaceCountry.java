package cn.lvyou.domainbean_model.categorys.categorybeans;

import java.io.Serializable;

public class CategoryPlaceCountry implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 596322817799402105L;
	private String countryId;
	private String countryName;
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
}
