package br.edu.iff.gestaopatrimonio.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	public Connection getConnection() {
		try {
			//return  DriverManager.getConnection("jdbc:sqLite:biblioteca.db");
			return  DriverManager.getConnection("jdbc:mysql://localhost:3306/patrimonio?user=root&password=ps00seiquenaoda00");
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
			return null;
		}
	}
}
