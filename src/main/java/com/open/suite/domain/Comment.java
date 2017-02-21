package com.open.suite.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
/**
 * @author    Minhajul Sarkar<polash.pbt@gmail.com>
 * @version   1.0.00
 * @since     1.0.00
 * 
 */

@Entity
@Table(name = "t_comments")
public class Comment extends CommonActivities implements Serializable {

	private static final long serialVersionUID = -5336266460310524815L;

	@Id
	@Column(name = "t_comment_code")
	private String commentCode;
	
	@Column(name = "t_thread_code")
	private String threadCode;
	
	@Transient
	private String threadTitle;
	
	@Column(name = "t_usre_email")
	private String userEmail;
	
	@Column(name = "t_comment_text")
	private String commentText;

	public String getThreadCode() {
		return threadCode;
	}

	public void setThreadCode(String threadCode) {
		this.threadCode = threadCode;
	}

	public String getThreadTitle() {
		return threadTitle;
	}

	public void setThreadTitle(String threadTitle) {
		this.threadTitle = threadTitle;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getCommentCode() {
		return commentCode;
	}

	public void setCommentCode(String commentCode) {
		this.commentCode = commentCode;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

}
