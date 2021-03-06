package com.open.suite.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author    Minhajul Sarkar<polash.pbt@gmail.com>
 * @version   1.0.00
 * @since     1.0.00
 * 
 */
@Entity
@Table(name = "t_thread_registration")
public class ThreadRegistration extends CommonActivities implements Serializable {

	private static final long serialVersionUID = 7528630891517563351L;

	@Id
	@Column(name = "t_thread_code")
	private String threadCode;
	
	@Column(name = "t_usre_email")
	private String userEmail;
	
	@Column(name = "t_thread_tile")
	private String threadTitle;
	
	@Column(name = "t_thread_des")
	private String threadDescription;
	
	@Column(name = "t_topic_id")
	private Integer topicId;

	public String getThreadCode() {
		return threadCode;
	}

	public void setThreadCode(String threadCode) {
		this.threadCode = threadCode;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getThreadDescription() {
		return threadDescription;
	}

	public void setThreadDescription(String threadDescription) {
		this.threadDescription = threadDescription;
	}

	public String getThreadTitle() {
		return threadTitle;
	}

	public void setThreadTitle(String threadTitle) {
		this.threadTitle = threadTitle;
	}
	
}
