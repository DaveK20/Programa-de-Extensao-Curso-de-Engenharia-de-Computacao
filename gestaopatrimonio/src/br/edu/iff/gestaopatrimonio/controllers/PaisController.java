package br.edu.iff.gestaopatrimonio.controllers;
import java.util.List;

import br.edu.iff.gestaopatrimonio.daos.PaisDAO;
import br.edu.iff.gestaopatrimonio.models.Pais;

public class PaisController {
	    private PaisDAO PaisDAO;

	    public PaisController() {
	        this.PaisDAO = new PaisDAO();
	    }

	    public List<Pais> listarPais() {
	        return PaisDAO.listarPaises();
	    }

	    public void adicionarPais(Pais pais) {
	        PaisDAO.adicionarPais(pais);
	    }

	    public void atualizarPais(Pais pais) {
	        PaisDAO.atualizarPais(pais);
	    }

	    public void removerPais(int id) {
	        PaisDAO.removerPais(id);
	    }
	    
	    public List<Pais> selectPaises(int id) {
	    	return PaisDAO.selectPaises(id);
	    }
	}

