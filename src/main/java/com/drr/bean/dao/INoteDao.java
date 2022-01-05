package com.drr.bean.dao;

import java.sql.SQLException;
import java.util.List;

import com.drr.bean.model.Category;
import com.drr.bean.model.Note;

public interface INoteDao {
	
	public List<Category> listAll() throws SQLException;
	public Note selectItem(Note note) throws SQLException;
	public Note insert(Note note) throws SQLException;
	public Note update(Note note) throws SQLException;
	public Note delete(Note note) throws SQLException;
	
}
