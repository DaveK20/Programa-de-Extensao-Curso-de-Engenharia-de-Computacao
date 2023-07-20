package br.edu.iff.gestaopatrimonio.models;

import java.util.Date;

public class Procedencia {
	private int id;

	private Date data; //usar o formato Datetime, o BD não ira aceitar insert de string no campo data

	private Pais pais;

	private Estado estado;

	private Cidade cidade;

	
	public Procedencia(int id, Date data, Pais pais, Estado estado, Cidade cidade) {
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
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
