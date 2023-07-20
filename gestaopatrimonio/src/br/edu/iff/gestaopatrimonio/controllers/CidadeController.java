package br.edu.iff.gestaopatrimonio.controllers;
import java.util.List;
import br.edu.iff.gestaopatrimonio.daos.CidadeDAO;
import br.edu.iff.gestaopatrimonio.models.Cidade;

	public class CidadeController {
	    private CidadeDAO cidadeDAO;

	    public CidadeController() {
	        this.cidadeDAO = new CidadeDAO();
	    }

	    public List<Cidade> listarCidades() {
	        return cidadeDAO.listarCidades();
	    }

	    public void adicionarCidade(Cidade cidade) {
	        cidadeDAO.adicionarCidade(cidade);
	    }

	    public void atualizarCidade(Cidade cidade) {
	        cidadeDAO.atualizarCidade(cidade);
	    }

	    public void removerCidade(int id) {
	        cidadeDAO.removerCidade(id);
	    }
	    
	    public List<Cidade> selectCidades(int procedencia_id) {
	        return cidadeDAO.selectCidades(procedencia_id);
	    }
	}


