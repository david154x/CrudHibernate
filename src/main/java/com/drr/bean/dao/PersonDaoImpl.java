package com.drr.bean.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.drr.bean.model.Person;
import com.drr.util.Conexion;

public class PersonDaoImpl implements IPersonDao{
	
	private static final String SQL_SELECT_ALL = "SELECT id, name_one, name_two, last_name_one, last_name_two, gender, date_birth FROM persona";
	private static final String SQL_SELECT_ITEM = "SELECT name_one, name_two, last_name_one, last_name_two, gender, date_birth FROM persona WHERE id = ?";
	private static final String SQL_INSERT = "INSERT INTO persona (name_one, name_two, last_name_one, last_name_two, gender, date_birth) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE persona name_one = ?, name_two = ?, last_name_one = ?, last_name_two = ?, gender = ?, date_birth = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM persona WHERE id = ?";
	
	@Override
	public List<Person> listAll() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Person> listOfPersons = new ArrayList<>();
		Person person;
		try {
			conn = Conexion.getDataSource().getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String nameOne = rs.getString("name_one");
				String nameTwo = rs.getString("name_two");
				String lastNameOne = rs.getString("last_name_one");
				String lastNameTwo = rs.getString("last_name_two");
				String gender = rs.getString("gender");
				String dateBirth = rs.getString("date_birth");
				person = new Person(nameOne, nameTwo, lastNameOne, lastNameTwo, gender, dateBirth);
				listOfPersons.add(person);
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
		return listOfPersons;
	}

	@Override
	public Person selectItem(Person person) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Person personForId = null;
		try {
			conn = Conexion.getDataSource().getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_ITEM);
			stmt.setInt(1, person.getId());
			rs = stmt.executeQuery();
			while(rs.next()) {
				String nameOne = rs.getString("name_one");
				String nameTwo = rs.getString("name_two");
				String lastNameOne = rs.getString("last_name_one");
				String lastNameTwo = rs.getString("last_name_two");
				String gender = rs.getString("gender");
				String dateBirth = rs.getString("date_birth");
				personForId = new Person(nameOne, nameTwo, lastNameOne, lastNameTwo, gender, dateBirth);
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
		return personForId;
	}

	@Override
	public Person insert(Person person) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = Conexion.getDataSource().getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, person.getNameOne());
			stmt.setString(2, person.getNameTwo());
			stmt.setString(3, person.getLastNameOne());
			stmt.setString(4, person.getLastNameTwo());
			stmt.setString(5, person.getGender());
			stmt.setString(6, person.getDateOfBirth());
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
		return person;
	}

	@Override
	public Person update(Person person) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = Conexion.getDataSource().getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, person.getNameOne());
			stmt.setString(2, person.getNameTwo());
			stmt.setString(3, person.getLastNameOne());
			stmt.setString(4, person.getLastNameTwo());
			stmt.setString(5, person.getGender());
			stmt.setString(6, person.getDateOfBirth());
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
		return person;
	}

	@Override
	public Person delete(Person person) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = Conexion.getDataSource().getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, person.getId());
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
		return person;
	}
	
}
