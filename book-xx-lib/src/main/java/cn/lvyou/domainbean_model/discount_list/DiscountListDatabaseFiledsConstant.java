package cn.lvyou.domainbean_model.discount_list;

public final class DiscountListDatabaseFiledsConstant {

	public DiscountListDatabaseFiledsConstant() {
	}

	public static enum RequstBean {
		// 分类id 默认值0 指全部分类
		product_type,
		// 本页最大id 默认值0,指第一页
		max_id,
		// 页大小 默认值10
		page_size,
		// 时间
		times,
		// 大洲id
		continent_id,
		// 国家id
		country_id,
		// 出发城市
		departure;
	}

	public static enum RespondBean {

		info, times, data,

		// ID
		id,
		// 折扣封图
		pic,
		// 折扣title
		title,
		// 折扣简介
		detail,
		// 折扣价格
		price,
		// 折扣到期时间
		end_date,
		// 是否穷游儿独享1-是0-否
		self_use,
		// 是否穷游首发1-是0-否
		first_pub,
		// 原价
		list_price,
		// appview折扣详细页面url
		url;
	}
}
