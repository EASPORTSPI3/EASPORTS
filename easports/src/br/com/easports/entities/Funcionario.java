package br.com.easports.entities;

import java.util.Date;

import br.com.easports.util.Cargo;
import br.com.easports.util.Departamento;

public class Funcionario extends PessoaFisica{

	private String ctps;
	private Cargo cargo;
	private Departamento departamento;
	
	public Funcionario() {
		
	}

	public Funcionario(String nome, String telefone, String cpf, Date dataNasc, Endereco endereco) {
		
		super(nome, telefone, cpf, dataNasc, endereco);
		
	}

	public Funcionario(String nome, String telefone, String cpf, Date dataNasc, Endereco endereco, String ctps,
			Cargo cargo, Departamento departamento) {
		super(nome, telefone, cpf, dataNasc, endereco);
		this.ctps = ctps;
		this.cargo = cargo;
		this.departamento = departamento;
	}
	
}
