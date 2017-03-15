package com.minus.www.app.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.minus.www.app.model.User;
import com.minus.www.app.model.User.Activation;
import com.minus.www.app.repository.UserRepository;
import com.minus.www.app.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	JavaMailSender mail;

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub

		return userRepo.save(user);
	}

	@Override
	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return userRepo.findOne(id);
	}

	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public void delete(Long id) {
		userRepo.delete(id);

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userRepo.delete(user);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		userRepo.deleteAll();
	}

	@Override
	public String passwordEncrypt(String password) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}

	@Override
	public Boolean checkPassword(String rawPassword, String encodedPassword) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}

	@Override
	public void sendComment(String senderName, String senderEmail, String senderComment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMail(String from, String to, String subject, String message) throws MessagingException {
		
		MimeMessage mimeMessage = mail.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
		
		mimeMessage.setContent(message, "text/html");
		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject(subject);
		
		mail.send(mimeMessage);
	
	}
}
