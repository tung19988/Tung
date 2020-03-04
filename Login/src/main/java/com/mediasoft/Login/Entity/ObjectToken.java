package com.mediasoft.Login.Entity;



public class ObjectToken {
	
	private Integer user;

	private Integer exprient;
	
	private Integer timeout;
	
	private long loginTime;
	
	private long lastActive;

	public ObjectToken(Integer user, Integer exprient, Integer timeout, long loginTime, long lastActive) {
		super();
		this.user = user;
		this.exprient = exprient;
		this.timeout = timeout;
		this.loginTime = loginTime;
		this.lastActive = lastActive;
	}

	public ObjectToken() {
		super();
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Integer getExprient() {
		return exprient;
	}

	public void setExprient(Integer exprient) {
		this.exprient = exprient;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public long getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(long loginTime) {
		this.loginTime = loginTime;
	}

	public long getlastActive() {
		return lastActive;
	}

	public void setlastActive(long lastActive) {
		this.lastActive = lastActive;
	}
	
	
}
