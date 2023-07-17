package br.edu.iff.gestaopatrimonio.controllers;

import java.util.List;
import br.edu.iff.gestaopatrimonio.models.Aquisicao;
import br.edu.iff.gestaopatrimonio.daos.AquisicaoDAO;
import br.edu.iff.gestaopatrimonio.daos.FormaAquisicaoDAO;

public class AquisicaoController {
    private AquisicaoDAO aquisicaoDAO;

    public AquisicaoController() {
        aquisicaoDAO = new AquisicaoDAO();
    }

    // Inserir uma nova aquisição
    public void inserirAquisicao(Aquisicao aquisicao, int patrimonio_id) {
        aquisicaoDAO.insertAquisicao(aquisicao, patrimonio_id);
    }

    // Obter todas as aquisições
    public List<Aquisicao> obterTodasAquisicoes() {
        return aquisicaoDAO.getAllAquisicoes();
    }

    // Atualizar uma aquisição existente
    public void atualizarAquisicao(Aquisicao aquisicao) {
        aquisicaoDAO.updateAquisicao(aquisicao);
    }

    // Excluir uma aquisição
    public void excluirAquisicao(int id) {
        aquisicaoDAO.deleteAquisicao(id);
    }
    
    public List<Aquisicao> obterTodasAquisicoesporPatrimonioID(int patrimonio_id)
    {
    	return aquisicaoDAO.getAllAquisicaoByIdPatrimonio(patrimonio_id);
    }
}
