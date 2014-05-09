package cn.lvyou.domainbean_model.get_list_byid;


public final class GetListByidDatabaseFieldsConstant {
	private GetListByidDatabaseFieldsConstant() {

	}

	public static enum RequestBean {
		// 折扣id字符串 例如4,3,44,33
		id;

	}

	public static enum RespondBean {
		//
		data,
		// int ID
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
		list_price;
	}
}
