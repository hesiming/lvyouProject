package cn.retech.my_network_engine.net_error_handle;

/**
 * 网络请求时, 错误码枚举 错误码说明 : http 错误码(0~999)
 * 
 * 
 * @author skyduck
 * 
 */
public enum MyNetErrorCodeEnum {

	// 无效的
	kNetErrorCodeEnum_NONE(-2014),

	// / http错误码 (0 ~ 999)
	kNetErrorCodeEnum_HTTP_Error(0), kNetErrorCodeEnum_HTTP_NotFound(404),
	// 网络访问成功(也就是说从服务器获取到了正常的有效数据)
	kNetErrorCodeEnum_Success(200),

	// / 客户端错误 (1000 ~ 1999)
	kNetErrorCodeEnum_Client_Error(1000),
	//
	kNetErrorCodeEnum_Client_ProgrammingError(1001), // 客户端编程错误
	//
	kNetErrorCodeEnum_Client_TimeOut(1002), // 联网超时

	// / 服务器错误 (2000 ~ 2999)
	kNetErrorCodeEnum_Server_Error(2000),

	// 从服务器端获得的实体数据为空(EntityData), 这种情况有可能是正常的, 比如 退出登录 接口, 服务器就只是通知客户端访问成功,
	// 而不发送任何实体数据.
	kNetErrorCodeEnum_Server_NoResponseData(2001),
	// 解析服务器端返回的实体数据失败, 在netUnpackedDataOfUTF8String不为空的时候,
	// unpackNetRespondRawEntityDataToUTF8String是绝对不能为空的.
	kNetErrorCodeEnum_Server_UnpackedResponseDataFailed(2002),
	// 服务器和客户端之前约定的数据交换协议发生了变化(这样会导致客户端解析服务器返回的数据失败)
	kNetErrorCodeEnum_Server_Server(2003),
	// 将网络返回的数据字符串(JSON/XML)解析成业务Bean失败.
	kNetErrorCodeEnum_Server_ParseNetRespondStringToDomainBeanFailed(2004),

	// / 和服务器约定好的错误码, 联网成功, 但是服务器那边发生了错误, 服务器要告知客户端错误的详细信息 (3000 ~ 3999)
	kNetErrorCodeEnum_Server_Custom_Error(3000),
	//
	kNetErrorCodeEnum_Server_Failed(3001), // "操作失败"
	kNetErrorCodeEnum_Server_Exception(3002), // "处理异常"
	kNetErrorCodeEnum_Server_NoResult(3003), // "无结果返回"
	kNetErrorCodeEnum_Server_NeedLogin(3004), // "需要登录"
	// ////////////////////////////////////qyer业务错误码 错误代码	错误信息//////////////////////////////////////////////////
	kNetErrorCodeEnum_Invalid_Client(20001),//无效客户端
	kNetErrorCodeEnum_Invalid_Request(20002),//无效请求
	kNetErrorCodeEnum_Invalid_Token(20003),//无效的Token
	kNetErrorCodeEnum_Expired_Token(20004),//Token过期
	kNetErrorCodeEnum_Insufficient_Scope(20005),//范围不足(根据英文直译)
	kNetErrorCodeEnum_Unsupported_Grant_Type(20006),
	kNetErrorCodeEnum_Unauthorized_Client(20007),
	kNetErrorCodeEnum_Invalid_Grant(20008),
	kNetErrorCodeEnum_Invalid_Scope(20009),
	kNetErrorCodeEnum_Password_Or_Email_Mistake(20010),//邮箱或密码错误
	kNetErrorCodeEnum_Request_Frequently(20011);//短时间内频繁登录,请稍后再试!
		
//	20012	请求次数超过限制次数
//	20013	调用接口失败
//	-	POI
//	20101	用户ID不能为空
//	20102	景点 ID不能为空
//	20103	内容不能为空
//	20104	内容长度非法
//	20105	综合评价必须选择
//	20106	您发布的内容中包含敏感信息，无法提交，请进行修改
//	20107	此用户已经点评，不能重复点评
//	20108	用户点评失败
//	20120	获取点评失败
//	20121	景点ID不能为空
//	20122	获取当前用户点评失败
//	-	私信
//	20201	获取用户私信失败
//	20203	收信用户ID不能为空
//	20204	收信用户不存在
//	20205	私信内容不能为空
//	20206	发信人用户不能与收信人用户相同
//	20207	私信内容不能不能超过500汉字
//	20208	私信过于频繁，请稍后重试
//	20210	私信对方用户ID不能为空
//	20211	发送私信失败
//	20212	获取新私信个数失败
//	-	用户
//	20301	获取用户信息失败
//	20302	修改用户信息失败
//	20303	经\维度不能为空
//	20304	提交用户位置信息失败
//	20306	用户名必须为中文、英文、数字或下划线字符，3-15个字符
//	20307	用户名不能包含敏感词语
//	20308	用户名已被注册
//	20309	邮箱格式不正确
//	20310	该邮箱不允许注册
//	20311	该邮箱地址已被注册
//	20312	账号注册失败
//	20313	获取用户位置信息失败
//	20314	密码长度不能小于6
//	20315	密码验证失败
//	20316	用户名不能为空
//	20317	密码不能为空
//	20318	account_s error
//	20319	头像图片不能为空
//	20320	修改用户头像失败
//	20321	头像不是合法的jpg图片文件
//	20322	头像文件超过5M
//	20323	修改用户封面图失败
//	20324	账户被封禁
//	-	目的地
//	20401	oper参数错误
//	20402	poiid不能为空
//	20403	不能重复添加feeling
//	20404	添加feeling失败
//	20405	获取feeling失败
//	20406	城市ID不能为空
//	20407	获取POI列表失败
//	20408	获取POI信息失败
//	20409	获取POI图片列表失败
//	20410	POI不存在
//	20411	获取POI附近酒店失败
//	20412	city_id不能为空
//	20413	获取城市酒店列表失败
//	-	APP
//	20501	应用名称不能为空
//	20502	设备类型不能为空
//	20503	获取推送通知失败
//	20504	应用名称错误
//	20505	获取APP广告列表失败
//	20506	内容不能为空
//	20507	提交APP数据出错
//	20508	获取APP数据出错
//	20509	ID不能为空
//	20510	编辑APP数据出错
//	20513	client_id不能为空
//	20514	设备号不能为空
//	20516	获取推送间隔失败
//	20519	应用不存在
//	20520	client_id和应用名称不能同时为空
//	20521	获取关联应用失败
//	20522	获取站外关联应用失败
//	20523	提交应用崩溃日志出错
//	20524	取扩展推送信息失败
//	20525	扩展推送ID不能为空
//	20526	无扩展推送信息
//	20527	验证是否存在高级应用版本出错
//	20512	添加应用反馈失败
//	20513	client_id不能为空
//	20514	设备号不能为空
//	20515	反馈内容不能为空
//	20517	获取反馈回复失败
//	20518	添加以用户为中心的统计数据失败
//	20519	app_opentime,guide_detail,bookmark_detail至少要有一个参数不为空
//	20520	参数appid错误
//	20521	参数device_id错误
//	20522	ios,hd添加设备失败
//	-	-
//	20601	城市ID不能为空
//	20602	分类ID不能为空
//	20603	分类ID不合法
//	20604	此分类不存在
//	20605	获取城市信息失败
//	-	供应商
//	20701	供应商类别不能为空
//	20702	获取供应商列表失败
//	20703	获取供应商信息失败
//	20704	供应商ID不能为空
//	20705	供应商id列表不能为空
//	20706	设置个人供应商列表失败
//	20707	获取个人供应商列表失败
//	-	供应商评论、旅行汇首页
//	20801	评论内容不能为空
//	20802	评星不能为空
//	20803	添加供应商评论失败
//	20804	获取供应商评论列表失败
//	20806	不能重复评论
//	20807	获取旅行汇首页出错
//	-	锦囊
//	20901	获取锦囊分类错误
//	20902	获取锦囊列表错误
//	20904	锦囊ID不能为空
//	20905	获取锦囊评论失败
//	20906	锦囊评论内容不能为空
//	20907	错误的锦囊ID
//	20908	锦囊评论内容不能超过3000个字符
//	20909	添加锦囊评论失败
//	20910	添加锦囊下载日志失败
//	20911	获取移动端锦囊下载数量限制失败
//	20912	获取锦囊id列表失败
//	20913	获取锦囊下载数错误
//	20914	您发布的内容中包含敏感信息，无法提交，请进行修改
//	-	相册图片
//	21801	上传相册图片失败
//	21802	上传图片不能为空
//	21803	文件类型不支持
//	21804	图片上传失败
//	21805	获取七牛上传token失败
//	-	lastminute相关
//	21601	获取LastMinute列表失败
//	21602	获取LastMinute分类列表失败
//	21603	获取LastMinute推荐折扣列表失败
//	21604	获取LastMinute热门折扣列表失败
//	21606	获取LastMinute分页列表失败
//	21607	获取LastMinute详细信息失败
//	21608	获取折扣总分类失败
//	21609	lastminute添加收藏失败
//	21610	lastminute取消收藏失败
//	21611	获取lastminute收列表失败
//	21612	lastminute添加提醒条件失败
//	21613	lastminute取消提醒失败
//	21614	获取lastminute提醒条件列表失败
//	21615	获取折扣全部分类失败
//	21616	折扣提醒推送失败
//	21617	绑定用户到应用设备失败
//	21618	从应用设备解绑用户失败
//	21619	设备ID不能为空
//	21620	折扣id必须大于0
//	21621	用户不存在
//	21622	提醒条件id必须大于0
//	21623	类型时间国家必须有一个不是全部
//	21624	绑定用户到应用设备或从应用设备解绑用户时appid不存在
//	21625	获取热门国家失败
//	21626	参数id错误
//	-	mail相关
//	21201	发送邮件错误
//	21202	邮件标题不能为空
//	21203	收件邮箱不能为空
//	21204	邮件内容不能为空
//	-	运营接口
//	21401	获取运营图片失败
//	-	WINDOWS PHONE 推送
//	21301	系统版本不能为空
//	21302	MAC地址不能为空
//	21303	推送URI不能为空
//	20523	提交推送URI失败
//	-	城市指南
//	21701	城市指南ID不能为空
//	21702	获取城市指南置顶图失败
//	21703	获取地图下载链接失败
//	21704	获取城市指南运营位
//	-	plan相关
//	21901	获取plan列表失败
//	21902	参数错误
//	21903	获取更新时间失败
	
	
	
	private final int errorCode;

	public int getErrorCode() {
		return errorCode;
	}

	private MyNetErrorCodeEnum(int errorCode) {
		this.errorCode = errorCode;
	}

	public static MyNetErrorCodeEnum valueOfErrorCode(int errorCode) {
		for (MyNetErrorCodeEnum item : MyNetErrorCodeEnum.values()) {
			if (item.getErrorCode() == errorCode) {
				return item;
			}
		}

		if (errorCode > kNetErrorCodeEnum_HTTP_Error.getErrorCode() && errorCode < kNetErrorCodeEnum_Client_Error.getErrorCode()) {
			return kNetErrorCodeEnum_HTTP_Error;
		} else {
			return kNetErrorCodeEnum_NONE;
		}

	}
}
