package br.edu.iff.gestaopatrimonio.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.models.UnidadeAdministrativa;
import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;

public class UnidadeAdministrativaDAO {
	Connection connection;
	
	public UnidadeAdministrativaDAO(){
		connection = (new JDBCConnection()).getConnection();
		
	}
	
    public UnidadeAdministrativa cadastrarUnidadeAdministrativa(String sigla, String nome) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("INSERT INTO unidade_administrativa(sigla, nome) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, sigla);
			ps.setString(2, nome);
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				UnidadeAdministrativa ua = new UnidadeAdministrativa(id,sigla, nome);
				System.out.println("Registro de unidade finalizada");
				return ua;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    	return null;
    }
    
    public UnidadeAdministrativa atualizarUnidadeAdministrativa(int id, String novaSigla, String novoNome) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("UPDATE unidade_administrativa SET sigla = ?, nome = ? WHERE id = ?");
			ps.setString(1, novaSigla);
			ps.setString(2, novoNome);
			ps.setInt(3, id);
			ps.executeUpdate();
			UnidadeAdministrativa ue = new UnidadeAdministrativa(id, novaSigla, novoNome);
			return ue;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public UnidadeAdministrativa atualizarSiglaUnidadeAdministrativa(int id,String novaSigla) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("UPDATE unidade_administrativa SET sigla = ? WHERE id = ?");
			ps.setString(1, novaSigla);
			ps.setInt(2, id);
			ps.executeUpdate();
			
			PreparedStatement consulta;
			consulta = connection.prepareStatement("SELECT * FROM unidade_administrativa WHERE id = ?");
			consulta.setInt(1, id);
			ResultSet rs = consulta.executeQuery();
			if(rs.next()) {
				int idNovo = rs.getInt("id");
				String siglaNova = rs.getString("sigla");
				String nomeNovo = rs.getString("nome");
				UnidadeAdministrativa ue = new UnidadeAdministrativa(idNovo, siglaNova, nomeNovo);
				return ue;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public UnidadeAdministrativa atualizarNomeUnidadeAdministrativa(int id, String novoNome) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("UPDATE unidade_administrativa SET nome = ? WHERE id = ?");
			ps.setString(1, novoNome);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println(ps);
			PreparedStatement consulta;
			consulta = connection.prepareStatement("SELECT * FROM unidade_administrativa WHERE id = ?");
			consulta.setInt(1, id);
			ResultSet rs = consulta.executeQuery();
			if(rs.next()) {
				int idNovo = rs.getInt(1);
				String siglaNova = rs.getString("sigla");
				String nomeNovo = rs.getString("nome");
				UnidadeAdministrativa ue = new UnidadeAdministrativa(idNovo, siglaNova, nomeNovo);
				return ue;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public void removerUnidadeAdministrativa(int id) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("DELETE FROM unidade_administrativa WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Remoção concluída");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public List<UnidadeAdministrativa> listarUnidadeAdiministrativa() {
    	List<UnidadeAdministrativa> listaUnidadeAdministrativa= new ArrayList<>();
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("SELECT * FROM unidade_administrativa");
			ResultSet rs = ps.executeQuery();
			while(rs.next() != false) {
				int id = rs.getInt("id");
				String sigla = rs.getString("sigla");
				String nome = rs.getString("nome");
				UnidadeAdministrativa unidade = new UnidadeAdministrativa(id, sigla, nome);
				
				listaUnidadeAdministrativa.add(unidade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    	return listaUnidadeAdministrativa;
    }    
}
