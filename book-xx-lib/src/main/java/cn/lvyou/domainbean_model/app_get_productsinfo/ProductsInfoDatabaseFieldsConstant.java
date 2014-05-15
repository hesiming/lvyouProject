package cn.lvyou.domainbean_model.app_get_productsinfo;

public class ProductsInfoDatabaseFieldsConstant {
	private ProductsInfoDatabaseFieldsConstant() {

	}

	public static enum RequestBean {
		// true int 折扣ID
		id, oauth_token;
	}

	public static enum RespondBean {
		//
		data,
		// int 折扣ID
		id,
		// string 折扣标题
		title,
		// string 折扣图片地址 尺寸275×185
		pic,
		// string 折扣价格 可能为数字，也可能为<em>999</em>元起
		price,
		// array 折扣产品类型，数组,如果折扣不存在类型，则此项没有
		products,
		// int 库存
		stock,
		// int 购买限制，为0则不限制
		buy_limit,
		// int 0为全款 1为预付款
		type,
		// float 类型的价格
		product_price;

	}
}
