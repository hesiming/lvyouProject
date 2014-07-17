package cn.lvyou.domainbean_model.app_get_productsinfo;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cn.lvyou.domainbean_model.hot_country.HotCountryDatabaseFieldsConstant;
import cn.lvyou.my_network_engine.domainbean_helper.IParseNetRespondDataToDomainBean;
import cn.lvyou.toolutils.JSONTools;

public class ProductsInfoParseNetRespondStringToDomainBean implements IParseNetRespondDataToDomainBean {

	@Override
	public Object parseNetRespondDataToDomainBean(Object netRespondData) throws Exception {
		final String netRespondString = (String) netRespondData;
		JSONObject jsonRootObject = new JSONObject(netRespondString);
		List<ProdutsInfoItem> list = new ArrayList<ProdutsInfoItem>();
		// int 折扣ID
		int id = 0;
		// string 折扣标题
		String title = "";
		// string 折扣图片地址 尺寸275×185
		String pic = "";
		// string 折扣价格 可能为数字，也可能为<em>999</em>元起
		String price = "";
		// 获取ArrayObject
		if (jsonRootObject.has(HotCountryDatabaseFieldsConstant.RespondBean.data.name())) {
			JSONObject continentObject = jsonRootObject.getJSONObject(ProductsInfoDatabaseFieldsConstant.RespondBean.data.name());

			id = JSONTools.safeParseJSONObjectForValueIsInteger(continentObject, ProductsInfoDatabaseFieldsConstant.RespondBean.id.name(), 0);
			title = JSONTools.safeParseJSONObjectForValueIsString(continentObject, ProductsInfoDatabaseFieldsConstant.RespondBean.title.name(), "");
			pic = JSONTools.safeParseJSONObjectForValueIsString(continentObject, ProductsInfoDatabaseFieldsConstant.RespondBean.pic.name(), "");
			price = JSONTools.safeParseJSONObjectForValueIsString(continentObject, ProductsInfoDatabaseFieldsConstant.RespondBean.price.name(), "");
			if (continentObject.has(ProductsInfoDatabaseFieldsConstant.RespondBean.products.name())) {
				JSONArray countryArray = jsonRootObject.getJSONArray(ProductsInfoDatabaseFieldsConstant.RespondBean.products.name());
				for (int i = 0; i < countryArray.length(); i++) {
					JSONObject jsonObject = countryArray.getJSONObject(i);

					// int 折扣类型ID
					int productId = JSONTools.safeParseJSONObjectForValueIsInteger(jsonObject, ProductsInfoDatabaseFieldsConstant.RespondBean.id.name(), 0);
					// string 类型名称
					String productTitle = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, ProductsInfoDatabaseFieldsConstant.RespondBean.title.name(), "");
					// int 库存
					String stock = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, ProductsInfoDatabaseFieldsConstant.RespondBean.stock.name(), "");
					// int 购买限制，为0则不限制
					String buy_limit = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, ProductsInfoDatabaseFieldsConstant.RespondBean.buy_limit.name(), "");
					// int 0为全款 1为预付款
					String type = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, ProductsInfoDatabaseFieldsConstant.RespondBean.type.name(), "");
					// float 类型的价格
					String product_price = JSONTools.safeParseJSONObjectForValueIsString(jsonObject, ProductsInfoDatabaseFieldsConstant.RespondBean.product_price.name(), "");
					ProdutsInfoItem produtsInfoItem = new ProdutsInfoItem(productId, productTitle, stock, buy_limit, type, product_price);
					list.add(produtsInfoItem);
				}
			}

		}
		ProductsInfoNetRespondBean productsInfoNetRespondBean = new ProductsInfoNetRespondBean(id, title, pic, price, list);
		return productsInfoNetRespondBean;
	}

}
