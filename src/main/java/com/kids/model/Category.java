package com.kids.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String categoryname;

	public Category() {
		super();
	}

	public Category(int id, String categoryname) {
		super();
		this.id = id;
		this.categoryname = categoryname;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryname=" + categoryname + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	

}
