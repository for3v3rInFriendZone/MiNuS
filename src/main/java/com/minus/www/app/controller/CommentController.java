package com.minus.www.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.minus.www.app.model.Comment;
import com.minus.www.app.service.CommentService;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {
	
	@Autowired
	CommentService commentSer;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Comment>> getUsers() {

		List<Comment> users = (List<Comment>) commentSer.findAll();
		return new ResponseEntity<List<Comment>>(users, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Comment> saveUser(@RequestBody Comment user) {

		Comment newUser = commentSer.save(user);
		return new ResponseEntity<Comment>(newUser, HttpStatus.CREATED);
	}
	
}
