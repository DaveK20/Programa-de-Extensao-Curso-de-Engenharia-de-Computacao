package br.edu.iff.gestaopatrimonio.daos;

/**
 * @author hj_ro
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.models.ClassificacaoGenerica;
import br.edu.iff.gestaopatrimonio.models.Patrimonio;
import br.edu.iff.gestaopatrimonio.models.TipoPatrimonio;
import br.edu.iff.gestaopatrimonio.models.UnidadeAdministrativa;
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
							+ "", Statement.RETURN_GENERATED_KEYS);
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
			ResultSet id = ps.getGeneratedKeys();
			id.next();
			patrimonio.setId(id.getInt(1));
			return patrimonio;
		} catch (Exception e) {

		}
		return patrimonio;
	}

	public List<Patrimonio> listar() {
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM patrimonio");
			ResultSet result = ps.executeQuery();
			if (!result.next()) {
				throw new Exception("Nenhum patrim�nio cadastrado.");
			}
			List<Patrimonio> patrimonios = new ArrayList<Patrimonio>();
			do {
				Patrimonio patrimonio = new Patrimonio();
				patrimonio.setId(result.getInt("id"));
				patrimonio.setObservacoes(result.getString("observacoes"));
				patrimonio.setNumeroDeIdentificacao(result.getInt("numero_de_identificacao"));
				patrimonio.setPesquisaMuseologica(result.getString("pesquisa_museologica"));
				patrimonio.setTema(result.getString("tema"));
				patrimonio.setCatalogacao(result.getString("catalogacao"));
				patrimonio.setTombo(result.getString("tombo"));
				patrimonio.setMovimento(result.getString("movimento"));
				patrimonio.setInventarioMuseologico(result.getString("inventario_museologico"));
				patrimonio.setInventarioPatrimonial(result.getString("inventario_patrimonial"));
				patrimonio.setInformacaoData(result.getString("informacao_data"));
				patrimonio.setLocalGuardado(result.getString("local_guardado"));
				patrimonio.setAssinatura(result.getString("assinatura"));
				patrimonio.setTitulo(result.getString("titulo"));
				TipoPatrimonio tipoPatrimonio = new TipoPatrimonio();
				tipoPatrimonio.setId(result.getInt("tipo_patrimonio_id"));
				patrimonio.setTipoPatrimonio(tipoPatrimonio);
				UnidadeAdministrativa unidadeAdministrativa = new UnidadeAdministrativa();
				unidadeAdministrativa.setId(result.getInt("unidade_administrativa_id"));
				patrimonio.setUnidadeAdministrativa(unidadeAdministrativa);
				ClassificacaoGenerica classificacaoGenerica = new ClassificacaoGenerica();
				classificacaoGenerica.setId(result.getInt("classificacao_generica_id"));
				patrimonio.setClassificacaoGenerica(classificacaoGenerica);

				patrimonios.add(patrimonio);
			} while (result.next());
			return patrimonios;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Boolean atualizar(Patrimonio patrimonio, int id) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("UPDATE patrimonio SET observacoes = ?, numero_de_identificacao = ?,"
							+ "pesquisa_museologica = ?, tema, catalogacao = ?, tombo = ?, movimento = ?, inventario_museologico = ?, inventario_patrimonial = ?,"
							+ "informacao_data = ?, local_guardado = ?, assinatura = ?, titulo = ?, tipo_patrimonio_id = ?, unidade_administrativa_id = ?, "
							+ "classificacao_generica_id = ? WHERE id = ?;\r\n" + "");
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
			ps.setInt(17, id);
			ps.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean apagar(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM patrimonio WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Patrimonio> buscarPorTitulo(String titulo) {
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM patrimonio WHERE titulo LIKE ? ");
			ps.setString(1, "%" + titulo + "%");
			ResultSet result = ps.executeQuery();
			if (!result.next()) {
				throw new Exception("Nenhum patrim�nio cadastrado.");
			}
			List<Patrimonio> patrimonios = new ArrayList<Patrimonio>();
			do {
				Patrimonio patrimonio = new Patrimonio();
				patrimonio.setId(result.getInt("id"));
				patrimonio.setObservacoes(result.getString("observacoes"));
				patrimonio.setNumeroDeIdentificacao(result.getInt("numero_de_identificacao"));
				patrimonio.setPesquisaMuseologica(result.getString("pesquisa_museologica"));
				patrimonio.setTema(result.getString("tema"));
				patrimonio.setCatalogacao(result.getString("catalogacao"));
				patrimonio.setTombo(result.getString("tombo"));
				patrimonio.setMovimento(result.getString("movimento"));
				patrimonio.setInventarioMuseologico(result.getString("inventario_museologico"));
				patrimonio.setInventarioPatrimonial(result.getString("inventario_patrimonial"));
				patrimonio.setInformacaoData(result.getString("informacao_data"));
				patrimonio.setLocalGuardado(result.getString("local_guardado"));
				patrimonio.setAssinatura(result.getString("assinatura"));
				patrimonio.setTitulo(result.getString("titulo"));
				TipoPatrimonio tipoPatrimonio = new TipoPatrimonio();
				tipoPatrimonio.setId(result.getInt("tipo_patrimonio_id"));
				patrimonio.setTipoPatrimonio(tipoPatrimonio);
				UnidadeAdministrativa unidadeAdministrativa = new UnidadeAdministrativa();
				unidadeAdministrativa.setId(result.getInt("unidade_administrativa_id"));
				patrimonio.setUnidadeAdministrativa(unidadeAdministrativa);
				ClassificacaoGenerica classificacaoGenerica = new ClassificacaoGenerica();
				classificacaoGenerica.setId(result.getInt("classificacao_generica_id"));
				patrimonio.setClassificacaoGenerica(classificacaoGenerica);

				patrimonios.add(patrimonio);
			} while (result.next());
			return patrimonios;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
