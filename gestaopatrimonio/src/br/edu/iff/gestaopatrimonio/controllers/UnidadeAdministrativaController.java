package br.edu.iff.gestaopatrimonio.controllers;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.daos.UnidadeAdministrativaDAO;
import br.edu.iff.gestaopatrimonio.models.UnidadeAdministrativa;

public class UnidadeAdministrativaController {
	UnidadeAdministrativaDAO unidadeDAO = new UnidadeAdministrativaDAO();
	
	public UnidadeAdministrativa cadastrarUnidadeAdministrativa( String sigla, String nome) {
		
		if(sigla.length()<=6 && nome.length()<=53) {
			UnidadeAdministrativa uniAdmin = unidadeDAO.cadastrarUnidadeAdministrativa(sigla, nome);
			return uniAdmin;
		}
		return null;
	}
	
	public void removerUnidadeAdministrativa(int id) {
		unidadeDAO.removerUnidadeAdministrativa(id);
	}
	
	public UnidadeAdministrativa atualizarUnidadeAdministrativa( int id, String novaSigla, String novoNome) {
		if(novaSigla.length()<=6 && novoNome.length()<=53) {
			UnidadeAdministrativa uniAdmin = unidadeDAO.atualizarUnidadeAdministrativa(id, novaSigla, novoNome);
			return uniAdmin;
		}
		return null;
	}
	
	public UnidadeAdministrativa atualizarSiglaUnidadeAdministrativa( int id, String novaSigla) {
		if(novaSigla.length()<=6) {
			UnidadeAdministrativa uniAdmin = unidadeDAO.atualizarSiglaUnidadeAdministrativa(id, novaSigla);
			return uniAdmin;
		}
		return null;
	}
	
	public UnidadeAdministrativa atualizarNomeUnidadeAdministrativa( int id, String novoNome) {
		if(novoNome.length()<=53) {
			UnidadeAdministrativa uniAdmin = unidadeDAO.atualizarSiglaUnidadeAdministrativa(id, novoNome);
			return uniAdmin;
		}
		return null;
	}
	
	public List<UnidadeAdministrativa> listarUnidadeAdministrativa() {
    	List<UnidadeAdministrativa> listaUnidadeAdministrativa= new ArrayList<>();
    	UnidadeAdministrativaDAO unidade = new UnidadeAdministrativaDAO();
    	listaUnidadeAdministrativa = unidade.listarUnidadeAdiministrativa();
    	
    	for(UnidadeAdministrativa ua: listaUnidadeAdministrativa) {
    		System.out.println(ua.getId()+"|"+ua.getSigla()+"|"+ua.getNome());
    	}
    	return listaUnidadeAdministrativa;
	}
}
