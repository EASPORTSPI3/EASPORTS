package br.com.easports.entities;

import java.util.Date;

public class PessoaFisica extends Pessoa {

	private String cpf;
	private Date dataNasc;
	private Endereco endereco;

	public PessoaFisica() {

	}

	public PessoaFisica(String nome, String telefone, String cpf, Date dataNasc) {

		super(nome, telefone);
		this.cpf = cpf;
		this.dataNasc = dataNasc;

	}

	public PessoaFisica(String nome, String telefone, String cpf, Date dataNasc, Endereco endereco) {

		super(nome, telefone);
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.endereco = endereco;

	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
