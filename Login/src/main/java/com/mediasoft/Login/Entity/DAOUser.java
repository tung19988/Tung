package com.mediasoft.Login.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Register")
public class DAOUser {

	
	@Id
	private Integer id;
	private String user;
	
	@DBRef
	private Role role;
	@JsonIgnore
	private String pass;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}
	
	public String getUser() {
		return user;
	}

	public void setUsername(String user) {
		this.user = user;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
}