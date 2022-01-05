package com.drr.bean.model;

public class Phone {
	
	private int id;
	private int fk_id_per;
	private String number_phone;
	
	public Phone() {
		super();
	}

	public Phone(int id) {
		super();
		this.id = id;
	}

	public Phone(int fk_id_per, String number_phone) {
		super();
		this.fk_id_per = fk_id_per;
		this.number_phone = number_phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFk_id_per() {
		return fk_id_per;
	}

	public void setFk_id_per(int fk_id_per) {
		this.fk_id_per = fk_id_per;
	}

	public String getNumber_phone() {
		return number_phone;
	}

	public void setNumber_phone(String number_phone) {
		this.number_phone = number_phone;
	}
	
}
