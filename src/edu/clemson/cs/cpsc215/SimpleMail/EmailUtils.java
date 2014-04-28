//Parker Davis (parkerd), Peter Schatteman (prschat), Phillip Schneider (pschnei)
//Last Modified: Apr 27 2014
//Assignment 4: SimpleMail
//This file contains the EmailUtils class and associated methods
package edu.clemson.cs.cpsc215.SimpleMail;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class EmailUtils {
	
	private ArrayList<String> to = new ArrayList<String>();
	private ArrayList<String> cc = new ArrayList<String>();
	private ArrayList<String> bcc = new ArrayList<String>();
	private String message;
	private String subject;
	
	public void sendEmail() {

		Configuration config = DataStore.getDataStore().getConfig();
		String serv = config.getSmtpServ();
		String fromAddr = config.getMail();
		
//		if (serv == null || serv == "") {
//			("Cannot send email: No SMTP server set.");
//		}
//		else if (fromAddr == null || fromAddr == "") {
//			("Cannot send email: Email address (from) not set.");
//		}
		
		Properties props = new Properties();
		props.put("mail.smtp.host", serv);
		
		Session ses = Session.getDefaultInstance(props, null);
		Message msg = new MimeMessage(ses);
		
		try {
			for(int c = 0; c < to.size(); c++) {
				msg.setRecipient(RecipientType.TO,  new InternetAddress(to.get(c)));
			}
			for(int c = 0; c < cc.size(); c++) {
				msg.setRecipient(RecipientType.CC, new InternetAddress(cc.get(c)));
			}
			for(int c = 0; c < bcc.size(); c++) {
				msg.setRecipient(RecipientType.BCC, new InternetAddress(bcc.get(c)));
			}
			msg.setSubject(subject);
			msg.setText(message);
			msg.setFrom(new InternetAddress(fromAddr));
			Transport.send(msg);
		} catch (AddressException e) {
			System.out.println("Error: invalid Address.");
			//e.printStackTrace();
		} catch (MessagingException e) {
			System.out.println("Error: could not send message.");
			//e.printStackTrace();
		}
		
	}

	public ArrayList<String> getTo() {
		return to;
	}

	public void addTo(String newto) {
		to.add(newto);
	}

	public ArrayList<String> getCc() {
		return cc;
	}

	public void addCc(String newcc) {
		cc.add(newcc);
	}

	public ArrayList<String> getBcc() {
		return bcc;
	}

	public void addBcc(String newbcc) {
		bcc.add(newbcc);
	}
	
	public void clearRecipients(){
		bcc.clear();
		cc.clear();
		to.clear();
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String newsubject) {
		subject = newsubject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}