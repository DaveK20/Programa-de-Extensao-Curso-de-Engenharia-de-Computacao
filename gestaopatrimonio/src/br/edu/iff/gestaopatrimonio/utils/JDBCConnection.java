package br.edu.iff.gestaopatrimonio.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class JDBCConnection {

	public Connection getConnection() {
		try {
			
			 Dotenv dotenv = Dotenv.configure()
					    .directory("./src/")
					    .filename(".env") // instead of '.env', use 'env'
					    .load();

			System.out.println(dotenv.get("USER")); // Return your system USERNAME configuration.	
			//return  DriverManager.getConnection("jdbc:sqLite:biblioteca.db");
			System.out.println(dotenv.get("PASSWORD")); // Return your system USERNAME configuration.	

			return  DriverManager.getConnection("jdbc:mysql://localhost:"+dotenv.get("PORT")+"/"+dotenv.get("DB")+"?user="+dotenv.get("USER")+dotenv.get("PASSWORD"));
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
			return null;
		}
	}
}
