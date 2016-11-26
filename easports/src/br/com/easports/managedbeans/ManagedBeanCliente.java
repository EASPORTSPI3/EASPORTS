package br.com.easports.managedbeans;

import java.util.List;

import br.com.easports.entities.ClientePF;
import br.com.easports.persistence.ClientePFDAO;

public class ManagedBeanCliente {
	
	private List<ClientePF> listagemClientes;
	
	public List<ClientePF> getListagemClientes(){
		
		try{
			
			ClientePFDAO c = new ClientePFDAO();
			
			listagemClientes = c.listAll();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return listagemClientes;
	}

}