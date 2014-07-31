package org.yo.web;

public class ServerResponse {

	private Long retCode;
	private String message;
	private Object data;
	public Long getRetCode() {
		return retCode;
	}
	public void setRetCode(Long retCode) {
		this.retCode = retCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

}
