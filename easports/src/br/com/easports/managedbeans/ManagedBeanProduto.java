package br.com.easports.managedbeans;

import java.util.List;

import br.com.easports.entities.Produto;
import br.com.easports.persistence.ProdutoDAO;

public class ManagedBeanProduto {
	
	private List<Produto> listagemProdutos;
	
	public List<Produto> getListagemProdutos(){
		
		try{
			
			ProdutoDAO p = new ProdutoDAO();
			
			listagemProdutos = p.listAll();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return listagemProdutos;
	}

}