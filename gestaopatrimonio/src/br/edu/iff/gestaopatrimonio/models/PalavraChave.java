package br.edu.iff.gestaopatrimonio.models;
	

	public class PalavraChave {
		private int id;
		private String palavra;
		private int patrimonio_id;
		
		public PalavraChave(){
			
		}

		public PalavraChave(int id, String palavra, int patrimonio_id) {
			this.id = id;
			this.palavra = palavra;
			this.patrimonio_id = patrimonio_id;
		}



		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getPalavra() {
			return palavra;
		}


		public void setPalavra(String palavra) {
			this.palavra = palavra;
		}


		public int getPatrimonio_id() {
			return patrimonio_id;
		}


		public void setPatrimonio_id(int patrimonio_id) {
			this.patrimonio_id = patrimonio_id;
		}



	}

