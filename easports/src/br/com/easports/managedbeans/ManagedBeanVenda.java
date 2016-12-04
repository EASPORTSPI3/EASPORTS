package br.com.easports.managedbeans;

import java.util.List;

import br.com.easports.entities.Venda;
import br.com.easports.persistence.VendaDAO;


public class ManagedBeanVenda {

	private List<Venda> listagemVendas;

	public List<Venda> getListagemVendas() {
		
		try{
			
			VendaDAO v = new VendaDAO();
			
			listagemVendas = v.listAll();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return listagemVendas;
	}
}
