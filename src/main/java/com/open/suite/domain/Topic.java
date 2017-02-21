package com.open.suite.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_topic")
public class Topic extends CommonActivities implements Serializable {

	private static final long serialVersionUID = 866909173534560546L;

	@Id
	@Column(name = "t_topic_id")
	private Integer topicId;
	
	@Column(name = "t_topic_name")
	private String topicName;

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

}
