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
			PreparedStatement ps = connection.prepareStatement("INSERT INTO patrimonio (numero_de_identificacao, observacoes, catalogacao, "
					+ "tombo, inventario_museologico, inventario_patrimonial, local_guardado, tipo_patrimonio_id, unidade_administrativa_id, "
					+ "classificacao_generica_id ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);\r\n"
					+ "" );
			ps.setString(1,"123456");
			ps.setString(2, patrimonio.getObservacoes());
			ps.setString(3,"Gr0001");
			ps.setString(4,"00210");
			ps.setString(5,"80.000.069");
			ps.setString(6,"0171");
			ps.setString(7,"Exposição Permanente – salão oval, nicho 1");
			ps.setString(8,"1");
			ps.setString(9,"2");
			ps.setString(10,"1");
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
