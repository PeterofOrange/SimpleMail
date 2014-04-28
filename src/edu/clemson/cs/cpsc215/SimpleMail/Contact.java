//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the Serializable class and associated methods
package edu.clemson.cs.cpsc215.SimpleMail;

import java.io.Serializable;

public class Contact implements Serializable {
	
	private static final long serialVersionUID = -4738635381364334800L;
	private String name; 
	private String post;
	private String phone;
	private String email;
	
	/**
	 * gets the Contact's name
	 * 
	 * @return		the name of the Contact
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the Contact's name
	 * 
	 * @param name		the name of the Contact
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * gets the Contact's postal address
	 * 
	 * @return		the postal address of the Contact
	 */
	public String getPost() {
		return post;
	}
	
	/**
	 * sets the Contact's postal address
	 * 
	 * @param name		the postal address of the Contact
	 */
	public void setPost(String post) {
		this.post = post;
	}
	
	/**
	 * gets the Contact's phone number
	 * 
	 * @return		the phone number of the Contact
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * sets the Contact's phone number
	 * 
	 * @param name		the phone number of the Contact
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * gets the Contact's email address
	 * 
	 * @return		the email address of the Contact
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * sets the Contact's email address
	 * 
	 * @param name		the email address of the Contact
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Creates a Contact
	 * 
	 * @param name		the name of the Contact
	 * @param post		the postal address of the Contact
	 * @param phone		the phone number of the Contact
	 * @param email		the email address of the Contact
	 */
	public Contact(String name, String post, String phone, String email) {
		super();
		this.name = name;
		this.post = post;
		this.phone = phone;
		this.email = email;
	}
	
	/**
	 * Creates a Contact
	 * 
	 * @param name		the name of the Contact
	 * @param email		the email address of Contact
	 */
	public Contact(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

}