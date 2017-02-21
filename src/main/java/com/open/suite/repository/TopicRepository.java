package com.open.suite.repository;


import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.open.suite.domain.Topic;

/**
 * @author    Minhajul Sarkar<polash.pbt@gmail.com>
 * @version   1.0.00
 * @since     1.0.00
 * 
 */
@Repository
public interface TopicRepository extends CrudRepository<Topic, Long>{

	ArrayList<Topic> findAll();
	ArrayList<Topic> findAllByTopicId(int topicId);
	
}
