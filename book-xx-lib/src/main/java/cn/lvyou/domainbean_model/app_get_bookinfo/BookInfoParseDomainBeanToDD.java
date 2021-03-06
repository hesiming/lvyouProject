package cn.lvyou.domainbean_model.app_get_bookinfo;

import java.util.HashMap;
import java.util.Map;

import android.text.TextUtils;
import cn.lvyou.my_network_engine.domainbean_helper.IParseDomainBeanToDataDictionary;

public class BookInfoParseDomainBeanToDD implements IParseDomainBeanToDataDictionary {

	@Override
	public Map<String, String> parseDomainBeanToDataDictionary(Object netRequestDomainBean) {

		if (null == netRequestDomainBean) {
			throw new IllegalArgumentException("netRequestDomainBean is null!");
		}

		boolean isRightObjectType = netRequestDomainBean instanceof BookInfoNetRequestBean;
		if (!isRightObjectType) {
			throw new IllegalArgumentException("传入的业务Bean的类型不符 !");
		}

		BookInfoNetRequestBean requestBean = (BookInfoNetRequestBean) netRequestDomainBean;
		String id = requestBean.getId();
		if (TextUtils.isEmpty(id)) {
			throw new IllegalArgumentException("必须的数据字段不完整 ! ");
		}
		Map<String, String> params = new HashMap<String, String>();
		// 必须参数
		params.put(BookInfoDatabaseFieldsConstant.RequestBean.id.name(), id);
		return params;
	}
}
