package com.scb.sgml.demospringbootapp.config;

import org.springframework.http.HttpStatus;

public class APISuccessPayload {

	String message;
	int status;
	String httpStatus;
	boolean success;
	boolean exception;
	Object body;
	
	@Override
	public String toString() {
		return "APISuccessPayload [message=" + message + ", status=" + status + ", httpStatus=" + httpStatus
				+ ", success=" + success + ", exception=" + exception + ", body=" + body + "]";
	}

	public APISuccessPayload() {
		
	}
	
	public APISuccessPayload(String message, int status, String httpStatus, boolean success, boolean exception,
			Object body) {
		this.message = message;
		this.status = status;
		this.httpStatus = httpStatus;
		this.success = success;
		this.exception = exception;
		this.body = body;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public boolean isException() {
		return exception;
	}
	public void setException(boolean exception) {
		this.exception = exception;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	
	
	public static APISuccessPayload build(Object body, String message, HttpStatus status) {
		
		APISuccessPayload payload = new APISuccessPayload();
		payload.setBody(body);
		payload.setMessage(message);
		payload.setStatus(status.value());
		payload.setHttpStatus(String.valueOf(status));
		payload.setSuccess(true);
		payload.setException(false);
		return payload;
	}
	
}
