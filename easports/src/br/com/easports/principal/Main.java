package br.com.easports.principal;

import br.com.easports.entities.Endereco;
import br.com.easports.managedbeans.ManagedBeanCargo;
import br.com.easports.persistence.CargoDAO;
import br.com.easports.persistence.EnderecoDAO;

public class Main {

	public static void main(String[] args) throws Exception {

		//Endereco teste = new Endereco("Rua Américo Conti", 476, "02145-054", "Jardim Amélia", "SP", "Cotia", "Brasil");
		ManagedBeanCargo mbc = new ManagedBeanCargo();
		
		mbc.getListagemCargos();

		EnderecoDAO enderecoDao = new EnderecoDAO();

		try {
			
			//enderecoDao.insert(teste);
			
		} 
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}

	}

}
