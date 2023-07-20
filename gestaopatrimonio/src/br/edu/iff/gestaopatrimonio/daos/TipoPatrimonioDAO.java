package br.edu.iff.gestaopatrimonio.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.models.TipoPatrimonio;
import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;

public class TipoPatrimonioDAO {
	Connection connection;
	
	public TipoPatrimonioDAO(){
		connection = (new JDBCConnection()).getConnection();	
	}
	
    public TipoPatrimonio cadastrarTipoPatrimonio(String nome_tipo_patrimonio) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("INSERT INTO tipo_patrimonio(nome_tipo_patrimonio) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, nome_tipo_patrimonio);
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				TipoPatrimonio tipo_patrimonio = new TipoPatrimonio(id,nome_tipo_patrimonio);
				System.out.println("Registro de tipo_patrimonio finalizado");
				return tipo_patrimonio;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    	return null;
    }
    
    public TipoPatrimonio atualizarTipoPatrimonio(int id, String novoNome_tipo_patrimonio) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("UPDATE tipo_patrimonio_generica SET nome_tipo_patrimonio = ? WHERE id = ?");
			ps.setString(1, novoNome_tipo_patrimonio);
			ps.setInt(2, id);
			ps.executeUpdate();
			TipoPatrimonio tipo_patrimonio = new TipoPatrimonio(id, novoNome_tipo_patrimonio);
			System.out.println(tipo_patrimonio.getId()+" "+tipo_patrimonio.getNome_tipo_patrimonio());
			return tipo_patrimonio;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public TipoPatrimonio atualizarNome_tipo_patrimonioTipoPatrimonio(int id,String novoNome_tipo_patrimonio) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("UPDATE tipo_patrimonio SET nome_tipo_patrimonio = ? WHERE id = ?");
			ps.setString(1, novoNome_tipo_patrimonio);
			ps.setInt(2, id);
			ps.executeUpdate();
			
			PreparedStatement consulta;
			consulta = connection.prepareStatement("SELECT * FROM tipo_patrimonio WHERE id = ?");
			consulta.setInt(1, id);
			ResultSet rs = consulta.executeQuery();
			if(rs.next()) {
				int idNovo = rs.getInt("id");
				String nome_tipo_patrimonioNovo = rs.getString("nome_tipo_patrimonio");
				TipoPatrimonio tipo_patrimonio = new TipoPatrimonio(idNovo, nome_tipo_patrimonioNovo);
				return tipo_patrimonio;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    
    public void removerTipoPatrimonio(int id) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("DELETE FROM tipo_patrimonio WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Remoção concluída");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public List<TipoPatrimonio> listarTipoPatrimonio() {
    	List<TipoPatrimonio> listaTipoPatrimonio= new ArrayList<>();
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("SELECT * FROM tipo_patrimonio");
			ResultSet rs = ps.executeQuery();
			while(rs.next() != false) {
				int id = rs.getInt("id");
				String nome_tipo_patrimonio = rs.getString("nome_tipo_patrimonio");
				TipoPatrimonio tipo_patrimonio = new TipoPatrimonio(id, nome_tipo_patrimonio);
				
				listaTipoPatrimonio.add(tipo_patrimonio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    	return listaTipoPatrimonio;
    }
}


