package br.edu.iff.gestaopatrimonio.daos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.models.Pais;
import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;

public class PaisDAO {
    private Connection conexao;

    public PaisDAO() {
        this.conexao = (new JDBCConnection()).getConnection();
    }

    public List<Pais> listarPaises() {
        List<Pais> paises = new ArrayList<>();

        try {
            String query = "SELECT * FROM pais";// depende
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Pais pais = new Pais(resultSet.getInt("id"),resultSet.getString("nome") );
                pais.setId(resultSet.getInt("id"));
                paises.add(pais);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paises;
    }

    public void adicionarPais(Pais pais) {
        try {
            String query = "INSERT INTO pais ( nome) VALUES (?)";// depende
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setString(1, pais.getNome());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarPais(Pais pais) {
        try {
            String query = "UPDATE pais SET nome = ? WHERE id = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setString(1, pais.getNome());
            preparedStatement.setInt(2, pais.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerPais(int id) {
        try {
            String query = "DELETE FROM pais WHERE id = ?";// depende
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Pais> selectPaises(int procedencia_id) {// mudar
        try {
            List<Pais> paises = new ArrayList<>();
            String query = "SELECT * FROM pais WHERE autor_id = ?";// depende
            PreparedStatement statement = conexao.prepareStatement(query);
            statement.setInt(1, procedencia_id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Pais pais = new Pais(resultSet.getInt("id"),resultSet.getString("nome") );//mudar
                pais.setId(resultSet.getInt("id"));//remover depois, não precisa setar o resultado novamente
                paises.add(pais);
            }
            return paises;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
}
