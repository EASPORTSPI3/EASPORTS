package br.com.easports.entities;

import java.util.ArrayList;
import java.util.Date;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Venda {
	private Integer idVenda;
	private Date dataVenda;
	private Funcionario funcionario;
	private ArrayList<Pedido> lista;
	
	public Venda() {

	}
	public Venda(Integer idVenda, Date dataVenda, Funcionario funcionario) {
		this.idVenda = idVenda;
		this.dataVenda = dataVenda;
		this.funcionario = funcionario;
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
