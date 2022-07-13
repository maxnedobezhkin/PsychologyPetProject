package com.example.demo.security.jwt;

public class JwtRequest {
	private String login;
	private String password;
	
	public JwtRequest() {
		super();
	}

	public JwtRequest(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "JwtRequest [login=" + login + ", password=" + password + "]";
	}
	
}
