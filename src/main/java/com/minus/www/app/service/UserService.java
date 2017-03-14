package com.minus.www.app.service;

import javax.mail.MessagingException;

import com.minus.www.app.model.User;

public interface UserService {

	public User save(User user);

	public User findOne(Long id);

	public Iterable<User> findAll();

	public void delete(Long id);

	public void delete(User user);

	public void deleteAll();

	public String passwordEncrypt(String password);

	public Boolean checkPassword(String rawPassword, String encodedPassword);

	public User findByUsername(String username);

	public void sendComment(String senderName, String senderEmail, String senderComment);
	
	public void sendMail(String from, String to, String subject, String message) throws MessagingException;

}
