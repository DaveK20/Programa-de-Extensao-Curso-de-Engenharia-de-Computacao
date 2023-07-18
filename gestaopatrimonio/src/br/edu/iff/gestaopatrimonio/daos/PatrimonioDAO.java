package br.edu.iff.gestaopatrimonio.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.models.Patrimonio;
import br.edu.iff.gestaopatrimonio.utils.JDBCConnection;

public class PatrimonioDAO {

	private Connection connection;

	public PatrimonioDAO() {
		connection = (new JDBCConnection()).getConnection();
	}

	public Patrimonio cadastrar(Patrimonio patrimonio) throws Exception {
		try {

			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO patrimonio ( observacoes, numero_de_identificacao,"
							+ "pesquisa_museologica, tema, catalogacao, tombo, movimento, inventario_museologico, inventario_patrimonial,"
							+ "informacao_data, local_guardado, assinatura, titulo, tipo_patrimonio_id, unidade_administrativa_id, "
							+ "classificacao_generica_id ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? );\r\n"
							+ "");
			ps.setString(1, patrimonio.getObservacoes());
			ps.setInt(2, patrimonio.getNumeroDeIdentificacao());
			ps.setString(3, patrimonio.getPesquisaMuseologica());
			ps.setString(4, patrimonio.getTema());
			ps.setString(5, patrimonio.getCatalogacao());
			ps.setString(6, patrimonio.getTombo());
			ps.setString(7, patrimonio.getMovimento());
			ps.setString(8, patrimonio.getInventarioMuseologico());
			ps.setString(9, patrimonio.getInventarioPatrimonial());
			ps.setString(10, patrimonio.getInformacaoData());
			ps.setString(11, patrimonio.getLocalGuardado());
			ps.setString(12, patrimonio.getAssinatura());
			ps.setString(13, patrimonio.getTitulo());
			ps.setInt(14, patrimonio.getTipoPatrimonio().getId());
			ps.setInt(15, patrimonio.getUnidadeAdministrativa().getId());
			ps.setInt(16, patrimonio.getClassificacaoGenerica().getId());
			ps.execute();
		} catch (Exception e) {

		}
		return patrimonio;
	}

	public List<Patrimonio> listar() {
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM patrimonio");
			ResultSet result = ps.executeQuery();
			if (!result.next()) {
				throw new Exception("Nenhum patrimônio cadastrado.");
			}
			List<Patrimonio> patrimonios = new ArrayList<Patrimonio>();
			do {
				Patrimonio patrimonio = new Patrimonio();
				patrimonio.setObservacoes(result.getString(2));
				patrimonios.add(patrimonio);
			} while (result.next());
			return patrimonios;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Boolean atualizar(Patrimonio patrimonio, int id) {
		return false;
	}

	public Boolean apagar(int id) {
		return false;
	}

	public Patrimonio buscarPorTitulo(String titulo) {
		return null;
	}

}
