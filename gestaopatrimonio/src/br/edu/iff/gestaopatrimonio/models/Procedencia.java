package br.edu.iff.gestaopatrimonio.models;

import java.time.LocalDate;

public class Procedencia {
	private int id;

	private LocalDate data; // usar o formato Datetime, o BD não ira aceitar insert de string no campo data

	private Pais pais;

	private Estado estado;

	private Cidade cidade;

	public Procedencia(int id, LocalDate data, Pais pais, Estado estado, Cidade cidade) {
		this.id = id;
		this.data = data;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
