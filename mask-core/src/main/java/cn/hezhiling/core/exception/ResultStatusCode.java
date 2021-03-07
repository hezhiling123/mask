package cn.hezhiling.core.exception;

public enum ResultStatusCode {
	/**
	 * OK
	 */
	OK("200", "OK"),
	/**
	 * 1XX错误
	 */
	HTTP_ERROR_100("100", "1XX错误"),
	/**
	 * 3XX错误
	 */
	HTTP_ERROR_300("300", "3XX错误"),
	/**
	 * 4XX错误
	 */
	HTTP_ERROR_400("400", "4XX错误"),
	/**
	 * 5XX错误
	 */
	HTTP_ERROR_500("500", "5XX错误"),
	/**
	 * 签名错误
	 */
	SIGN_ERROR("120", "签名错误"),
	/**
	 * 访问超时
	 */
	TIME_OUT("130", "访问超时"),
	/**
	 * 您已经在其他地方登录
	 */
	KICK_OUT("300", "您已经在其他地方登录，请重新登录！"),
	/**
	 * 参数解析失败
	 */
	BAD_REQUEST("407", "参数解析失败"),
	/**
	 * 无效的授权码
	 */
	INVALID_TOKEN("401", "无效的授权码"),
	/**
	 * 无效的密钥
	 */
	INVALID_CLIENTID("402", "无效的密钥"),
	/**
	 * 访问地址不存在
	 */
	REQUEST_NOT_FOUND("404", "访问地址不存在！"),
	/**
	 * 不支持当前请求方法
	 */
	METHOD_NOT_ALLOWED("405", "不支持当前请求方法"),
	/**
	 * 请求重复提交
	 */
	REPEAT_REQUEST_NOT_ALLOWED("406", "请求重复提交"),
	/**
	 * 服务器运行异常
	 */
	SYSTEM_ERR("500", "服务器运行异常"),
	/**
	 * 该用户不存在或密码错误
	 */
	NOT_EXIST_USER_OR_ERROR_PWD("10000", "该用户不存在或密码错误"),
	/**
	 * 用户名或密码为空
	 */
	NOT_PARAM_USER_OR_ERROR_PWD("10006", "用户名或密码为空"),
	/**
	 * 该用户已登录
	 */
	LOGINED_IN("10001", "该用户已登录"),
	/**
	 * 该用户不存在
	 */
	NOT_EXIST_BUSINESS("10002", "该用户不存在"),
	/**
	 * 登录异常
	 */
	SHIRO_ERROR("10003", "登录异常"),
	/**
	 * 您没有该权限
	 */
	UNAUTHO_ERROR("10004", "您没有该权限"),
	/**
	 * redis异常
	 */
	REDIS_ERROR("10006", "redis异常"),
	/**
	 * redis连接异常
	 */
	REDIS_CONNECT_ERROR("10007", "redis连接异常"),
	/**
	 * 请绑定手机号
	 */
	BIND_PHONE("10010", "请绑定手机号"),
	/**
	 * 上传文件异常
	 */
	UPLOAD_ERROR("20000", "上传文件异常"),
	/**
	 * 无效的验证码
	 */
	INVALID_CAPTCHA("30005", "无效的验证码"),
	/**
	 * 该用户已被冻结
	 */
	USER_FROZEN("40000", "该用户已被冻结"),

	USER_BIND_ERROR("40002","该第三方账号未绑定用户");

	private String code;
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	ResultStatusCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}