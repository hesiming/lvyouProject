package cn.retech.domainbean_model.categorys.categorybeans;

import java.io.Serializable;

public class CategoryOriginPlace implements Serializable{


	private static final long serialVersionUID = -8819075070088120464L;

	private String city;
	private String cityDes;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCityDes() {
		return cityDes;
	}
	public void setCityDes(String cityDes) {
		this.cityDes = cityDes;
	}
	
	
}
