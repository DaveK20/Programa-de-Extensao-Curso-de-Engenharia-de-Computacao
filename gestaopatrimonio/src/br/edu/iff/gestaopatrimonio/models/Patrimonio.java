package br.edu.iff.gestaopatrimonio.models;

import java.util.ArrayList;
import java.util.List;

public class Patrimonio {
	private int id;

	private String observacoes;

    public List<PalavraChave> palavrasChave = new ArrayList<PalavraChave> ();

    public List<Material> materiais = new ArrayList<Material> ();

    public List<Procedencia> procedencias = new ArrayList<Procedencia> ();

    public List<Autor> autores = new ArrayList<Autor> ();

    public TipoPatrimonio tipoPatrimonio;

    public UnidadeAdministrativa unidadeAdministrativa;

    public List<Imagem> imagens = new ArrayList<Imagem> ();

    public List<Tecnica> tecnicas = new ArrayList<Tecnica> ();

    public ClassificacaoGenerica classificacaoGenerica;

    public List<Aquisicao> aquisicoes = new ArrayList<Aquisicao> ();

}
