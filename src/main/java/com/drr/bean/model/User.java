package com.drr.bean.model;

public class User {
	
	private int id;
	private String nameUser;
	private String password;
	private char nameType;
	private byte status;
	
	public User() {
		super();
	}

	public User(int id) {
		super();
		this.id = id;
	}

	public User(String nameUser, String password, char nameType, byte status) {
		super();
		this.nameUser = nameUser;
		this.password = password;
		this.nameType = nameType;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getNameType() {
		return nameType;
	}

	public void setNameType(char nameType) {
		this.nameType = nameType;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

}
