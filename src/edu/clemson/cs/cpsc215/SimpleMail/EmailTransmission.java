//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 28 2014
//Assignment 4: SimpleMail
//This file contains the EmailUtils class and associated methods
package edu.clemson.cs.cpsc215.SimpleMail;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class EmailTransmission {

	private ArrayList<String> to = new ArrayList<String>();
	private ArrayList<String> cc = new ArrayList<String>();
	private ArrayList<String> bcc = new ArrayList<String>();
	private String message;
	private String subject;

	/**
	 * sends an email using the associated EmailTransmission object
	 * 
	 * @throws Exception
	 *             If the email sending encounters a fatal error
	 */
	public void sendEmail() throws Exception {

		Configuration config = DataStore.getDataStore().getConfig();
		String serverAddr = config.getServerAddr();
		String fromAddr = config.getEmail();

		if (serverAddr == null || serverAddr == "") {
			ErrorDlg.showError("Could not send email: server address incorrect");
		} else if (fromAddr == null || fromAddr == "") {
			ErrorDlg.showError("Could not send email: from address incorrect");
		}

		Properties props = new Properties();
		props.put("mail.smtp.host", serverAddr);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", config.getServerPort());
		Authenticator auth = new Authenticator();

		Session ses = Session.getDefaultInstance(props, auth);
		Message msg = new MimeMessage(ses);

		try {
			for (int c = 0; c < to.size(); c++) {
				if (!to.get(c).equals("")) {
					msg.addRecipient(RecipientType.TO,
							new InternetAddress(to.get(c)));
					// System.out.println(cc.get(c));
				}
			}
			// System.out.println(cc.size());
			for (int c = 0; c < cc.size(); c++) {
				if (!cc.get(c).equals("")) {
					// System.out.println(cc.get(c));
					msg.addRecipient(RecipientType.CC,
							new InternetAddress(cc.get(c)));
				}
			}
			for (int c = 0; c < bcc.size(); c++) {
				if (!bcc.get(c).equals("")) {
					// System.out.println(bcc.get(c));
					msg.addRecipient(RecipientType.BCC,
							new InternetAddress(bcc.get(c)));
				}
			}
			msg.setSubject(subject);
			msg.setText(message);
			msg.setFrom(new InternetAddress(fromAddr));
			Transport.send(msg);
		} catch (AddressException e) {
			ErrorDlg.showError("Could not send email: invalid to Address");
		} catch (MessagingException e) {
			ErrorDlg.showError("Could not send email");
			e.printStackTrace();
		}

	}

	/**
	 * gets the To addresses to send email to
	 * 
	 * @return the To addresses to send email to
	 */
	public ArrayList<String> getTo() {
		return to;
	}

	/**
	 * adds a To address to send email to
	 * 
	 * @param newto
	 *            the To address to add
	 */
	public void addTo(String newto) {
		to.add(newto);
	}

	/**
	 * gets the CC addresses to CC email to
	 * 
	 * @return the list of CC addresses
	 */
	public ArrayList<String> getCc() {
		return cc;
	}

	/**
	 * adds a CC address to CC email to
	 * 
	 * @param newcc
	 *            the CC addresses to add
	 */
	public void addCc(String newcc) {
		cc.add(newcc);
	}

	/**
	 * gets the list of BCC addresses to BCC email to
	 * 
	 * @return the list of BCC address
	 */
	public ArrayList<String> getBcc() {
		return bcc;
	}

	/**
	 * adds a BCC address to BCC email to
	 * 
	 * @param newbcc
	 *            the BCC address to add
	 */
	public void addBcc(String newbcc) {
		bcc.add(newbcc);
	}

	/**
	 * clears all of the recipient fields fields (BCC, CC, To)
	 */
	public void clearRecipients() {
		bcc.clear();
		cc.clear();
		to.clear();
	}

	/**
	 * gets the subject to be send for an email
	 * 
	 * @return the subject of the email
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * sets the subject to be used for an email
	 * 
	 * @param newsubject
	 *            the subject to set for the email
	 */
	public void setSubject(String newsubject) {
		subject = newsubject;
	}

	/**
	 * gets the message to be sent with an email
	 * 
	 * @return the message to be sent with an email
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * sets the message to send with an email
	 * 
	 * @param message
	 *            the text for the email message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	private class Authenticator extends javax.mail.Authenticator {
		private PasswordAuthentication authentication;

		public Authenticator() {
			Configuration config = DataStore.getDataStore().getConfig();
			String username = config.getEmail();
			String password = config.getPassword();
			authentication = new PasswordAuthentication(username, password);
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return authentication;
		}
	}
}