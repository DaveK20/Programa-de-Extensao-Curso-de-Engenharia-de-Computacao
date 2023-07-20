package br.edu.iff.gestaopatrimonio.controllers;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.daos.TipoPatrimonioDAO;
import br.edu.iff.gestaopatrimonio.models.TipoPatrimonio;

public class TipoPatrimonioController {
	TipoPatrimonioDAO tipo_patrimonioDAO = new TipoPatrimonioDAO();
	
	public TipoPatrimonio cadastrarTipoPatrimonio(String nome_tipo_patrimonio) {
		
		if(nome_tipo_patrimonio.length()<=45) {
			TipoPatrimonio tipo_patrimonio = tipo_patrimonioDAO.cadastrarTipoPatrimonio(nome_tipo_patrimonio);
			return tipo_patrimonio;
		}
		return null;
	}
	
	public void removerTipoPatrimonio(int id) {
		tipo_patrimonioDAO.removerTipoPatrimonio(id);
	}
	
	public TipoPatrimonio atualizarTipoPatrimonio( int id, String novoNome_tipo_patrimonio) {
		if(novoNome_tipo_patrimonio.length()<=45) {
			TipoPatrimonio tipo_patrimonio = tipo_patrimonioDAO.atualizarTipoPatrimonio(id, novoNome_tipo_patrimonio);
			return tipo_patrimonio;
		}
		return null;
	}
	
	public TipoPatrimonio atualizarNome_tipo_patrimonioTipoPatrimonio( int id, String novoNome_tipo_patrimonio) {
		if(novoNome_tipo_patrimonio.length()<=45) {
			TipoPatrimonio tipo_patrimonio = tipo_patrimonioDAO.atualizarNome_tipo_patrimonioTipoPatrimonio(id, novoNome_tipo_patrimonio);
			return tipo_patrimonio;
		}
		return null;
	}
	
	
	public List<TipoPatrimonio> listarTipoPatrimonio() {
    	List<TipoPatrimonio> listaTipoPatrimonio= new ArrayList<>();
    	TipoPatrimonioDAO tipo_patrimonio = new TipoPatrimonioDAO();
    	listaTipoPatrimonio = tipo_patrimonio.listarTipoPatrimonio();
    	
    	for(TipoPatrimonio tp: listaTipoPatrimonio) {
    		System.out.println(tp.getId()+"|"+tp.getNome_tipo_patrimonio());
    	}
    	return listaTipoPatrimonio;
	}
}
