package com.example.demo;

import java.sql.Blob;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="image")
public class Image {
	@Id 
	private Long id;
	
	private Blob imageContent;

	public Image() {
		super();
	}

	public Image(Long id, Blob imageContent) {
		super();
		this.id = id;
		this.imageContent = imageContent;
	}

	public Image(Blob imageContent) {
		super();
		this.imageContent = imageContent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Blob getImageContent() {
		return imageContent;
	}

	public void setImageContent(Blob imageContent) {
		this.imageContent = imageContent;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", imageContent=" + imageContent + "]";
	}
}
