package com.drr.bean.model;

import java.util.Date;

public class Note {
	
	private int id;
	private int fkIdPer;
	private int fkIdCate;
	private String header;
	private String body;
	private Date datePublication;
	private String comentAdmin;
	private char value;
	
	public Note() {
		super();
	}

	public Note(int id) {
		super();
		this.id = id;
	}

	public Note(int fkIdPer, int fkIdCate, String header, String body, Date datePublication, String comentAdmin,
			char value) {
		super();
		this.fkIdPer = fkIdPer;
		this.fkIdCate = fkIdCate;
		this.header = header;
		this.body = body;
		this.datePublication = datePublication;
		this.comentAdmin = comentAdmin;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFkIdPer() {
		return fkIdPer;
	}

	public void setFkIdPer(int fkIdPer) {
		this.fkIdPer = fkIdPer;
	}

	public int getFkIdCate() {
		return fkIdCate;
	}

	public void setFkIdCate(int fkIdCate) {
		this.fkIdCate = fkIdCate;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public String getComentAdmin() {
		return comentAdmin;
	}

	public void setComentAdmin(String comentAdmin) {
		this.comentAdmin = comentAdmin;
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}
	
}
