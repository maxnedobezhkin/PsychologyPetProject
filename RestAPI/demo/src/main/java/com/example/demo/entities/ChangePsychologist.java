package com.example.demo.entities;


public class ChangePsychologist {
	private String token;
	private Psychologist psychologist;
	
	public ChangePsychologist() {
		super();
	}
	
	public ChangePsychologist(String token, Psychologist psychologist) {
		super();
		this.token = token;
		this.psychologist = psychologist;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Psychologist getPsychologist() {
		return psychologist;
	}

	public void setPsychologist(Psychologist psychologist) {
		this.psychologist = psychologist;
	}

}
