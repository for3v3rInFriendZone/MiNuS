package com.minus.www.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.minus.www.app.model.User;
import com.minus.www.app.repository.UserRepository;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {

		List<User> users = (List<User>) userRepo.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<User> saveUser(@RequestBody User user) {

		User newUser = userRepo.save(user);
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable Long id) {

		User user = userRepo.findOne(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
