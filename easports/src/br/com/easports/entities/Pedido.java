package br.com.easports.entities;

public class Pedido {
	
	private Integer idPedido;
	private Integer idCliente;
	private Integer idProduto;
	private Integer idVenda;
	private Integer quantidade;
	private Produto produto;
	private ClientePF cliente;
	private Double valorTotal;
	private String valorTotalFormatado;
	private String status;
	private Venda venda;
	
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

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	
	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getValorTotalFormatado() {
		return valorTotalFormatado;
	}

	public void setValorTotalFormatado(String valorTotalFormatado) {
		this.valorTotalFormatado = valorTotalFormatado;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
}
