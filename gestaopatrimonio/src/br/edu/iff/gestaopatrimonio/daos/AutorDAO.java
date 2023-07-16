package br.edu.iff.gestaopatrimonio.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.iff.gestaopatrimonio.models.*;
import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;

public class AutorDAO {

private final String INSERT = "INSERT INTO autor(nome, biografia) VALUES (?,?)";	
	
private Connection connection;
	
	public AutorDAO() {
		connection = (new JDBCConnection()).getConnection();
	}
	
	public boolean insert(Autor autor) {
		try {
			PreparedStatement ps = connection.prepareStatement(INSERT);
			ps.setString(1,autor.getNome());
			ps.setString(2,autor.getBiografia());
			
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.getStackTrace();
			return false;			
		}
		
	}
}
