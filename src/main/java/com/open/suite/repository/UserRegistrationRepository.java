package com.open.suite.repository;


import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.open.suite.domain.UserRegistration;


@Repository
public interface UserRegistrationRepository extends CrudRepository<UserRegistration, Long>{

	ArrayList<UserRegistration> findAll();
	ArrayList<UserRegistration> findAllByUserId(int userId);
}
