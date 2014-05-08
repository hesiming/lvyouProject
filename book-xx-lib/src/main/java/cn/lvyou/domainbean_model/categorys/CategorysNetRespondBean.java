package cn.lvyou.domainbean_model.categorys;

import java.util.ArrayList;

import cn.lvyou.domainbean_model.categorys.categorybeans.ICategoryItem;

public class CategorysNetRespondBean {
	private ArrayList<ICategoryItem> types;
	private ArrayList<ICategoryItem> dates;
	private ArrayList<ICategoryItem> places;
	private ArrayList<ICategoryItem> originPlace;

	public ArrayList<ICategoryItem> getDates() {
		return dates;
	}

	public ArrayList<ICategoryItem> getOriginPlace() {
		return originPlace;
	}

	public ArrayList<ICategoryItem> getPlaces() {
		return places;
	}

	public ArrayList<ICategoryItem> getTypes() {
		return types;
	}

	public void setDates(ArrayList<ICategoryItem> dates) {
		this.dates = dates;
	}

	public void setOriginPlace(ArrayList<ICategoryItem> originPlace) {
		this.originPlace = originPlace;
	}

	public void setPlaces(ArrayList<ICategoryItem> places) {
		this.places = places;
	}

	public void setTypes(ArrayList<ICategoryItem> types) {
		this.types = types;
	}

}
