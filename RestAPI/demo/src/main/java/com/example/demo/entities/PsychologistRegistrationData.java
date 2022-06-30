package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "psychologist_registration_data")
public class PsychologistRegistrationData {
	@Id
	private int id;
	private String login;
	private String password;
	@OneToOne
//	(cascade = CascadeType.ALL)
	@JoinColumn(name="psychologist_id")
//	@MapsId
	private Psychologist psychologist;
	
	public PsychologistRegistrationData() {
		super();
	}

	public PsychologistRegistrationData(int id, String login, String password, Psychologist psychologist) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.psychologist = psychologist;
	}

	public PsychologistRegistrationData(String login, String password, Psychologist psychologist) {
		super();
		this.login = login;
		this.password = password;
		this.psychologist = psychologist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Psychologist getPsychologist() {
		return psychologist;
	}

	public void setPsychologist(Psychologist psychologist) {
		this.psychologist = psychologist;
	}

	@Override
	public String toString() {
		return "PsychologistRegistrationData [id=" + id + ", login=" + login + ", password=" + password
				+ ", psychologist=" + psychologist + "]";
	}
	
	
	
}
