package br.edu.iff.gestaopatrimonio.daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.models.FormaAquisicao;
import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;

public class FormaAquisicaoDAO {
    private Connection connection;

    public FormaAquisicaoDAO() {
    	JDBCConnection temp = new JDBCConnection();
    	connection = temp.getConnection();
    }

    // Create - Inserir uma nova forma de aquisição
    public boolean insertFormaAquisicao(FormaAquisicao formaAquisicao) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO forma_aquisicao (tipo) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, formaAquisicao.getTipo());
            return statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read - Obter todas as formas de aquisição
    public List<FormaAquisicao> getAllFormasAquisicao() {
        List<FormaAquisicao> formasAquisicao = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM forma_aquisicao");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");

                FormaAquisicao formaAquisicao = new FormaAquisicao(nome);
                formaAquisicao.setId(id);
                formasAquisicao.add(formaAquisicao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return formasAquisicao;
    }

    // Update - Atualizar uma forma de aquisição existente
    public boolean updateFormaAquisicao(FormaAquisicao formaAquisicao) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE forma_aquisicao SET tipo = ? WHERE id = ?");

            statement.setString(1, formaAquisicao.getTipo());
            statement.setInt(2, formaAquisicao.getId());

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public FormaAquisicao getFormaAquisicaoById(int id) {
        FormaAquisicao formaAquisicao = null;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM forma_aquisicao WHERE id = ?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String tipo = resultSet.getString("tipo");

                formaAquisicao = new FormaAquisicao(tipo);
                formaAquisicao.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return formaAquisicao;
    }

    // Delete - Excluir uma forma de aquisição
    public boolean deleteFormaAquisicao(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM forma_aquisicao WHERE id = ?");

            statement.setInt(1, id);

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
