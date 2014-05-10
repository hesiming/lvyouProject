package cn.lvyou.domainbean_model.hot_country;

public final class HotCountryItem {
	// int 国家id
	private int country_id;
	// string 国家名称
	private String country_name;
	public HotCountryItem(int country_id, String country_name) {
		this.country_id = country_id;
		this.country_name = country_name;
	}
	public int getCountry_id() {
		return country_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	@Override
	public String toString() {
		return "HotCountryItem [country_id=" + country_id + ", country_name=" + country_name + "]";
	}

}
