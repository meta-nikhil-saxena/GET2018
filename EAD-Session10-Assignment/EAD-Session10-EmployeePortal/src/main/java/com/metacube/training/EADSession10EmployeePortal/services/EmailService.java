package com.metacube.training.EADSession10EmployeePortal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.metacube.training.EADSession10EmployeePortal.models.User;

//Email service to get Mail on id
@Service
public class EmailService {

	private JavaMailSender javaMailSender;

	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(User user) {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("nikhil.saxena@metacube.com");
		mail.setSubject("FORGET PASSWORD");
		mail.setText("Hello " + user.getFirstName() + " " + user.getLastname()
				+ " your Password is : " + user.getPassword());
		javaMailSender.send(mail);
	}
}