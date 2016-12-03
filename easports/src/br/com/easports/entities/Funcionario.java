package br.com.easports.entities;

import java.util.Date;

public class Funcionario extends PessoaFisica{

	private Cargo cargo;
	private String senha;
	private Integer idFuncionario;
	
	public Funcionario() {
		
	}

	public Funcionario(String nome, String telefone, String cpf, Date dataNasc, Endereco endereco) {
		
		super(nome, telefone, cpf, dataNasc, endereco);
		
	}

	public Funcionario(String nome, String telefone, String cpf, Date dataNasc, Endereco endereco, String senha, Cargo cargo) {
		super(nome, telefone, cpf, dataNasc, endereco);
		this.cargo = cargo;

		this.senha = senha;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
}
