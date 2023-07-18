package br.edu.iff.gestaopatrimonio.controllers;
/**
 * @author hj_ro
 */
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
	
	public Boolean atualizar(Patrimonio patrimonio, int id) {
		return atualizar(patrimonio,id);
	}
	
	public Boolean apagar(int id) {
		return apagar(id);
	}
	
	public List<Patrimonio> buscarPorTitulo(String titulo) {
		return patrimonioDAO.buscarPorTitulo(titulo);
	}
	
}