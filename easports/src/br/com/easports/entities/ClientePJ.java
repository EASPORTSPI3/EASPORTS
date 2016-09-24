package br.com.easports.entities;

public class ClientePJ extends PessoaJuridica{
	
	public ClientePJ(){
		
	}

	public ClientePJ(String nome, String telefone, String cnpj, String razaoSocial, Endereco endereco) {
		
		super(nome, telefone, cnpj, razaoSocial, endereco);
		
	}

}
