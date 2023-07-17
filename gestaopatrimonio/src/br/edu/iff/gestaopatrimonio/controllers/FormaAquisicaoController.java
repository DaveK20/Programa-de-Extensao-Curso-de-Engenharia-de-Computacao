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
        formaAquisicaoDAO.insertFormaAquisicao(formaAquisicao);
    }

    // Obter todas as formas de aquisição
    public List<FormaAquisicao> obterTodasFormasAquisicao() {
        return formaAquisicaoDAO.getAllFormasAquisicao();
    }

    // Atualizar uma forma de aquisição existente
    public void atualizarFormaAquisicao(FormaAquisicao formaAquisicao) {
        formaAquisicaoDAO.updateFormaAquisicao(formaAquisicao);
    }

    // Excluir uma forma de aquisição
    public void excluirFormaAquisicao(int id) {
        formaAquisicaoDAO.deleteFormaAquisicao(id);
    }
    
    // Obter uma forma de aquisição por ID
    public FormaAquisicao obterFormaAquisicaoPorId(int id) {
        return formaAquisicaoDAO.getFormaAquisicaoById(id);
    }
}

