package cn.lvyou.domainbean_model.favor_list;

public final class FavorListDatabaseFieldsConstant {
	private FavorListDatabaseFieldsConstant() {

	}

	public static enum RequestBean {
		// 采用OAuth授权方式为必填参数， OAuth授权后获得。
		oauth_token,
		// 本页最大id 默认值0,指第一页 非必选
		max_id,
		// 页大小 默认值10 非必选
		page_size;

	}

	public static enum RespondBean {
		//
		data,
		// int ID
		id,
		// string 折扣封图
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
		first_pub;
	}
}
