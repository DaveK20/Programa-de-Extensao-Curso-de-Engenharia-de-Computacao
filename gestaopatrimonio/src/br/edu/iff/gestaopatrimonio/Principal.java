package br.edu.iff.gestaopatrimonio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.iff.gestaopatrimonio.controllers.AutorController;
import br.edu.iff.gestaopatrimonio.controllers.PatrimonioController;
import br.edu.iff.gestaopatrimonio.models.Autor;
import br.edu.iff.gestaopatrimonio.models.ClassificacaoGenerica;
import br.edu.iff.gestaopatrimonio.models.NomeAlternativo;
import br.edu.iff.gestaopatrimonio.models.Patrimonio;
import br.edu.iff.gestaopatrimonio.models.TipoPatrimonio;
import br.edu.iff.gestaopatrimonio.models.UnidadeAdministrativa;

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

				Patrimonio patrimonio = new Patrimonio();
				patrimonio.setObservacoes("Patrim�nio da comunidade de BJI");
				patrimonio.setNumeroDeIdentificacao(123456);
				patrimonio.setPesquisaMuseologica("TESTE");
				patrimonio.setTema("TESTE");
				patrimonio.setCatalogacao("Gr0001");
				patrimonio.setTombo("00210");
				patrimonio.setMovimento("TESTE");
				patrimonio.setInventarioMuseologico("80.000.069");
				patrimonio.setInventarioPatrimonial("0171");
				patrimonio.setInformacaoData("TESTE");
				patrimonio.setLocalGuardado("Exposi��o Permanente � sal�o oval, nicho 1");
				patrimonio.setAssinatura("TESTE");
				patrimonio.setTitulo("TESTE");
				TipoPatrimonio tipoPatrimonio = new TipoPatrimonio();
				tipoPatrimonio.setId(1);
				patrimonio.setTipoPatrimonio(tipoPatrimonio);
				UnidadeAdministrativa unidadeAdministrativa = new UnidadeAdministrativa();
				unidadeAdministrativa.setId(1);
				patrimonio.setUnidadeAdministrativa(unidadeAdministrativa);
				ClassificacaoGenerica classificacaoGenerica = new ClassificacaoGenerica();
				classificacaoGenerica.setId(1);
				patrimonio.setClassificacaoGenerica(classificacaoGenerica);

				PatrimonioController patrimonioController = new PatrimonioController();
				patrimonio = patrimonioController.cadastrar(patrimonio);
				System.out.println(patrimonio.getTitulo() + " : " + patrimonio.getObservacoes() + " : "
						+ patrimonio.getLocalGuardado());

				List<Patrimonio> patrimonios = patrimonioController.listar();
				for (Patrimonio patrimonio2 : patrimonios) {
					System.out.println(patrimonio2.getId() + " : " + patrimonio2.getTitulo() + " : "
							+ patrimonio2.getObservacoes() + " : " + patrimonio2.getLocalGuardado());
				}
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
