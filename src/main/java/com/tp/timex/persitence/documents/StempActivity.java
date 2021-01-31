package com.tp.timex.persitence.documents;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="stemp")
public class StempActivity {
	
	@Id
    private String id;
	
	@JsonFormat(pattern="dd.MM.yyyy HH:mm:ss")
	private LocalDateTime timestamp;
	
	private Long taskId;
	private Long projectId;
	
	private String descritption;
	
	private String userId;

	private StempType activity;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getDescritption() {
		return descritption;
	}

	public void setDescritption(String descritption) {
		this.descritption = descritption;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public StempType getActivity() {
		return activity;
	}

	public void setActivity(StempType activity) {
		this.activity = activity;
	}



	public enum StempType {
		START, STOP;
	}
	
}
