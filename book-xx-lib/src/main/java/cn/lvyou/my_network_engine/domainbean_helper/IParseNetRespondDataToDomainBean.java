package cn.lvyou.my_network_engine.domainbean_helper;

/**
 * 将目标网络业务接口返回的响应字符串, 解析该业务接口对应的 "网络响应业务Bean"
 * @author skyduck
 * 
 */
public interface IParseNetRespondDataToDomainBean {
	public Object parseNetRespondDataToDomainBean(final Object netRespondData) throws Exception;
}
