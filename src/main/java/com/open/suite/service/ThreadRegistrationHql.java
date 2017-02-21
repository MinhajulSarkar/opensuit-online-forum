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

import com.open.suite.domain.ThreadRegistration;

/**
 * @author    Minhajul Sarkar<polash.pbt@gmail.com>
 * @version   1.0.00
 * @since     1.0.00
 * 
 */
@Repository
public class ThreadRegistrationHql {

	@PersistenceContext
	EntityManager entityManager;


	protected Session getCurrentSession() {
		return entityManager.unwrap(Session.class);
	}

	@Transactional(readOnly=true)
	public ArrayList<ThreadRegistration> fetchAllByCriteria(String searchValue) {
		Session session = getCurrentSession();
		String sql="SELECT th.T_THREAD_TILE, th.T_ENTRY_USER, th.T_ENTRY_DATE,"
				+ "th.T_UPDATE_DATE "
				+ "FROM t_thread_registration th left outer join t_comments co on th.T_THREAD_CODE=co.T_THREAD_CODE "
				+ "LEFT OUTER JOIN t_user_registration u on th.T_USRE_ID=u.T_USRE_ID "
				+ "where th.T_THREAD_TILE like '%"+searchValue+"%' or co.T_COMMENT_TEXT like '%"+searchValue+"%' or u.T_USER_NAME like '%"+searchValue+"%'";
		Query qurey=session.createSQLQuery(sql);
		ArrayList<ThreadRegistration> threadList=new ArrayList<ThreadRegistration>();
		@SuppressWarnings("unchecked")
		List<Object[]> results= (List<Object[]>) qurey.list();
		for (Object[] objects : results) {
			String threadTitle= (String) objects[0];
			String contributor= (String) objects[1];
			Date entryDate= (Date) objects[2];
			Date updateDate= (Date) objects[3];
			ThreadRegistration threadRegistration=new ThreadRegistration();
			threadRegistration.setThreadTitle(threadTitle);
			threadRegistration.setEntryUser(contributor);
			threadRegistration.setEntryDate((updateDate==null)?entryDate:updateDate);
			threadList.add(threadRegistration);
		}
		
		return threadList;
	}
	
}
