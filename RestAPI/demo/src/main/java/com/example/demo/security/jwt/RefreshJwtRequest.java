package com.example.demo.security.jwt;


public class RefreshJwtRequest {

	public String refreshToken;

	public RefreshJwtRequest() {
		super();
	}

	public RefreshJwtRequest(String refreshToken) {
		super();
		this.refreshToken = refreshToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
	
}
