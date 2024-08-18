package com.kids.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Creator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String creatorname;
	private String channelname;
	private String email;
	private String password;
	
	public Creator() {
		super();
	}

	public Creator(int id, String creatorname, String channelname, String email, String password) {
		super();
		this.id = id;
		this.creatorname = creatorname;
		this.channelname = channelname;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Creator [id=" + id + ", creatorname=" + creatorname + ", channelname=" + channelname + ", email="
				+ email + ", password=" + password + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreatorname() {
		return creatorname;
	}

	public void setCreatorname(String creatorname) {
		this.creatorname = creatorname;
	}

	public String getChannelname() {
		return channelname;
	}

	public void setChannelname(String channelname) {
		this.channelname = channelname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
