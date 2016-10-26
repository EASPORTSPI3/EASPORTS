package br.com.easports.entities;

public class Pedido {
	
	private Integer idCliente;
	private Integer idProduto;
	private Integer quantidade;
	private boolean finalizado;
	private Produto produto;
	private ClientePF cliente;
	
	public Pedido() {
		
	}

	public Pedido(Integer idCliente, Integer idProduto, Integer quantidade) {
		
		this.idCliente = idCliente;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		
	}
	
	public Pedido(Integer idCliente, Integer idProduto, Integer quantidade, Produto produto, ClientePF cliente) {
		super();
		this.idCliente = idCliente;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.produto = produto;
		this.cliente = cliente;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
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

	public ClientePF getCliente() {
		return cliente;
	}

	public void setCliente(ClientePF cliente) {
		this.cliente = cliente;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
}
