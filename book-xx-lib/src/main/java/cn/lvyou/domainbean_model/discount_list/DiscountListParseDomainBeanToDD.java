package cn.lvyou.domainbean_model.discount_list;

import java.util.HashMap;
import java.util.Map;

import android.text.TextUtils;
import cn.lvyou.my_network_engine.domainbean_helper.IParseDomainBeanToDataDictionary;

import com.google.common.collect.Maps;

/**
 * 获取折扣列表 将业务bean转成数据字典
 * 
 * @author hesiming
 * 
 */
public final class DiscountListParseDomainBeanToDD implements IParseDomainBeanToDataDictionary {

	@Override
	public Map<String, String> parseDomainBeanToDataDictionary(Object netRequestDomainBean) {

		if (null == netRequestDomainBean) {
			throw new IllegalArgumentException("netRequestDomainBean is null!");
		}

		boolean isRightObjectType = netRequestDomainBean instanceof DiscountListNetRequestBean;
		if (!isRightObjectType) {
			throw new IllegalArgumentException("传入的业务Bean的类型不符 !");
		}

		DiscountListNetRequestBean discountListNetRequestBean = (DiscountListNetRequestBean) netRequestDomainBean;
		HashMap<String, String> hashMap = Maps.newHashMap();
		// 大洲id 非必选
		if (!TextUtils.isEmpty(discountListNetRequestBean.getContinent_id())) {
			hashMap.put(DiscountListDatabaseFiledsConstant.RequstBean.continent_id.name(), discountListNetRequestBean.getContinent_id());
		}
		// 国家id 非必选
		if (!TextUtils.isEmpty(discountListNetRequestBean.getCountry_id())) {
			hashMap.put(DiscountListDatabaseFiledsConstant.RequstBean.country_id.name(), discountListNetRequestBean.getCountry_id());
		}
		// 出发城市 非必选
		if (!TextUtils.isEmpty(discountListNetRequestBean.getDeparture())) {
			hashMap.put(DiscountListDatabaseFiledsConstant.RequstBean.departure.name(), discountListNetRequestBean.getDeparture());
		}
		// 本页最大id 默认值0,指第一页 非必选
		if (!TextUtils.isEmpty(discountListNetRequestBean.getMax_id())) {
			hashMap.put(DiscountListDatabaseFiledsConstant.RequstBean.max_id.name(), discountListNetRequestBean.getMax_id());
		}
		// 页大小 默认值10 非必选
		if (!TextUtils.isEmpty(discountListNetRequestBean.getPage_size())) {
			hashMap.put(DiscountListDatabaseFiledsConstant.RequstBean.page_size.name(), discountListNetRequestBean.getPage_size());
		}
		// 分类id 默认值0 指全部分类 非必选
		if (!TextUtils.isEmpty(discountListNetRequestBean.getProduct_type())) {
			hashMap.put(DiscountListDatabaseFiledsConstant.RequstBean.product_type.name(), discountListNetRequestBean.getProduct_type());
		}
		// 时间 非必选
		if (!TextUtils.isEmpty(discountListNetRequestBean.getTimes())) {
			hashMap.put(DiscountListDatabaseFiledsConstant.RequstBean.times.name(), discountListNetRequestBean.getTimes());
		}

		return hashMap;
	}
}
