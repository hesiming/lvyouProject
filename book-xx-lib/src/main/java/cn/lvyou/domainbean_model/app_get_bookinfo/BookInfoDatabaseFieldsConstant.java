package cn.lvyou.domainbean_model.app_get_bookinfo;

public class BookInfoDatabaseFieldsConstant {
	private BookInfoDatabaseFieldsConstant() {

	}

	public static enum RequestBean {
		// true int 折扣ID
		id;
	}

	public static enum RespondBean {
		//
		data,
		// int 折扣ID
		id,
		// string 折扣H5页地址
		url,
		// int 是否预定类折扣 1、预定类产品 0、非预定类产品
		booktype,
		// string 折扣开始时间 格式9999-12-31 23:59:59
		start_date,
		// string 折扣结束时间 格式9999-12-31 23:59:59
		end_date,
		// string 第一次定单开始时间 格式UNIX时间戳
		firstpay_start_time,
		// string 第一次定单结束时间 格式UNIX时间戳
		firstpay_end_time,
		// string 第二次定单开始时间 格式UNIX时间戳
		secondpay_start_time,
		// string 第二次定单结束时间 格式UNIX时间戳
		secondpay_end_time;

	}
}
