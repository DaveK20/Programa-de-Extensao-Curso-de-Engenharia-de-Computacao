package br.edu.iff.gestaopatrimonio.controllers;

import java.util.List;

import br.edu.iff.gestaopatrimonio.daos.TecnicaDAO;
import br.edu.iff.gestaopatrimonio.models.Tecnica;

public class TecnicaController {

	TecnicaDAO tecnicaDAO = new TecnicaDAO();
	
	public Tecnica cadastrarTecnica(String nome){
		Tecnica tecnica = new Tecnica();
		if(nome.length()<=45) {
			tecnica = tecnicaDAO.cadastrarTecnica(nome);
		}
		return tecnica;
	}
	
	public Tecnica atualizarTecnica(int id, String nome){
		Tecnica tecnica = new Tecnica();
		if(nome.length()<=45) {
			tecnica = tecnicaDAO.atualizarTecnica(id, nome);
		}
		return tecnica;
	}
	
	public void removerTecnica(int id) {
		tecnicaDAO.removerTecnica(id);
	}

	public List<Tecnica> listarTecnicas() {
	
		return tecnicaDAO.listarTecnicas();
	}	
	
	
}