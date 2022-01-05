package com.drr.bean.dao;

import java.sql.SQLException;
import java.util.List;

import com.drr.bean.model.Person;

public interface IPersonDao {
	
	public List<Person> listAll() throws SQLException;
	public Person selectItem(Person person) throws SQLException;
	public Person insert(Person person) throws SQLException;
	public Person update(Person person) throws SQLException;
	public Person delete(Person person) throws SQLException;
	
}
