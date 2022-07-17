package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="doctors_contact")
public class Contacts {
	@Id
	private int id;
	private ArrayList<String> phones;
	private ArrayList<String> emails;
	private String site;
	private String telegramm;
	
//	@OneToOne(mappedBy = "contacts", optional = false)
//	private Psychologist psychologist;

	public Contacts() {
	}

	public Contacts(int id, ArrayList<String> phones, ArrayList<String> emails, String site, String telegramm) {
		super();
		this.id = id;
		this.phones = phones;
		this.emails = emails;
		this.site = site;
		this.telegramm = telegramm;
	}

	public Contacts(ArrayList<String> phones, ArrayList<String> emails, String site, String telegramm) {
		super();
		this.phones = phones;
		this.emails = emails;
		this.site = site;
		this.telegramm = telegramm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<String> getPhones() {
		return phones;
	}

	public void setPhones(ArrayList<String> phones) {
		this.phones = phones;
	}

	public ArrayList<String> getEmails() {
		return emails;
	}

	public void setEmails(ArrayList<String> emails) {
		this.emails = emails;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getTelegramm() {
		return telegramm;
	}

	public void setTelegramm(String telegramm) {
		this.telegramm = telegramm;
	}

	@Override
	public String toString() {
		return "Contacts [id=" + id + ", phones=" + phones + ", emails=" + emails + ", site=" + site + ", telegramm="
				+ telegramm + "]";
	}
}
