package br.edu.iff.gestaopatrimonio.models;

public class FormaAquisicao {
    private int id;

    private String tipo;

    public FormaAquisicao(String tipo)
    {
    	this.tipo = tipo;
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
