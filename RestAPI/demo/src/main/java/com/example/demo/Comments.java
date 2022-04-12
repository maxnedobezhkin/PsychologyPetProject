package com.example.demo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comments {
	@Id
	private int id;
	private String comments;
	
//	@OneToMany(mappedBy = "comments")
//	private Set<Psychologist> psychologist;
	
	
	public Comments() {
		super();
	}

	public Comments(int id, String comments) {
		super();
		this.id = id;
		this.comments = comments;
	}

	public Comments(String comments) {
		super();
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", comments=" + comments + "]";
	}
}
