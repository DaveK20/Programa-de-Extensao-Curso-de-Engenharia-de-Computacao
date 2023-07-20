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

import br.edu.iff.gestaopatrimonio.models.Aquisicao;
import br.edu.iff.gestaopatrimonio.models.Autor;
import br.edu.iff.gestaopatrimonio.models.ClassificacaoGenerica;
import br.edu.iff.gestaopatrimonio.models.Material;
import br.edu.iff.gestaopatrimonio.models.PalavraChave;
import br.edu.iff.gestaopatrimonio.models.Patrimonio;
import br.edu.iff.gestaopatrimonio.models.Procedencia;
import br.edu.iff.gestaopatrimonio.models.Tecnica;
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
				throw new Exception("Nenhum patrimônio cadastrado.");
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
				throw new Exception("Nenhum patrimônio cadastrado.");
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

	public boolean desvincularTecnicaDeUmPatrimonio(int patrimonio_id, int tecnica_id) {
		try {
			PreparedStatement ps = connection.prepareStatement(
					"DELETE FROM patrimonio_has_tecnica" + " WHERE patrimonio_id = ? AND tecnica_id = ?");
			ps.setInt(1, patrimonio_id);
			ps.setInt(2, tecnica_id);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * @author hj_ro
	 * @author Yan
	 */
	public boolean vincularTecnicasAUmPatrimonio(List<Tecnica> tecnicas, int patrimonioId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("INSERT INTO patrimonio_has_tecnica (patrimonio_id, tecnica_id) VALUES (?,?)");
		for (Tecnica tecnica : tecnicas) {
			ps.setInt(1, patrimonioId);
			ps.setInt(2, tecnica.getId());
			ps.execute();
		}
		return true;
	}

	/**
	 * @author hj_ro
	 * @author Aline
	 */
	public boolean inserirProcedenciaAUmPatrimonio(Procedencia procedencia, int patrimonio_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("INSERT INTO procedencia (data, pais_id, estado_id, cidade_id,"
				+ " patrimonio_id) VALUES (?,?,?,?,?)");
		ps.setDate(1, java.sql.Date.valueOf( procedencia.getData()));
		ps.setInt(2, procedencia.getPais().getId());
		ps.setInt(3, procedencia.getEstado().getId());
		ps.setInt(4, procedencia.getCidade().getId());
		ps.setInt(5, patrimonio_id);
		ps.execute();
		return true;
	}
	
	/**
	 * @author hj_ro
	 * @author Aline
	 */
	public boolean excluirProcedenciaAUmPatrimonio(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("DELETE FROM procedencia WHERE id = ?");
		ps.setInt(1, id);
		ps.execute();
		return true;
	}
	
	/**
	 * @author hj_ro
	 */
	public boolean inserirMaterialAUmPatrimonio(int patrimonio_id_patrimonio, int material_id_material) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("INSERT INTO patrimonio_has_material "
				+ "(patrimonio_is_patrimonio, material_id_material)"
				+ " VALUES (?,?)");
		ps.setInt(1, patrimonio_id_patrimonio);
		ps.setInt(2, material_id_material);
		ps.execute();
		return true;
	}
	
	/**
	 * @author hj_ro
	 */
	public boolean excluirMaterialAUmPatrimonio(int patrimonio_id_patrimonio, int material_id_material) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("DELETE FROM Patrimonio_has_material "
				+ "WHERE patrimonio_id_patrimonio = ? AND material_id_material = ?");
		ps.setInt(1, patrimonio_id_patrimonio);
		ps.setInt(2, material_id_material);
		ps.executeUpdate();
		return true;
	}
	
	/**
	 * @author hj_ro
	 */
	public boolean inserirAquisicaoAUmPatrimonio(Aquisicao aquisicao, int patrimonio_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("INSERT INTO aquisicao (data, patrimonio_id, "
				+ "forma_aquisicao_id ) VALUES (?,?,?)");
		ps.setDate(1, java.sql.Date.valueOf( aquisicao.getData()));
		ps.setInt(2, patrimonio_id);
		ps.setInt(3, aquisicao.getFormaAquisicao().getId());
		ps.execute();
		return true;
	}
	
	/**
	 * @author hj_ro
	 */
	public boolean excluirAquisicaoAUmPatrimonio(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("DELETE FROM aquisicao WHERE id = ?");
		ps.setInt(1, id);
		ps.execute();
		return true;
	}
	
	/**
	 * @author hj_ro
	 */
	public boolean inserirPalavraChaveAUmPatrimonio(PalavraChave palavraChave, int patrimonio_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("INSERT INTO palavra_chave (palavra_chave_nome"
				+ "patrimonio_id) VALUES (?,?)");
		ps.setDate(1, java.sql.Date.valueOf( palavraChave.getPalavra()));
		ps.setInt(2, patrimonio_id);
		ps.execute();
		return true;
	}
	
	/**
	 * @author hj_ro
	 */
	public boolean excluirPalavraChaveAUmPatrimonio(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("DELETE FROM palavra_chave WHERE id = ?");
		ps.setInt(1, id);
		ps.execute();
		return true;
	}
	
	/**
	 * @author hj_ro
	 */
	public boolean vincularAutorAUmPatrimonio(Autor autor, int patrimonio_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("INSERT INTO patrimonio_has_autor (patrimonio_id "
				+ "autor_id) VALUES (?,?)");
		ps.setInt(1, autor.getId());
		ps.setInt(2, patrimonio_id);
		ps.execute();
		return true;
	}
	
	/**
	 * @author hj_ro
	 */
	public boolean desvincularAutorAUmPatrimonio(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("DELETE FROM patrimonio_has_autor WHERE id = ?");
		ps.setInt(1, id);
		ps.execute();
		return true;
	}
}
