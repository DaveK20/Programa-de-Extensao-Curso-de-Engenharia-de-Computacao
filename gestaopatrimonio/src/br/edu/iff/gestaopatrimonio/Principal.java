package br.edu.iff.gestaopatrimonio;

import br.edu.iff.gestaopatrimonio.daos.*;
import br.edu.iff.gestaopatrimonio.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.iff.gestaopatrimonio.controllers.*;

public class Principal {

	public static void main(String[] args) throws Exception {

		Boolean continua = true;
		while (continua) {
			System.out.println("#### Sistema de Gerenciamento de Patrim�nio #### \n");
			System.out.println("1 Listar Patrim�nios");
			System.out.println("2 Listar Aquisi��es");
			System.out.println("3 Listar Autores");
			System.out.println("4 Listar Cidades");
			System.out.println("5 Listar Classifica��es Gen�ricas");
			System.out.println("6 Listar Estados");
			System.out.println("7 Listar Formas de Aquisi��es");
			System.out.println("8 Listar Imagens");
			System.out.println("9 Listar Materiais");
			System.out.println("10 Listar Materiais dos Patrim�nios");
			System.out.println("11 Listar Nomes Alternativos");
			System.out.println("12 Listar Pa�ses");
			System.out.println("13 Listar Palavras-Chaves");
			System.out.println("14 Listar Proced�ncias");
			System.out.println("15 Listar T�cnicas");
			System.out.println("16 Listar Tipos de Imagens");
			System.out.println("17 Listar Tipos de Patrim�nios");
			System.out.println("18 Listar Unidades Administrativas");
			System.out.println("99 Sair");

			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			String opcao = scan.next();
			System.out.println("Sua opcao foi, " + opcao);

			if (opcao.equals("1")) {
				PatrimonioController patrimonioController = new PatrimonioController();
				Patrimonio patrimonio = new Patrimonio();
				patrimonioController.cadastrar(patrimonio);
			}
			if (opcao.equals("2")) {

			}
			if (opcao.equals("3")) {
				AutorController autorcontroller = new AutorController();
				List<NomeAlternativo> nomealternativo = new ArrayList<>();
				System.out.println(autorcontroller.insert(new Autor("Arlisson", "HAHAHAHA", nomealternativo)));
			}
			if (opcao.equals("4")) {

			}
			if (opcao.equals("5")) {

			}
			if (opcao.equals("6")) {

			}
			if (opcao.equals("7")) {

			}
			if (opcao.equals("8")) {

			}
			if (opcao.equals("9")) {

			}
			if (opcao.equals("10")) {

			}
			if (opcao.equals("11")) {

			}
			if (opcao.equals("12")) {

			}
			if (opcao.equals("13")) {

			}
			if (opcao.equals("14")) {

			}
			if (opcao.equals("15")) {

			}
			if (opcao.equals("16")) {

			}
			if (opcao.equals("17")) {

			}
			if (opcao.equals("18")) {

			}
			if (opcao.equals("99")) {
				System.out.println("Programa terminado.");
				continua = false;
			}
		}
	}
}
