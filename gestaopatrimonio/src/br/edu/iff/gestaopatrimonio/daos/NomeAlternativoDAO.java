package br.edu.iff.gestaopatrimonio.daos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.models.NomeAlternativo;
import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;

public class NomeAlternativoDAO {
    private Connection conexao;

    public NomeAlternativoDAO() {
    	this.conexao = (new JDBCConnection()).getConnection();
    }

    public List<NomeAlternativo> listarNomesAlternativos() {
        List<NomeAlternativo> nomesAlternativos = new ArrayList<>();

        try {
            String query = "SELECT * FROM nome_alternativo";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                NomeAlternativo nomeAlternativo = new NomeAlternativo(resultSet.getString("nome_alternativo"),resultSet.getInt("autor_id"));
                nomeAlternativo.setId(resultSet.getInt("id"));               
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
            String query = "INSERT INTO nome_alternativo (autor_id, nome_alternativo) VALUES (?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setInt(1, nomeAlternativo.getAutor_id());
            preparedStatement.setString(2, nomeAlternativo.getNome());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarNomeAlternativo(NomeAlternativo nomeAlternativo) {
        try {
            String query = "UPDATE nome_alternativo SET nome = ? WHERE id = ?";
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
            String query = "DELETE FROM nome_alternativo WHERE id = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<NomeAlternativo> selectNomes(int autor_id) {
    	 try {
    		 List<NomeAlternativo> nomealternativo = new ArrayList<>();
             String query = "SELECT * FROM nome_alternativo WHERE autor_id = ?";
             PreparedStatement statement = conexao.prepareStatement(query);
             statement.setInt(1, autor_id);
             ResultSet resultSet = statement.executeQuery();

             while (resultSet.next()) {
                 NomeAlternativo nomeAlternativo = new NomeAlternativo(resultSet.getString("nome_alternativo"),resultSet.getInt("autor_id"));
                 nomeAlternativo.setId(resultSet.getInt("id"));               
                 nomealternativo.add(nomeAlternativo);
             }
             return nomealternativo;             
             
         } catch (SQLException e) {
             e.printStackTrace();
            
         }
    	 return null;
         
    }
}
