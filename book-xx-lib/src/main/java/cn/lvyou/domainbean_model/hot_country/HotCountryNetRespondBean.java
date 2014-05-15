package cn.lvyou.domainbean_model.hot_country;

import java.util.List;

public final class HotCountryNetRespondBean {
	private List<HotCountryItem> countryList;
	// 大陆ID?
	private int continent_id;

	// 大陆名称?
	private String continent_name;

	public int getContinent_id() {
		return continent_id;
	}

	public void setContinent_id(int continent_id) {
		this.continent_id = continent_id;
	}

	public String getContinent_name() {
		return continent_name;
	}

	public void setContinent_name(String continent_name) {
		this.continent_name = continent_name;
	}

	public HotCountryNetRespondBean(List<HotCountryItem> countryList) {
		this.countryList = countryList;
	}

	public List<HotCountryItem> getCountryList() {
		return countryList;
	}

	@Override
	public String toString() {
		return "HotCountryNetRRespondBean [countryList=" + countryList + ", continent_id=" + continent_id + ", continent_name=" + continent_name + "]";
	}

}
