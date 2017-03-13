package com.minus.www.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minus.www.app.model.Comment;
import com.minus.www.app.repository.CommentRepository;
import com.minus.www.app.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository commentRepo;
	
	@Override
	public Comment save(Comment comment) {
		// TODO Auto-generated method stub
		return commentRepo.save(comment);
	}

	@Override
	public Comment findOne(Long id) {
		// TODO Auto-generated method stub
		return commentRepo.findOne(id);
	}

	@Override
	public Iterable<Comment> findAll() {
		// TODO Auto-generated method stub
		return commentRepo.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		commentRepo.delete(id);
	}

	@Override
	public void delete(Comment comment) {
		// TODO Auto-generated method stub
		commentRepo.delete(comment);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		commentRepo.deleteAll();
	}

}
