package cn.lvyou.domainbean_model.app_query;

import java.util.HashMap;
import java.util.Map;

import android.text.TextUtils;
import cn.lvyou.my_network_engine.domainbean_tools.IParseDomainBeanToDataDictionary;

public class AppQueryParseDomainBeanToDD implements IParseDomainBeanToDataDictionary {

	@Override
	public Map<String, String> parseDomainBeanToDataDictionary(Object netRequestDomainBean) {
		if (null == netRequestDomainBean) {
			throw new IllegalArgumentException("netRequestDomainBean is null!");
		}

		boolean isRightObjectType = netRequestDomainBean instanceof AppQueryNetRequestBean;
		if (!isRightObjectType) {
			throw new IllegalArgumentException("传入的业务Bean的类型不符 !");
		}

		AppQueryNetRequestBean requestBean = (AppQueryNetRequestBean) netRequestDomainBean;
		String out_trade_no = requestBean.getOut_trade_no();
		if (TextUtils.isEmpty(out_trade_no)) {
			throw new IllegalArgumentException("必须的数据字段不完整 ! ");
		}

		Map<String, String> params = new HashMap<String, String>();
		// 必须参数
		params.put(AppQueryDatabaseFieldsConstant.RequestBean.out_trade_no.name(), out_trade_no);
		return params;
	}
}
