package br.edu.iff.gestaopatrimonio;

import br.edu.iff.gestaopatrimonio.daos.*;
import br.edu.iff.gestaopatrimonio.models.*;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.controllers.*;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AutorController autorcontroller = new AutorController();
		
		List<NomeAlternativo> nomealternativo = new ArrayList<>();
		
				
		System.out.println(autorcontroller.insert(new Autor("Arlisson","HAHAHAHA",nomealternativo)));
		
		
		
		
		
	}

}
