package br.edu.iff.gestaopatrimonio.controllers;

import java.util.List;

import br.edu.iff.gestaopatrimonio.daos.ImagemDAO;
import br.edu.iff.gestaopatrimonio.models.Imagem;
import br.edu.iff.gestaopatrimonio.models.TipoImagem;

public class ImagemController {
	ImagemDAO imagemDAO = new ImagemDAO();
	
	public void cadastrarImagem(String nome, String data, String arquivo, TipoImagem tipoImagem){
		if(nome.length() <= 45 && imagemDAO.inserirImagem(nome, data, arquivo, tipoImagem))
			System.out.println("Inserido com sucesso!");
	    else
	        System.out.println("Ocorreu erro ao inserir!");
	}
	
	public void atualizarImagem(Imagem imagem) {
		if(imagemDAO.atualizarImagem(imagem))
        	System.out.println("Atualizado com sucesso!");
        else
        	System.out.println("Ocorreu erro ao atualizar!");
	}
	
	public void excluirImagem(int id) {
		if(imagemDAO.deletarImagem(id))
        	System.out.println("Excluído com sucesso!");
        else
        	System.out.println("Ocorreu erro ao excluir!");
	}
	
	public Imagem buscarImagemPorId(int id) {
		return imagemDAO.buscarImagemPorId(id);
	}
	
	public List<Imagem> listarImagens(){
		return imagemDAO.listarImagens();
	}
	
}
