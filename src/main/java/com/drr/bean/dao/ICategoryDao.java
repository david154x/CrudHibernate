package com.drr.bean.dao;

import java.sql.SQLException;
import java.util.List;

import com.drr.bean.model.Category;

public interface ICategoryDao {
	
	public List<Category> listAll() throws SQLException;
	public Category selectItem(Category category) throws SQLException;
	public Category insert(Category category) throws SQLException;
	public Category update(Category category) throws SQLException;
	public Category delete(Category category) throws SQLException;
	
}
