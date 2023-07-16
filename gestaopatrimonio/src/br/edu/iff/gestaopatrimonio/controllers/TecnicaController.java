package br.edu.iff.gestaopatrimonio.controllers;

import java.util.List;

import br.edu.iff.gestaopatrimonio.daos.TecnicaDAO;
import br.edu.iff.gestaopatrimonio.models.Tecnica;

public class TecnicaController {

	TecnicaDAO tecnicaDAO = new TecnicaDAO();
	
	public Tecnica cadastrarTecnica(Tecnica tecnica) throws Exception {
		
			tecnica = tecnicaDAO.cadastrarTecnica(tecnica);
		return tecnica;
	}

	public List<Tecnica> listarTecnicas() {
	
		return tecnicaDAO.listarTecnicas();
	}	
	
	
}