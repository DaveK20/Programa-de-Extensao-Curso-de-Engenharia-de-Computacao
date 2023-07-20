package br.edu.iff.gestaopatrimonio.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.models.Material;
import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;

public class MaterialDAO {
	Connection connection;
	
	public MaterialDAO(){
		connection = (new JDBCConnection()).getConnection();	
	}
	
    public Material cadastrarMaterial(String nome) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("INSERT INTO material(nome) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, nome);
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				Material material = new Material(id,nome);
				System.out.println("Registro de material finalizado");
				return material;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    	return null;
    }
    
    public Material atualizarMaterial(int id, String novoNome) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("UPDATE material_generica SET nome = ? WHERE id = ?");
			ps.setString(1, novoNome);
			ps.setInt(2, id);
			ps.executeUpdate();
			Material material = new Material(id, novoNome);
			System.out.println(material.getId()+" "+material.getNome());
			return material;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public Material atualizarNomeMaterial(int id,String novoNome) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("UPDATE material SET nome = ? WHERE id = ?");
			ps.setString(1, novoNome);
			ps.setInt(2, id);
			ps.executeUpdate();
			
			PreparedStatement consulta;
			consulta = connection.prepareStatement("SELECT * FROM material WHERE id = ?");
			consulta.setInt(1, id);
			ResultSet rs = consulta.executeQuery();
			if(rs.next()) {
				int idNovo = rs.getInt("id");
				String nomeNovo = rs.getString("nome");
				Material material = new Material(idNovo, nomeNovo);
				return material;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    
    public void removerMaterial(int id) {
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("DELETE FROM material WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Remoção concluída");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public List<Material> listarMaterial() {
    	List<Material> listaMaterial= new ArrayList<>();
    	PreparedStatement ps;
    	try {
			ps = connection.prepareStatement("SELECT * FROM material");
			ResultSet rs = ps.executeQuery();
			while(rs.next() != false) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				Material material = new Material(id, nome);
				
				listaMaterial.add(material);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    	return listaMaterial;
    }
}
