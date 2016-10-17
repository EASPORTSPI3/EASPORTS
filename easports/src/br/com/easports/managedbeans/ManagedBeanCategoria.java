package br.com.easports.managedbeans;

import java.util.List;

import br.com.easports.entities.Categoria;
import br.com.easports.persistence.CategoriaDAO;

public class ManagedBeanCategoria {
	
	private List<Categoria> listagemCategorias;

	public List<Categoria> getListagemCategorias() {
		
		try{
			
			CategoriaDAO c = new CategoriaDAO();
			
			listagemCategorias = c.listAll();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return listagemCategorias;
	}
	

}
