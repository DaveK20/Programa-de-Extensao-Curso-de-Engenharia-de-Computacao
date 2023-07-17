package br.edu.iff.gestaopatrimonio.daos;
import java.util.List;

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
}
