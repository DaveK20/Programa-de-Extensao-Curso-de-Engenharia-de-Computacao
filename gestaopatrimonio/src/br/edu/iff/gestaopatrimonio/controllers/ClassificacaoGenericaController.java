package br.edu.iff.gestaopatrimonio.controllers;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.daos.ClassificacaoGenericaDAO;
import br.edu.iff.gestaopatrimonio.models.ClassificacaoGenerica;

public class ClassificacaoGenericaController {
	ClassificacaoGenericaDAO classificacaoDAO = new ClassificacaoGenericaDAO();
	
	public ClassificacaoGenerica cadastrarClassificacaoGenerica( String nome, String descricao) {
		
		if(nome.length()<=45 && descricao.length()<=45) {
			ClassificacaoGenerica classificacao = classificacaoDAO.cadastrarClassificacaoGenerica(nome, descricao);
			return classificacao;
		}
		return null;
	}
	
	public void removerClassificacaoGenerica(int id) {
		classificacaoDAO.removerClassificacaoGenerica(id);
	}
	
	public ClassificacaoGenerica atualizarClassificacaoGenerica( int id, String novoNome, String novaDescricao) {
		if(novoNome.length()<=45 && novaDescricao.length()<=45) {
			ClassificacaoGenerica classificacao = classificacaoDAO.atualizarClassificacaoGenerica(id, novoNome, novaDescricao);
			return classificacao;
		}
		return null;
	}
	
	public ClassificacaoGenerica atualizarNomeClassificacaoGenerica( int id, String novoNome) {
		if(novoNome.length()<=45) {
			ClassificacaoGenerica classificacao = classificacaoDAO.atualizarNomeClassificacaoGenerica(id, novoNome);
			return classificacao;
		}
		return null;
	}
	
	public ClassificacaoGenerica atualizarDescricaoClassificacaoGenerica( int id, String novaDescricao) {
		if(novaDescricao.length()<=45) {
			ClassificacaoGenerica classificacao = classificacaoDAO.atualizarDescricaoClassificacaoGenerica(id, novaDescricao);
			return classificacao;
		}
		return null;
	}
	
	public List<ClassificacaoGenerica> listarClassificacaoGenerica() {
    	List<ClassificacaoGenerica> listaClassificacaoGenerica= new ArrayList<>();
    	ClassificacaoGenericaDAO classificacao = new ClassificacaoGenericaDAO();
    	listaClassificacaoGenerica = classificacao.listarClassificacaoGenerica();
    	
    	for(ClassificacaoGenerica classG: listaClassificacaoGenerica) {
    		System.out.println(classG.getId()+"|"+classG.getNome()+"|"+classG.getDescricao());
    	}
    	return listaClassificacaoGenerica;
	}
}
