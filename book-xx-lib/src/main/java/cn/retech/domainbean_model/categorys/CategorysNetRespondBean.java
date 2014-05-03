package cn.retech.domainbean_model.categorys;

import java.util.ArrayList;

import cn.retech.domainbean_model.categorys.categorybeans.CategoryDate;
import cn.retech.domainbean_model.categorys.categorybeans.CategoryOriginPlace;
import cn.retech.domainbean_model.categorys.categorybeans.CategoryPlace;
import cn.retech.domainbean_model.categorys.categorybeans.CategoryType;

public class CategorysNetRespondBean {
  private ArrayList<CategoryType> types;
  private ArrayList<CategoryDate> dates;
  private ArrayList<CategoryPlace> places;
  private ArrayList<CategoryOriginPlace> originPlace;

  public ArrayList<CategoryDate> getDates() {
    return dates;
  }

  public ArrayList<CategoryOriginPlace> getOriginPlace() {
    return originPlace;
  }

  public ArrayList<CategoryPlace> getPlaces() {
    return places;
  }

  public ArrayList<CategoryType> getTypes() {
    return types;
  }

  public void setDates(ArrayList<CategoryDate> dates) {
    this.dates = dates;
  }

  public void setOriginPlace(ArrayList<CategoryOriginPlace> originPlace) {
    this.originPlace = originPlace;
  }

  public void setPlaces(ArrayList<CategoryPlace> places) {
    this.places = places;
  }

  public void setTypes(ArrayList<CategoryType> types) {
    this.types = types;
  }

}
