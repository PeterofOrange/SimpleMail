//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the Configuration class and associated methods
package edu.clemson.cs.cpsc215.SimpleMail;

import java.io.Serializable;

public class Configuration implements Serializable {

	private static final long serialVersionUID = -3397949010748837896L;
	private String myMail;
	private String smtpServ;

	/**
	 * Gets the email address for a Configuration
	 * 
	 * @return		the email address associated for this Configuration
	 */
	public String getEmail() {
		return myMail;
	}
	
	/**
	 * Sets the email address for a Configuration
	 * 
	 * @param		myMail the email address to set
	 */
	public void setEmail(String myMail) {
		this.myMail = myMail;
	}
	
	/**
	 * Gets the SMTP server's address for a Configuration
	 * 
	 * @return		the SMTP server's address for this Configuration
	 */
	public String getSmtpServ() {
		return smtpServ;
	}
	
	/**
	 * Sets the SMTP server's address for a Configuration
	 * 
	 * @param smtpServ		the SMTP server to set
	 */
	public void setSmtpServ(String smtpServ) {
		this.smtpServ = smtpServ;
	}
	
	//use Configuration() then setMail() instead to save a function or two, maybe, could delete this
	/**
	 * Creates a Configuration an email address
	 * 
	 * @param myMail		the email address for this Configuration
	 */
	public Configuration(String myMail) {
		super();
		this.myMail = myMail;
	}
	
	/**
	 * Creates a Configuration
	 */
	public Configuration() {
		super();
	}

}