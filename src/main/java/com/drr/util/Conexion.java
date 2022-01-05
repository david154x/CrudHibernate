package com.drr.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
	
	private static final String jdbc = "jdbc:mariadb://";
	private static final String host = "localhost";
	private static final int port = 3306;
	private static final String database = "agenda";
	private static final String username = "root";
	private static final String password = "password";
	private static final String url = jdbc + host + ":" + port + "/" + database;
	private static BasicDataSource dataSource;
	
	public static DataSource getDataSource() {
		if(dataSource == null) {
			dataSource = new BasicDataSource();
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			dataSource.setInitialSize(5);
		}
		return dataSource;
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = getDataSource().getConnection();
			System.out.println("¡Se ha conectado correcta y exitosamente!");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				System.out.println("No se ha podido desconectar de la base de datos");
				e.printStackTrace();
			}
		}
		return conn;
	}

    public static void close(Connection conn) throws SQLException{
        conn.close();
    }

    public static void close(PreparedStatement stmt) throws SQLException{
        stmt.close();
    }

    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
}
