/**
 * 
 */
package com.upsada.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @author sadanand chavan
 *
 * May 11, 2021 12:41:51 PM
 */
public class EmailServiceImpl {
	
	@Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(
        String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("noreply@baeldung.com");
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
    }

}
