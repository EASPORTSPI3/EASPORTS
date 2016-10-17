package br.com.easports.entities;

public class Estoque {

	private Integer idEstoque;
	private Integer quantidade;
	private Produto produto;
	private Categoria categoria;
	
	
	public Estoque() {

	}

	public Estoque(Integer idEstoque, Integer quantidade) {

		this.idEstoque = idEstoque;
		this.quantidade = quantidade;
		
	}

	public Estoque(Integer idEstoque, Integer quantidade, Produto produto, Categoria categoria) {

		this.idEstoque = idEstoque;
		this.quantidade = quantidade;
		this.produto = produto;
		this.categoria = categoria;
		
	}

	public Integer getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(Integer idEstoque) {
		this.idEstoque = idEstoque;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
