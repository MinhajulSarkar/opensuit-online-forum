package com.open.suite.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user_registration")
public class UserRegistration extends CommonActivities implements Serializable {

	private static final long serialVersionUID = -5051119949524633456L;

	@Id
	@Column(name = "t_usre_id")
	private String userId;
	
	@Column(name = "t_user_name")
	private String userName;
	
	@Column(name = "t_email")
	private String email;
	
	@Column(name = "t_password")
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
