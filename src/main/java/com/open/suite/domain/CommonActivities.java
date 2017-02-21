package com.open.suite.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
/**
 * @author    Minhajul Sarkar<polash.pbt@gmail.com>
 * @version   1.0.00
 * @since     1.0.00
 * 
 */

@MappedSuperclass
public abstract class CommonActivities implements Serializable {

	private static final long serialVersionUID = 8906703744876342939L;
	
	@Column(name = "t_entry_user")
	private String entryUser;
	
	@Column(name = "t_entry_date")
	private Date entryDate;
	
	@Column(name = "t_update_user")
	private String updateUser;
	
	@Column(name = "t_update_date")
	private Date updateDate;

	public String getEntryUser() {
		return entryUser;
	}

	public void setEntryUser(String entryUser) {
		this.entryUser = entryUser;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	

}
