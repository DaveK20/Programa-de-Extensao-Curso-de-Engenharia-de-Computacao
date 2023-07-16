package br.edu.iff.gestaopatrimonio.models;

import java.util.ArrayList;
import java.util.List;

public class Patrimonio {
<<<<<<< HEAD
    private int id;
=======
	private int id;
>>>>>>> branch 'main' of https://github.com/AyrtonBorges/Programa-de-Extensao-Curso-de-Engenharia-de-Computacao.git

<<<<<<< HEAD
    private String observacoes;
=======
	private String observacoes;
>>>>>>> branch 'main' of https://github.com/AyrtonBorges/Programa-de-Extensao-Curso-de-Engenharia-de-Computacao.git

    private List<PalavraChave> palavrasChave = new ArrayList<PalavraChave> ();

    private List<Material> materiais = new ArrayList<Material> ();

    private List<Procedencia> procedencias = new ArrayList<Procedencia> ();

    private List<Autor> autores = new ArrayList<Autor> ();

    private TipoPatrimonio tipoPatrimonio;

    private UnidadeAdministrativa unidadeAdministrativa;

    private List<Imagem> imagens = new ArrayList<Imagem> ();

    private List<Tecnica> tecnicas = new ArrayList<Tecnica> ();

    private ClassificacaoGenerica classificacaoGenerica;

    private List<Aquisicao> aquisicoes = new ArrayList<Aquisicao> ();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<PalavraChave> getPalavrasChave() {
		return palavrasChave;
	}

	public void setPalavrasChave(List<PalavraChave> palavrasChave) {
		this.palavrasChave = palavrasChave;
	}

	public List<Material> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}

	public List<Procedencia> getProcedencias() {
		return procedencias;
	}

	public void setProcedencias(List<Procedencia> procedencias) {
		this.procedencias = procedencias;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public TipoPatrimonio getTipoPatrimonio() {
		return tipoPatrimonio;
	}

	public void setTipoPatrimonio(TipoPatrimonio tipoPatrimonio) {
		this.tipoPatrimonio = tipoPatrimonio;
	}

	public UnidadeAdministrativa getUnidadeAdministrativa() {
		return unidadeAdministrativa;
	}

	public void setUnidadeAdministrativa(UnidadeAdministrativa unidadeAdministrativa) {
		this.unidadeAdministrativa = unidadeAdministrativa;
	}

	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	public List<Tecnica> getTecnicas() {
		return tecnicas;
	}

	public void setTecnicas(List<Tecnica> tecnicas) {
		this.tecnicas = tecnicas;
	}

	public ClassificacaoGenerica getClassificacaoGenerica() {
		return classificacaoGenerica;
	}

	public void setClassificacaoGenerica(ClassificacaoGenerica classificacaoGenerica) {
		this.classificacaoGenerica = classificacaoGenerica;
	}

	public List<Aquisicao> getAquisicoes() {
		return aquisicoes;
	}

	public void setAquisicoes(List<Aquisicao> aquisicoes) {
		this.aquisicoes = aquisicoes;
	}

    
}
