package com.open.suite.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.open.suite.domain.Comment;
import com.open.suite.repository.CommentRepository;

/**
 * @author    Minhajul Sarkar<polash.pbt@gmail.com>
 * @version   1.0.00
 * @since     1.0.00
 * 
 */
@Service
public class CommentService {

	@Autowired
	private CommentRepository repository;
	
	@Transactional
	public Comment save(Comment commentObj) {
		return repository.save(commentObj);
	}
	
	@Transactional
	public void delete(Comment commentObj) {
		repository.delete(commentObj);
	}
	
	@Transactional(readOnly=true)
	public Comment findByCommentCode(String commentCode) {
		return repository.findByCommentCode(commentCode);
	}
	
	@Transactional(readOnly=true)
	public ArrayList<Comment> fetchAllByFirstName(String commentCode) {
		return repository.findAllByCommentCode(commentCode);
	}
	
	@Transactional(readOnly=true)
	public ArrayList<Comment> findAllByThreadCode(String threadCode) {
		return repository.findAllByThreadCode(threadCode);
	}
	
	@Transactional(readOnly=true)
	public ArrayList<Comment> fetchAll() {
		return repository.findAll();
	}
	
}
