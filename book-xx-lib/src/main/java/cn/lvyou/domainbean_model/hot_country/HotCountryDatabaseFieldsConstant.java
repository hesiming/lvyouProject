package cn.lvyou.domainbean_model.hot_country;

public final class HotCountryDatabaseFieldsConstant {
	private HotCountryDatabaseFieldsConstant() {

	}

	public static enum RequestBean {
	}

	public static enum RespondBean {
		//
		data,
		// 大陆ID?
		continent_id,
		// 大陆名称?
		continent_name,
		// 热门城市列表
		country,
		// int 国家id
		country_id,
		// string 国家名称
		country_name;
	}
}
