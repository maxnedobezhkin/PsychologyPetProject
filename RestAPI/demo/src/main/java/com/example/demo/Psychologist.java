package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="doctors")
@SecondaryTables({
	@SecondaryTable(name="comments_list",
			pkJoinColumns=@PrimaryKeyJoinColumn(name="user_id")),
	@SecondaryTable(name="receptions",
			pkJoinColumns=@PrimaryKeyJoinColumn(name="user_id")),
	@SecondaryTable(name="therapies",
			pkJoinColumns=@PrimaryKeyJoinColumn(name="user_id")),
	@SecondaryTable(name="doctor_contact",
			pkJoinColumns=@PrimaryKeyJoinColumn(name="user_id"))
	
})

public class Psychologist {	
	@Id
	@SequenceGenerator (
			name = "psychologist_name",
			sequenceName = "psychologist_name",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "psychologist_name"
	)
	private int id;
	private String name;
	private String country;
	private String region;
	
	@Column(name="comments", table="comments_list")
	private String comments;
	
	@Column(name="address", table="receptions")
	private String address;
	
	@Column(name="url", table="receptions")
	private String url;
	
	@Column(name="phones", table="doctor_contact")
	private String[] phones;
	
	@Column(name="emails", table="doctor_contact")
	private String[] emails;
	
	@Column(name="site", table="doctor_contact")
	private String site;
	
	@Column(name="telegram", table="doctor_contact")
	private String telegram;
	
	@Column(name="therapies", table="therapies")
	private String therapy;
	
	
	public Psychologist() {
	}


	public Psychologist(int id, 
						String name, 
						String country, 
						String region, 
						String comments, 
						String address, 
						String url,
						String[] phones,
						String[] emails,
						String site,
						String telegram, 
						String therapy) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.region = region;
		this.comments = comments;
		this.address = address;
		this.url = url;
		this.phones = phones;
		this.emails = emails;
		this.site = site;
		this.telegram = telegram;
		this.therapy = therapy;
	}


	public Psychologist(String name, 
						String country, 
						String region, 
						String comments, 
						String address, 
						String url,
						String[] phones, 
						String[] emails, 
						String site, 
						String telegram, 
						String therapy) {
		super();
		this.name = name;
		this.country = country;
		this.region = region;
		this.comments = comments;
		this.address = address;
		this.url = url;
		this.phones = phones;
		this.emails = emails;
		this.site = site;
		this.telegram = telegram;
		this.therapy = therapy;
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


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
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


	public String[] getPhones() {
		return phones;
	}


	public void setPhones(String[] phones) {
		this.phones = phones;
	}


	public String[] getEmails() {
		return emails;
	}


	public void setEmails(String[] emails) {
		this.emails = emails;
	}


	public String getSite() {
		return site;
	}


	public void setSite(String site) {
		this.site = site;
	}


	public String getTelegram() {
		return telegram;
	}


	public void setTelegram(String telegram) {
		this.telegram = telegram;
	}


	public String getTherapy() {
		return therapy;
	}


	public void setTherapy(String therapy) {
		this.therapy = therapy;
	}


	@Override
	public String toString() {
		return "Psychologist [id=" + id + ", name=" + name + ", country=" + country + ", region=" + region
				+ ", comments=" + comments + ", address=" + address + ", url=" + url + ", phones="
				+ Arrays.toString(phones) + ", emails=" + Arrays.toString(emails) + ", site=" + site + ", telegram="
				+ telegram + ", therapy=" + therapy + "]";
	}
	
}
