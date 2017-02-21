package com.open.suite.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.open.suite.domain.ThreadRegistration;
import com.open.suite.repository.ThreadRegistrationRepository;


@Service
public class ThreadRegistrationService {

	@Autowired
	private ThreadRegistrationRepository repository;
	
	@Transactional
	public ThreadRegistration save(ThreadRegistration threadObj) {
		return repository.save(threadObj);
	}
	
	@Transactional
	public void delete(ThreadRegistration threadObj) {
		repository.delete(threadObj);
	}
	
	@Transactional(readOnly=true)
	public ThreadRegistration findThreadByCode(String code) {
		return repository.findByThreadCode(code);
	}
	
	@Transactional(readOnly=true)
	public ArrayList<ThreadRegistration> fetchAllByFirstName(String code) {
		return repository.findAllByThreadCode(code);
	}
	
	@Transactional(readOnly=true)
	public ArrayList<ThreadRegistration> fetchAll() {
		return repository.findAll();
	}
	
}
