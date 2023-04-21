package com.rohit.blog.payloads;

import org.springframework.http.HttpStatus;

public class ApiResponse {

	private String message;
	private Boolean success;
	
	public ApiResponse() {
		
	}
	public ApiResponse(String message , Boolean success) {
		this.message = message;
		this.success = success;
		
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
