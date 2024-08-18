package com.kids.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String uname;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private Long mobno;
	private String childAge;
	
	@ElementCollection
	private List<Long> blockedvideosid;

	@ElementCollection
	private List<String> blockedcatid;
	
	public Users() {
		super();
	}

	public Users(int id, String uname, String fname, String lname, String email, String password, Long mobno,
			String childAge, List<Long> blockedvideosid, List<String> blockedcatid) {
		super();
		this.id = id;
		this.uname = uname;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.mobno = mobno;
		this.childAge = childAge;
		this.blockedvideosid = blockedvideosid;
		this.blockedcatid = blockedcatid;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", uname=" + uname + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", password=" + password + ", mobno=" + mobno + ", childAge=" + childAge + ", blockedvideosid="
				+ blockedvideosid + ", blockedcatid=" + blockedcatid + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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

	public Long getMobno() {
		return mobno;
	}

	public void setMobno(Long mobno) {
		this.mobno = mobno;
	}

	public String getChildAge() {
		return childAge;
	}

	public void setChildAge(String childAge) {
		this.childAge = childAge;
	}

	public List<Long> getBlockedvideosid() {
		return blockedvideosid;
	}

	public void setBlockedvideosid(List<Long> blockedvideosid) {
		this.blockedvideosid = blockedvideosid;
	}

	public List<String> getBlockedcatid() {
		return blockedcatid;
	}

	public void setBlockedcatid(List<String> blockedcatid) {
		this.blockedcatid = blockedcatid;
	}
	
}
