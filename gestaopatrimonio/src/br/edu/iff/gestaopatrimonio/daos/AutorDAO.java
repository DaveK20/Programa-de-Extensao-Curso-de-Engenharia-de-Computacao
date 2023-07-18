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
private final String UPDATE = "UPDATE autor SET nome = ?, biografia =? WHERE id=?";
private final String SELECTALL = "SELECT * FROM autor";	
private final String DELETE = "DELETE FROM autor WHERE id = ?";
private final String DELETEALL = "DELETE FROM autor";
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
	public List<Autor> selectNome(String nome) {
		try {	
			
			List<Autor> autores = new ArrayList<>();
			NomeAlternativoDAO nomealternativo = new NomeAlternativoDAO();
			PreparedStatement ps;
			ps = connection.prepareStatement(SELECT_NOME);
			ps.setString(1, nome);
			ResultSet result =  ps.executeQuery();
			while(result.next()) {
				
				Autor autor = new Autor(result.getString("nome"),result.getString("biografia"),nomealternativo.selectNomes(result.getInt("id")));
				autor.setId(result.getInt("id"));
				autores.add(autor);
				
			}			
			return autores;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 	
	 * @param autor
	 * @param id
	 * @return Atualiza um autor no banco, recebendo um novo autor, e o id referente a ele no banco
	 */
	public boolean update(Autor autor, int id) {
		try {
			PreparedStatement ps = connection.prepareStatement(UPDATE);
			ps.setString(1,autor.getNome());
			ps.setString(2,autor.getBiografia());
			ps.setInt(3, id);
			
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.getStackTrace();
			return false;			
		}
		
	}
	
	/**
	 * 
	 * @return Retorna todos os autores cadastrados no banco;
	 */	
	public List<Autor> selectAll() {
		try {	
			
			List<Autor> autores = new ArrayList<>();
			NomeAlternativoDAO nomealternativo = new NomeAlternativoDAO();
			PreparedStatement ps;
			ps = connection.prepareStatement(SELECTALL);			
			ResultSet result =  ps.executeQuery();
			while(result.next()) {
				
				Autor autor = new Autor(result.getString("nome"),result.getString("biografia"),nomealternativo.selectNomes(result.getInt("id")));
				autor.setId(result.getInt("id"));
				autores.add(autor);
				
			}			
			return autores;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param id
	 * @return Deleta um autor do banco de acordo com o seu id específico
	 */	
	public boolean delete( int id) {
		try {
			PreparedStatement ps = connection.prepareStatement(DELETE);
			ps.setInt(1,id);			
			
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.getStackTrace();
			return false;			
		}
		
	}
	
	/**
	 * 
	 * @return Apaga todos os dados da tabela autor
	 * 
	 */	
	public boolean deleteAll() {
		try {
			PreparedStatement ps = connection.prepareStatement(DELETEALL);				
			
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.getStackTrace();
			return false;			
		}
	}
}
