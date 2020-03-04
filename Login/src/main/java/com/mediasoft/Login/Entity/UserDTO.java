package com.mediasoft.Login.Entity;

public class UserDTO {
	private String token;
	private boolean status;

	
	
	public UserDTO() {
		super();
	}

	public UserDTO(String token, boolean status) {
		super();
		this.token = token;
		this.status = status;
	}

	public String gettoken() {
		return token;
	}

	public UserDTO(String token) {
		super();
		this.token = token;
	}

	public void settoken(String token) {
		this.token = token;
	}

	public boolean getstatus() {
		return status;
	}

	public void setstatus(boolean status) {
		this.status = status;
	}
}