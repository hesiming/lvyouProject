package cn.lvyou.domainbean_model.app_get_start_image;

public final class AppStartImageDatabaseFieldsConstant {
	private AppStartImageDatabaseFieldsConstant() {

	}

	public static enum RequestBean {
		// 图片分辨率
		size(""),
		// 包括三种尺寸（640×960/640×1136/1080×1920）
		sizeSmall("640×960"), sizeMiddle("640×1136"), sizeBig("1080×1920");

		String value;

		RequestBean(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public static enum RespondBean {
		data,
		// ID
		id,
		// 图片地址
		url;
	}
}
