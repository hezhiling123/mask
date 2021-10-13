package cn.hezhiling.core.exception;

public class MaskRuntimeException extends RuntimeException {
	private String code;
	private String msg;

	public MaskRuntimeException(Throwable t) {
		super(t);
		this.msg = ResultStatusCode.HTTP_ERROR_500.getMsg();
		this.code = ResultStatusCode.HTTP_ERROR_500.getCode();
	}

	public MaskRuntimeException(String msg) {
		super(msg);
		this.msg = msg;
		this.code = ResultStatusCode.HTTP_ERROR_400.getCode();
	}

	public MaskRuntimeException(ResultStatusCode resultStatusCode) {
		this.msg = resultStatusCode.getMsg();
		this.code = resultStatusCode.getCode();
	}

	public MaskRuntimeException(String code, String msg) {
		this.msg = msg;
		this.code = code;
	}

	public MaskRuntimeException(ResultStatusCode resultStatusCode, String msg) {
		this.code = resultStatusCode.getCode();
		this.msg = resultStatusCode.getMsg();
	}

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
}
