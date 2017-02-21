package com.open.suite.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.open.suite.domain.Comment;

/**
 * @author    Minhajul Sarkar<polash.pbt@gmail.com>
 * @version   1.0.00
 * @since     1.0.00
 * 
 */
@Repository
public class CommentHql {

	@PersistenceContext
	EntityManager entityManager;


	protected Session getCurrentSession() {
		return entityManager.unwrap(Session.class);
	}

	@Transactional(readOnly=true)
	public ArrayList<Comment> fetchAllByCriteria(String searchValue) {
		Session session = getCurrentSession();
		String sql="select th.t_thread_code,th.t_thread_tile,"
				+ "co.t_usre_email,co.t_comment_code,co.t_comment_text,co.t_entry_user,co.t_entry_date,"
				+ "co.t_update_date "
				+ "from t_thread_registration th "
				+ "left outer join t_comments co on co.t_thread_code=th.t_thread_code "
				+ "left outer join user u on co.t_usre_email=u.email "
				+ "where th.t_thread_code="+searchValue;
		Query qurey=session.createSQLQuery(sql);
		ArrayList<Comment> threadList=new ArrayList<Comment>();
		@SuppressWarnings("unchecked")
		List<Object[]> results= (List<Object[]>) qurey.list();
		for (Object[] objects : results) {
			String threadCode= (String) objects[0];
			String threadTitle= (String) objects[1];
			String usreEmail= (String) objects[2];
			String commentCode=(String) objects[3];
			String commentText=(String) objects[4];
			String contributor= (String) objects[5];
			Date entryDate= (Date) objects[6];
			Date updateDate= (Date) objects[7];
			Comment comment=new Comment();
			comment.setThreadCode(threadCode);
			comment.setThreadTitle(threadTitle);
			comment.setUserEmail(usreEmail);
			comment.setCommentCode(commentCode);
			comment.setCommentText(commentText);
			comment.setEntryUser(contributor);
			comment.setEntryDate((updateDate==null)?entryDate:updateDate);
			threadList.add(comment);
		}
		return threadList;
	}
	
}
