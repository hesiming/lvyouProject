package cn.lvyou.domainbean_model.get_detail;

public class GetDetailDatabaseFieldsConstant {
	private GetDetailDatabaseFieldsConstant() {

	}

	public static enum RequestBean {
		// 必选 折扣ID
		id,
		// 非必选 采用OAuth授权方式为必填参数， OAuth授权后获得。 默认值空
		oauth_token;
	}

	public static enum RespondBean {
		//
		data,
		// int ID
		id,
		// string 折扣H5页地址
		app_url,
		// int 是否预定类折扣 1、预定类产品 0、非预定类产品
		app_booktype,
		// string 折扣开始时间 字符串
		app_start_date,
		// string 折扣结束时间 字符串
		app_end_date,
		// int 折扣开始时间 时间戳
		app_start_date_new,
		// int 折扣结束时间 时间戳
		app_end_date_new,
		// string 第一次定单开始时间 格式UNIX时间戳
		app_firstpay_start_time,
		// string 第一次定单结束时间 格式UNIX时间戳
		app_firstpay_end_time,
		// string 第二次定单开始时间 格式UNIX时间戳
		app_secondpay_start_time,
		// string 第二次定单结束时间 格式UNIX时间戳
		app_secondpay_end_time,
		// int 库存数量
		app_stock,
		// int 是否在售 1:在售 0:下架
		onsale,
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
		// string 折扣代码
		discount_code,
		// int 是否穷游儿独享1-是0-否
		self_use,
		// int 是否穷游首发1-是0-否
		first_pub,
		// int 是否登录可见1-是0-否
		login_visible,
		// array 折扣详情图片原图
		detail_image,
		// array 折扣详情图片180×180
		detail_image180,
		// int 预订类型-0:链接, 1:电话
		order_type,
		// array 折扣预订方式
		order_info,
		// array 折扣预订方式说明
		order_info_txt,
		// sting 折扣详情
		deal_info,
		// sting 使用说明
		use_if,
		// sting 相应web详细页地址
		qyer_url,
		// array 相关折扣
		related,
		// int 是否收藏1-是0-否
		favored;
	}

	public static enum GetDetailRelatedRespondBean {
		// int ID
		id,
		// string 折扣title
		title,
		// string 折扣价格
		price,
		// 折扣封图
		pic, addtime;
	}
}
