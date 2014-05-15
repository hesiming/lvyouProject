package cn.lvyou.domainbean_model.favor_list;

import java.util.ArrayList;
import java.util.List;

/**
 * lastminute收藏列表
 * 
 * @author hesiming
 * 
 */
public final class FavorListNetRespondBean {
	List<FavorItem> favorItems = new ArrayList<FavorItem>();

	public FavorListNetRespondBean(List<FavorItem> favorItems) {
		this.favorItems = favorItems;
	}

	public List<FavorItem> getFavorItems() {
		return favorItems;
	}

	@Override
	public String toString() {
		return "FavorListNetRespondBean [favorItems=" + favorItems + "]";
	}

}
