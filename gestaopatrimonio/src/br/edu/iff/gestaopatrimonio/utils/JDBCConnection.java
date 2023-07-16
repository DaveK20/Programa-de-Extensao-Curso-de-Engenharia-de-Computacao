package br.edu.iff.gestaopatrimonio.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class JDBCConnection {

	public Connection getConnection() {
		try {
			
			/* Dotenv dotenv = Dotenv.configure()
					    .directory("./src/")
					    .filename(".env") // instead of '.env', use 'env'
					    .load();
			return  DriverManager.getConnection("jdbc:mysql://localhost:"+dotenv.get("PORT")+"/"+dotenv.get("DB")+"?user="+dotenv.get("USER")+dotenv.get("PASSWORD"));
			*/
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/patrimonio?user=root");
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
			return null;
		}
	}
}
