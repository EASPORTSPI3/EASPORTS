package br.com.easports.managedbeans;

import java.util.List;

import br.com.easports.entities.Fornecedor;
import br.com.easports.persistence.FornecedorDAO;

public class ManagedBeanFornecedor {
	
	private List<Fornecedor> listagemFornecedores;
	
	public List<Fornecedor> getListagemFornecedores(){
		
		try{
			
			FornecedorDAO d = new FornecedorDAO();
			
			listagemFornecedores = d.listAll();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return listagemFornecedores;
	}

}