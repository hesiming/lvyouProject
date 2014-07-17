package cn.lvyou.my_custom_network_engine.engine_helper;

import java.util.Map;

import cn.lvyou.my_network_engine.engine_helper.interfaces.INetRequestParamsPackage;

import com.loopj.android.http.RequestParams;

/**
 * 
 * @author skyduck
 * 
 */
public class NetRequestParamsPackageForLvyou implements INetRequestParamsPackage {

  @Override
  public Object packageNetRequestParams(final String httpRequestMethod, final Map<String, String> domainDataDictionary) {

    do {
      if (domainDataDictionary == null || domainDataDictionary.size() <= 0) {
        break;
      }

      RequestParams requestParams = new RequestParams(domainDataDictionary);
      return requestParams;
    } while (false);

    return new RequestParams();
  }
}
