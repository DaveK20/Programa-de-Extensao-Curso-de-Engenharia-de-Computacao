package br.edu.iff.gestaopatrimonio.models;

public class UnidadeAdministrativa {
	private int id;

	private String sigla;

	private String nome;
	
	
    public UnidadeAdministrativa() {
    	
    }
    
    public UnidadeAdministrativa(int id, String sigla, String nome) {
    	setId(id);
    	setSigla(sigla);
    	setNome(nome);
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
