package com.minus.www.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

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

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncrypt(user.getPassword()));
		user.setActivation(Activation.DEACTIVATED);

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

}
