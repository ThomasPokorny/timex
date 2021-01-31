package com.tp.timex.persitence.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User {
	
	@Id
	private String id;
	private String name;
	private String email;
	private Integer organisationId;

	public void setId(String id) { 
		this.id = id;
	}

	public void setName(String name) { 
		this.name = name;
	}

	public void setEmail(String email) { 
		this.email = email;
	}

	
	public void setOrganisationId(Integer organisationId) { 
		this.organisationId = organisationId;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Integer getOrganisationId() {
		return organisationId;
	}
}
