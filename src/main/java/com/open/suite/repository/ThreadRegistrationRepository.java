package com.open.suite.repository;


import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.open.suite.domain.ThreadRegistration;

/**
 * @author    Minhajul Sarkar<polash.pbt@gmail.com>
 * @version   1.0.00
 * @since     1.0.00
 * 
 */
@Repository
public interface ThreadRegistrationRepository extends CrudRepository<ThreadRegistration, Long>{

	ArrayList<ThreadRegistration> findAll();
	ArrayList<ThreadRegistration> findAllByThreadCode(String code);
	ThreadRegistration findByThreadCode(String code);
	
}
