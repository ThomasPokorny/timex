package com.tp.timex.persitence.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="project")
public class Project {
	
	@Id
	private String id;
	private String name;
	private String description;
	
	private List<Task> tasks;

	public void setId(String id) { 
		this.id = id;
	}

	public void setName(String name) { 
		this.name = name;
	}

	public void setDescription(String description) { 
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
}
