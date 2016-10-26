package br.com.easports.managedbeans;

import java.util.List;

import br.com.easports.entities.Pedido;
import br.com.easports.persistence.PedidoDAO;

public class ManagedBeanPedido {
	
	private List<Pedido> listagemPedidos;
	
	public List<Pedido> getListagemPedidos(){
		
		try{
			
			PedidoDAO p = new PedidoDAO();
			
			listagemPedidos = p.listAll();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return listagemPedidos;
	}

}