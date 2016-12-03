package br.com.easports.entities;

import java.util.Date;

public class Venda {
	private Integer idVenda;
	private Date dataVenda;
	private Funcionario funcionario;
	
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
}
