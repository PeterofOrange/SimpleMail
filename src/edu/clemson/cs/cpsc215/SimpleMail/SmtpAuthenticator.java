package edu.clemson.cs.cpsc215.SimpleMail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SmtpAuthenticator extends Authenticator {
	private Configuration config = DataStore.getDataStore().getConfig();
	private String username = config.getEmail();
	private String password = config.getPassword();

	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}

}