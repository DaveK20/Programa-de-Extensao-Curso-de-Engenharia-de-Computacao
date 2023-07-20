package br.edu.iff.gestaopatrimonio.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;

public class ProcedenciaDAO {

	private Connection connection;

	public ProcedenciaDAO() {
		connection = (new JDBCConnection()).getConnection();
	}

	public void cadastrarProcedencia(LocalDate data, int patrimonioId, int paisId, int estadoId, int cidadeId) {
		try {
			java.sql.Date dataProcedencia = java.sql.Date.valueOf(data);
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO procedencia (data, patrimonio_id, pais_id, estado_id, cidade_id) VALUES (?,?,?,?,?)");
			ps.setDate(1, dataProcedencia);
			ps.setInt(2, patrimonioId);
			ps.setInt(3, paisId);
			ps.setInt(5, estadoId);
			ps.setInt(5, cidadeId);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void atualizarProcedencia(int procedenciaId, LocalDate novaData, int novoPatrimonioId, int novoPaisId,
			int novoEstadoId, int novaCidadeId) {
		try {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE procedencia Set data = ?, patrimonio_id = ?, pais_id = ?, estado_id = ?, cidade id = ? WHERE id = ?");
			ps.setDate(1, java.sql.Date.valueOf(novaData));
			ps.setInt(2, novoPatrimonioId);
			ps.setInt(3, novoPaisId);
			ps.setInt(4, novoEstadoId);
			ps.setInt(5, novaCidadeId);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removerProcedencia(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM procedencia WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
