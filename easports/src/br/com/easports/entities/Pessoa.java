package br.com.easports.entities;

public abstract class Pessoa {

	private String nome;
	private String telefone;
	private Endereco endereco;

	public Pessoa() {

	}

	public Pessoa(String nome, String telefone) {

		this.nome = nome;
		this.telefone = telefone;

	}

	public Pessoa(String nome, String telefone, Endereco endereco) {

		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
