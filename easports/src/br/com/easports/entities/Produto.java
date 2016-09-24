package br.com.easports.entities;

import br.com.easports.util.Categoria;

public class Produto {
	
	private String nome;
	private String modelo;
	private String codigoDeProd;
	private Double valorVenda;
	private Double valorCusto;
	private Fornecedor fornecedor;
	private Categoria categoria;
	
	public Produto() {
		
	}

	public Produto(String nome, String modelo, String codigoDeProd, Double valorVenda, Double valorCusto,
			Fornecedor fornecedor, Categoria categoria) {
		
		this.nome = nome;
		this.modelo = modelo;
		this.codigoDeProd = codigoDeProd;
		this.valorVenda = valorVenda;
		this.valorCusto = valorCusto;
		this.fornecedor = fornecedor;
		this.categoria = categoria;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCodigoDeProd() {
		return codigoDeProd;
	}

	public void setCodigoDeProd(String codigoDeProd) {
		this.codigoDeProd = codigoDeProd;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Double getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(Double valorCusto) {
		this.valorCusto = valorCusto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
