package com.mediasoft.Register.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Country")
public class Country {
	@Transient
    public static final String SEQUENCE_NAME = "country";
	
	@Id
	private String id;

	
	private String name;
	
	
	public Country() {
		super();
	}



	public Country(String id) {
		super();
		this.id = id;
	}



	public Country(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
