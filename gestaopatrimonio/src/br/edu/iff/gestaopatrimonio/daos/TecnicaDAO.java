package br.edu.iff.gestaopatrimonio.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.models.Tecnica;
import br.edu.iff.gestaopatrimonio.models.UnidadeAdministrativa;
import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;



public class TecnicaDAO {
	
	private Connection connection;
	
	public TecnicaDAO() {
		connection = (new JDBCConnection()).getConnection();
	}
	

//	public Tecnica cadastrarTecnica(Tecnica tecnica) throws Exception {
//		try {
//			PreparedStatement ps = connection.prepareStatement("INSERT INTO tecnica (nome) VALUES (?)" );
//			//ps.setString(1, tecnica.nome);
//			ps.execute();			
//		} catch (Exception e) {
//
//		}
//		return tecnica;
//	}
	public Tecnica cadastrarTecnica(String nome) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO tecnica (nome) VALUES (?)",Statement.RETURN_GENERATED_KEYS );
			ps.setString(1, nome);
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				Tecnica tecnica = new Tecnica(id, nome);
				System.out.println("Registro de tecnica finalizada");
				return tecnica;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
    public Tecnica atualizarTecnica(int id, String novoNome) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("UPDATE tecnica SET nome = ? WHERE id = ?");
			ps.setString(1, novoNome);
			ps.setInt(2, id);
			ps.executeUpdate();
			Tecnica tecnica = new Tecnica(id, novoNome);
			return tecnica;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
	
    public void removerTecnica(int id) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("DELETE FROM tecnica WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Remoção concluída");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
	public List<Tecnica> listarTecnicas(){
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM tecnica");
			ResultSet result = ps.executeQuery();
			if(!result.next()) {
				throw new Exception("Nenhum tecnica cadastrada.");
			}
			List<Tecnica> tecnicas = new ArrayList<Tecnica>();
            do {
                Tecnica tecnica = new Tecnica();
                //tecnica.nome = result.getString(2);
                tecnicas.add(tecnica);
            }while (result.next());
			return tecnicas;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
     	


}
