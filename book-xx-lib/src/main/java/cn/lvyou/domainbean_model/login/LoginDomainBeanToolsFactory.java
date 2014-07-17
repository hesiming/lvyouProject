package cn.lvyou.domainbean_model.login;

import cn.lvyou.global_data_cache.UrlConstantForThisProject;
import cn.lvyou.my_network_engine.domainbean_helper.IDomainBeanHelper;
import cn.lvyou.my_network_engine.domainbean_helper.IParseDomainBeanToDataDictionary;
import cn.lvyou.my_network_engine.domainbean_helper.IParseNetRespondDataToDomainBean;

/**
 * 用户登录
 * 
 */
public final class LoginDomainBeanToolsFactory implements IDomainBeanHelper {
	@Override
	public IParseDomainBeanToDataDictionary getParseDomainBeanToDDStrategyObject() {
		return new LoginParseDomainBeanToDD();
	}

	@Override
	public IParseNetRespondDataToDomainBean getParseNetRespondDataToDomainBeanStrategyObject() {
		return new LoginParseNetRespondStringToDomainBean();
	}

	@Override
	public String getSpecialPath(final Object netRequestDomainBean) {
		return UrlConstantForThisProject.kUrlConstant_SpecialPath_LOGIN;
	}
}
