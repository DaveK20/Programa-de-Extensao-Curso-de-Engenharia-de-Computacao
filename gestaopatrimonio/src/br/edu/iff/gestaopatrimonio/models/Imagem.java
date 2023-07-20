package br.edu.iff.gestaopatrimonio.models;

public class Imagem {
    private int id;

    private String nome;

    private String data;

    private String arquivo;

    private TipoImagem tipoImagem;
    
    public Imagem(String nome, String data, String arquivo, TipoImagem tipoImagem) {
    	setNome(nome);
    	setData(data);
    	setArquivo(arquivo);
    	setTipoImagem(tipoImagem);
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public TipoImagem getTipoImagem() {
		return tipoImagem;
	}

	public void setTipoImagem(TipoImagem tipoImagem) {
		this.tipoImagem = tipoImagem;
	}

}
