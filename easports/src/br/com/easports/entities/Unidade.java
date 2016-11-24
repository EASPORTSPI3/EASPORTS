package br.com.easports.entities;

public class Unidade {

	private String nome;
	private String endereco;
	private String telefone;

	public Unidade() {

	}

	public Unidade(final String nome, final String endereco, final String telefone) {

		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;

	}

	public String getEndereco() {
		return endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setEndereco(final String endereco) {
		this.endereco = endereco;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public void setTelefone(final String telefone) {
		this.telefone = telefone;
	}

}
