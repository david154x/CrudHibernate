package com.drr.bean.dao;

import java.sql.SQLException;
import java.util.List;

import com.drr.bean.model.Category;
import com.drr.bean.model.Phone;

public interface IPhoneDao {
	
	public List<Category> listAll() throws SQLException;
	public Phone selectItem(Phone phone) throws SQLException;
	public Phone insert(Phone phone) throws SQLException;
	public Phone update(Phone phone) throws SQLException;
	public Phone delete(Phone phone) throws SQLException;
	
}