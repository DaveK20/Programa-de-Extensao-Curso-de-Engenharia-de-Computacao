package br.edu.iff.gestaopatrimonio.models;

public class Tecnica {
	private int id;

	private String nome;

	private Patrimonio patrimonio;

	public Tecnica() {

	}

	public Tecnica(int id, String nome) {
		setId(id);
		setNome(nome);
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

	public Patrimonio getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(Patrimonio patrimonio) {
		this.patrimonio = patrimonio;
	}

}
