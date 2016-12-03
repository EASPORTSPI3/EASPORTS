package br.com.easports.principal;

import br.com.easports.util.Criptografia;

public class Main {

	public static void main(String[] args) throws Exception {

//		String pasta = System.getProperty("user.home") + "\\desktop\\PI\\easports\\EASPORTS\\easports\\WebContent\\img";
//		
//		System.out.println(pasta);
		
		 String senha = "123456";
	     System.out.println(Criptografia.criptografar(senha));
	     
	}

}
