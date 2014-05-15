package cn.lvyou.domainbean_model.subscribe_push;

public final class SubscribePushDatabaseFieldsConstant {
	private SubscribePushDatabaseFieldsConstant() {

	}

	public static enum RequestBean {
		// 采用OAuth授权方式为必填参数， OAuth授权后获得。
		oauth_token,

	}

	public static enum RespondBean {
		//
		data,

		// int ID
		id,
		// string 折扣封图
		pic,
		// string 折扣title
		title,
		// string 折扣简介
		detail,
		// string 折扣价格
		price,
		// string 折扣到期时间
		end_date,
		// int 是否穷游儿独享1-是0-否
		self_use,
		// int 是否穷游首发1-是0-否
		first_pub;
	}
}
