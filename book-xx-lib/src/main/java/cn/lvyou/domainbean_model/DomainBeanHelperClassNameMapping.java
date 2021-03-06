package cn.lvyou.domainbean_model;

import cn.lvyou.domainbean_model.add_favor.AddFavorDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.add_favor.AddFavorNetRequestBean;
import cn.lvyou.domainbean_model.add_subscribe.AddSubscribeDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.add_subscribe.AddSubscribeNetRequestBean;
import cn.lvyou.domainbean_model.app_get_bookinfo.BookInfoDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.app_get_bookinfo.BookInfoNetRequestBean;
import cn.lvyou.domainbean_model.app_get_orderforminfo.OrderforminfoDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.app_get_orderforminfo.OrderforminfoNetRequestBean;
import cn.lvyou.domainbean_model.app_get_productsinfo.ProductsInfoDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.app_get_productsinfo.ProductsInfoNetRequestBean;
import cn.lvyou.domainbean_model.app_get_start_image.AppStartImageDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.app_get_start_image.AppStartImageNetRequestBean;
import cn.lvyou.domainbean_model.app_get_userorderformlist.UserOrderDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.app_get_userorderformlist.UserOrderNetRequestBean;
import cn.lvyou.domainbean_model.app_post_del_orderform.DelOrderformDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.app_post_del_orderform.DelOrderformNetRequestBean;
import cn.lvyou.domainbean_model.app_post_orderform.PostOrderformDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.app_post_orderform.PostOrderformNetRequestBean;
import cn.lvyou.domainbean_model.app_post_second_orderform.PostSecondOrderformDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.app_post_second_orderform.PostSecondOrderformNetRequestBean;
import cn.lvyou.domainbean_model.app_query.AppQueryDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.app_query.AppQueryNetRequestBean;
import cn.lvyou.domainbean_model.bind_uid.BindUidDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.bind_uid.BindUidNetRequestBean;
import cn.lvyou.domainbean_model.categorys.CategorysDomainBeanToolsFactory;
import cn.lvyou.domainbean_model.categorys.CategorysNetRequestBean;
import cn.lvyou.domainbean_model.del_favor.DelFavorDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.del_favor.DelFavorNetRequestBean;
import cn.lvyou.domainbean_model.del_subscribe.DelSubscribeDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.del_subscribe.DelSubscribeNetRequestBean;
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
import cn.lvyou.domainbean_model.hot_country.HotCountryDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.hot_country.HotCountryNetRequestBean;
import cn.lvyou.domainbean_model.login.LoginDomainBeanToolsFactory;
import cn.lvyou.domainbean_model.login.LoginNetRequestBean;
import cn.lvyou.domainbean_model.optionTop.OptionTopDomainBeanToolsFactory;
import cn.lvyou.domainbean_model.optionTop.OptionTopNetRequestBean;
import cn.lvyou.domainbean_model.register.RegisterDomainBeanToolsFactory;
import cn.lvyou.domainbean_model.register.RegisterNetRequestBean;
import cn.lvyou.domainbean_model.subscribe_list.SubscribeListDomainBeanToolsFactory;
import cn.lvyou.domainbean_model.subscribe_list.SubscribeListNetRequestBean;
import cn.lvyou.domainbean_model.subscribe_push.SubscribePushDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.subscribe_push.SubscribePushNetRequestBean;
import cn.lvyou.domainbean_model.unbind_uid.UnBindUidDonainBeanToolsFactory;
import cn.lvyou.domainbean_model.unbind_uid.UnBindUidNetRequestBean;
import cn.lvyou.my_network_engine.domainbean_helper.StrategyClassNameMappingBase;

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
		// --------------------------------------------------------------------------------------------读取接口---------------------------------------------------------------------//
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
		/**
		 * lastminute提醒条件列表
		 */
		strategyClassesNameMappingList.put(SubscribeListNetRequestBean.class.getName(), SubscribeListDomainBeanToolsFactory.class.getName());
		/**
		 * 折扣提醒推送
		 */
		strategyClassesNameMappingList.put(SubscribePushNetRequestBean.class.getName(), SubscribePushDonainBeanToolsFactory.class.getName());
		/**
		 * 获取折扣热门国家
		 */
		strategyClassesNameMappingList.put(HotCountryNetRequestBean.class.getName(), HotCountryDonainBeanToolsFactory.class.getName());
		/**
		 * APP获取折扣预定基础信息
		 */
		strategyClassesNameMappingList.put(BookInfoNetRequestBean.class.getName(), BookInfoDonainBeanToolsFactory.class.getName());
		/**
		 * APP获取折扣类型信息
		 */
		strategyClassesNameMappingList.put(ProductsInfoNetRequestBean.class.getName(), ProductsInfoDonainBeanToolsFactory.class.getName());
		/**
		 * APP获取订单信息
		 */
		strategyClassesNameMappingList.put(OrderforminfoNetRequestBean.class.getName(), OrderforminfoDonainBeanToolsFactory.class.getName());
		/**
		 * APP获取用户订单列表
		 */
		strategyClassesNameMappingList.put(UserOrderNetRequestBean.class.getName(), UserOrderDonainBeanToolsFactory.class.getName());
		/**
		 * APP主动查询支付宝
		 */
		strategyClassesNameMappingList.put(AppQueryNetRequestBean.class.getName(), AppQueryDonainBeanToolsFactory.class.getName());
		// --------------------------------------------------------------------------------------------写入接口---------------------------------------------------------------------//

		/**
		 * lastminute添加收藏
		 */
		strategyClassesNameMappingList.put(AddFavorNetRequestBean.class.getName(), AddFavorDonainBeanToolsFactory.class.getName());
		/**
		 * lastminute取消收藏
		 */
		strategyClassesNameMappingList.put(DelFavorNetRequestBean.class.getName(), DelFavorDonainBeanToolsFactory.class.getName());
		/**
		 * lastminute添加提醒条件
		 */
		strategyClassesNameMappingList.put(AddSubscribeNetRequestBean.class.getName(), AddSubscribeDonainBeanToolsFactory.class.getName());
		/**
		 * lastminute取消提醒条件
		 */
		strategyClassesNameMappingList.put(DelSubscribeNetRequestBean.class.getName(), DelSubscribeDonainBeanToolsFactory.class.getName());
		/**
		 * 绑定用户到应用设备
		 */
		strategyClassesNameMappingList.put(BindUidNetRequestBean.class.getName(), BindUidDonainBeanToolsFactory.class.getName());
		/**
		 * 从应用设备解绑用户
		 */
		strategyClassesNameMappingList.put(UnBindUidNetRequestBean.class.getName(), UnBindUidDonainBeanToolsFactory.class.getName());
		/**
		 * APP提交订单
		 */
		strategyClassesNameMappingList.put(PostOrderformNetRequestBean.class.getName(), PostOrderformDonainBeanToolsFactory.class.getName());
		/**
		 * APP删除订单
		 */
		strategyClassesNameMappingList.put(DelOrderformNetRequestBean.class.getName(), DelOrderformDonainBeanToolsFactory.class.getName());
		/**
		 * APP生成尾单
		 */
		strategyClassesNameMappingList.put(PostSecondOrderformNetRequestBean.class.getName(), PostSecondOrderformDonainBeanToolsFactory.class.getName());
	}
}
