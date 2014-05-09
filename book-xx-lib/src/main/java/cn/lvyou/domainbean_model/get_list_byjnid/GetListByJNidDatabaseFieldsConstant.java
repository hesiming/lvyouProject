package cn.lvyou.domainbean_model.get_list_byjnid;

public final class GetListByJNidDatabaseFieldsConstant {
	private GetListByJNidDatabaseFieldsConstant() {

	}

	public static enum RequestBean {
		// int 锦囊id 默认值0 非必选参数
		jn_id;
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
		// string 折扣价格
		price,
		// string 折扣到期时间
		end_date,
		// string web方面链接
		web_url,
		// string m方面链接
		m_url,
		// int 分类
		product_type;
	}
}
