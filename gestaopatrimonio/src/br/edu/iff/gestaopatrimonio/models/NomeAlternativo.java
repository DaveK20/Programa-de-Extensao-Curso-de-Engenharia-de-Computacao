package br.edu.iff.gestaopatrimonio.models;

public class NomeAlternativo {
    private int id;
    private String nome;
    private int autor_id;
    
    public NomeAlternativo(String nome, int id_autor) {
    	setAutor_id(id_autor);
    	setNome(nome);
    }

    public int getAutor_id() {
		return autor_id;
	}

	public void setAutor_id(int autor_id) {
		this.autor_id = autor_id;
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
}
