package br.edu.iff.gestaopatrimonio.controllers;
import java.sql.SQLException;
/**
 * @author hj_ro
 */
import java.util.List;

import br.edu.iff.gestaopatrimonio.daos.PatrimonioDAO;
import br.edu.iff.gestaopatrimonio.daos.TecnicaDAO;
import br.edu.iff.gestaopatrimonio.models.Patrimonio;
import br.edu.iff.gestaopatrimonio.models.Tecnica;

public class PatrimonioController {

	PatrimonioDAO patrimonioDAO = new PatrimonioDAO();
	TecnicaDAO tecnicaDAO = new TecnicaDAO();
	
	public Patrimonio cadastrar(Patrimonio patrimonio) throws Exception {
		patrimonio = patrimonioDAO.cadastrar(patrimonio);
		vincularTecnicasAUmPatrimonio(patrimonio.getTecnicas(), patrimonio.getId());	
		patrimonio.setTecnicas(tecnicaDAO.listarPorPatrimonioId(patrimonio.getId()));
		return patrimonio;
	}

	public List<Patrimonio> listar() throws SQLException {
		List<Patrimonio> patrimonios = patrimonioDAO.listar();
        for (int index = 0; index <  patrimonios.size(); index++) {
        		Patrimonio patrimonio = patrimonios.get(index);
    			patrimonio.setTecnicas(tecnicaDAO.listarPorPatrimonioId(patrimonio.getId())); 
            	patrimonios.set(index, patrimonio);
            }
		return patrimonios;
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
	
	private boolean vincularTecnicasAUmPatrimonio(List<Tecnica> tecnicas, int patrimonioId) throws SQLException {
		tecnicaDAO.vincularTecnicasAUmPatrimonio(tecnicas, patrimonioId);
		return true;
	}
	
}