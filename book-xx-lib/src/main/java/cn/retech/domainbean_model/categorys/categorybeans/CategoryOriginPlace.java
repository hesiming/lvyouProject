package cn.retech.domainbean_model.categorys.categorybeans;

import java.io.Serializable;

public class CategoryOriginPlace implements Serializable, ICategoryItem {

	private static final long serialVersionUID = -8819075070088120464L;

	private String city;
	private String cityDes;

	public void setCity(String city) {
		this.city = city;
	}

	public void setCityDes(String cityDes) {
		this.cityDes = cityDes;
	}

	@Override
	public String getDominParameter() {
		return city;
	}

	@Override
	public String getDescription() {
		return cityDes;
	}

}
