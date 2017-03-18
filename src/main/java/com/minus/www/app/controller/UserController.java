package com.minus.www.app.controller;

import java.util.List;

import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.minus.www.app.model.User;
import com.minus.www.app.model.User.Activation;
import com.minus.www.app.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userSer;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {

		List<User> users = (List<User>) userSer.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		
		user.setPassword(userSer.passwordEncrypt(user.getPassword()));
		user.setActivation(Activation.DEACTIVATED);
		
		User newUser = userSer.save(user);
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable String username) {

		User user = userSer.findByUsername(username);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Boolean> checkUserLogin(@RequestBody User user) {

		Boolean checkStatus = false;
		User userDB = userSer.findByUsername(user.getUsername());
		if (userDB != null && userDB.getActivation().equals(Activation.ACTIVATED)) {
			checkStatus = userSer.checkPassword(user.getPassword(), userDB.getPassword());
		}

		return new ResponseEntity<Boolean>(checkStatus, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/checkUsername", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Boolean> checkUsernameUniqueness(@RequestBody User user) {

		Boolean usernameExists = false;
		User userDB = userSer.findByUsername(user.getUsername());
		if (userDB != null) {
			usernameExists = true;
		}

		return new ResponseEntity<Boolean>(usernameExists, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/mail", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<User> sendMail(@RequestBody User user) throws MessagingException {
		
		String msg1 = "Hi there, <i>" + user.getFirstname() + "</i><br/> " + "You are almost finished with signing up. <br/> Just click on this <a href='http://localhost:8080/#!/registrationConfirmation/" +user.getUsername()+ "'>link</a> and you will confirm your registration. <br/>";
		String msg2 = "All the best and we wish you a great day. <br/> <hr/> Your <span style='color:lightblue;'>M</span>i<span style='color: #cccc00;'>N</span>u<span style='color: green;'>S</span> team.";

		userSer.sendMail("acquirersep@gmail.com", user.getEmail(), "MiNuS sign up confirmation", msg1+msg2);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/activateAccount/{userName}", method = RequestMethod.GET)
	public ResponseEntity<User> sendConfirmationMailForSignUp(@PathVariable String userName) {

		User user = userSer.findByUsername(userName);
		if(user == null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} 
		
		user.setActivation(Activation.ACTIVATED);
		userSer.save(user);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
