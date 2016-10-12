package br.com.easports.entities;

public class Fornecedor extends PessoaJuridica {

	private Integer idFornecedor;

	public Fornecedor() {

	}

	public Fornecedor(String nome, String telefone, String cnpj, String razaoSocial) {

		super(nome, telefone, cnpj, razaoSocial);

	}

	public Fornecedor(String nome, String telefone, String cnpj, String razaoSocial, Endereco endereco) {

		super(nome, telefone, cnpj, razaoSocial, endereco);

	}

	public Integer getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	
}
