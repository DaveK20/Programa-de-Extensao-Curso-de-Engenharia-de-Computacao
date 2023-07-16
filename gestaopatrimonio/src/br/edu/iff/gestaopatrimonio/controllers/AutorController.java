package br.edu.iff.gestaopatrimonio.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.daos.*;
import br.edu.iff.gestaopatrimonio.models.*;

public class AutorController {

	AutorDAO autordao = new AutorDAO();
	
	
	
	/**
	 *  
	 * 
	 * @param Autor
	 * @Função Insere um objeto do tipo autor no banco de dados
	 */
	public boolean insert(Autor autor) {
		if(autor.getNome().length()> 45) {
			return false;
		}else {
			for(Autor a :autordao.selectAll()) {
				if(a.getBiografia().equals(autor.getBiografia())) {
					return false;
				}
			}
		}
		autordao.insert(autor);
		return true;
	}
	
	/**
	 * 
	 * @param nome
	 * @return Retorna uma lista de autores com o nome solicitado
	 */	
	public List<Autor> selectNome(String nome) {
		return autordao.selectNome(nome); 
	}
	
	/**
	 * 	
	 * @param autor
	 * @param id
	 * @return Atualiza um autor no banco, recebendo um novo autor, e o id referente a ele no banco
	 */
	public boolean update(Autor autor, int id) {
		return autordao.update(autor,id);
	}
	
	/**
	 * 
	 * @return Retorna todos os autores cadastrados no banco;
	 */	
	public List<Autor> selectAll() {
		return autordao.selectAll();
	}
	
	/**
	 * 
	 * @param id
	 * @return Deleta um autor do banco de acordo com o seu id específico
	 */	
	public boolean delete( int id) {
		return autordao.delete(id);
		
	}
	
	/**
	 * 
	 * @return Apaga todos os dados da tabela autor
	 * 
	 */	
	public boolean deleteAll() {
		return autordao.deleteAll();
	}
	
}
