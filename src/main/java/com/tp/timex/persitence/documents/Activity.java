package com.tp.timex.persitence.documents;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="activity")
public class Activity {
	
	@Id
    private String id;
	
	@JsonFormat(pattern="dd.MM.yyyy HH:mm:ss")
	private LocalDateTime from;
	
	@JsonFormat(pattern="dd.MM.yyyy HH:mm:ss")
	private LocalDateTime to;
	private Long taskId;
	private Long projectId;
	
	private String descritption;
	
	private String userId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDateTime getFrom() {
		return from;
	}
	public void setFrom(LocalDateTime from) {
		this.from = from;
	}
	public LocalDateTime getTo() {
		return to;
	}
	public void setTo(LocalDateTime to) {
		this.to = to;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDescritption() {
		return descritption;
	}
	public void setDescritption(String descritption) {
		this.descritption = descritption;
	}
	
}
