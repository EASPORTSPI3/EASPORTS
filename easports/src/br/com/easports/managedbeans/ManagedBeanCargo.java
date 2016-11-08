package br.com.easports.managedbeans;

import java.util.List;
import br.com.easports.entities.Cargo;
import br.com.easports.persistence.CargoDAO;


public class ManagedBeanCargo {

	private List<Cargo> listagemCargos;

	public List<Cargo> getListagemCargos() {
		
		try{
			
			CargoDAO c = new CargoDAO();
			
			listagemCargos = c.listAll();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return listagemCargos;
	}
}
