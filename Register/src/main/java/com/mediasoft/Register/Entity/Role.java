package com.mediasoft.Register.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Role")
public class Role {
	
	@Id
	private long _id;
	private String name;
	private String description;
	
	public long get_id() {
		return _id;
	}
	public void set_id(long _id) {
		this._id = _id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Role(long _id, String name, String description) {
		super();
		this._id = _id;
		this.name = name;
		this.description = description;
	}
	public Role() {
		super();
	}
	public Role(long _id) {
		super();
		this._id = _id;
	}
	
	
}
