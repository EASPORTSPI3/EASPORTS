package br.com.easports.entities;

public class Departamento {

	private Integer idDepartamento;
	private String departamento;
	
	public Departamento() {

	}	
	public Departamento(Integer idDepartamento, String departamento) {
		this.idDepartamento = idDepartamento;
		this.departamento = departamento;
	}
	
	public Integer getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	
	
}
