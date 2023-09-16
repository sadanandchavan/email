
package com.upsada.email;

import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sadanand chavan
 *
 * May 11, 2021 12:44:08 PM
 */

@RestController
public class EmailController {
	
	@Autowired 
	EmailService emailService;
	
	@RequestMapping(value = "/resetPassword/emailId")
	   public String resetPasswordSendEmail() {
		try {
			System.out.println("sendemail start.");

			Hashtable<String, String> resetPassHashtable = new Hashtable<String, String>();
			
			resetPassHashtable.put(key, value);
			
			
			emailService.sendmail();
			System.out.println("sendemail end.");
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      return "Email sent successfully";
	   }  
	

		
}
