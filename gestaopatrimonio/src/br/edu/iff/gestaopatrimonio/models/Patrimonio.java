package br.edu.iff.gestaopatrimonio.models;

import java.util.ArrayList;
import java.util.List;

public class Patrimonio {
	private int id;

	private String observacoes;

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

}
