package com.minus.www.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.minus.www.app.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{

}
