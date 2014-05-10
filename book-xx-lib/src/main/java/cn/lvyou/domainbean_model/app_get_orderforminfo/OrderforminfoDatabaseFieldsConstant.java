package cn.lvyou.domainbean_model.app_get_orderforminfo;

public class OrderforminfoDatabaseFieldsConstant {
	private OrderforminfoDatabaseFieldsConstant() {

	}

	public static enum RequestBean {
		// true int 折扣ID
		id;
	}

	public static enum RespondBean {
		//
		data,
		// int 订单号
		id,
		// string 截止时间，为0时则表示不限制
		lastalipaydatetime,
		// string 折扣标题
		lastminute_title,
		// string 折扣价格 可能为数字，也可能为<em>999</em>元起
		lastminute_price,
		// int 产品类型 0为全款 1为预付款 2为尾款
		products_type,
		// string 产品标题
		products_title,
		// float 购买单价
		unit_price,
		// int 购买数量
		num,
		// float 购买总价
		price,
		// string 商家支付宝号
		alipay_account,
		// string 商家名称
		supplier_title,
		// int 商家类型 1，非认证商家 0，认证商家
		supplier_type,
		// string 商家电话
		supplier_phone,
		// int 订单状态 1 已支付 0未支付 -1超时
		payment,
		// array 对应折扣信息，数组
		lastminute,
		// array 对应商家信息，数组
		supplier,
		// array 对应产品信息，数组
		products,
		// array 订单信息，数组
		orderform,
		// int 订单支付类型 0 未支付 1 web端支付 2 app端支付
		pay_type;

	}

	public static enum LastminuteRespondBean {
		id, title, supplier, price, product_type, feature, info_give, start_pos, country, city, start_date, end_date, pic, pic_info, detail, use_if, qyer_url, url, recommend, admin, addtime, detail_image, end_pos, views, booking_time, travel_time, login_visible, discount_code, order_type, continent, ctn, channel, op_pic, status, op_pic1, edittime, departure, abroad, list_price, buy_price, relatid, currency_code, booktype, timeout, firstpay_start_time, firstpay_end_time, secondpay_start_time, secondpay_end_time;

	}

	public static enum OrderformRespondBean {
		id, pid, num, name, phone, email, uid, unit_price, price, payment, datetime, firstpay, relid, buyer_email, buyer_id, notify_id, notify_time, notify_type, payment_type, seller_email, seller_id, sign, sign_type, total_fee, trade_no, trade_status, return_type, return_time;

	}

	public static enum ProductsRespondBean {
		id, lid, title, total, stock, price, advance_payment, buy_limit, type;
	}

	public static enum SupplierRespondBean {
		id, catename, catename_en, catename_py, image, sub_image, alipay_account, phone, siteurl, email, type, status;

	}
}
