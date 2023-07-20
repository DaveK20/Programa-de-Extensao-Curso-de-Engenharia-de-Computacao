package br.edu.iff.gestaopatrimonio.daos;

public class Estado {
	 private int id;
	    private String sigla;
	    private String nome;
	    private int Procedencia_id;
	    
	    
		public Estado(int id, String sigla, String nome, int procedencia_id) {
			this.id = id;
			this.sigla = sigla;
			this.nome = nome;
			Procedencia_id = procedencia_id;
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
		public int getProcedencia_id() {
			return Procedencia_id;
		}
		public void setProcedencia_id(int procedencia_id) {
			Procedencia_id = procedencia_id;
		}
	    
	    
		

}
