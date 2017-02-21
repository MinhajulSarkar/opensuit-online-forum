package com.open.suite.repository;


import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.open.suite.domain.Comment;


@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{

	ArrayList<Comment> findAll();
	ArrayList<Comment> findAllByCommentCode(String commentCode);
	Comment findByCommentCode(String commentCode);
	ArrayList<Comment> findAllByThreadCode(String threadCode);
	
}
