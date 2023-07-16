package br.edu.iff.gestaopatrimonio.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.edu.iff.gestaopatrimonio.models.*;
import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;

public class AutorDAO {

private final String INSERT = "INSERT INTO autor(nome, biografia) VALUES (?,?)";	
private final String SELECT_NOME = "SELECT * FROM autor WHERE nome = ?";
private final String UPDATE = "UPDATE autor SET nome =?, biografia =? WHERE id=?";
	
private Connection connection;
	
	public AutorDAO() {
		connection = (new JDBCConnection()).getConnection();
	}
	
	/**
	 *  
	 * 
	 * @param Autor
	 * @Função Insere um objeto do tipo autor no banco de dados
	 */
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
	/**
	 * 
	 * @param nome
	 * @return Retorna uma lista de autores com o nome solicitado
	 */
	
	public List<Autor> select_nome(String nome) {
		try {	
			
			List<Autor> autores = new ArrayList<>();
			List<NomeAlternativo> nomealternativo = new ArrayList<>();
			PreparedStatement ps;
			ps = connection.prepareStatement(SELECT_NOME);
			ps.setString(1, nome);
			ResultSet result =  ps.executeQuery();
			while(result.next()) {
				Autor autor = new Autor(result.getString("nome"),result.getString("biografia"),nomealternativo);
				autor.setId(result.getInt("id"));
				autores.add(autor);
				
			}			
			return autores;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean update(Autor autor) {
		try {
			PreparedStatement ps = connection.prepareStatement(INSERT);
			ps.setString(1,autor.getNome());
			ps.setString(2,autor.getBiografia());
			ps.setInt(3, autor.getId());
			
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.getStackTrace();
			return false;			
		}
		
	}
	
}
