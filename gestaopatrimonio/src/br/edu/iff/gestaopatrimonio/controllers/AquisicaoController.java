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
        if(aquisicaoDAO.insertAquisicao(aquisicao, patrimonio_id))
        	System.out.println("Inserido com sucesso!");
        else
        	System.out.println("Ocorreu erro ao inserir!");
    }

    // Obter todas as aquisições
    public List<Aquisicao> obterTodasAquisicoes() {
        return aquisicaoDAO.getAllAquisicoes();
    }

    // Atualizar uma aquisição existente
    public void atualizarAquisicao(Aquisicao aquisicao) {
        if(aquisicaoDAO.updateAquisicao(aquisicao))
        	System.out.println("Atualizado com sucesso!");
        else
        	System.out.println("Ocorreu erro ao atualizar!");
    }

    // Excluir uma aquisição
    public void excluirAquisicao(int id) {
        if(aquisicaoDAO.deleteAquisicao(id))
        	System.out.println("Excluído com sucesso!");
        else
        	System.out.println("Ocorreu erro ao excluir!");
    }
    
    // Obter todas Aquisições por ID do Patrimônio
    public List<Aquisicao> obterTodasAquisicoesporPatrimonioID(int patrimonio_id)
    {
    	return aquisicaoDAO.getAllAquisicaoByIdPatrimonio(patrimonio_id);
    }
    
    // Obter Aquisição por ID
    public Aquisicao obterAquisicaoporID(int id)
    {
    	return aquisicaoDAO.getAquisicaoById(id);
    }
}
