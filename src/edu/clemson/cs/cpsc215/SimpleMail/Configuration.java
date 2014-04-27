package edu.clemson.cs.cpsc215.SimpleMail;

import java.io.Serializable;

public class Configuration implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3397949010748837896L;
	private String myMail;
	private long smtpServ;

	public String getMail() {
		return myMail;
	}
	public void setMail(String myMail) {
		this.myMail = myMail;
	}
	public long getSmtpServ() {
		return smtpServ;
	}
	public void setSmtpServ(long smtpServ) {
		this.smtpServ = smtpServ;
	}
	public Configuration(String myMail) {
		super();
		this.myMail = myMail;
	}

}