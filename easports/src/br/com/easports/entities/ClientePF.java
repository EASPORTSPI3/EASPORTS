package br.com.easports.entities;

import java.util.Date;

public class ClientePF extends PessoaFisica{

	public ClientePF() {
		
	}

	public ClientePF(String nome, String telefone, String cpf, Date dataNasc, Endereco endereco) {
		
		super(nome, telefone, cpf, dataNasc, endereco);
		
	}
	
}
