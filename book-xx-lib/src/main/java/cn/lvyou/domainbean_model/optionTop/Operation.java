package cn.lvyou.domainbean_model.optionTop;

import java.io.Serializable;

public class Operation implements Serializable {

	private static final long serialVersionUID = 7867183921683354124L;

	private int openType;
	private String title;
	private String content;
	private String ids;
	private String url;
	private String pic;
	private String bigPic;

	public int getOpenType() {
		return openType;
	}

	public void setOpenType(int openType) {
		this.openType = openType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getBigPic() {
		return bigPic;
	}

	public void setBigPic(String bigPic) {
		this.bigPic = bigPic;
	}

	@Override
	public String toString() {
		return "Operation [openType=" + openType + ", title=" + title + ", content=" + content + ", ids=" + ids + ", url=" + url + ", pic=" + pic + ", bigPic=" + bigPic + "]";
	}

}
