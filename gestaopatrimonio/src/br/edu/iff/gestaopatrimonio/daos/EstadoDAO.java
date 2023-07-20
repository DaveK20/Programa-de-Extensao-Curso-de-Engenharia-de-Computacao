package br.edu.iff.gestaopatrimonio.daos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.edu.iff.gestaopatrimonio.models.Estado;
import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;

public class EstadoDAO {
    private Connection conexao;

    public EstadoDAO() {
        this.conexao = (new JDBCConnection()).getConnection();
    }
    public void cadastrarEstado(Estado estado) {
        try {
            String query = "INSERT INTO estado (sigla, nome) VALUES (?, ?)";//bd
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setString(1, Estado.getSigla());
            preparedStatement.setString(2, Estado.getNome());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Estado buscarEstado(int id) {
        try {
            String query = "SELECT * FROM estado WHERE id = ?";//bd
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Estado(resultSet.getInt("id"), resultSet.getString("sigla"), resultSet.getString("nome"));
            }
            
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void atualizarEstado(Estado estadoAtualizado) {
        try {
            String query = "UPDATE estado SET sigla = ?, nome = ? WHERE id = ?";//bd
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setString(1, estadoAtualizado.getSigla());
            preparedStatement.setString(2, estadoAtualizado.getNome());
            preparedStatement.setInt(3, estadoAtualizado.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void apagarEstado(int id) {
        try {
            String query = "DELETE FROM estado WHERE id = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Estado> listarEstados() {
        List<Estado> estados = new ArrayList<>();

        try {
            String query = "SELECT * FROM estado";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Estado estado = new Estado(resultSet.getInt("id"), resultSet.getString("sigla"), resultSet.getString("nome"));
                estados.add(estado);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estados;
    }
}
