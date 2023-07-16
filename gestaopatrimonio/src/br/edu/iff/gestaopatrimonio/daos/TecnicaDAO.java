package br.edu.iff.gestaopatrimonio.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.models.Tecnica;
import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;



public class TecnicaDAO {
	
	private Connection connection;
	
	public TecnicaDAO() {
		connection = (new JDBCConnection()).getConnection();
	}
	

	public Tecnica cadastrarTecnica(Tecnica tecnica) throws Exception {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO tecnica (nome) VALUES (?)" );
			ps.setString(1, tecnica.nome);
			ps.execute();			
		} catch (Exception e) {

		}
		return tecnica;
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
                tecnica.nome = result.getString(2);
                tecnicas.add(tecnica);
            }while (result.next());
			return tecnicas;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
     	


}
