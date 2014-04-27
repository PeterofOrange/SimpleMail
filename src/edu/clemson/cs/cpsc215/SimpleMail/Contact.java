package edu.clemson.cs.cpsc215.SimpleMail;

import java.io.Serializable;

public class Contact implements Serializable{
	
	private static final long serialVersionUID = -4738635381364334800L;
	private String name;
	private String post;
	private String phone;
	private String email;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPost() {
		return post;
	}
	
	public void setPost(String post) {
		this.post = post;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Contact(String name, String post, String phone, String email) {
		super();
		this.name = name;
		this.post = post;
		this.phone = phone;
		this.email = email;
	}
	
	public Contact(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

}