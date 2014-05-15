package cn.lvyou.domainbean_model.subscribe_list;

public final class SubscribeListDatabaseFieldsConstant {
	private SubscribeListDatabaseFieldsConstant() {

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
		// id
		id,
		// 折扣类型
		product_type,
		// 旅行时间
		date_str,
		// 目的地
		country,
		// 出发地
		start_pos;
	}
}
