package com.drr.bean.dao;

import java.sql.SQLException;
import java.util.List;

import com.drr.bean.model.Category;
import com.drr.bean.model.User;

public interface IUserDao {
	
	public List<Category> listAll() throws SQLException;
	public User selectItem(User user) throws SQLException;
	public User insert(User user) throws SQLException;
	public User update(User user) throws SQLException;
	public User delete(User user) throws SQLException;
	
}
