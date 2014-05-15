package cn.lvyou.domainbean_model.app_get_orderforminfo;

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

public class OrderforminfoParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		OrderforminfoNetRespondBean orderforminfoNetRespondBean = new OrderforminfoNetRespondBean();
		// 获取ArrayObject
		if (jsonRootObject.has(OrderforminfoDatabaseFieldsConstant.RespondBean.data.name())) {
			JSONObject orderforminfo = jsonRootObject.getJSONObject(OrderforminfoDatabaseFieldsConstant.RespondBean.data.name());

			// int 订单号
			orderforminfoNetRespondBean.setId(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, OrderforminfoDatabaseFieldsConstant.RespondBean.id.name(), ""));
			// string 截止时间，为0时则表示不限制
			orderforminfoNetRespondBean.setLastalipaydatetime(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, OrderforminfoDatabaseFieldsConstant.RespondBean.lastalipaydatetime.name(),
					""));
			// string 折扣标题
			orderforminfoNetRespondBean.setLastminute_title(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, OrderforminfoDatabaseFieldsConstant.RespondBean.lastminute_title.name(), ""));
			// string 折扣价格 可能为数字，也可能为<em>999</em>元起
			orderforminfoNetRespondBean.setLastminute_price(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, OrderforminfoDatabaseFieldsConstant.RespondBean.lastminute_price.name(), ""));
			// int 产品类型 0为全款 1为预付款 2为尾款
			orderforminfoNetRespondBean.setProducts_type(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, OrderforminfoDatabaseFieldsConstant.RespondBean.products_type.name(), ""));
			// string 产品标题
			orderforminfoNetRespondBean.setProducts_title(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, OrderforminfoDatabaseFieldsConstant.RespondBean.products_title.name(), ""));
			// float 购买单价
			orderforminfoNetRespondBean.setUnit_price(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, OrderforminfoDatabaseFieldsConstant.RespondBean.unit_price.name(), ""));
			// int 购买数量
			orderforminfoNetRespondBean.setNum(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, OrderforminfoDatabaseFieldsConstant.RespondBean.num.name(), ""));
			// float 购买总价
			orderforminfoNetRespondBean.setPrice(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, OrderforminfoDatabaseFieldsConstant.RespondBean.price.name(), ""));
			// string 商家支付宝号
			orderforminfoNetRespondBean.setAlipay_account(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, OrderforminfoDatabaseFieldsConstant.RespondBean.alipay_account.name(), ""));
			// string 商家名称
			orderforminfoNetRespondBean.setSupplier_title(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, OrderforminfoDatabaseFieldsConstant.RespondBean.supplier_title.name(), ""));
			// int 商家类型 1，非认证商家 0，认证商家
			orderforminfoNetRespondBean.setSupplier_type(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, OrderforminfoDatabaseFieldsConstant.RespondBean.supplier_type.name(), ""));
			// string 商家电话
			orderforminfoNetRespondBean.setSupplier_phone(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, OrderforminfoDatabaseFieldsConstant.RespondBean.supplier_phone.name(), ""));
			// int 订单状态 1 已支付 0未支付 -1超时
			orderforminfoNetRespondBean.setPayment(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, OrderforminfoDatabaseFieldsConstant.RespondBean.payment.name(), ""));
			// array 对应折扣信息，数组
			List<LastminuteBean> lastminute = new ArrayList<LastminuteBean>();
			if (orderforminfo.has(OrderforminfoDatabaseFieldsConstant.RespondBean.lastminute.name())) {
				JSONArray lastminuteArray = orderforminfo.getJSONArray(OrderforminfoDatabaseFieldsConstant.RespondBean.lastminute.name());
				for (int i = 0; i < lastminuteArray.length(); i++) {

					JSONObject lastminuteObject = lastminuteArray.getJSONObject(i);
					LastminuteBean lastminuteBean = new LastminuteBean();
					lastminuteBean.setId(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.id.name(), ""));
					lastminuteBean.setTitle(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.title.name(), ""));
					lastminuteBean.setSupplier(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.supplier.name(), ""));
					lastminuteBean.setPrice(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.price.name(), ""));
					lastminuteBean.setProduct_type(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.product_type.name(), ""));
					lastminuteBean.setFeature(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.feature.name(), ""));
					lastminuteBean.setInfo_give(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.info_give.name(), ""));
					lastminuteBean.setStart_pos(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.start_pos.name(), ""));
					lastminuteBean.setCountry(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.country.name(), ""));
					lastminuteBean.setCity(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.city.name(), ""));
					lastminuteBean.setStart_date(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.start_date.name(), ""));
					lastminuteBean.setEnd_date(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.end_date.name(), ""));
					lastminuteBean.setPic(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.pic.name(), ""));
					lastminuteBean.setPic_info(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.pic_info.name(), ""));
					lastminuteBean.setDetail(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.detail.name(), ""));
					lastminuteBean.setUse_if(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.use_if.name(), ""));
					lastminuteBean.setQyer_url(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.qyer_url.name(), ""));
					lastminuteBean.setUrl(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.url.name(), ""));
					lastminuteBean.setRecommend(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.recommend.name(), ""));
					lastminuteBean.setAdmin(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.admin.name(), ""));
					lastminuteBean.setAddtime(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.addtime.name(), ""));
					lastminuteBean.setDetail_image(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.detail_image.name(), ""));
					lastminuteBean.setEnd_pos(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.end_pos.name(), ""));
					lastminuteBean.setViews(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.views.name(), ""));
					lastminuteBean.setBooking_time(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.booking_time.name(), ""));
					lastminuteBean.setTravel_time(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.travel_time.name(), ""));
					lastminuteBean
							.setLogin_visible(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.login_visible.name(), ""));
					lastminuteBean
							.setDiscount_code(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.discount_code.name(), ""));
					lastminuteBean.setOrder_type(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.order_type.name(), ""));
					lastminuteBean.setContinent(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.continent.name(), ""));
					lastminuteBean.setCtn(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.ctn.name(), ""));
					lastminuteBean.setChannel(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.channel.name(), ""));
					lastminuteBean.setOp_pic(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.op_pic.name(), ""));
					lastminuteBean.setStatus(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.status.name(), ""));
					lastminuteBean.setOp_pic1(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.op_pic1.name(), ""));
					lastminuteBean.setEdittime(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.edittime.name(), ""));
					lastminuteBean.setDeparture(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.departure.name(), ""));
					lastminuteBean.setAbroad(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.abroad.name(), ""));
					lastminuteBean.setList_price(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.list_price.name(), ""));
					lastminuteBean.setBuy_price(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.buy_price.name(), ""));
					lastminuteBean.setRelatid(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.relatid.name(), ""));
					lastminuteBean
							.setCurrency_code(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.currency_code.name(), ""));
					lastminuteBean.setBooktype(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.booktype.name(), ""));
					lastminuteBean.setTimeout(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject, OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.timeout.name(), ""));
					lastminuteBean.setFirstpay_start_time(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject,
							OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.firstpay_end_time.name(), ""));
					lastminuteBean.setFirstpay_end_time(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject,
							OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.firstpay_end_time.name(), ""));
					lastminuteBean.setSecondpay_start_time(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject,
							OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.secondpay_start_time.name(), ""));
					lastminuteBean.setSecondpay_end_time(JSONTools.safeParseJSONObjectForValueIsString(lastminuteObject,
							OrderforminfoDatabaseFieldsConstant.LastminuteRespondBean.secondpay_end_time.name(), ""));
					lastminute.add(lastminuteBean);
				}
			}

			orderforminfoNetRespondBean.setLastminute(lastminute);
			// array 对应商家信息，数组
			List<SupplierBean> supplier = new ArrayList<SupplierBean>();
			if (orderforminfo.has(OrderforminfoDatabaseFieldsConstant.RespondBean.supplier.name())) {
				JSONArray supplierArray = orderforminfo.getJSONArray(OrderforminfoDatabaseFieldsConstant.RespondBean.supplier.name());
				for (int i = 0; i < supplierArray.length(); i++) {
					JSONObject supplierObject = supplierArray.getJSONObject(i);
					SupplierBean supplierBean = new SupplierBean();
					supplierBean.setId(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, OrderforminfoDatabaseFieldsConstant.SupplierRespondBean.id.name(), ""));
					supplierBean.setCatename(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, OrderforminfoDatabaseFieldsConstant.SupplierRespondBean.catename.name(), ""));
					supplierBean.setCatename_en(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, OrderforminfoDatabaseFieldsConstant.SupplierRespondBean.catename_en.name(), ""));
					supplierBean.setCatename_py(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, OrderforminfoDatabaseFieldsConstant.SupplierRespondBean.catename_py.name(), ""));
					supplierBean.setImage(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, OrderforminfoDatabaseFieldsConstant.SupplierRespondBean.image.name(), ""));
					supplierBean.setSub_image(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, OrderforminfoDatabaseFieldsConstant.SupplierRespondBean.sub_image.name(), ""));
					supplierBean.setAlipay_account(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, OrderforminfoDatabaseFieldsConstant.SupplierRespondBean.alipay_account.name(), ""));
					supplierBean.setPhone(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, OrderforminfoDatabaseFieldsConstant.SupplierRespondBean.phone.name(), ""));
					supplierBean.setSiteurl(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, OrderforminfoDatabaseFieldsConstant.SupplierRespondBean.siteurl.name(), ""));
					supplierBean.setEmail(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, OrderforminfoDatabaseFieldsConstant.SupplierRespondBean.email.name(), ""));
					supplierBean.setType(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, OrderforminfoDatabaseFieldsConstant.SupplierRespondBean.type.name(), ""));
					supplierBean.setStatus(JSONTools.safeParseJSONObjectForValueIsString(supplierObject, OrderforminfoDatabaseFieldsConstant.SupplierRespondBean.status.name(), ""));
					supplier.add(supplierBean);
				}
			}
			orderforminfoNetRespondBean.setSupplier(supplier);
			// array 对应产品信息，数组
			List<ProductsBean> products = new ArrayList<ProductsBean>();
			if (orderforminfo.has(OrderforminfoDatabaseFieldsConstant.RespondBean.products.name())) {
				JSONArray productsArray = orderforminfo.getJSONArray(OrderforminfoDatabaseFieldsConstant.RespondBean.products.name());
				for (int i = 0; i < productsArray.length(); i++) {
					JSONObject productsObject = productsArray.getJSONObject(i);
					ProductsBean productsBean = new ProductsBean();
					productsBean.setId(JSONTools.safeParseJSONObjectForValueIsString(productsObject, OrderforminfoDatabaseFieldsConstant.ProductsRespondBean.id.name(), ""));
					productsBean.setLid(JSONTools.safeParseJSONObjectForValueIsString(productsObject, OrderforminfoDatabaseFieldsConstant.ProductsRespondBean.lid.name(), ""));
					productsBean.setTitle(JSONTools.safeParseJSONObjectForValueIsString(productsObject, OrderforminfoDatabaseFieldsConstant.ProductsRespondBean.title.name(), ""));
					productsBean.setTotal(JSONTools.safeParseJSONObjectForValueIsString(productsObject, OrderforminfoDatabaseFieldsConstant.ProductsRespondBean.total.name(), ""));
					productsBean.setStock(JSONTools.safeParseJSONObjectForValueIsString(productsObject, OrderforminfoDatabaseFieldsConstant.ProductsRespondBean.stock.name(), ""));
					productsBean.setPrice(JSONTools.safeParseJSONObjectForValueIsString(productsObject, OrderforminfoDatabaseFieldsConstant.ProductsRespondBean.price.name(), ""));
					productsBean.setAdvance_payment(JSONTools.safeParseJSONObjectForValueIsString(productsObject, OrderforminfoDatabaseFieldsConstant.ProductsRespondBean.advance_payment.name(), ""));
					productsBean.setBuy_limit(JSONTools.safeParseJSONObjectForValueIsString(productsObject, OrderforminfoDatabaseFieldsConstant.ProductsRespondBean.buy_limit.name(), ""));
					productsBean.setType(JSONTools.safeParseJSONObjectForValueIsString(productsObject, OrderforminfoDatabaseFieldsConstant.ProductsRespondBean.type.name(), ""));
					products.add(productsBean);
				}
			}
			orderforminfoNetRespondBean.setProducts(products);

			// array 订单信息，数组
			List<OrderformBean> orderform = new ArrayList<OrderformBean>();
			if (orderforminfo.has(OrderforminfoDatabaseFieldsConstant.RespondBean.orderform.name())) {
				JSONArray orderformArray = orderforminfo.getJSONArray(OrderforminfoDatabaseFieldsConstant.RespondBean.orderform.name());
				for (int i = 0; i < orderformArray.length(); i++) {
					JSONObject orderformObject = orderformArray.getJSONObject(i);

					OrderformBean orderformBean = new OrderformBean();
					orderformBean.setId(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.id.name(), ""));
					orderformBean.setPid(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.pid.name(), ""));
					orderformBean.setNum(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.num.name(), ""));
					orderformBean.setName(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.name.name(), ""));
					orderformBean.setPhone(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.phone.name(), ""));
					orderformBean.setEmail(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.email.name(), ""));
					orderformBean.setUid(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.uid.name(), ""));
					orderformBean.setUnit_price(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.unit_price.name(), ""));
					orderformBean.setPrice(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.price.name(), ""));
					orderformBean.setPayment(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.payment.name(), ""));
					orderformBean.setDatetime(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.datetime.name(), ""));
					orderformBean.setDatetime(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.datetime.name(), ""));
					orderformBean.setFirstpay(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.firstpay.name(), ""));
					orderformBean.setRelid(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.relid.name(), ""));
					orderformBean.setBuyer_email(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.buyer_email.name(), ""));
					orderformBean.setBuyer_id(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.buyer_id.name(), ""));
					orderformBean.setNotify_id(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.notify_id.name(), ""));
					orderformBean.setNotify_time(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.notify_time.name(), ""));
					orderformBean.setNotify_type(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.notify_type.name(), ""));
					orderformBean.setPayment(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.payment_type.name(), ""));
					orderformBean.setSeller_email(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.seller_email.name(), ""));
					orderformBean.setSeller_id(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.seller_id.name(), ""));
					orderformBean.setSign(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.sign.name(), ""));
					orderformBean.setSign_type(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.sign_type.name(), ""));
					orderformBean.setTotal_fee(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.total_fee.name(), ""));
					orderformBean.setTrade_no(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.trade_no.name(), ""));
					orderformBean.setTrade_status(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.trade_status.name(), ""));
					orderformBean.setReturn_type(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.return_type.name(), ""));
					orderformBean.setReturn_time(JSONTools.safeParseJSONObjectForValueIsString(orderformObject, OrderforminfoDatabaseFieldsConstant.OrderformRespondBean.return_time.name(), ""));
					orderform.add(orderformBean);
				}
			}

			orderforminfoNetRespondBean.setOrderform(orderform);
			// int 订单支付类型 0 未支付 1 web端支付 2 app端支付
			orderforminfoNetRespondBean.setPay_type(JSONTools.safeParseJSONObjectForValueIsString(orderforminfo, OrderforminfoDatabaseFieldsConstant.RespondBean.pay_type.name(), ""));
		}
		return orderforminfoNetRespondBean;
	}
}
