package cn.lvyou.domainbean_model.app_post_orderform;

public final class PostOrderformDatabaseFieldsConstant {
	private PostOrderformDatabaseFieldsConstant() {

	}

	public static enum RequestBean {
		// true string 采用OAuth授权方式为必填参数， OAuth授权后获得。
		oauth_token,
		// true int 折扣类型ID 必填参数
		pid,
		// true int 数量 必填参数
		num,
		// true string 姓名 必填参数
		name,
		// true string 电话 必填参数
		phone,
		// true string 邮箱 必填参数
		email,
		// true float 金额，总价 必填参数
		price;
	}

	public static enum RespondBean {
		//
		data,
		// int 订单ID
		id,
		// int 折扣类型ID
		pid,
		// int 数量
		num,
		// string 姓名
		name,
		// string 手机
		phone,
		// string email
		email,
		// int UID
		uid,
		// float 单价
		unit_price,
		// float 总价
		price,
		// int 1 已支付 0未支付 -1超时
		payment,
		// string 时间戳
		datetime,
		// int 1首次付款 2二次付款
		firstpay, relid, buyer_email, buyer_id, notify_id, notify_time, notify_type, payment_type, seller_email, seller_id, sign, sign_type, total_fee, trade_no, trade_status, return_type, return_time;

	}
}
