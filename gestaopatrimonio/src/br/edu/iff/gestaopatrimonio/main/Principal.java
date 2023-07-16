package br.edu.iff.gestaopatrimonio.main;

import java.util.List;
import java.util.Scanner;

import br.edu.iff.gestaopatrimonio.controllers.PatrimonioController;
import br.edu.iff.gestaopatrimonio.controllers.TecnicaController;
import br.edu.iff.gestaopatrimonio.models.Patrimonio;
import br.edu.iff.gestaopatrimonio.models.Tecnica;

public class Principal {

	public static void main(String[] args) throws Exception {
		Boolean continua = true;
   	
    	TecnicaController tecnicaController = new TecnicaController();
    	PatrimonioController patrimonioController = new PatrimonioController();
    	
 		while (continua) {
	
			System.out.println("#### Sistema de Gerenciamento de Patrimônio #### \n");
			System.out.println("1 Cadastrar Patrimônio.");
			System.out.println("2 Listar patrimônios.");
			System.out.println("5 Cadastrar Tecnica.");
			System.out.println("6 Listar tecnicas.");
			System.out.println("9 Sair.");             
	
		    Scanner scan = new Scanner(System.in);
	        String opcao = scan.next();
	    	System.out.println("Sua opcao foi, " + opcao);
	        if (opcao.equals("1")){
	        	System.out.println("Digite a observação.");
	        	String observacoes = scan.next();
	        	Patrimonio u = new Patrimonio();
	        	u.setObservacoes(observacoes);
	        	u = patrimonioController.cadastrar(u);
	        	System.out.println("Tecnica cadastrado: "+u.getObservacoes());
	        	
	        }
	        if (opcao.equals("2")){
	        	List<Patrimonio> us = patrimonioController.listar();
	        	for (Patrimonio p : us) {
					System.out.println(p.getObservacoes());
				}
	        }
	        if (opcao.equals("5")){
	        	System.out.println("Digite o nome da tecnica");
	        	String nome = scan.next();
	        	Tecnica u = new Tecnica();
	        	u.nome =nome;
	        	u = tecnicaController.cadastrarTecnica(u);
	        	System.out.println("Tecnica cadastrado: "+u.nome);
	        	
	        }
	        if (opcao.equals("6")){
	        	List<Tecnica> us = tecnicaController.listarTecnicas();
	        	for (Tecnica t : us) {
					System.out.println(t.nome);
				}
	        }
	        if (opcao.equals("9")){
	        	System.out.println("Programa terminado.");
	        	continua = false;
	        }
		}
	}
}
