package br.com.easports.entities;

import java.util.Date;




public class Funcionario extends PessoaFisica{

	private Cargo cargo;
	private Departamento departamento;
	private String senha;
	
	public Funcionario() {
		
	}

	public Funcionario(String nome, String telefone, String cpf, Date dataNasc, Endereco endereco) {
		
		super(nome, telefone, cpf, dataNasc, endereco);
		
	}

	public Funcionario(String nome, String telefone, String cpf, Date dataNasc, Endereco endereco, String senha,
			Cargo cargo, Departamento departamento) {
		super(nome, telefone, cpf, dataNasc, endereco);
		this.cargo = cargo;
		this.departamento = departamento;

		this.senha = senha;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
