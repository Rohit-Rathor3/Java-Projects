package com.rohit.blog.security;

import lombok.Data;

@Data
public class JwtAuthResponse {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public JwtAuthResponse(){
		
	}
	
}
