package br.edu.iff.gestaopatrimonio.models;

public class TipoImagem {
	private int id;

	private int largura;

	private int altura;

	private String descricao;

	public TipoImagem() {
	}

	public TipoImagem(int id, int largura, int altura, String descricao) {
		setId(id);
		setAltura(altura);
		setLargura(largura);
		setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

}
