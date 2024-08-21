package com.kids.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String description;
	private String title;

	@Lob
	@Column(length = 104857600)
	private byte[] videofile;
	
	@Lob
	@Column(length = 104857600)
	private byte[] image;
	
	@ManyToOne
	@JoinColumn(name = "creator_id")
	private Creator creator;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	private boolean status;
	private String agelevel;

	public Video() {
		super();
	}

	public Video(int id, String description, String title, byte[] videofile, byte[] image, Creator creator,
			Category category, boolean status, String agelevel) {
		super();
		this.id = id;
		this.description = description;
		this.title = title;
		this.videofile = videofile;
		this.image = image;
		this.creator = creator;
		this.category = category;
		this.status = status;
		this.agelevel = agelevel;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", description=" + description + ", title=" + title + ", videofile="
				+ Arrays.toString(videofile) + ", image=" + Arrays.toString(image) + ", creator=" + creator
				+ ", category=" + category + ", status=" + status + ", agelevel=" + agelevel + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getVideofile() {
		return videofile;
	}

	public void setVideofile(byte[] videofile) {
		this.videofile = videofile;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Creator getCreator() {
		return creator;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getAgelevel() {
		return agelevel;
	}

	public void setAgelevel(String agelevel) {
		this.agelevel = agelevel;
	}
	
}
