package br.edu.iff.gestaopatrimonio.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.models.Imagem;
import br.edu.iff.gestaopatrimonio.models.TipoImagem;
import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;

public class ImagemDAO {
	private Connection connection;

	public ImagemDAO() {
		connection = (new JDBCConnection()).getConnection();
	}
	
	public boolean inserirImagem(String nome, String data, String arquivo, TipoImagem tipoImagem) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO imagens (nome, data, arquivo, tipoImagemId) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, nome);
            statement.setString(2, data);
            statement.setString(3, arquivo);
            statement.setObject(4, tipoImagem);

            return statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	public Imagem buscarImagemPorId(int id) {
		Imagem imagem = null;
		
		try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM imagem WHERE id = ?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                TipoImagemDAO temp = new TipoImagemDAO();
                String nome = resultSet.getString("nome");
                String data = resultSet.getString("data");
                String arquivo = resultSet.getString("arquivo");
                TipoImagem tipoImagem = temp.pegarTipoImagemId(resultSet.getInt("tipo_imagem_id"));
                imagem = new Imagem(nome, data, arquivo, tipoImagem);
                imagem.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return imagem;
    }
	
	public List<Imagem> listarImagens() {
        List<Imagem> imagens = new ArrayList<>();
        try {
        	Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM imagens");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String data = resultSet.getString("data");
                String arquivo = resultSet.getString("arquivo");
                int tipoImagemId = resultSet.getInt("tipo_imagem_id");
                
                TipoImagemDAO tipoImagemDAO = new TipoImagemDAO();
                TipoImagem tipoImagem = tipoImagemDAO.pegarTipoImagemId(tipoImagemId);
                
                Imagem imagem = new Imagem(nome, data, arquivo, tipoImagem);
                imagem.setId(id);
                imagens.add(imagem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imagens;
    }
	
	public boolean atualizarImagem(Imagem imagem) {
		try {
			PreparedStatement statement = connection.prepareStatement("UPDATE aquisicao SET"
					+ " nome = ?, data = ?, arquivo = ?, tipoImagemId=? WHERE id = ?");
			
			statement.setString(1, imagem.getNome());
			statement.setString(2, imagem.getData());
			statement.setString(3, imagem.getArquivo());
			statement.setInt(4, imagem.getTipoImagem().getId());
			
			statement.executeUpdate();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deletarImagem(int id) {
		try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM imagem WHERE id = ?");

            statement.setInt(1, id);

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }	
}
