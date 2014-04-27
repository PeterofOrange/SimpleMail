package edu.clemson.cs.cpsc215.SimpleMail;

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
	
	public static void  sendEmail(String toAddr, String ccAddr, String bccAddr, String subject, String message) {

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
			msg.setRecipient(RecipientType.TO,  new InternetAddress(toAddr));
			msg.setRecipient(RecipientType.CC, new InternetAddress(ccAddr));
			msg.setRecipient(RecipientType.BCC, new InternetAddress(bccAddr));
			msg.setSubject(subject);
			msg.setText(message);
			msg.setFrom(new InternetAddress(fromAddr));
			Transport.send(msg);
		} catch (AddressException e) {
			System.out.println("Error: invalid Address.");
			e.printStackTrace();
		} catch (MessagingException e) {
			System.out.println("Error: could not send message.");
			e.printStackTrace();
		}
		
	}
}
