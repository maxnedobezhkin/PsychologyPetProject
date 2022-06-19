package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "receptions")
public class Receptions {
	@Id
	private int id;
	private String address;
	private String url;
	
	public Receptions() {
		super();
	}

	public Receptions(int id, String address, String url) {
		super();
		this.id = id;
		this.address = address;
		this.url = url;
	}

	public Receptions(String address, String url) {
		super();
		this.address = address;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Receptions [id=" + id + ", address=" + address + ", url=" + url + "]";
	}
}
