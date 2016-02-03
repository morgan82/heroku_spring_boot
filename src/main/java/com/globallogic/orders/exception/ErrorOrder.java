package com.globallogic.orders.exception;

public class ErrorOrder {
	
	private String message;
	
	private String code;

	public ErrorOrder() {
		super();
	}
	
	public ErrorOrder(String message, String code){
		super();
		this.message = message;
		this.code = code;
	}
	
	
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
