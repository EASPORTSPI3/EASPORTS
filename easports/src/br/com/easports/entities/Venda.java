package br.com.easports.entities;

import java.util.ArrayList;
import java.util.Date;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Venda {
	private Integer idVenda;
	private Date dataVenda;
	private Funcionario funcionario;
	private ArrayList<Pedido> lista;
	private Double valorTotalVenda;
	private String valorTotalVendaFormatado;
	private ClientePF cliente;
	
	public Venda() {

	}
	public Venda(Integer idVenda, Date dataVenda, Funcionario funcionario) {
		this.idVenda = idVenda;
		this.dataVenda = dataVenda;
		this.funcionario = funcionario;
	}
	
	
	
	public ClientePF getCliente() {
		return cliente;
	}
	public void setCliente(ClientePF cliente) {
		this.cliente = cliente;
	}
	public Double getValorTotalVenda() {
		return valorTotalVenda;
	}
	public void setValorTotalVenda(Double valorTotalVenda) {
		this.valorTotalVenda = valorTotalVenda;
	}
	public String getValorTotalVendaFormatado() {
		return valorTotalVendaFormatado;
	}
	public void setValorTotalVendaFormatado(String valorTotalVendaFormatado) {
		this.valorTotalVendaFormatado = valorTotalVendaFormatado;
	}
	public Integer getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public ArrayList<Pedido> getLista() {
		return lista;
	}
	public void setLista(ArrayList<Pedido> lista) {
		this.lista = lista;
	}
	
	public void addPedido(Pedido pedido){
		this.lista.add(pedido);
	}
	
}
