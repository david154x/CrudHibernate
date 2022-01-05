package com.drr.bean.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.drr.bean.model.Category;
import com.drr.util.Conexion;

public class CategoryDaoImpl implements ICategoryDao {
	
	private static final String SQL_SELECT_ALL = "SELECT id, name, status FROM categoria";
	private static final String SQL_SELECT_ITEM = "SELECT id, name, status FROM categoria WHERE id = ?";
	private static final String SQL_INSERT = "INSERT INTO categoria (name) VALUES (?)";
	private static final String SQL_UPDATE = "UPDATE category name = ?, status ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM categoria WHERE id = ?";
	
	@Override
	public List<Category> listAll() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Category> listOfCategory = new ArrayList<>();
		Category category;
		try {
			conn = Conexion.getDataSource().getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				boolean status = rs.getBoolean("status");
				category = new Category(id, name, status);
				listOfCategory.add(category);
			}
		}catch(SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			try {
				Conexion.close(rs);
				Conexion.close(stmt);
				Conexion.close(conn);
			}catch(SQLException e) {
				e.printStackTrace(System.out);
			}
		}
		return listOfCategory;
	}
	
	@Override
	public Category selectItem(Category category) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Category categoryForId = null;
		try {
			conn = Conexion.getDataSource().getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_ITEM);
			stmt.setInt(1, category.getId());
			rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				boolean status = rs.getBoolean("status");
				categoryForId = new Category(id, name, status);
			}
		}catch(SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			try {
				Conexion.close(rs);
				Conexion.close(stmt);
				Conexion.close(conn);
			}catch(SQLException e) {
				e.printStackTrace(System.out);
			}
		}
		return categoryForId;
	}
	
	@Override
	public Category insert(Category category) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = Conexion.getDataSource().getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, category.getName());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			try {
				Conexion.close(stmt);
				Conexion.close(conn);
			}catch(SQLException e) {
				e.printStackTrace(System.out);
			}
		}
		return category;
	}
	
	@Override
	public Category update(Category category) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = Conexion.getDataSource().getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, category.getName());
			stmt.setBoolean(2, category.isStatus());
			stmt.setInt(3, category.getId());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				Conexion.close(stmt);
				Conexion.close(conn);
			}catch(SQLException e) {
				e.printStackTrace(System.out);
			}
		}
		return category;
	}
	
	@Override
	public Category delete(Category category) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = Conexion.getDataSource().getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, category.getId());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			try {
				Conexion.close(stmt);
				Conexion.close(conn);
			}catch(SQLException e) {
				e.printStackTrace(System.out);
			}
		}
		return category;
	}
	
}
