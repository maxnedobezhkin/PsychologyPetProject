package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String lastname;
	private String country;
	private String region;
	private String email;
	private String phone;
	
	public Patient() {
		super();
	}

	public Patient(int id, String name, String lastname, String country, String region, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.country = country;
		this.region = region;
		this.email = email;
		this.phone = phone;
	}

	public Patient(String name, String lastname, String country, String region, String email, String phone) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.country = country;
		this.region = region;
		this.email = email;
		this.phone = phone;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", lastname=" + lastname + ", country=" + country + ", region="
				+ region + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
}
