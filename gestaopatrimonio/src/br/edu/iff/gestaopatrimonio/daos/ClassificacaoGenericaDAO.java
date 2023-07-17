package br.edu.iff.gestaopatrimonio.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.models.ClassificacaoGenerica;
import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;

public class ClassificacaoGenericaDAO {
	Connection connection;
	
	public ClassificacaoGenericaDAO(){
		connection = (new JDBCConnection()).getConnection();	
	}
	
    public ClassificacaoGenerica cadastrarClassificacaoGenerica(String nome, String descricao) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("INSERT INTO classificacao_generica(nome, descricao) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, nome);
			ps.setString(2, descricao);
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				ClassificacaoGenerica classificacao = new ClassificacaoGenerica(id,nome, descricao);
				System.out.println("Registro de classificacao finalizada");
				return classificacao;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    	return null;
    }
    
    public ClassificacaoGenerica atualizarClassificacaoGenerica(int id, String novoNome, String novaDescricao) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("UPDATE classificacao_generica SET nome = ?, descricao = ? WHERE id = ?");
			ps.setString(1, novoNome);
			ps.setString(2, novaDescricao);
			ps.setInt(3, id);
			ps.executeUpdate();
			ClassificacaoGenerica classificacao = new ClassificacaoGenerica(id, novoNome, novaDescricao);
			System.out.println(classificacao.getId()+" "+classificacao.getNome()+" "+classificacao.getDescricao());
			return classificacao;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public ClassificacaoGenerica atualizarNomeClassificacaoGenerica(int id,String novoNome) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("UPDATE classificacao_generica SET nome = ? WHERE id = ?");
			ps.setString(1, novoNome);
			ps.setInt(2, id);
			ps.executeUpdate();
			
			PreparedStatement consulta;
			consulta = connection.prepareStatement("SELECT * FROM classificacao_generica WHERE id = ?");
			consulta.setInt(1, id);
			ResultSet rs = consulta.executeQuery();
			if(rs.next()) {
				int idNovo = rs.getInt("id");
				String nomeNovo = rs.getString("nome");
				String descricao = rs.getString("descricao");
				ClassificacaoGenerica classificacao = new ClassificacaoGenerica(idNovo, nomeNovo, descricao);
				return classificacao;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public ClassificacaoGenerica atualizarDescricaoClassificacaoGenerica(int id, String novaDescricao) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("UPDATE classificacao_generica SET descricao = ? WHERE id = ?");
			ps.setString(1, novaDescricao);
			ps.setInt(2, id);
			ps.executeUpdate();
			PreparedStatement consulta;
			consulta = connection.prepareStatement("SELECT * FROM classificacao_generica WHERE id = ?");
			consulta.setInt(1, id);
			ResultSet rs = consulta.executeQuery();
			if(rs.next()) {
				int idNovo = rs.getInt("id");
				String nome = rs.getString("nome");
				String descricaoNova = rs.getString("descricao");
				ClassificacaoGenerica classificacao = new ClassificacaoGenerica(idNovo, nome, descricaoNova);
				return classificacao;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public void removerClassificacaoGenerica(int id) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("DELETE FROM classificacao_generica WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Remoção concluída");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public List<ClassificacaoGenerica> listarClassificacaoGenerica() {
    	List<ClassificacaoGenerica> listaClassificacaoGenerica= new ArrayList<>();
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("SELECT * FROM classificacao_generica");
			ResultSet rs = ps.executeQuery();
			while(rs.next() != false) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				ClassificacaoGenerica classificacao = new ClassificacaoGenerica(id, nome, descricao);
				
				listaClassificacaoGenerica.add(classificacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    	return listaClassificacaoGenerica;
    }
}
