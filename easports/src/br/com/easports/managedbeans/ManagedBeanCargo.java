package br.com.easports.managedbeans;

import java.util.List;
import br.com.easports.entities.Cargo;
import br.com.easports.persistence.CargoDAO;

public class ManagedBeanCargo {

	private List<Cargo> listagemCargo;

	public List<Cargo> getListagemCargos() {
	
		try {
			
			CargoDAO cargoDAO = new CargoDAO();

			listagemCargo = cargoDAO.listAll();
			
		} 
		catch (Exception e)	{			
			e.printStackTrace();
		}
		
		return listagemCargo;
	}
}
