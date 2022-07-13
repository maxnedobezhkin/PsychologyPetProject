package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient_registration_data")
public class PatientRegistrationData extends User{
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String login;
	private String password;
	
	@OneToOne
//	@MapsId
	@JoinColumn(name="patient_id")
	private Patient patient;

	public PatientRegistrationData() {
		super();
	}

	public PatientRegistrationData(int id, String login, String password, Patient patient) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.patient = patient;
	}

	public PatientRegistrationData(String login, String password, Patient patient) {
		super();
		this.login = login;
		this.password = password;
		this.patient = patient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String getLogin() {
		return login;
	}

	@Override
	public void setLogin(String login) {
		this.login = login;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "PatientRegistrationData [id=" + id + ", login=" + login + ", password=" + password + ", patient="
				+ patient + "]";
	}
	
	
	
}
