package br.edu.iff.gestaopatrimonio.controllers;
import java.util.List;

import br.edu.iff.gestaopatrimonio.daos.EstadoDAO;
import br.edu.iff.gestaopatrimonio.models.Estado;

public class EstadoController {
		private EstadoDAO estadoDAO;
		
	    public EstadoController() {
	        this.estadoDAO = new EstadoDAO();
	        
	        public List<Estado> listarEstados() {
	            return estadoDAO.listarEstados();
	        }

	        public void cadastrarEstado(Estado estado) {
	        	estadoDAO.cadastrarEstado(estado);
	        }

	        public void atualizarEstado(Estado estadoAtualizado) {
	        	estadoDAO.atualizarEstado(estadoAtualizado);
	        }

	        public void  apagarEstado(int id) {
	        	estadoDAO.apagarEstado(id);
	        }
	        
	        public List<Estado> listarEstados(int id) {
	        	return estadoDAO.listarEstados(id);
	        }
	    }
	    }
}
