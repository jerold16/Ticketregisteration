package org.JTravels.Reservation_Api.service;

import org.JTravels.Reservation_Api.Dto.EmailConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender sender;
	public String sendemail(EmailConfiguration config) {
		MimeMessage message=sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		try {
			helper.setTo(config.getTo());
			helper.setSubject(config.getSubject());
			helper.setText(config.getText());
			sender.send(message);
			return "Mail sended";
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Mail not sended";
		}
		
	}

}
