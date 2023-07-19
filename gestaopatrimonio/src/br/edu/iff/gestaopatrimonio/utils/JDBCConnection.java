package br.edu.iff.gestaopatrimonio.utils;
/**
 * @author hj_ro
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class JDBCConnection {

	public Connection getConnection() {
		try {

			Dotenv dotenv = Dotenv.configure().directory("./src/").filename(".env").load();
			return DriverManager.getConnection("jdbc:mysql://localhost:" + dotenv.get("PORT") + "/" + dotenv.get("DB")
					+ "?user=" + dotenv.get("USERR") + dotenv.get("PASSWORD"));
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
			return null;
		}
	}
}
