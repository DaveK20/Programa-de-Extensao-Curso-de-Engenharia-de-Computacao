package br.edu.iff.gestaopatrimonio.controllers;

import java.util.List;

import br.edu.iff.gestaopatrimonio.daos.PatrimonioDAO;
import br.edu.iff.gestaopatrimonio.models.Patrimonio;

public class PatrimonioController {

	PatrimonioDAO patrimonioDAO = new PatrimonioDAO();
	
	public Patrimonio cadastrar(Patrimonio patrimonio) throws Exception {
		patrimonio = patrimonioDAO.cadastrar(patrimonio);
		return patrimonio;
	}

	public List<Patrimonio> listar() {
		return patrimonioDAO.listar();
	}	
	
	
}