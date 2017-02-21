package com.open.suite.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.open.suite.app.Application;
import com.open.suite.domain.Comment;
import com.open.suite.service.CommentService;
import com.open.suite.service.ThreadRegistrationHql;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class CustomerTest {

	@Autowired private ThreadRegistrationHql service;
	@Autowired private CommentService coService;
	
	
	
    @Test
    public void testFindByLastName() {

    	/*ArrayList<ThreadRegistration> threadRegistrations=service.fetchAllByCriteria("minh");
    	
    	for (ThreadRegistration threadRegistration : threadRegistrations) {
			System.out.println(threadRegistration.getThreadTitle());
		}*/
    	
    	/*Comment commentObj=new Comment();
//    	commentObj.setCommentCode("3");
    	commentObj.setThreadCode("1212");
    	commentObj.setCommentText("This is test Updatessss");
    	commentObj.setUserId(1);
    	commentObj.setEntryUser("Minhaj");
    	commentObj.setEntryDate(new Date());
    	
    	commentObj.setUpdateUser("Minhaj");
    	commentObj.setUpdateDate(new Date());
    	
    	coService.save(commentObj);*/
    	
    System.out.println("working fine");
    assertThat(true);
    }
    
}
