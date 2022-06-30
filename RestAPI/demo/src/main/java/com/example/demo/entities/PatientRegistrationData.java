package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient_registration_data")
public class PatientRegistrationData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String lastname;
	private String login;
	private String password;
	
	@OneToOne
	@MapsId
	private Patient patient;

	public PatientRegistrationData() {
		super();
	}

	public PatientRegistrationData(String name, String lastname, String login, String password, Patient patient) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.login = login;
		this.password = password;
		this.patient = patient;
	}

	public PatientRegistrationData(int id, String name, String lastname, String login, String password,
			Patient patient) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "PatientRegistrationData [id=" + id + ", name=" + name + ", lastname=" + lastname + ", login=" + login
				+ ", password=" + password + ", patient=" + patient + "]";
	}
	
	
}
