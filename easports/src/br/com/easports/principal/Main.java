package br.com.easports.principal;

import br.com.easports.entities.Endereco;
import br.com.easports.persistence.EnderecoDAO;

public class Main {

	public static void main(String[] args) {

		//Endereco teste = new Endereco("Rua Am�rico Conti", 476, "02145-054", "Jardim Am�lia", "SP", "Cotia", "Brasil");

		EnderecoDAO enderecoDao = new EnderecoDAO();

		try {
			
			//enderecoDao.insert(teste);
			
		} 
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}

	}

}
