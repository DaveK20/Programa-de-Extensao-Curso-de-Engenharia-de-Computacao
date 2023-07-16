package br.edu.iff.gestaopatrimonio;

import br.edu.iff.gestaopatrimonio.daos.*;
import br.edu.iff.gestaopatrimonio.models.*;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.controllers.*;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AutorDAO autordao = new AutorDAO();
		
		List<NomeAlternativo> nomealternativo = new ArrayList<>();
		
				
		//System.out.println(autordao.insert(new Autor("joao","grosso",nomealternativo)));
		
		
		/*for(Autor a: autordao.select_nome("joao")) {
			System.out.println(a.toString());
		}*/
		
		System.out.println(autordao.update(new Autor("joao","jose",nomealternativo),1));
		
	}

}
