package br.edu.iff.gestaopatrimonio.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.iff.gestaopatrimonio.models.FormaAquisicao;
import br.edu.iff.gestaopatrimonio.models.TipoImagem;
import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;

public class TipoImagemDAO {
	private Connection connection;

	public TipoImagemDAO() {
		connection = (new JDBCConnection()).getConnection();
	}

	public TipoImagem cadastrarTipoImagem(int largura, int altura, String descricao) {
		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO tipo_imagem (largura, altura, descricao) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, largura);
			ps.setInt(2, altura);
			ps.setString(3, descricao);
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				TipoImagem imagem = new TipoImagem(largura, altura, descricao);
				imagem.setId(id);
				System.out.println("Registro de tipo de imagem finalizada");
				return imagem;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public TipoImagem pegarTipoImagemId(int id) {
        TipoImagem tipoImagem = null;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM tipo_imagem WHERE id = ?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int largura = resultSet.getInt("largura");
                int altura = resultSet.getInt("altura");
                String descricao = resultSet.getString("descricao");
                
                tipoImagem = new TipoImagem(largura, altura, descricao);
                tipoImagem.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tipoImagem;
    }

	public TipoImagem atualizarTipoImagem(int id, int novaLargura, int novaAltura, String novaDescricao) {
		PreparedStatement ps;
		try {
			ps = connection
					.prepareStatement("UPDATE tipo_imagem SET largura = ?, altura = ?, descricao = ?, WHERE id = ?");
			ps.setInt(1, novaLargura);
			ps.setInt(2, novaAltura);
			ps.setString(3, novaDescricao);
			ps.setInt(4, id);
			ps.executeUpdate();
			TipoImagem imagem = new TipoImagem(novaLargura, novaAltura, novaDescricao);
			imagem.setId(id);
			return imagem;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public TipoImagem atualizarLarguraTipoImagem(int id, int novaLargura) {
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("UPDATE tipo_imagem SET largura = ? WHERE id = ?");
			ps.setInt(1, novaLargura);
			ps.setInt(2, id);
			ps.executeUpdate();
			PreparedStatement consulta;
			consulta = connection.prepareStatement("SELECT * FROM tipo_imagem WHERE id = ?");
			consulta.setInt(1, id);
			ResultSet rs = consulta.executeQuery();
			if (rs.next()) {
				int idNovo = rs.getInt("id");
				int larguraNova = rs.getInt("largura");
				int alturaNova = rs.getInt("altura");
				String descricaoNova = rs.getString("descricao");
				TipoImagem imagem = new TipoImagem(larguraNova, alturaNova, descricaoNova);
				imagem.setId(idNovo);
				return imagem;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public TipoImagem atualizarAlturaTipoImagem(int id, int novaAltura) {
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("UPDATE tipo_imagem SET altura = ? WHERE id = ?");
			ps.setInt(1, novaAltura);
			ps.setInt(2, id);
			ps.executeUpdate();
			PreparedStatement consulta;
			consulta = connection.prepareStatement("SELECT * FROM tipo_imagem WHERE id = ?");
			consulta.setInt(1, id);
			ResultSet rs = consulta.executeQuery();
			if (rs.next()) {
				int idNovo = rs.getInt("id");
				int larguraNova = rs.getInt("largura");
				int alturaNova = rs.getInt("altura");
				String descricaoNova = rs.getString("descricao");
				TipoImagem imagem = new TipoImagem(larguraNova, alturaNova, descricaoNova);
				imagem.setId(idNovo);
				return imagem;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public TipoImagem atualizarDescricaoTipoImagem(int id, String novaDescricao) {
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("UPDATE tipo_imagem SET descricao = ? WHERE id = ?");
			ps.setString(1, novaDescricao);
			ps.setInt(2, id);
			ps.executeUpdate();
			PreparedStatement consulta;
			consulta = connection.prepareStatement("SELECT * FROM tipo_imagem WHERE id = ?");
			consulta.setInt(1, id);
			ResultSet rs = consulta.executeQuery();
			if (rs.next()) {
				int idNovo = rs.getInt("id");
				int larguraNova = rs.getInt("largura");
				int alturaNova = rs.getInt("altura");
				String descricaoNova = rs.getString("descricao");
				TipoImagem imagem = new TipoImagem(larguraNova, alturaNova, descricaoNova);
				imagem.setId(idNovo);
				return imagem;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void removerTipoDeImagem(int id) {
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("DELETE FROM tipo_imagem WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Remoção concluída");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
