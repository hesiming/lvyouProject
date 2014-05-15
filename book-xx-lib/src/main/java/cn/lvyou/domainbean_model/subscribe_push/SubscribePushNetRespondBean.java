package cn.lvyou.domainbean_model.subscribe_push;

import java.util.List;

/**
 * 折扣提醒推送
 * 
 * @author hesiming
 * 
 */
public final class SubscribePushNetRespondBean {
	private List<SubscribePushItem> subscribePushItems;

	public SubscribePushNetRespondBean(List<SubscribePushItem> subscribePushItems) {
		this.subscribePushItems = subscribePushItems;
	}

	public List<SubscribePushItem> getSubscribePushItems() {
		return subscribePushItems;
	}

	@Override
	public String toString() {
		return "SubscribePushNetRespondBean [subscribePushItems=" + subscribePushItems + "]";
	}

}
