package br.edu.iff.gestaopatrimonio.daos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NomeAlternativoDAO {
    private Connection conexao;

    public NomeAlternativoDAO() {
    	connection = (new JDBCConnection()).getConnection();
    }

    public List<NomeAlternativo> listarNomesAlternativos() {
        List<NomeAlternativo> nomesAlternativos = new ArrayList<>();

        try {
            String query = "SELECT * FROM nomes_alternativos";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                NomeAlternativo nomeAlternativo = new NomeAlternativo();
                nomeAlternativo.setId(resultSet.getInt("id"));
                nomeAlternativo.setNome(resultSet.getString("nome"));
                nomesAlternativos.add(nomeAlternativo);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nomesAlternativos;
    }

    public void adicionarNomeAlternativo(NomeAlternativo nomeAlternativo) {
        try {
            String query = "INSERT INTO nomes_alternativos (id, nome) VALUES (?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setInt(1, nomeAlternativo.getId());
            preparedStatement.setString(2, nomeAlternativo.getNome());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarNomeAlternativo(NomeAlternativo nomeAlternativo) {
        try {
            String query = "UPDATE nomes_alternativos SET nome = ? WHERE id = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setString(1, nomeAlternativo.getNome());
            preparedStatement.setInt(2, nomeAlternativo.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerNomeAlternativo(int id) {
        try {
            String query = "DELETE FROM nomes_alternativos WHERE id = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
