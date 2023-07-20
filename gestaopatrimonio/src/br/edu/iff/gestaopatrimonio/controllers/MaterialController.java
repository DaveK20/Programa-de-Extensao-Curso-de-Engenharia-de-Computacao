package br.edu.iff.gestaopatrimonio.controllers;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.gestaopatrimonio.daos.MaterialDAO;
import br.edu.iff.gestaopatrimonio.models.Material;

public class MaterialController {
	MaterialDAO materialDAO = new MaterialDAO();
	
	public Material cadastrarMaterial(String nome) {
		
		if(nome.length()<=45) {
			Material material = materialDAO.cadastrarMaterial(nome);
			return material;
		}
		return null;
	}
	
	public void removerMaterial(int id) {
		materialDAO.removerMaterial(id);
	}
	
	public Material atualizarMaterial( int id, String novoNome) {
		if(novoNome.length()<=45) {
			Material material = materialDAO.atualizarMaterial(id, novoNome);
			return material;
		}
		return null;
	}
	
	public Material atualizarNomeMaterial( int id, String novoNome) {
		if(novoNome.length()<=45) {
			Material material = materialDAO.atualizarNomeMaterial(id, novoNome);
			return material;
		}
		return null;
	}
	
	
	public List<Material> listarMaterial() {
    	List<Material> listaMaterial= new ArrayList<>();
    	MaterialDAO material = new MaterialDAO();
    	listaMaterial = material.listarMaterial();
    	
    	for(Material m: listaMaterial) {
    		System.out.println(m.getId()+"|"+m.getNome());
    	}
    	return listaMaterial;
	}
}
