package br.edu.iff.gestaopatrimonio.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.models.Patrimonio;
import br.edu.iff.gestaopatrimonio.models.Tecnica;
import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;



public class PatrimonioDAO {
	
	private Connection connection;
	
	public PatrimonioDAO() {
		connection = (new JDBCConnection()).getConnection();
	}
	

	public Patrimonio cadastrar(Patrimonio patrimonio) throws Exception {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO patrimonio (observacoes) VALUES (?)" );
			ps.setString(1, patrimonio.getObservacoes());
			ps.execute();			
		} catch (Exception e) {

		}
		return patrimonio;
	}
	
	public List<Patrimonio> listar(){
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM patrimonio");
			ResultSet result = ps.executeQuery();
			if(!result.next()) {
				throw new Exception("Nenhum patrimônio cadastrado.");
			}
			List<Patrimonio> patrimonios = new ArrayList<Patrimonio>();
            do {
                Patrimonio patrimonio = new Patrimonio();
                patrimonio.setObservacoes(result.getString(2));
                patrimonios.add(patrimonio);
            }while (result.next());
			return patrimonios;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
     	


}
