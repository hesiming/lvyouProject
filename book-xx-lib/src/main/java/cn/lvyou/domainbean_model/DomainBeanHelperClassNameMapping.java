package cn.lvyou.domainbean_model;

import cn.lvyou.domainbean_model.app_get_start_image.AppStartImageDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.app_get_start_image.AppStartImageNetRequestBean;
import cn.lvyou.domainbean_model.categorys.CategorysDomainBeanToolsFactory;
import cn.lvyou.domainbean_model.categorys.CategorysNetRequestBean;
import cn.lvyou.domainbean_model.discount_list.DiscountListDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.discount_list.DiscountListNetRequestBean;
import cn.lvyou.domainbean_model.favor_list.FavorListDomainBeanToolsFactory;
import cn.lvyou.domainbean_model.favor_list.FavorListNetRequestBean;
import cn.lvyou.domainbean_model.get_detail.GetDetailDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.get_detail.GetDetailNetRequestBean;
import cn.lvyou.domainbean_model.get_list_byid.GetListByidDomainBeanToolsFactory;
import cn.lvyou.domainbean_model.get_list_byid.GetListByidNetRequestBean;
import cn.lvyou.domainbean_model.get_list_byjnid.GetListByJNidDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.get_list_byjnid.GetListByJNidNetRequestBean;
import cn.lvyou.domainbean_model.login.LoginDomainBeanToolsFactory;
import cn.lvyou.domainbean_model.login.LoginNetRequestBean;
import cn.lvyou.domainbean_model.optionTop.OptionTopDomainBeanToolsFactory;
import cn.lvyou.domainbean_model.optionTop.OptionTopNetRequestBean;
import cn.lvyou.domainbean_model.register.RegisterDomainBeanToolsFactory;
import cn.lvyou.domainbean_model.register.RegisterNetRequestBean;
import cn.lvyou.my_network_engine.domainbean_strategy_mapping.StrategyClassNameMappingBase;

/**
 * 所有业务接口, 要在这里完成NetRequestBean和DomainBeanToolsFactory的映射
 * 
 * @author skyduck
 * 
 */
public final class DomainBeanHelperClassNameMapping extends StrategyClassNameMappingBase {

	// 注意：
	// Key : 网络请求业务Bean
	// Value : 是该网络接口对应的抽象工厂类
	public DomainBeanHelperClassNameMapping() {
		/**
		 * 用户登录
		 */
		strategyClassesNameMappingList.put(LoginNetRequestBean.class.getName(), LoginDomainBeanToolsFactory.class.getName());
		/**
		 * 用户注册
		 */
		strategyClassesNameMappingList.put(RegisterNetRequestBean.class.getName(), RegisterDomainBeanToolsFactory.class.getName());
		/**
		 * 筛选分类
		 */
		strategyClassesNameMappingList.put(CategorysNetRequestBean.class.getName(), CategorysDomainBeanToolsFactory.class.getName());
		/**
		 * 顶部索引图片
		 */
		strategyClassesNameMappingList.put(OptionTopNetRequestBean.class.getName(), OptionTopDomainBeanToolsFactory.class.getName());
		/**
		 * 折扣列表
		 */
		strategyClassesNameMappingList.put(DiscountListNetRequestBean.class.getName(), DiscountListDonainBeanToolsFactory.class.getName());
		/**
		 * 获取APP启动页面图片
		 */
		strategyClassesNameMappingList.put(AppStartImageNetRequestBean.class.getName(), AppStartImageDonainBeanToolsFactory.class.getName());
		/**
		 * 获取折扣详情
		 */
		strategyClassesNameMappingList.put(GetDetailNetRequestBean.class.getName(), GetDetailDonainBeanToolsFactory.class.getName());
		/**
		 * 通过传锦囊id获取折扣列表
		 */
		strategyClassesNameMappingList.put(GetListByJNidNetRequestBean.class.getName(), GetListByJNidDonainBeanToolsFactory.class.getName());
		/**
		 * 通过id字符串获取折扣列表
		 */
		strategyClassesNameMappingList.put(GetListByidNetRequestBean.class.getName(), GetListByidDomainBeanToolsFactory.class.getName());
		/**
		 * lastminute收藏列表
		 */
		strategyClassesNameMappingList.put(FavorListNetRequestBean.class.getName(), FavorListDomainBeanToolsFactory.class.getName());
	}
}
