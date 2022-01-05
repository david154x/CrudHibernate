package com.drr.bean.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name_one")
	private String nameOne;
	
	@Column(name="name_two")
	private String nameTwo;
	
	@Column(name="last_name_one")
	private String lastNameOne;
	
	@Column(name="last_name_two")
	private String lastNameTwo;
	
	private String gender;
	
	@Column(name="date_birth")
	private String dateOfBirth;
	
	public Person() {
		super();
	}

	public Person(String nameOne, String nameTwo, String lastNameOne, String lastNameTwo, String gender,
			String dateOfBirth) {
		super();
		this.nameOne = nameOne;
		this.nameTwo = nameTwo;
		this.lastNameOne = lastNameOne;
		this.lastNameTwo = lastNameTwo;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOne() {
		return nameOne;
	}

	public void setNameOne(String nameOne) {
		this.nameOne = nameOne;
	}

	public String getNameTwo() {
		return nameTwo;
	}

	public void setNameTwo(String nameTwo) {
		this.nameTwo = nameTwo;
	}

	public String getLastNameOne() {
		return lastNameOne;
	}

	public void setLastNameOne(String lastNameOne) {
		this.lastNameOne = lastNameOne;
	}

	public String getLastNameTwo() {
		return lastNameTwo;
	}

	public void setLastNameTwo(String lastNameTwo) {
		this.lastNameTwo = lastNameTwo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
