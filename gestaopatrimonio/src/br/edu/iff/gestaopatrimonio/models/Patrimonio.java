package br.edu.iff.gestaopatrimonio.models;

import java.util.ArrayList;
import java.util.List;

public class Patrimonio {

	private int id;

	private String titulo;

	private String observacoes;

	private int numeroDeIdentificacao;

	private String pesquisaMuseologica;

	private String tema;

	private String catalogacao;

	private String tombo;

	private String movimento;

	private String inventarioMuseologico;

	private String inventarioPatrimonial;

	private String informacaoData;

	private String localGuardado;

	private String assinatura;

	private List<PalavraChave> palavrasChave = new ArrayList<PalavraChave>();

	private List<Material> materiais = new ArrayList<Material>();

	private List<Procedencia> procedencias = new ArrayList<Procedencia>();

	private List<Autor> autores = new ArrayList<Autor>();

	private TipoPatrimonio tipoPatrimonio;

	private UnidadeAdministrativa unidadeAdministrativa;

	private List<Imagem> imagens = new ArrayList<Imagem>();

	private List<Tecnica> tecnicas = new ArrayList<Tecnica>();

	private ClassificacaoGenerica classificacaoGenerica;

	private List<Aquisicao> aquisicoes = new ArrayList<Aquisicao>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public int getNumeroDeIdentificacao() {
		return numeroDeIdentificacao;
	}

	public void setNumeroDeIdentificacao(int numeroDeIdentificacao) {
		this.numeroDeIdentificacao = numeroDeIdentificacao;
	}

	public String getPesquisaMuseologica() {
		return pesquisaMuseologica;
	}

	public void setPesquisaMuseologica(String pesquisaMuseologica) {
		this.pesquisaMuseologica = pesquisaMuseologica;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getCatalogacao() {
		return catalogacao;
	}

	public void setCatalogacao(String catalogacao) {
		this.catalogacao = catalogacao;
	}

	public String getTombo() {
		return tombo;
	}

	public void setTombo(String tombo) {
		this.tombo = tombo;
	}

	public String getMovimento() {
		return movimento;
	}

	public void setMovimento(String movimento) {
		this.movimento = movimento;
	}

	public String getInventarioMuseologico() {
		return inventarioMuseologico;
	}

	public void setInventarioMuseologico(String inventarioMuseologico) {
		this.inventarioMuseologico = inventarioMuseologico;
	}

	public String getInventarioPatrimonial() {
		return inventarioPatrimonial;
	}

	public void setInventarioPatrimonial(String inventarioPatrimonial) {
		this.inventarioPatrimonial = inventarioPatrimonial;
	}

	public String getInformacaoData() {
		return informacaoData;
	}

	public void setInformacaoData(String informacaoData) {
		this.informacaoData = informacaoData;
	}

	public String getLocalGuardado() {
		return localGuardado;
	}

	public void setLocalGuardado(String localGuardado) {
		this.localGuardado = localGuardado;
	}

	public String getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(String assinatura) {
		this.assinatura = assinatura;
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
