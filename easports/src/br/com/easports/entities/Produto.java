package br.com.easports.entities;

public class Produto {
	
	private Integer idProduto;
	private String nome;
	private String codigo;
	private String imagem;
	private Double valorVenda;
	private Double valorCusto;
	private Fornecedor fornecedor;
	private Categoria categoria;
	private Integer quantidade;
	
	public Produto() {
		
	}

	public Produto(Integer idProduto, String nome, String imagem, String codigo, 
			Double valorVenda, Double valorCusto, Integer quantidade) {
		
		this.idProduto = idProduto;
		this.nome = nome;
		this.imagem = imagem;
		this.codigo = codigo;
		this.valorVenda = valorVenda;
		this.valorCusto = valorCusto;
		this.quantidade = quantidade;
		
	}

	public Produto(Integer idProduto, String nome, String imagem, String codigo, 
			Double valorVenda, Double valorCusto, Integer quantidade, Fornecedor fornecedor, Categoria categoria) {
		
		this.idProduto = idProduto;
		this.nome = nome;
		this.imagem = imagem;
		this.codigo = codigo;
		this.valorVenda = valorVenda;
		this.valorCusto = valorCusto;
		this.quantidade = quantidade;
		this.fornecedor = fornecedor;
		this.categoria = categoria;
		
	}
	
	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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
