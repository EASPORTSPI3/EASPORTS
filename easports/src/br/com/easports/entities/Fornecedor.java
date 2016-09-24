package br.com.easports.entities;

public class Fornecedor extends PessoaJuridica{

	public Fornecedor() {
		
	}

	public Fornecedor(String nome, String telefone, String cnpj, String razaoSocial, Endereco endereco) {
		
		super(nome, telefone, cnpj, razaoSocial, endereco);
		
	}

}
