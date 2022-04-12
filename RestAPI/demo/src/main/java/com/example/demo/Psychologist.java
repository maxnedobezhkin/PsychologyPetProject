package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="doctors")
public class Psychologist {	
	@Id
//	@SequenceGenerator (
//			name = "psychologist_name",
//			sequenceName = "psychologist_name",
//			allocationSize = 1
//	)
//	@GeneratedValue(
//			strategy = GenerationType.SEQUENCE,
//			generator = "psychologist_name"
//	)
	private int id;
	private String name;
	private String country;
	private String region;
	private String therapies;
	
	@ManyToOne
	@JoinColumn(name="comments_id")
	private Comments comments;
	
	@OneToOne
	@JoinColumn(name="contacts_id")
	private Contacts contacts;
	
	@OneToOne
	@JoinColumn(name="receptions_id")
	private Receptions receptions;

	public Psychologist() {
		super();
	}

	public Psychologist(int id, String name, String country, String region, String therapies, Comments comments,
			Contacts contacts, Receptions receptions) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.region = region;
		this.therapies = therapies;
		this.comments = comments;
		this.contacts = contacts;
		this.receptions = receptions;
	}

	public Psychologist(String name, String country, String region, String therapies, Comments comments,
			Contacts contacts, Receptions receptions) {
		super();
		this.name = name;
		this.country = country;
		this.region = region;
		this.therapies = therapies;
		this.comments = comments;
		this.contacts = contacts;
		this.receptions = receptions;
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

	public String getTherapies() {
		return therapies;
	}

	public void setTherapies(String therapies) {
		this.therapies = therapies;
	}

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	public Contacts getContacts() {
		return contacts;
	}

	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}

	public Receptions getReceptions() {
		return receptions;
	}

	public void setReceptions(Receptions receptions) {
		this.receptions = receptions;
	}

	@Override
	public String toString() {
		return "Psychologist [id=" + id + ", name=" + name + ", country=" + country + ", region=" + region
				+ ", therapies=" + therapies + ", comments=" + comments + ", contacts=" + contacts + ", receptions="
				+ receptions + "]";
	}

	
	
}
