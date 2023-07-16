package br.edu.iff.gestaopatrimonio.models;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private int id;

    private String nome;

    private String biografia;

    public List<NomeAlternativo> nomeAlternativo = new ArrayList<NomeAlternativo> ();

	

	public Autor(String nome, String biografia, List<NomeAlternativo> nomeAlternativo) {
		super();		
		setNome(nome);
		setBiografia(biografia);
		setNomeAlternativo(nomeAlternativo);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public List<NomeAlternativo> getNomeAlternativo() {
		return nomeAlternativo;
	}

	public void setNomeAlternativo(List<NomeAlternativo> nomeAlternativo) {
		this.nomeAlternativo = nomeAlternativo;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", biografia=" + biografia + ", nomeAlternativo="
				+ nomeAlternativo + "]";
	}

}
