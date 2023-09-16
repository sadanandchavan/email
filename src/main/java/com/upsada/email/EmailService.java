/**
 * 
 */
package com.upsada.email;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

/**
 * @author sadanand chavan
 *
 * May 22, 2021 10:19:00 AM
 */

@Service
public class EmailService {
	Properties props = new Properties();
	/**
	 * 
	 */
	public EmailService() {
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "mail.integratedhealing.co.in");
		   props.put("mail.smtp.port", "587");
		   
		   System.out.println("props ="+props);
		  	// TODO Auto-generated constructor stub
	}  
	   
	public void sendmail() throws AddressException, MessagingException, IOException {
		   //Sada220@ "Pulsar@220"
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("notification@integratedhealing.co.in", "Pulsar@220");
		      }
		   });
		   
		   System.out.println("session= "+session);
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress("notification@integratedhealing.co.in", "Integrated Healing"));

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("sadi.chavan@gmail.com"));
		   msg.setSubject("Password reset");
		   msg.setContent("Password reset code : 86768676878", "text/html");
		   msg.setSentDate(new Date());

		   System.out.println("msg1  = "+msg);
		   
		   
		   
		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent("Password reset code : 86768676878", "text/html");

		   //Multipart multipart = new MimeMultipart();
		   //multipart.addBodyPart(messageBodyPart);
		  // MimeBodyPart attachPart = new MimeBodyPart();

		   //attachPart.attachFile("/var/tmp/image19.png");
		   //multipart.addBodyPart(attachPart);
		   //msg.setContent(multipart);
		   Transport.send(msg);   
		   System.out.println("Transport Done....");
		}

}
