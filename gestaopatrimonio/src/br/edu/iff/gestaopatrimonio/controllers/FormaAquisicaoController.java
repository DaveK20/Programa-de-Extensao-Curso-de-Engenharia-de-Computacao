package br.edu.iff.gestaopatrimonio.controllers;

import br.edu.iff.gestaopatrimonio.models.FormaAquisicao;

import java.util.List;

import br.edu.iff.gestaopatrimonio.daos.FormaAquisicaoDAO;

public class FormaAquisicaoController {
    private FormaAquisicaoDAO formaAquisicaoDAO;

    public FormaAquisicaoController() {
        formaAquisicaoDAO = new FormaAquisicaoDAO();
    }

    // Inserir uma nova forma de aquisição
    public void inserirFormaAquisicao(FormaAquisicao formaAquisicao) {
        if(formaAquisicaoDAO.insertFormaAquisicao(formaAquisicao))
        	System.out.println("Inserido com sucesso!");
        else
        	System.out.println("Ocorreu erro ao inserir!");
    }

    // Obter todas as formas de aquisição
    public List<FormaAquisicao> obterTodasFormasAquisicao() {
        return formaAquisicaoDAO.getAllFormasAquisicao();
    }

    // Atualizar uma forma de aquisição existente
    public void atualizarFormaAquisicao(FormaAquisicao formaAquisicao) {
        if(formaAquisicaoDAO.updateFormaAquisicao(formaAquisicao))
        	System.out.println("Atualizado com sucesso!");
        else
        	System.out.println("Ocorreu erro ao atualizar!");
    }

    // Excluir uma forma de aquisição
    public void excluirFormaAquisicao(int id) {
        if(formaAquisicaoDAO.deleteFormaAquisicao(id))
        	System.out.println("Excluído com sucesso!");
        else
        	System.out.println("Ocorreu erro ao excluir!");
    }
    
    // Obter uma forma de aquisição por ID
    public FormaAquisicao obterFormaAquisicaoPorId(int id) {
        return formaAquisicaoDAO.getFormaAquisicaoById(id);
    }
}

