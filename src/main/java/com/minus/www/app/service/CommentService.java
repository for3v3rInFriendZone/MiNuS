package com.minus.www.app.service;

import com.minus.www.app.model.Comment;

public interface CommentService {

	public Comment save(Comment comment);
	
	public Comment findOne(Long id);
	
	public Iterable<Comment> findAll();
	
	public void delete(Long id);
	
	public void delete(Comment comment);
	
	public void deleteAll();
	
}
