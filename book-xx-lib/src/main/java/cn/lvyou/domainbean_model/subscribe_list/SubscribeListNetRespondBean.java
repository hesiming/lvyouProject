package cn.lvyou.domainbean_model.subscribe_list;

import java.util.ArrayList;
import java.util.List;

/**
 * lastminute提醒条件列表
 * 
 * @author hesiming
 * 
 */
public final class SubscribeListNetRespondBean {
	List<SubscribeItem> subscribeItems = new ArrayList<SubscribeItem>();

	public SubscribeListNetRespondBean(List<SubscribeItem> subscribeItems) {
		super();
		this.subscribeItems = subscribeItems;
	}

	public List<SubscribeItem> getSubscribeItems() {
		return subscribeItems;
	}

	@Override
	public String toString() {
		return "SubscribeListNetRespondBean [subscribeItems=" + subscribeItems + "]";
	}

}
