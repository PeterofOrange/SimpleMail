//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the Configuration class and associated methods
package edu.clemson.cs.cpsc215.SimpleMail;

import java.io.Serializable;

public class Configuration implements Serializable {

	private static final long serialVersionUID = -3397949010748837896L;
	private String senderEmail;
	private String senderPassword;
	private String serverAddr;
	private String serverPort;
	

	/**
	 * Gets the email address for a Configuration
	 * 
	 * @return		the email address associated for this Configuration
	 */
	public String getEmail() {
		return senderEmail;
	}
	
	/**
	 * Sets the email address for a Configuration
	 * 
	 * @param		senderEmail the email address to set
	 */
	public void setEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	
	/**
	 * Gets the SMTP server's address for a Configuration
	 * 
	 * @return		the SMTP server's address for this Configuration
	 */
	public String getserverAddr() {
		return serverAddr;
	}
	
	/**
	 * Gets the email password for a Configuration
	 * 
	 * @return		the email password associated for this Configuration
	 */
	public String getPassword() {
		return senderPassword;
	}
	
	/**
	 * Sets the email password for a Configuration
	 * 
	 * @param		senderPassword the email password to set
	 */
	public void setPassword(String senderPassword) {
		this.senderPassword = senderPassword;
	}
	
	/**
	 * Sets the SMTP server's address for a Configuration
	 * 
	 * @param serverAddr		the SMTP server to set
	 */
	public void setServerAddr(String serverAddr) {
		this.serverAddr = serverAddr;
	}
	
	/**
	 * Gets the SMTP server's address for a configuration
	 * 
	 * 
	 * @return		the SMTP server's address for this configuration
	 */
	public String getServerAddr() {
		return serverAddr;
	}
	
	/**
	 * Sets the SMTP server's port for a Configuration
	 * 
	 * @param serverAddr		the SMTP server port to set
	 */
	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}
	
	/**
	 * Gets the SMTP server's port for a configuration
	 * 
	 * 
	 * @return		the SMTP server's port for this configuration
	 */
	public String getServerPort() {
		return serverPort;
	}
	
	/**
	 * Creates a Configuration an email address
	 * 
	 * @param senderEmail		the email address for this Configuration
	 */
	public Configuration(String senderEmail) {
		super();
		this.senderEmail = senderEmail;
	}
	
	/**
	 * Creates a Configuration
	 */
	public Configuration() {
		super();
	}
}