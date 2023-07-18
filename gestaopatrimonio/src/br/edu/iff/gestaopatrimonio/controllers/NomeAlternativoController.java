package br.edu.iff.gestaopatrimonio.controllers;
import java.util.List;

import br.edu.iff.gestaopatrimonio.daos.NomeAlternativoDAO;
import br.edu.iff.gestaopatrimonio.models.NomeAlternativo;

public class NomeAlternativoController {
    private NomeAlternativoDAO nomeAlternativoDAO;

    public NomeAlternativoController() {
        this.nomeAlternativoDAO = new NomeAlternativoDAO();
    }

    public List<NomeAlternativo> listarNomesAlternativos() {
        return nomeAlternativoDAO.listarNomesAlternativos();
    }

    public void adicionarNomeAlternativo(NomeAlternativo nomeAlternativo) {
        nomeAlternativoDAO.adicionarNomeAlternativo(nomeAlternativo);
    }

    public void atualizarNomeAlternativo(NomeAlternativo nomeAlternativo) {
        nomeAlternativoDAO.atualizarNomeAlternativo(nomeAlternativo);
    }

    public void removerNomeAlternativo(int id) {
        nomeAlternativoDAO.removerNomeAlternativo(id);
    }
    
    public List<NomeAlternativo> selectNomes(int id) {
    	return nomeAlternativoDAO.selectNomes(id);
    }
}
