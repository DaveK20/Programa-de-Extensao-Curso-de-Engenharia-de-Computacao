package br.edu.iff.gestaopatrimonio.daos;
	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	import br.edu.iff.gestaopatrimonio.models.Cidade;
	import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;

	public class CidadeDAO {
	    private Connection conexao;

	    public CidadeDAO() {
	        this.conexao = (new JDBCConnection()).getConnection();
	    }

	    public List<Cidade> listarCidades() {
	        List<Cidade> cidades = new ArrayList<>();

	        try {
	            String query = "SELECT * FROM cidade";
	            Statement statement = conexao.createStatement();
	            ResultSet resultSet = statement.executeQuery(query);

	            while (resultSet.next()) {
	            	int id = resultSet.getInt("id");
	            	String nome = resultSet.getString("nome");
	                Cidade cidade = new Cidade(id, nome);
	                cidade.setId(resultSet.getInt("id"));
	                cidades.add(cidade);
	            }

	            resultSet.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return cidades;
	    }

	    public void adicionarCidade(Cidade cidade) {
	        try {
	            String query = "INSERT INTO cidade ( nome) VALUES (?)";
	            PreparedStatement preparedStatement = conexao.prepareStatement(query);
	            preparedStatement.setString(1, cidade.getNome());
	            preparedStatement.execute();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void atualizarCidade(Cidade cidade) {
	        try {
	            String query = "UPDATE cidade SET nome = ? WHERE id = ?";
	            PreparedStatement preparedStatement = conexao.prepareStatement(query);
	            preparedStatement.setString(1, cidade.getNome());
	            preparedStatement.setInt(2, cidade.getId());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void removerCidade(int id) {
	        try {
	            String query = "DELETE FROM cidade WHERE id = ?";
	            PreparedStatement preparedStatement = conexao.prepareStatement(query);
	            preparedStatement.setInt(1, id);
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public List<Cidade> selectCidades(int procedencia_id) {
	        try {
	            List<Cidade> cidades = new ArrayList<>();
	            String query = "SELECT * FROM cidade WHERE procedencia_id = ?";
	            PreparedStatement statement = conexao.prepareStatement(query);
	            statement.setInt(1, procedencia_id);
	            ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                Cidade cidade = new Cidade(resultSet.getInt("procedencia_id"), resultSet.getString("nome"));
	                cidade.setId(resultSet.getInt("id"));
	                cidades.add(cidade);
	            }
	            return cidades;

	        } catch (SQLException e) {
	            e.printStackTrace();

	        }
	        return null;
	    }
	}
