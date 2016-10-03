package br.com.easports.entities;

import java.util.Date;

public class ClientePF extends PessoaFisica {

	private Integer idCliente;

	public ClientePF() {

	}

	public ClientePF(String nome, String telefone, String cpf, Date dataNasc) {

		super(nome, telefone, cpf, dataNasc);

	}

	public ClientePF(String nome, String telefone, String cpf, Date dataNasc, Endereco endereco) {

		super(nome, telefone, cpf, dataNasc, endereco);

	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
}
