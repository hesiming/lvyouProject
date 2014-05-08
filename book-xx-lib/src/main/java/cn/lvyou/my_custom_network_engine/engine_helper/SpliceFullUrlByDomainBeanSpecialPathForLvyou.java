package cn.lvyou.my_custom_network_engine.engine_helper;

import cn.lvyou.global_data_cache.UrlConstantForThisProject;
import cn.lvyou.my_network_engine.engine_helper.interfaces.ISpliceFullUrlByDomainBeanSpecialPath;

public class SpliceFullUrlByDomainBeanSpecialPathForLvyou implements ISpliceFullUrlByDomainBeanSpecialPath {

  public SpliceFullUrlByDomainBeanSpecialPathForLvyou() {
  }

  @Override
  public String getFullUrlByDomainBeanSpecialPath(final String specialPath) {
    final String fullUrlString = UrlConstantForThisProject.kUrlConstant_MainUrl + "/" + specialPath;
    return fullUrlString;
  }

}
