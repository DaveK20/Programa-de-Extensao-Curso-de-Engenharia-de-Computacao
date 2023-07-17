package br.edu.iff.gestaopatrimonio.models;

public class Aquisicao {
    private int id;

    private String data;

    private FormaAquisicao formaAquisicao;
    
    public Aquisicao(String data, FormaAquisicao formaAquisicao)
    {
    	this.data = data;
    	this.formaAquisicao = formaAquisicao;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public FormaAquisicao getFormaAquisicao() {
		return formaAquisicao;
	}

	public void setFormaAquisicao(FormaAquisicao formaAquisicao) {
		this.formaAquisicao = formaAquisicao;
	}

}
