package br.edu.iff.gestaopatrimonio.daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.models.Aquisicao;
import br.edu.iff.gestaopatrimonio.models.FormaAquisicao;
import br.edu.iff.gestaopatrimonio.daos.FormaAquisicaoDAO;
import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;

public class AquisicaoDAO {
	private Connection connection;

    public AquisicaoDAO() {
    	JDBCConnection temp = new JDBCConnection();
    	connection = temp.getConnection();
    }

    // Create - Inserir uma nova aquisição
    public void insertAquisicao(Aquisicao aquisicao, int patrimonio_id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO aquisicao (data, patrimonio_id, forma_aquisicao_id) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, aquisicao.getData());
            statement.setInt(2, patrimonio_id);
            statement.setInt(3, aquisicao.getFormaAquisicao().getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    aquisicao.setId(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read - Obter todas as aquisições
    public List<Aquisicao> getAllAquisicoes() {
        List<Aquisicao> aquisicoes = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM aquisicao");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String data = resultSet.getString("data");
                int formaAquisicaoId = resultSet.getInt("forma_aquisicao_id");

                // Obter a forma de aquisição correspondente
                FormaAquisicaoDAO formaAquisicaoDAO = new FormaAquisicaoDAO();
                FormaAquisicao formaAquisicao = formaAquisicaoDAO.getFormaAquisicaoById(formaAquisicaoId);

                Aquisicao aquisicao = new Aquisicao(data, formaAquisicao);
                aquisicao.setId(id);
                aquisicoes.add(aquisicao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aquisicoes;
    }

    // Update - Atualizar uma aquisição existente
    public void updateAquisicao(Aquisicao aquisicao) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE aquisicao SET data = ?, forma_aquisicao_id = ? WHERE id = ?");

            statement.setString(1, aquisicao.getData());
            statement.setInt(2, aquisicao.getFormaAquisicao().getId());
            statement.setInt(3, aquisicao.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete - Excluir uma aquisição
    public void deleteAquisicao(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM aquisicao WHERE id = ?");

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Aquisicao> getAllAquisicaoByIdPatrimonio(int patrimonio_id) {
        List<Aquisicao> Aquisicao = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM aquisicao WHERE patrimonio_id = ?");
            statement.setInt(1, patrimonio_id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	FormaAquisicaoDAO temp = new FormaAquisicaoDAO();
                String data = resultSet.getString("data");
                FormaAquisicao formaAquisicao = temp.getFormaAquisicaoById(resultSet.getInt("forma_aquisicao_id"));
                Aquisicao tempAquisicao = new Aquisicao(data,formaAquisicao);
                tempAquisicao.setId(resultSet.getInt("id"));
                Aquisicao.add(tempAquisicao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Aquisicao;
    }
    
    public Aquisicao getAquisicaoById(int id) {
        Aquisicao Aquisicao = null;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM aquisicao WHERE id = ?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                FormaAquisicaoDAO temp = new FormaAquisicaoDAO();
                String data = resultSet.getString("data");
                FormaAquisicao formaAquisicao = temp.getFormaAquisicaoById(resultSet.getInt("forma_aquisicao_id"));
                Aquisicao = new Aquisicao(data,formaAquisicao);
                Aquisicao.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Aquisicao;
    }
}