package com.example.demo.security.jwt;

public class JwtResponse {
	private final String type = "Bearer";
	private String accessToken;
	private String refreshToken;
	
	public JwtResponse() {
		super();
	}

	public JwtResponse(String accessToken, String refreshToken) {
		super();
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "JwtResponse [type=" + type + ", accessToken=" + accessToken + ", refreshToken=" + refreshToken + "]";
	}
	
	
}
