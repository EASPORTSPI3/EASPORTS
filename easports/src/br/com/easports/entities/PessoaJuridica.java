package br.com.easports.entities;

public class PessoaJuridica extends Pessoa {

	private String cnpj;
	private String razaoSocial;
	private Endereco endereco;

	public PessoaJuridica() {

	}

	public PessoaJuridica(String nome, String telefone, String cnpj, String razaoSocial) {

		super(nome, telefone);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;

	}

	public PessoaJuridica(String nome, String telefone, String cnpj, String razaoSocial, Endereco endereco) {

		super(nome, telefone);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.endereco = endereco;

	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
