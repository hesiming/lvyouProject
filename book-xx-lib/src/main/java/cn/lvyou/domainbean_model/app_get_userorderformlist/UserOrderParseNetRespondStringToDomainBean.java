package cn.lvyou.domainbean_model.app_get_userorderformlist;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.lvyou.domainbean_model.app_get_orderforminfo.order_info_item.LastminuteBean;
import cn.lvyou.domainbean_model.app_get_orderforminfo.order_info_item.OrderformBean;
import cn.lvyou.domainbean_model.app_get_orderforminfo.order_info_item.ProductsBean;
import cn.lvyou.domainbean_model.app_get_orderforminfo.order_info_item.SupplierBean;
import cn.lvyou.my_network_engine.domainbean_tools.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public class UserOrderParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		UserOrderNetRespondBean orderforminfoNetRespondBean = new UserOrderNetRespondBean();
		// 获取ArrayObject
		if (jsonRootObject.has(UserOrderDatabaseFieldsConstant.RespondBean.data.name())) {
			JSONObject orderforminfo = jsonRootObject.getJSONObject(UserOrderDatabaseFieldsConstant.RespondBean.data.name());

			orderforminfoNetRespondBean.setPager(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, UserOrderDatabaseFieldsConstant.RespondBean.pager.name(), ""));
			orderforminfoNetRespondBean.setCounts(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, UserOrderDatabaseFieldsConstant.RespondBean.counts.name(), ""));
			if (orderforminfo.has(UserOrderDatabaseFieldsConstant.RespondBean.res.name())) {
				JSONArray jsonArray = orderforminfo.getJSONArray(UserOrderDatabaseFieldsConstant.RespondBean.res.name());
				List<UserorderformResBean> resList = new ArrayList<UserorderformResBean>();
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					UserorderformResBean userorderformResBean = new UserorderformResBean();
					// int 订单号
					userorderformResBean.setId(JSONTools.safeParseJSONObjectForValueIsString(jsonObject, UserOrderDatabaseFieldsConstant.RespondBean.id.name(), ""));
					// string 截止时间，为0时则表示不限制
					userorderformResBean.setLastalipaydatetime(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, UserOrderDatabaseFieldsConstant.RespondBean.lastalipaydatetime.name(), ""));
					// string 折扣标题
					userorderformResBean.setLastminute_title(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, UserOrderDatabaseFieldsConstant.RespondBean.lastminute_title.name(), ""));
					// string 折扣价格 可能为数字，也可能为<em>999</em>元起
					userorderformResBean.setLastminute_price(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, UserOrderDatabaseFieldsConstant.RespondBean.lastminute_price.name(), ""));
					// int 产品类型 0为全款 1为预付款 2为尾款
					userorderformResBean.setProducts_type(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, UserOrderDatabaseFieldsConstant.RespondBean.products_type.name(), ""));
					// string 产品标题
					userorderformResBean.setProducts_title(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, UserOrderDatabaseFieldsConstant.RespondBean.products_title.name(), ""));
					// float 购买单价
					userorderformResBean.setUnit_price(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, UserOrderDatabaseFieldsConstant.RespondBean.unit_price.name(), ""));
					// int 购买数量
					userorderformResBean.setNum(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, UserOrderDatabaseFieldsConstant.RespondBean.num.name(), ""));
					// float 购买总价
					userorderformResBean.setPrice(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, UserOrderDatabaseFieldsConstant.RespondBean.price.name(), ""));
					// string 商家支付宝号
					userorderformResBean.setAlipay_account(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, UserOrderDatabaseFieldsConstant.RespondBean.alipay_account.name(), ""));
					// string 商家名称
					userorderformResBean.setSupplier_title(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, UserOrderDatabaseFieldsConstant.RespondBean.supplier_title.name(), ""));
					// int 商家类型 1，非认证商家 0，认证商家
					userorderformResBean.setSupplier_type(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, UserOrderDatabaseFieldsConstant.RespondBean.supplier_type.name(), ""));
					// string 商家电话
					userorderformResBean.setSupplier_phone(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, UserOrderDatabaseFieldsConstant.RespondBean.supplier_phone.name(), ""));
					// int 订单状态 1 已支付 0未支付 -1超时
					userorderformResBean.setPayment(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, UserOrderDatabaseFieldsConstant.RespondBean.payment.name(), ""));
					// array 对应折扣信息，数组
					List<LastminuteBean> lastminute = new ArrayList<LastminuteBean>();
					if (orderforminfo.has(UserOrderDatabaseFieldsConstant.RespondBean.lastminute.name())) {
						JSONArray lastminuteArray = orderforminfo.getJSONArray(UserOrderDatabaseFieldsConstant.RespondBean.lastminute.name());
						for (int j = 0; j < lastminuteArray.length(); j++) {

							JSONObject lastminuteObject = lastminuteArray.getJSONObject(j);
							LastminuteBean lastminuteBean = new LastminuteBean();
							lastminuteBean.setId(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.id.name(), ""));
							lastminuteBean.setTitle(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.title.name(), ""));
							lastminuteBean.setSupplier(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.supplier.name(), ""));
							lastminuteBean.setPrice(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.price.name(), ""));
							lastminuteBean.setProduct_type(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.product_type.name(),
									""));
							lastminuteBean.setFeature(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.feature.name(), ""));
							lastminuteBean.setInfo_give(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.info_give.name(), ""));
							lastminuteBean.setStart_pos(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.start_pos.name(), ""));
							lastminuteBean.setCountry(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.country.name(), ""));
							lastminuteBean.setCity(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.city.name(), ""));
							lastminuteBean.setStart_date(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.start_date.name(), ""));
							lastminuteBean.setEnd_date(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.end_date.name(), ""));
							lastminuteBean.setPic(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.pic.name(), ""));
							lastminuteBean.setPic_info(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.pic_info.name(), ""));
							lastminuteBean.setDetail(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.detail.name(), ""));
							lastminuteBean.setUse_if(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.use_if.name(), ""));
							lastminuteBean.setQyer_url(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.qyer_url.name(), ""));
							lastminuteBean.setUrl(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.url.name(), ""));
							lastminuteBean.setRecommend(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.recommend.name(), ""));
							lastminuteBean.setAdmin(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.admin.name(), ""));
							lastminuteBean.setAddtime(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.addtime.name(), ""));
							lastminuteBean.setDetail_image(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.detail_image.name(),
									""));
							lastminuteBean.setEnd_pos(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.end_pos.name(), ""));
							lastminuteBean.setViews(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.views.name(), ""));
							lastminuteBean.setBooking_time(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.booking_time.name(),
									""));
							lastminuteBean
									.setTravel_time(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.travel_time.name(), ""));
							lastminuteBean.setLogin_visible(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.login_visible.name(),
									""));
							lastminuteBean.setDiscount_code(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.discount_code.name(),
									""));
							lastminuteBean.setOrder_type(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.order_type.name(), ""));
							lastminuteBean.setContinent(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.continent.name(), ""));
							lastminuteBean.setCtn(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.ctn.name(), ""));
							lastminuteBean.setChannel(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.channel.name(), ""));
							lastminuteBean.setOp_pic(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.op_pic.name(), ""));
							lastminuteBean.setStatus(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.status.name(), ""));
							lastminuteBean.setOp_pic1(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.op_pic1.name(), ""));
							lastminuteBean.setEdittime(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.edittime.name(), ""));
							lastminuteBean.setDeparture(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.departure.name(), ""));
							lastminuteBean.setAbroad(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.abroad.name(), ""));
							lastminuteBean.setList_price(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.list_price.name(), ""));
							lastminuteBean.setBuy_price(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.buy_price.name(), ""));
							lastminuteBean.setRelatid(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.relatid.name(), ""));
							lastminuteBean.setCurrency_code(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.currency_code.name(),
									""));
							lastminuteBean.setBooktype(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.booktype.name(), ""));
							lastminuteBean.setTimeout(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, UserOrderDatabaseFieldsConstant.LastminuteRespondBean.timeout.name(), ""));
							lastminuteBean.setFirstpay_start_time(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject,
									UserOrderDatabaseFieldsConstant.LastminuteRespondBean.firstpay_end_time.name(), ""));
							lastminuteBean.setFirstpay_end_time(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject,
									UserOrderDatabaseFieldsConstant.LastminuteRespondBean.firstpay_end_time.name(), ""));
							lastminuteBean.setSecondpay_start_time(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject,
									UserOrderDatabaseFieldsConstant.LastminuteRespondBean.secondpay_start_time.name(), ""));
							lastminuteBean.setSecondpay_end_time(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject,
									UserOrderDatabaseFieldsConstant.LastminuteRespondBean.secondpay_end_time.name(), ""));
							lastminute.add(lastminuteBean);
						}
					}

					userorderformResBean.setLastminute(lastminute);
					// array 对应商家信息，数组
					List<SupplierBean> supplier = new ArrayList<SupplierBean>();
					if (orderforminfo.has(UserOrderDatabaseFieldsConstant.RespondBean.supplier.name())) {
						JSONArray supplierArray = orderforminfo.getJSONArray(UserOrderDatabaseFieldsConstant.RespondBean.supplier.name());
						for (int k = 0; k < supplierArray.length(); k++) {
							JSONObject supplierObject = supplierArray.getJSONObject(i);
							SupplierBean supplierBean = new SupplierBean();
							supplierBean.setId(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, UserOrderDatabaseFieldsConstant.SupplierRespondBean.id.name(), ""));
							supplierBean.setCatename(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, UserOrderDatabaseFieldsConstant.SupplierRespondBean.catename.name(), ""));
							supplierBean.setCatename_en(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, UserOrderDatabaseFieldsConstant.SupplierRespondBean.catename_en.name(), ""));
							supplierBean.setCatename_py(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, UserOrderDatabaseFieldsConstant.SupplierRespondBean.catename_py.name(), ""));
							supplierBean.setImage(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, UserOrderDatabaseFieldsConstant.SupplierRespondBean.image.name(), ""));
							supplierBean.setSub_image(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, UserOrderDatabaseFieldsConstant.SupplierRespondBean.sub_image.name(), ""));
							supplierBean
									.setAlipay_account(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, UserOrderDatabaseFieldsConstant.SupplierRespondBean.alipay_account.name(), ""));
							supplierBean.setPhone(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, UserOrderDatabaseFieldsConstant.SupplierRespondBean.phone.name(), ""));
							supplierBean.setSiteurl(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, UserOrderDatabaseFieldsConstant.SupplierRespondBean.siteurl.name(), ""));
							supplierBean.setEmail(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, UserOrderDatabaseFieldsConstant.SupplierRespondBean.email.name(), ""));
							supplierBean.setType(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, UserOrderDatabaseFieldsConstant.SupplierRespondBean.type.name(), ""));
							supplierBean.setStatus(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, UserOrderDatabaseFieldsConstant.SupplierRespondBean.status.name(), ""));
							supplier.add(supplierBean);
						}
					}
					userorderformResBean.setSupplier(supplier);
					// array 对应产品信息，数组
					List<ProductsBean> products = new ArrayList<ProductsBean>();
					if (orderforminfo.has(UserOrderDatabaseFieldsConstant.RespondBean.products.name())) {
						JSONArray productsArray = orderforminfo.getJSONArray(UserOrderDatabaseFieldsConstant.RespondBean.products.name());
						for (int ii = 0; ii < productsArray.length(); ii++) {
							JSONObject productsObject = productsArray.getJSONObject(i);
							ProductsBean productsBean = new ProductsBean();
							productsBean.setId(JSONTools.safeParseJSONObjectForValueIsString(productsObject, UserOrderDatabaseFieldsConstant.ProductsRespondBean.id.name(), ""));
							productsBean.setLid(JSONTools.safeParseJSONObjectForValueIsString(productsObject, UserOrderDatabaseFieldsConstant.ProductsRespondBean.lid.name(), ""));
							productsBean.setTitle(JSONTools.safeParseJSONObjectForValueIsString(productsObject, UserOrderDatabaseFieldsConstant.ProductsRespondBean.title.name(), ""));
							productsBean.setTotal(JSONTools.safeParseJSONObjectForValueIsString(productsObject, UserOrderDatabaseFieldsConstant.ProductsRespondBean.total.name(), ""));
							productsBean.setStock(JSONTools.safeParseJSONObjectForValueIsString(productsObject, UserOrderDatabaseFieldsConstant.ProductsRespondBean.stock.name(), ""));
							productsBean.setPrice(JSONTools.safeParseJSONObjectForValueIsString(productsObject, UserOrderDatabaseFieldsConstant.ProductsRespondBean.price.name(), ""));
							productsBean.setAdvance_payment(JSONTools.safeParseJSONObjectForValueIsString(productsObject, UserOrderDatabaseFieldsConstant.ProductsRespondBean.advance_payment.name(),
									""));
							productsBean.setBuy_limit(JSONTools.safeParseJSONObjectForValueIsString(productsObject, UserOrderDatabaseFieldsConstant.ProductsRespondBean.buy_limit.name(), ""));
							productsBean.setType(JSONTools.safeParseJSONObjectForValueIsString(productsObject, UserOrderDatabaseFieldsConstant.ProductsRespondBean.type.name(), ""));
							products.add(productsBean);
						}
					}
					userorderformResBean.setProducts(products);

					// array 订单信息，数组
					List<OrderformBean> orderform = new ArrayList<OrderformBean>();
					if (orderforminfo.has(UserOrderDatabaseFieldsConstant.RespondBean.orderform.name())) {
						JSONArray orderformArray = orderforminfo.getJSONArray(UserOrderDatabaseFieldsConstant.RespondBean.orderform.name());
						for (int ij = 0; ij < orderformArray.length(); ij++) {
							JSONObject orderformObject = orderformArray.getJSONObject(i);

							OrderformBean orderformBean = new OrderformBean();
							orderformBean.setId(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.id.name(), ""));
							orderformBean.setPid(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.pid.name(), ""));
							orderformBean.setNum(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.num.name(), ""));
							orderformBean.setName(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.name.name(), ""));
							orderformBean.setPhone(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.phone.name(), ""));
							orderformBean.setEmail(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.email.name(), ""));
							orderformBean.setUid(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.uid.name(), ""));
							orderformBean.setUnit_price(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.unit_price.name(), ""));
							orderformBean.setPrice(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.price.name(), ""));
							orderformBean.setPayment(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.payment.name(), ""));
							orderformBean.setDatetime(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.datetime.name(), ""));
							orderformBean.setDatetime(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.datetime.name(), ""));
							orderformBean.setFirstpay(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.firstpay.name(), ""));
							orderformBean.setRelid(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.relid.name(), ""));
							orderformBean.setBuyer_email(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.buyer_email.name(), ""));
							orderformBean.setBuyer_id(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.buyer_id.name(), ""));
							orderformBean.setNotify_id(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.notify_id.name(), ""));
							orderformBean.setNotify_time(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.notify_time.name(), ""));
							orderformBean.setNotify_type(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.notify_type.name(), ""));
							orderformBean.setPayment(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.payment_type.name(), ""));
							orderformBean.setSeller_email(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.seller_email.name(), ""));
							orderformBean.setSeller_id(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.seller_id.name(), ""));
							orderformBean.setSign(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.sign.name(), ""));
							orderformBean.setSign_type(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.sign_type.name(), ""));
							orderformBean.setTotal_fee(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.total_fee.name(), ""));
							orderformBean.setTrade_no(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.trade_no.name(), ""));
							orderformBean.setTrade_status(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.trade_status.name(), ""));
							orderformBean.setReturn_type(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.return_type.name(), ""));
							orderformBean.setReturn_time(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, UserOrderDatabaseFieldsConstant.OrderformRespondBean.return_time.name(), ""));
							orderform.add(orderformBean);
						}
					}

					userorderformResBean.setOrderform(orderform);
					// int 订单支付类型 0 未支付 1 web端支付 2 app端支付
					userorderformResBean.setPay_type(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, UserOrderDatabaseFieldsConstant.RespondBean.pay_type.name(), ""));
					resList.add(userorderformResBean);
					orderforminfoNetRespondBean.setRes(resList);
				}

			}

		}
		return orderforminfoNetRespondBean;
	}
}
