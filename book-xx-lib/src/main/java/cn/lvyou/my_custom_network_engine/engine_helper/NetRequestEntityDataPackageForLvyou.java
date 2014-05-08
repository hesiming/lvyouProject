package cn.lvyou.my_custom_network_engine.engine_helper;

import java.util.Map;

import cn.lvyou.my_network_engine.engine_helper.interfaces.INetRequestEntityDataPackage;

import com.loopj.android.http.RequestParams;

/**
 * 
 * @author skyduck
 * 
 */
public class NetRequestEntityDataPackageForLvyou implements INetRequestEntityDataPackage {

	@Override
	public RequestParams packageNetRequestEntityData(final Map<String, String> domainDD) {

		do {
			if (domainDD == null || domainDD.size() <= 0) {
				break;
			}

			RequestParams requestParams = new RequestParams(domainDD);
			return requestParams;
		} while (false);

		return null;
	}
}
