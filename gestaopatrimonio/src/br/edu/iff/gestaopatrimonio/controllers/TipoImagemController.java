package br.edu.iff.gestaopatrimonio.controllers;

import br.edu.iff.gestaopatrimonio.daos.TipoImagemDAO;
import br.edu.iff.gestaopatrimonio.models.TipoImagem;

public class TipoImagemController {
	TipoImagemDAO imagemDAO = new TipoImagemDAO();

	public TipoImagem cadastrarTipoImagem(int largura, int altura, String descricao) {

		if (descricao.length() <= 45 && largura >= 0 && altura >= 0) {
			TipoImagem tipoImagemAdmin = imagemDAO.cadastrarTipoImagem(largura, altura, descricao);
			return tipoImagemAdmin;
		}
		return null;
	}

	public void removerTipoImagem(int id) {
		imagemDAO.removerTipoDeImagem(id);
	}

	public TipoImagem atualizarTipoImagem(int id, int largura, int altura, String descricao) {
		if (descricao.length() <= 45 && largura >= 0 && altura >= 0) {
			TipoImagem tipoImagemAdmin = imagemDAO.atualizarTipoImagem(id, largura, altura, descricao);
			return tipoImagemAdmin;
		}
		return null;
	}

	public TipoImagem atualizarLargura(int id, int novaLargura) {
		if (novaLargura >= 0) {
			TipoImagem tipoImagemAdmin = imagemDAO.atualizarLarguraTipoImagem(id, novaLargura);
			return tipoImagemAdmin;
		}
		return null;
	}

	public TipoImagem atualizarAltura(int id, int novaAltura) {
		if (novaAltura >= 0) {
			TipoImagem tipoImagemAdmin = imagemDAO.atualizarAlturaTipoImagem(id, novaAltura);
			return tipoImagemAdmin;
		}
		return null;
	}

	public TipoImagem atualizarDescricao(int id, String novaDescricao) {
		if (novaDescricao.length() <= 45) {
			TipoImagem tipoImagemAdmin = imagemDAO.atualizarDescricaoTipoImagem(id, novaDescricao);
			return tipoImagemAdmin;
		}
		return null;
	}

}
