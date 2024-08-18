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
	
	private String category_name;

	public Category() {
		super();
	}

	public Category(int id, String category_name) {
		super();
		this.id = id;
		this.category_name = category_name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", category_name=" + category_name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

}
